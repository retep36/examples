<template>
  <div class="row">
    <ul class="list">
      <li
        @click="rate(star)"
        v-for="star in maxStars"
        :class="{ 'active': star <= stars }"
        :key="star.stars"
        class="star"
      >
        <i class="fas fa-star"></i>
      </li>
    </ul>
    <p class="text">{{this.avgRating}}</p>
    <p class="text">{{this.ratings.length}} hodnotení</p>
  </div>
</template>

<script>
import axios from "axios";
import "@fortawesome/fontawesome-free/css/all.css";
import "@fortawesome/fontawesome-free/js/all.js";

const token = "$2b$10$qRp10LYIwXvJk2kQXu2EE.yhrz9vMtu9S.3MTkpLy6tVticPY.jFa";
const axiosHeaders = {
  headers: {
    "secret-key": token
  }
};

export default {
  name: "ProductRating",
  data() {
    return {
      stars: 0,
      maxStars: 5,
      ratings: [],
      avgRating: 0
    };
  },
  mounted() {
    // nacitaj hodnotenia
    axios
      .get(
        `https://api.jsonbin.io/b/5f33be176f8e4e3faf30e100/latest`,
        axiosHeaders
      )
      .then(response => {
        this.ratings = response.data.Rating;
        this.computeAvgRating();
      })
      .catch(function(error) {
        console.error(error);
      });
  },
  methods: {
    // funkcia na ohodnotenie produktu, premenna star uchovava hodnotenie (cislo od 1 do 5)
    rate(star) {
      if (star >= 0 && star <= this.maxStars) {
        this.stars = this.stars === star ? star - 1 : star;
      }
      this.ratings.push(star);

      // odosle hodnotenie
      axios({
        method: "put",
        url: "https://api.jsonbin.io/b/5f33be176f8e4e3faf30e100",
        headers: { "Content-Type": "application/json", "secret-key": token },
        data: {
          ProductId: "1000",
          Rating: this.ratings
        }
      }).then(response => {
        console.log(response);
        this.computeAvgRating();
      });
    },
    // vypocet priemerneho hodnotenia
    async computeAvgRating() {
      const add = (a, b) => a + b;
      this.avgRating = (this.ratings.reduce(add) / this.ratings.length).toFixed(
        2
      );
    }
  }
};
</script>

<style scoped lang="scss">
.list {
  margin-left: 0;
  margin-bottom: 0;
  padding-left: 0;
  &:hover {
    .star {
      color: #ffe100;
    }
  }
  .star {
    display: inline-block;
    font-size: 1em;
    transition: all 0.2s ease-in-out;
    cursor: pointer;
    &:hover {
      ~ .star:not(.active) {
        color: inherit;
      }
    }
    &.active {
      color: #ffe100;
    }
    &:hover {
      color: #ffe100;
    }
  }
}

.text {
  margin-left: 1em;
  height: 0 auto;
}

@media only screen and (max-width: 342px) {
  .list {
    width: 100%;
  }
  .star {
    font-size: 2em
  }
  .text {
    width: 100%;
    margin: 0;
  }
}
</style>