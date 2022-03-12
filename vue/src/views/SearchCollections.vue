<template>
  <div class="collections">
    <div class="main-header">
      <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
      <common-input-box placeholderContent="SEARCH" />
      <hamburger-button @click="occurNavBarEvent"/>
    </div>
    <div class="col-container">
      <div class="col-area">
        <common-collection :num="num3" v-for="num3 in number3" :key="num3" />
      </div>
    </div>

    <!-- 네브 바 구역 -->
    <navigator-bar ref="navbar" />
    
    <!-- 푸터 구간 -->
    <main-footer />
  </div>
</template>

<script>
import CommonInputBox from '@/components/CommonInputBox.vue'
import HamburgerButton from '@/components/HamburgerButton.vue'
import NavigatorBar from '@/components/NavigatorBar.vue';
import CommonCollection from '@/components/CommonCollection.vue';
import MainFooter from '../components/MainFooter.vue';

export default {
  name: 'SearchCollections',
  components: {
    CommonInputBox, HamburgerButton, NavigatorBar, CommonCollection, MainFooter
  },
  data() {
    return {
      number3: []
    }
  },
  methods: {
    occurNavBarEvent() {
      this.$refs.navbar.openNavBar();
    }
  },
  mounted() {
    for(let i = 0; i < 50; i++) {
      this.number3[i] = Math.floor(Math.random() * 9);
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
.col-container {
  margin-top: 180px;
  margin-left: 160px;
  overflow: hidden;
}
.col-area {
  display: flex;
  flex-wrap: wrap;
  margin-top: 20px;
}
.common-collection {
  margin-right: 20px;
  margin-bottom: 22px;
}
</style>