<template>
  <div class="button" :style=" { width: width+'px', height: height+'px', border: border, background: bgcolor }">
    {{ buttonName }}
  </div>
</template>

<script>
export default {
  name: "CommonButton",
  props: ['buttonName', 'width', 'height', 'border', 'bgcolor']
}
</script>

<style scoped>
.button {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 130px;
  height: 40px;
  background-color: rgb(232, 236, 230);
  font-family: 'Alegreya';
  font-weight: 700;
  color: black;
  font-size: 16px;
  border-radius: 20px;
  border: 1px solid black;
  cursor: pointer;
}
</style>