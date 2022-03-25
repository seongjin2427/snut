<template>
  <router-view />
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* @import url('https://fonts.googleapis.com/css2?family=Alegreya+Sans:wght@300;400;500;700;800&display=swap'); */
@import url('https://fonts.googleapis.com/css2?family=Alegreya+Sans:wght@300;400;500;700;800&display=swap');

@font-face {
  font-family: 'AlegreyaSans';
  src: url('@/assets/font/AlegreyaSans-Regular.ttf') format('opentype'),
  url('@/assets/font/AlegreyaSans-Regular.ttf') format('truetype');;
  unicode-range: U+0041-005A, U+0061-007A;
}

@font-face {
  font-family: 'NotoSansKR';
  src: url('@/assets/font/NotoSansKR-Regular.otf') format('opentype'),
  url('@/assets/font/NotoSansKR-Regular.otf') format('truetype');;
  unicode-range: U+AC00-D7A3;
}

* {
  margin: 0;
  padding: 0;
  font-family: 'AlegreyaSans', 'NotoSansKR', 'Apple SD Gothic Neo', sans-serif;
}

html, body {
  width: 100vw;
  height: 100vh;
}


</style>