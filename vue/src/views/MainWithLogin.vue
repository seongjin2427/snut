<template>
  <div>
    <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
    <input class="main-search-input" type="text" placeholder="SEARCH">
    <h1>MainWithLogin 페이지 입니다</h1>
    <main-button buttonName="Log in" />
  </div>
</template>

<script>
import MainButton from "@/components/MainButton.vue"

export default {
  name: "MainWithLogin",
  components: {
    MainButton
  }
}
</script>

<style scoped>
.main-logo-text {
    height: 59px;
    margin-left: 117px;
    margin-top: 49px;
    width: 169px;
}
input:focus {
  outline: none;
}
.main-search-input {
    top: 72px;
    left: 702px;
    width: 510px;
    height: 40px;
    padding: 0 15px;
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
}
</style>