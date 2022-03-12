<template>
  <input class="main-search-input" 
        type="text" 
        :placeholder="placeholderContent"
        v-model="upToWord"
        @keyup.enter="doSearch">
</template>

<script>
export default {
  name: 'CommonInputBox',
  props: ['placeholderContent'],
  data() {
    return {
      upToWord: ""
    }
  },
  methods: {
    doSearch() {
      this.$emit('mainDoSearch', this.upToWord);
    }
  }
}
</script>

<style scoped>
.main-search-input {
    top: 70px;
    left: 702px;
    width: 516px;
    height: 28px;
    padding: 6px 12px;
    border-color: #00000099;
    border-style: solid;
    border-width: 0.5px;
    letter-spacing: 0.00px;
    line-height: normal;
    mix-blend-mode: normal;
    position: absolute;
    resize: none;
    text-align: left;
    background-color: rgb(232, 236, 230);
}
.main-search-input::placeholder {
  color: #00000099;
  font-family: 'Noto Sans';
  font: 16px black;
}
</style>