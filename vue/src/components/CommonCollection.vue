<template>
<<<<<<< HEAD
  <div class="collection">
    <img :src="src" alt="sample_img">
=======
  <div class="common-collection" @mouseover="inCollection()" @mouseleave="outCollection()">
    <img :class="colSelect" :src="info.imgUrl" alt="col_image" />
    <div class="text1" v-if="testBoolean">
        <p>{{ info.title }}</p>
        <p>{{ info.modDate }}</p>
    </div>
>>>>>>> 1173a597230a090a057c18d0ed0fb81d4651891c
  </div>
</template>

<script>
<<<<<<< HEAD
export default {
  name: "CommonCollection",
  props: []
}
</script>

<style scoped>
img {
  width: 180px;
  height: 180px;
  object-fit: cover;
  /* margin-right: 0px; */
}
=======
export default{
  name: 'CommonCollection',
  props: ['info'],
  data() {
    return {
      colSelect: 'col-img' + this.info.id,
      colModal: {
        id: 'col-modal' + this.info.id
      },
      testBoolean: false
    }
  },
  methods: {
    inCollection() {
      this.testBoolean = true;
      document.querySelector('.'+this.colSelect).classList.add('lowerBrightness');
    },
    outCollection() {
      this.testBoolean = false;
      document.querySelector('.'+this.colSelect).classList.remove('lowerBrightness');
    }
  }
};
</script>

<style scoped>
.common-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 250px;
  height: 250px;
  position: relative
}
.common-collection img{
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
>>>>>>> 1173a597230a090a057c18d0ed0fb81d4651891c
</style>