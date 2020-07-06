<template>
  <div>
    <h2 class="subtitle text-left">used technologies in this project:</h2>
    <h4 class="text-left">
            router
      <br />event bus
      <br />axios
      <br />bulma.io
    </h4>
    <br />
    <h4 class="text-left">info about teams is stored at ... website do not finished yet &#128512;</h4>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.text-left {
  text-align: left;
  font-family: "Nunito", sans-serif;
}

.subtitle{
  color: #ffffff;
}

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
a {
  color: #42b983;
}
</style>
