<template>
  <ul class="row">
    <li class="text" id="price" :style="{color:this.hexColor}">{{productInfo.Price}}€</li>
    <li class="text">
      <del>{{productInfo.OldPrice}}€</del>
    </li>
    <li class="text">{{productInfo.Discount}} zľava</li>
  </ul>
</template>

<script>
export default {
  props: ["productInfo"],
  data() {
    return {
      hexColor: ""
    };
  },
  mounted() {
    if (localStorage.colorPage) {
      this.hexColor = localStorage.colorPage;
    }
    this.$root.$on("set-color", data => this.hexColor = data);
  }
};
</script>

<style lang="scss" scoped>
li {
  list-style: none;
}

ul {
  margin: 0;
  padding: 0;
}

.text {
  font-size: 1.5em;
  margin: 2em 1em 1em 0;
  height: 0 auto;
  align-content: left;
  color: #888;
}

#price {
    color: black;
}

@media only screen and (max-width: 450px) {
  .text {
    margin: 0.5em 0.3em 0.3em 0
  }
}
</style>