<template>

  <div class="column is-half is-offset-one-quarter">
    <transition-group name="fade">
      <div class="card" v-for="value in values" :key="value.id">
        <div class="card-image">
          <figure class="image is-own-size has-image-centered">
            <img :src="value.icon" alt="team logo" />
          </figure>
        </div>
        <div class="card-content">
          <div class="media-content">
            <p class="title">
              <a href="#">{{ value.name }}</a>
            </p>
            <p class="subtitle">{{ value | stadions }}</p>
          </div>

          <footer class="card-footer">
            <p class="card-footer-item">
              <span>
                Official Site
                <a :href="value.officialSiteUrl">here</a>
              </span>
            </p>
            <p class="card-footer-item">
              <span>
                <a href="#" @click="showTeamInfoDetail(status)">Detail</a>
              </span>
            </p>
          </footer>
        </div>
      </div>
      <TeamInfoDetail v-if="showTeamInfoDetail" />
      <slot></slot>
    </transition-group> 
  </div>
</template>


<script>
import axios from "axios";
import TeamInfoDetail from "@/components/TeamInfoDetail";

export default {
  components: {
    TeamInfoDetail
  },
  data() {
    return {
      value: "",
      values: [],
      arrayTeams: [],
      status: false
    };
  },
  methods: {
    extractData({ id, name, officialSiteUrl, icon, venue }) {
      return { id, name, officialSiteUrl, icon, venue };
    },
    showTeamInfoDetail(status){
      status = !status;
      return status
    }
  },
  created() {
      axios
      .get("/nhlapi.json")
      .then(response => {
        let arrayTeams = response.data.teams.map(song =>
          this.extractData(song)
        );
        this.$root.$emit("send-array", arrayTeams);
        this.values = arrayTeams;
      })
      .catch(error => {
        console.log(error);
      })
      .then(function() {});
  },
  filters: {
    stadions: function(value) {
      return value.venue.name + ", " + value.venue.city;
    }
  },
  mounted() {
    this.$root.$on("actual-data", data => (this.values = data));
  }
};
</script>


<style lang="scss" scoped>
.has-image-centered {
  margin-left: auto;
  margin-right: auto;
  display: block;
}

img {
  padding-top: 1rem;
}

.card {
  border: 0.5px solid lightgray;
  margin-bottom: 1em;
  border-radius: 2em;
}

.fade-enter-active {
  transition: all 0.2s ease;
}

.fade-enter {
  transform: scale(0.5);
}

.is-own-size {
  width: 20%;
}
</style>