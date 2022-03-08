<template>
  <div class="button">
    {{ buttonName }}
  </div>
</template>

<script>
export default {
  name: "CommonButton",
  props: ['buttonName']
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
}
</style>