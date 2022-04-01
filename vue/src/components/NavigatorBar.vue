<template>
  <div class="navigator closeNavBar">
    <div class="hamburgerBtn-area">
      <img class="hamburgerBtn" src="@/assets/btn_hamburger.png" alt="nav_btn" @click="closeNavBar">
    </div>
    <ul>
      <li><router-link to="/mcol/main">MY COLLECTION</router-link></li>
      <li><router-link to="/com">COMMUNITY</router-link></li>
      <li><router-link to="/mc">MY PAGE</router-link></li>
      <li><router-link to="/ab">ABOUT</router-link></li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'NavigatorBar',
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
  border-left: 1px black solid;
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
  cursor: pointer;
}
ul {
  margin-top: 300px;
  list-style: none;
}
li {
  display: block;
  margin: 85px auto;
  text-align: center;
  font-family: 'AlegreyaSans';
  font-weight: 800;
  font-size: 30px;
}
li * {
  font-family: 'AlegreyaSans';
  font-weight: 800;
  font-size: 30px;
  text-decoration: none;
  color: black;
}
</style>