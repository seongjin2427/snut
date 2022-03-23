<template>
  <div class="main-with-login">
    <div class="main-with-login-body">
      <header>
        <img class="main-logo-text" src="@/assets/logo_text.png" alt="text_logo">
        <input-box class="main-input" placeholder="SEARCH" width="30" height="38" />
        <div class="button-area">
          <common-button buttonName="Log in" width="80" height="35" marginTop="5" marginRight="20" />
          <common-button buttonName="Register" width="80" height="35" marginTop="5" marginRight="42" />
          <img src="@/assets/btn_hamburger.png" alt="nav_btn">
        </div>
      </header>
    </div>
  </div>
</template>

<script>
import CommonButton from '../components/CommonButton.vue'
import InputBox from '../components/InputBox.vue'


export default {
  components: { InputBox, CommonButton },
  name: "MainWithLogin"
}
</script>

<style scoped>
.main-with-login-body {
  max-width: 1200px;
  min-width: 1200px;
  width: 100vw;
  height: 100vh;
  /* background: lightcoral; */
  margin: 0 auto;
}
header {
  width: 100%;
  height: 200px;
  /* background: lightblue; */
  position: relative;
  display: flex;
  justify-content: flex-end;
}
.main-logo-text {
  width: 113px;
  height: 39px;
  margin-top: 60px;
  position: absolute;
  left: 0;
  top: 0;
}
.main-input {
  margin-top: 67px;
  margin-right: 5%;
}
.button-area {
  width: 30%;
  /* background: red; */
  display: flex;
  justify-content: flex-end;
  align-items: flex-start;
  margin-top: 63px;
}
.button-area img {
  margin-right: 20px;
  cursor: pointer;
}
</style>