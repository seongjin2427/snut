<template>
  <router-view />
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
  html, body {
  background-color: rgb(232, 236, 230);
  width: 100%;
  height: 100%;
  }
@media (max-width: 1680px) {
html, body {
  max-width: 1680px;
}
}
@media (min-width: 1680px){
  html, body {
    max-width: 1920px;
  }
}
@font-face {

  font-family: 'Noto Sans KR', 'Apple SD Gothic Neo',sans-serif;
  font-family: 'Montserrat', sans-serif;
  font-family: 'Alegreya', serif;
}
</style>