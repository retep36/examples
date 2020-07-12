<template>
  <div class="container">
    <WeatherSearch />
    <WeatherInfo v-cloak />
  </div>
</template>

<script>
import WeatherSearch from "@/components/WeatherSearch.vue";
import WeatherInfo from "@/components/WeatherInfo.vue";

export default {
  components: {
    WeatherSearch,
    WeatherInfo
  }
};
</script>

<style lang="scss" scoped>
.container {
  max-width: 40%;
}

@media only screen and (max-width: 1000px) {
  .container {
    max-width: 60%;
  }
}

@media only screen and (max-width: 600px) {
  .container {
    max-width: 80%;
  }
}

@media only screen and (max-width: 400px) {
  .container {
    max-width: 95%;
  }
}

[v-cloak] {
  display: none;
}
</style>