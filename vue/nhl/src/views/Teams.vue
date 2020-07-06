<template>
  <div class="container">
    <TeamsSearch />
    <TeamInfo />
  </div>
</template>


<script>
import TeamInfo from "@/components/TeamInfo";
import TeamsSearch from "@/components/TeamsSearch";

export default {
  components: {
    TeamInfo,
    TeamsSearch
  },
};
</script>


<style lang="scss" scoped>

</style>
