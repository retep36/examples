<template>
  <div id="app" v-cloak>
    <div class="background">
      <!-- <div class="hero-body"> -->
      <div class="container">
        <div id="nav">
          <h1 class="title text-left">🏒 NHL Stats</h1>
          <router-link class="menu" to="/">home</router-link>
          <router-link class="menu" to="/teams">teams</router-link>
        </div>
        <router-view />
      </div>
      <!-- </div> -->
    </div>
  </div>
</template>


<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 2vh;

  a {
    font-weight: bold;
    color: #ffffff;
    padding: 7px;
    margin: 5px;
    border: 1px solid white transparent;

    &.router-link-exact-active {
      color: #2eda8b;
      border-radius: 30px;
      background-color: #ffffff;
      border: 1px solid white;
    }
  }

  a:hover {
    color: #2eda8b;
    border-radius: 30px;
    border: 1px solid white;
    background-color: #ffffff;
  }
}

.background {
  width: 100%;
  min-height: 100vh;
  height: 100%;
  background: rgb(24, 164, 22);
  background: linear-gradient(
    90deg,
    rgba(24, 164, 22, 1) 0%,
    rgba(88, 224, 32, 1) 0%,
    rgba(0, 212, 255, 1) 100%
  );
}

.container,
.title {
  color: #ffffff;
}

li {
  list-style-type: none;
}

[v-cloak] {
  display: none;
}
</style>

