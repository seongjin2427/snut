<template>
  <div>
    <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
    <common-input-box placeholderContent="SEARCH" />
    <common-button v-if="loginBool" class="loginBtn" buttonName="Log in" />
    <common-button v-if="!loginBool" class="loginBtn" buttonName="Log out" />
    <common-button class="registerBtn" buttonName="Register" />
    <img class="center-logo" src="@/assets/large_logo.png" alt="Large_logo">
    <pick-your-snut class="pick-your-snut" />
  </div>
</template>

<script>
import CommonButton from "@/components/CommonButton.vue"
import CommonInputBox from "@/components/CommonInputBox.vue"
import PickYourSnut from "@/components/PickYourSnut.vue"

export default {
  name: "MainWithLogin",
  components: {
    CommonButton, CommonInputBox, PickYourSnut
  },
  data() {
    return {
      loginBool: true
    }
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
.loginBtn {
  left: 1430px;
  top: 70px;
  position: absolute;
  cursor: pointer;
}
.registerBtn {
  left: 1588px;
  top: 70px;
  position: absolute;
  cursor: pointer;
}
.center-logo {
    height: 406px;
    left: 689px;
    mix-blend-mode: normal;
    object-fit: cover;
    position: absolute;
    top: 296px;
    width: 507px;
}
.pick-your-snut {    
    height: 80px;
    left: 758px;
    mix-blend-mode: normal;
    position: absolute;
    top: 757px;
    width: 50%;
}
</style>