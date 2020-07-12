<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title main-text">
        {{datas[0]}}
        <a href="#" @click="setDefaultLocation()">
          <IconEmptyStar id="emptyStar" v-if="!isSetDefault()" />
          <IconStar id="star" v-if="isSetDefault()" />
        </a>
      </h5>

      <IconSun v-if="icon==1" class="icon" />
      <IconRain v-if="icon==2" class="icon" />
      <IconClouds v-if="icon==3" class="icon" />
      <IconStorm v-if="icon==4" class="icon" />
      <h6 class="card-subtitle temperature">{{ datas[1] }}°</h6>
      <h6 class="card-subtitle smaller-text">feeling like: {{ datas[2] }}°</h6>

      <p class="card-text smaller-text">{{ this.day }}</p>
      <hr />
      <div class="flex-grid">
        <div class="col">
          {{ getDays(dayNumber,1) }}
          <br />
          {{ dayOneTemp }}°
          <br />
          <IconSun v-if="(this.nextDays[3] == 800)" class="mini-icon" />
          <IconRain v-if="(this.nextDays[3] >= 500 && this.nextDays[3] < 550)" class="mini-icon" />
          <IconClouds v-if="(this.nextDays[3] >= 801 && this.nextDays[3] < 805)" class="mini-icon" />
          <IconStorm v-if="(this.nextDays[3] >= 200 && this.nextDays[3] < 250)" class="mini-icon" />
        </div>
        <div class="col">
          {{ getDays(dayNumber,2) }}
          <br />
          {{ dayTwoTemp }}°
          <br />
          <IconSun v-if="(this.nextDays[4] == 800)" class="mini-icon" />
          <IconRain v-if="(this.nextDays[4] >= 500 && this.nextDays[4] < 550)" class="mini-icon" />
          <IconClouds v-if="(this.nextDays[4] >= 801 && this.nextDays[4] < 805)" class="mini-icon" />
          <IconStorm v-if="(this.nextDays[4] >= 200 && this.nextDays[4] < 250)" class="mini-icon" />
        </div>
        <div class="col">
          {{ getDays(dayNumber,3) }}
          <br />
          {{ dayThreeTemp }}°
          <br />
          <IconSun v-if="(this.nextDays[5] == 800)" class="mini-icon" />
          <IconRain v-if="(this.nextDays[5] >= 500 && this.nextDays[5] < 550)" class="mini-icon" />
          <IconClouds v-if="(this.nextDays[5] >= 801 && this.nextDays[5] < 805)" class="mini-icon" />
          <IconStorm v-if="(this.nextDays[5] >= 200 && this.nextDays[5] < 250)" class="mini-icon" />
        </div>
      </div>
    </div>
  </div>
</template>



<script>
import axios from "axios";

import IconSun from "@/components/icons/IconSun.vue";
import IconRain from "@/components/icons/IconRain.vue";
import IconClouds from "@/components/icons/IconClouds.vue";
import IconStorm from "@/components/icons/IconStorm.vue";
import IconStar from "@/components/icons/IconStar.vue";
import IconEmptyStar from "@/components/icons/IconEmptyStar.vue";

export default {
  components: {
    IconSun,
    IconRain,
    IconClouds,
    IconStorm,
    IconStar,
    IconEmptyStar
  },
  data() {
    return {
      datas: [],
      icon: null,
      days: [
        "sunday",
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday"
      ],
      dayNumber: null,
      lat: null,
      lon: null,
      nextDays: [],
      dayOneTemp: 0,
      dayTwoTemp: 0,
      dayThreeTemp: 0,
      weatherLocation: ""
    };
  },
  methods: {
    setDefaultLocation() {
      if (this.$cookies.get("location") === this.weatherLocation) {
        this.$cookies.remove("location");
      } else {
        this.$cookies.set("location", this.weatherLocation, "24d");
      }
      console.log("cookie is set");
    },
    getDays(dayNumber, number) {
      if (this.dayNumber + number == 7) {
        return this.days[0];
      } else if (this.dayNumber + number == 8) {
        return this.days[1];
      } else if (this.dayNumber + number == 9) {
        return this.days[2];
      } else {
        return this.days[this.dayNumber + number];
      }
    },
    extractNextDays(response) {
      this.dayOneTemp = Math.round(response.data.daily[0].temp.day);
      this.dayTwoTemp = Math.round(response.data.daily[1].temp.day);
      this.dayThreeTemp = Math.round(response.data.daily[2].temp.day);
      this.dayOneWeather = response.data.daily[0].weather[0].id;
      this.dayTwoWeather = response.data.daily[1].weather[0].id;
      this.dayThreeWeather = response.data.daily[2].weather[0].id;
      this.nextDays.push(
        this.dayOneTemp,
        this.dayTwoTemp,
        this.dayThreeTemp,
        this.dayOneWeather,
        this.dayTwoWeather,
        this.dayThreeWeather
      );
    },
    isSetDefault() {
      if (this.$cookies.get("location") === this.weatherLocation) {
        return true;
      }
      return false;
    }
  },
  created() {
    this.dayNumber = new Date().getDay();
    this.day = this.days[this.dayNumber];
  },
  mounted() {
    this.$root.$on("weatherInfo", datas => (this.datas = datas));
    this.$root.$on("weatherLocation", data => (this.weatherLocation = data));
  },
  beforeUpdate() {
    if (this.datas[3] == 800) this.icon = 1;
    if (this.datas[3] >= 500 && this.datas[3] < 550) this.icon = 2;
    if (this.datas[3] >= 801 && this.datas[3] < 805) this.icon = 3;
    if (this.datas[3] >= 200 && this.datas[3] < 250) this.icon = 4;

    this.lat = this.datas[4];
    this.lon = this.datas[5];

    axios
      .get(
        `https:api.openweathermap.org/data/2.5/onecall?lat=${this.lat}&lon=${this.lon}&exclude=hourly&appid=5cf08107747f311e624edfd7fe88db25&units=metric`
      )
      .then(response => {
        this.nextDays = [];
        // console.log(response);
        this.extractNextDays(response);
      })
      .catch(function(error) {
        alert("Bad location" + error);
        //   console.log(error);
      })
      .then(function() {
        // always executed
      });
  }
};
</script>



<style lang="scss" scoped>
.card-body {
  background-color: #5cd5e0;
  border-radius: 30px;
  box-shadow: 0 5px 10px 0 rgba(56, 88, 135, 0.5);
}

.main-text,
.temperature,
.smaller-text {
  color: #ffffff;
  font-family: "Titillium Web", sans-serif;
  text-shadow: 1px 1px #0799c5;
}

.main-text {
  font-size: 2rem;
}

.temperature {
  font-size: 4em;
}

.icon {
  fill: #ffffff;
  max-width: 50%;
  margin: 3em;
}

.smaller-text {
  font-size: 2vh;
}

.card {
  margin-top: 0.5em;
}

.card-text {
  margin-top: 4em;
}

.flex-grid {
  display: flex;
}
.col {
  flex: 1;
}

.mini-icon {
  width: 40%;
}

#emptyStar {
  width: 5%;
  fill: white;
}

#star {
  width: 5%;
  fill: yellow;
}

#emptyStar:hover {
  width: 5%;
  fill: yellow;
}
</style>