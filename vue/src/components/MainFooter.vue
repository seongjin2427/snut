<template>
  <div class="footer-area">
    <div class="rectangle"></div>
    <img src="../assets/small_logo.png" alt="footer_logo">
    <br>
    <p class="footer-text">{{ cText }}</p>
  </div>
</template>

<script>
export default {
  name: 'MainFooter',
  data() {
    return {
      cText: "© snut. 2021 We love our users!"
    }
  }
}
</script>

<style scoped>
.footer-area {
  margin-top: 200px;
  position: absolute;
  display: flex;
  width: 100vw;
  flex-direction: column;
  align-items: center;
}
.rectangle {
  width: 100vw;
  height: 2px;
  background: rgba(196, 196, 196, 1);
}
img {
  width: 10.5625rem;
  height: 8.5rem;
  object-fit: cover;
  margin-top: 50px;
}
.footer-text {
  width: 301px;
  font-family: 'Noto-sans KR','Apple SD Gothic Neo', sans-serif ;
  font-size: 15px;
  letter-spacing: -0.23px;
  line-height: 24px;
  min-height: 24px;
  text-align: center;
  white-space: nowrap;
  margin-bottom: 20px;
}
</style>