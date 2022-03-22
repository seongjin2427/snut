<template>
  <div class="common-curation" @mouseover="inCuration()" @mouseleave="outCuration()">
    <img :class="cuSelect" :src="info.imgUrl[0]" alt="cu_image" />
    <div class="text1" v-if="testBoolean">
      <p>{{ info.title }}</p>
      <p>{{ info.modDate }}</p>
    </div>
  </div>
</template>

<script>
export default{
  name: 'CommonCuration',
  props: ['info'],
  data() {
    return {
      cuSelect: 'cu-img' + this.info.id,
      cuModal: {
        id: 'cu-modal' + this.info.id
      },
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
};
</script>

<style scoped>
.common-curation {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 250px;
  height: 250px;
  position: relative;
  margin: 10px;
}
.common-curation img{
  width: 250px;
  height: 250px;
  transition: all .3s;
}
.text1 {
  width: 250px;
  height: 250px;
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