<template>
  <div class="collection" @mouseover="inCuration()" @mouseleave="outCuration()" v-if="info.id">
    <img :class="cuSelect" :src="info.src" alt="sample_img">
    <div class="text1" v-if="testBoolean">
      <p>{{ '#'+info.hashTag[0] }}</p>
      <p>{{ '#'+info.hashTag[1] }}</p>
      <p>{{ '#'+info.hashTag[2] }}</p>
      <p>{{ info.modDate }}</p>
      <p>{{ info.cuCo }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommonCollection",
  props: ['info', 'id'],
  data() {
    return {
      cuSelect: 'cu-img' + this.id,
      testBoolean: false
    }
  },
  methods: {
    inCuration() {
      this.testBoolean = true;
      document.querySelector('.'+this.cuSelect).classList.add('lowerBrightness');
    },
    outCuration() {
      this.testBoolean = false;
      document.querySelector('.'+this.cuSelect).classList.remove('lowerBrightness');
    }
  }
}
</script>

<style scoped>
.collection {
  position: relative;
}
img {
  width: 180px;
  height: 180px;
  object-fit: cover;
  /* margin-right: 0px; */
}
.text1 {
  width: 180px;
  height: 180px;
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  opacity: 100%;
}
.text1 p {
  color: white;
  font-weight: bold;
  position: relative;
}
.lowerBrightness {
  transition: all .3s;
  filter: brightness(60%);
}
</style>