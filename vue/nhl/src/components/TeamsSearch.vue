<template>
  <div>
    <div class="column is-half is-offset-one-quarter">
      <form action="#">
        <input
          class="gradientInput"
          type="text"
          @keyup="searchTeam"
          v-model="query"
          placeholder="Enter team"
          ref="search"
        />
      </form>
    </div>
  </div>
</template>


<script>
// import { includes } from "lodash";
// import { filter } from "lodash";

export default {
  data() {
    return {
      query: "",
      data2: [],
      actualData: []
    };
  },
  methods: {
    searchTeam() {
      this.actualData = this.data2.filter(post => {
        return post.name.toLowerCase().includes(this.query.toLowerCase());
      });
      //   console.log(this.actualData);
      this.$root.$emit("actual-data", this.actualData);
    }
  },
  mounted() {
    this.$refs.search.focus();
    this.$root.$on("send-array", data => {
      this.data2 = data;
    });
  }
};
</script>


<style lang="scss" scoped>
.gradientInput {
  width: 100%;
  font-size: 1.5em;
  outline: none;
  border: 0.06em solid transparent;
  border-radius: 2em;
  padding-left: 20px;
}
</style>