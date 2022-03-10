<template>
  <div class="footer-area">
    <div class="rectangle-5"></div>
    <img src="../assets/small_logo.png" alt="footer_logo">
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
  top: 1800px;
  position: absolute;
  width: 1920px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.rectangle-5 {
  background-color: rgba(196, 196, 196, 1);
  height: 2px;
  width: 100%;
}
img {
  margin: 40px 0 40px;
  width: 203px;
  height: 162px;
  object-fit: cover;
}
.footer-text {
  width: 301px;
  font-family: 'noto-sans';
  font-size: 15px;
  letter-spacing: -0.23px;
  line-height: 24px;
  min-height: 24px;
  text-align: center;
  white-space: nowrap;
  margin-bottom: 20px;
}
</style>