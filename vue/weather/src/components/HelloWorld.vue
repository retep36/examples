<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <ul>
      <li>
        in this project i used
        <span class="textGreen">router</span>,
        <span class="textGreen">axios</span>,
        <span class="textGreen">lodash _.debounce</span>,
        <span class="textGreen">event bus</span> and
        <span class="textGreen">vue-cookies</span>
      </li>
      <br />
      <li>
        i have got data from
        <span class="textGreen">openweathermap.org</span>
      </li>
      <br />
      <li>
        click on
        <span class="textGreen">weather</span> in navigation to show app
      </li>
    </ul>
    <h3>Choose Location</h3>
    <ul>
      <li>
        enter location and wait
        <span class="textGreen">750ms</span>
      </li>
      <br />
      <li>
        data will be 
        <span class="textGreen">loaded automatically</span>
      </li>
    </ul>
    <h3>Set Default Location</h3>
    <ul>
      <li>
        default location is set to
        <span class="textGreen">Stará Ľubovňa</span> but you can change it by clicking on
        <IconEmptyStar />
      </li>
      <br />
      <li>
        then is default location set to
        <span class="textGreen">your choose</span>
      </li>
      <br />
      <li>
        for saving default location I used
        <span class="textGreen">vue-cookies</span> plugin
      </li>
      <br />
      <li>
        you can change your choose anytime or you can cancelled your default location, then is default
        <span
          class="textGreen"
        >Stará Ľubovňa</span>
      </li>
      <br />
      <li>
        your choose in cookies will be expired in
        <span class="textGreen">24 days</span>
      </li>
    </ul>
  </div>
</template>

<script>
import IconEmptyStar from "@/components/icons/IconEmptyStar.vue";

export default {
  name: "HelloWorld",
  components: {
    IconEmptyStar
  },
  props: {
    msg: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
.textGreen {
  color: #42b983;
}
#star {
  width: 2.5%;
  fill: #42b983;
}
</style>
