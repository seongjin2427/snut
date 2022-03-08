<template>
  <div class="button">
    {{ buttonName }}
  </div>
</template>

<script>
export default {
  name: "MainButton",
  props: ['buttonName']
}
</script>

<style scoped>
.button {
  width: 130px;
  height: 40px;
  background-color: rgb(232, 236, 230);
  display: flex;
  padding: 8px 44px;
  align-items: flex-start;
  border-radius: 20px;
}
</style>