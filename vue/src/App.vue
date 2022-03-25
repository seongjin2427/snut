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

<<<<<<< HEAD
* {
  margin: 0;
  padding: 0;
}

html, body {
  background-color: rgb(232, 236, 230);
  width: 100%;
  height: 100%;
=======
@font-face {
  font-family: 'AlegreyaSans';
  src: url('@/assets/font/AlegreyaSans-Regular.ttf') format('opentype'),
  url('@/assets/font/AlegreyaSans-Regular.ttf') format('truetype');;
  unicode-range: U+0041-005A, U+0061-007A;
>>>>>>> 606a00f2824b4cd1c232c0a7c090db49b15fb899
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
  font-family: 'AlegreyaSans', 'NotoSansKR', sans-serif;
}

html, body {
  max-width: 1920px;
  width: 100vw;
  height: 100vh;
}


</style>