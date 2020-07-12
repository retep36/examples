<template>
  <input
    class="form-control"
    type="text"
    placeholder="Enter location"
    v-model="location"
    ref="location"
    @keyup="search"
  />
</template>

<script>
import axios from "axios";
import { debounce } from "lodash-es";


export default {
  data() {
    return {
      location: 'stara lubovna',
      weatherInfo: [],
      name: "",
      temperature: null,
      feelsLike: null,
    };
  },
  created(){
      if(this.$cookies.isKey('location')){
          this.location = this.$cookies.get('location')
      }
      this.getWeather();
  },
  methods: {
    search: debounce(function() {
      if (this.location.length > 2) this.getWeather();
    }, 750),
    extractData(response) {
      this.name = response.data.name;
      this.temperature = response.data.main.temp;
      this.feelsLike = response.data.main.feels_like;
      this.weatherID = response.data.weather[0].id;
      this.lat = response.data.coord.lat;
      this.lon = response.data.coord.lon;
    //   this.wind = response.data.wind.speed;
      this.weatherInfo.push(
        this.name,
        this.temperature,
        this.feelsLike,
        this.weatherID,
        this.lat,
        this.lon
        // this.wind
      );
    },
    getWeather() {
      axios
        .get(
          `http://api.openweathermap.org/data/2.5/weather?q=${encodeURI(
            this.location
          )}&appid=5cf08107747f311e624edfd7fe88db25&units=metric`
        )
        .then(response => {
          this.weatherInfo = [];
          this.extractData(response);
          console.log(response)
          console.log(this.weatherInfo)
          this.$root.$emit("weatherInfo", this.weatherInfo);
          this.$root.$emit("weatherLocation", this.location);
        })
        .catch(function(error) {
          // handle error
          console.log(error);
        })
        .then(function() {
          // always executed
        });
    }
  },
  mounted() {
    this.$refs.location.focus();
  }
};
</script>

<style lang="scss" scoped>
</style>