<template>
  <div>
    <p class="row">
      <strong>Farba:</strong>
      {{this.colorName}}
    </p>
    <div class="row colors">
      <input
        type="button"
        class="colorButtons"
        @click="setColor(hexColors, index)"
        v-for="(hexColors, index) in this.hexColors"
        :key="index"
        :style="{backgroundColor: hexColors}"
        :class="{highlight:index == selected}"
      />
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      hexColor: "",
      colorName: "čierna",
      hexColors: [],
      nameColors: [],
      selected: null
    };
  },
  methods: {
    //   nastav zvolenu farbu 
    setColor(color, index) {
      this.colorName = this.nameColors[index];
      this.hexColor = color;
      this.$root.$emit("set-color", this.hexColor);
      localStorage.colorPage = this.hexColor;
      localStorage.colorName = this.colorName;
      this.selected = index;
    },
    // prevedie nazvy farieb do hex tvaru
    colorToHex(color) {
      if (color === "čierna") return "#000000";
      if (color === "biela") return "#ffffff";
      if (color === "červená") return "#ff3300";
      if (color === "modrá") return "#3366ff";
      if (color === "žltá") return "#ffe100";
      if (color === "fialová") return "#cc00cc";
    },
    // funkcia ktora vrati index farby z pola na zaklade mena
    outlineColorButton(colorName) {
      if (colorName === "čierna") return 0;
      if (colorName === "biela") return 1;
      if (colorName === "červená") return 2;
      if (colorName === "modrá") return 3;
      if (colorName === "žltá") return 4;
      if (colorName === "fialová") return 5;
    }
  },
  mounted() {
    if (localStorage.colorPage) {
      this.colorName = localStorage.colorName;
    }
    this.$root.$on("colors-array", data => {
      this.nameColors = data;
      this.hexColors = this.nameColors.map(color => this.colorToHex(color));
      this.selected = this.outlineColorButton(this.colorName);
    });
  }
};
</script>


<style scoped lang="scss" >
.colorButtons {
  width: 2em;
  height: 2em;
  border-radius: 1em;
  border: none;
  margin: 0.5em;
  padding: 0.1em;
  outline: none;
  border: 1px solid black;
  &.highlight {
    background-clip: content-box;
    border: 1px solid #888;
  }
}

.colors {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1em;
}
</style>


