<template>
  <!-- Detail produktu -->
  <div class="container" v-cloak>
    <div class="product">
      <h1 class="title">{{product.Name}}</h1>
      <!-- Komponent rating -->
      <ProductRating v-cloak />
      <!-- Komponent cena -->
      <ProductPrice v-cloak :productInfo="product"/>
      <!-- Oznacenie novinka -->
      <div class="newTag" v-if="product.NewTag">NOVINKA</div>
      <!-- Komponent farby -->
      <ProductColors v-cloak />
      <!-- formular s poctom kusov a hlaskami v pripade potreby -->
      <div class="row">
        <input class="form number-form" type="number" value="1" v-model="pieces" />
        <input class="form submit-form" type="button" value="Pridať do košíka" onclick="chceckQuantity" />
      </div>
      <p
        class="row text-danger"
        v-if="pieces > this.product.Quantity"
      >Na sklade je len {{this.product.Quantity}} kusov.</p>
      <p class="row text-danger" v-if="pieces <= 0">Číslo musí byť väčšie ako 0.</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import ProductRating from "@/components/ProductRating";
import ProductColors from "@/components/ProductColors";
import ProductPrice from "@/components/ProductPrice";

const token = "$2b$10$qRp10LYIwXvJk2kQXu2EE.yhrz9vMtu9S.3MTkpLy6tVticPY.jFa";
let axiosHeaders = {
  headers: { "secret-key": token }
};

export default {
  components: {
    ProductRating,
    ProductColors,
    ProductPrice
  },
  data() {
    return {
      product: [],
      pieces: 1,
      colors: [],
      hexColors: [],
      hexColor: ""
    };
  },
  methods: {
    //   funkcia na ohodnotenie produktu, premenna star uchovava hodnotenie (cislo od 1 do 5)
    // rate(star) {
    //   if (star >= 0 && star <= this.maxStars) {
    //     this.stars = this.stars === star ? star - 1 : star;
    //   }
    // }
  },
  created() {
    // nacitanie udajov z uloziska pomocou kniznice axios  
    axios
      .get(
        `https://api.jsonbin.io/b/5f329e9cdddf413f95c1f93a?ProductId=1000`,
        axiosHeaders
      )
      .then(response => {
        this.product = response.data;
        this.colors = response.data.params[1];
        this.$root.$emit("colors-array", this.colors);
      })
      .catch(function(error) {
        console.error(error);
      });
  },
  mounted() {
    //   ak je v local storage ulozena farba, tak ju nastav pri mountnuti komponentu
    if (localStorage.colorPage) {
      this.hexColor = localStorage.colorPage;
    }
    this.$root.$on("set-color", data => this.hexColor = data);
  }
};
</script>


<style scoped lang="scss">
.newTag {
  border: 1px solid black;
  border-radius: 1em;
  width: 10em;
  margin-bottom: 0.5em;
}

.container {
  border: 0.5px solid #000;
}

.title {
  font-size: 2.5em;
  text-align: left;
}

.product {
  width: 80%;
  margin: auto;
  margin-bottom: 1em;
}

.form {
  height: 3em;
  border: 1px solid black;
  border-radius: 1.5em;
}

.number-form {
  width: 10%;
  padding-left: 1em;
}

.submit-form {
  border-radius: 1.5em;
  width: 50%;
  height: 3em;
  background-color: #000;
  color: #ffffff;
  margin-left: 1em;
}

@media only screen and (max-width: 770px) {
  .number-form {
    width: 20%;
  }
    .submit-form {
    width: 0 auto;
  }
}

@media only screen and (max-width: 550px) {
  .number-form {
    width: 30%;
  }
    .submit-form {
    width: 0 auto;
  }
}

[v-cloak] {
  display: none;
}
</style>