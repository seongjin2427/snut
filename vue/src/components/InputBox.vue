<template>
  <div class="inputBox">
    <input type="text" :placeholder="placeholder" :style="{ width: width+'vw', height: height+'px' }">
  </div>
</template>

<script>
export default {
  name: "inputBox",
  props: ['width', 'height', 'placeholder']
}
</script>

<style scoped>
input {
  max-width: 376px;
  min-width: 300px;
  padding-left: 10px;
}
input:focus {
  outline: none;
}
input::placeholder {
  color: #00000099;
  font-size: 16px;
}
</style>