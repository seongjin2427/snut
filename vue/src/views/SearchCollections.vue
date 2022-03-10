<template>
  <div class="collections">
    <div class="main-header">
      <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
      <common-input-box placeholderContent="SEARCH" />
      <hamburger-button @click="occurNavBarEvent"/>
    </div>
  </div>
  <div>
    <h1>테스트</h1>
   </div>

  <!-- 네브 바 구역 -->
  <navigator-bar ref="navbar" />
</template>

<script>
import CommonInputBox from '@/components/CommonInputBox.vue'
import HamburgerButton from '@/components/HamburgerButton.vue'
import NavigatorBar from '../components/NavigatorBar.vue';

export default {
  name: 'SearchCollections',
  components: {
    CommonInputBox, HamburgerButton, NavigatorBar
  },
  methods: {
    occurNavBarEvent() {
      this.$refs.navbar.openNavBar();
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
.hamburgerBtn {
  position: absolute;
  left: 1768px;
  top: 66px;
  height: 50px;
  width: 40px;
  cursor: pointer;
}
</style>