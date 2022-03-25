<template>
  <div class="collection">
    <img :src="src" alt="sample_img">
  </div>
</template>

<script>
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
</style>