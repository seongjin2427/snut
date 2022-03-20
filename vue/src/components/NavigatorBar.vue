<template>
  <div class="navigator closeNavBar">
    <div class="hamburgerBtn-area">
      <hamburger-btn @click="closeNavBar" />
    </div>
    <ul>
      <li><router-link to="/mcol/main">My collection</router-link></li>
      <li>Community</li>
      <li>My Page</li>
      <li>Feedback</li>
    </ul>
  </div>
</template>

<script>
import HamburgerBtn from '@/components/HamburgerButton.vue'
export default {
  name: 'NavigatorBar',
  components: {
    HamburgerBtn
  },
  methods: {
    openNavBar() {
      var a = document.querySelector('.navigator');
      a.classList.add('openNavBar');
      
    },
    closeNavBar() {
      var a = document.querySelector('.navigator');
      a.classList.remove('openNavBar');
    },

  }
}
</script>

<style scoped>
.navigator {
  /* opacity: 0.5; */
  position: fixed;
  width: 400px;
  height: 200%;
  top: 0;
  background: #FFFFFF;
  transition: all .2s;
  right: -400px;
  z-index: 9999;
}
.openNavBar {
  right: 0px;
}
.hamburgerBtn-area {
  position: relative;
}
.hamburgerBtn {
  position: absolute;
  top: 66px;
  right: 124px;
}
ul {
  margin-top: 300px;
  list-style: none;
}
li {
  display: block;
  margin: 85px auto;
  text-align: center;
  font-family: 'alegreya';
  font-weight: 700;
  font-size: 30px;
}
a {
  text-decoration: none;
  color: black;
}
</style>