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
      <main>

        <div class="main-with-login-main">
          <img src="@/assets/large_logo.png" alt="main_logo">
          <div class="pick-your-snut">
            <div>PICK YOUR "<span>S</span><span>N</span><span>UT</span>"</div>
          </div>
        </div>

        <div class="hot-col">
          <p class="hot-col-title">
            인기컬렉션
          </p>
          <div class="hot-col-area">
            <common-collection v-for="(info, idx) in colInfo.data" :colInfo="colInfo" :src="info.src" :key="idx" />
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import CommonButton from '../components/CommonButton.vue'
import CommonCollection from '../components/CommonCollection.vue'
import InputBox from '../components/InputBox.vue'


export default {
  components: { InputBox, CommonButton, CommonCollection },
  name: "MainWithLogin",
  data() {
    return {
      colInfo: []
    }
  },
  methods: {

  },
  mounted() {
      for(let i = 0; i < 5; i++) {
        console.log('a'); 
      }
  }
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

/* header 구간 */
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

/* main 구간 */
.main-with-login-main {
  max-width: 1200px;
  height: 700px;
  background: blue;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.main-with-login-main img {
  width: 341px;
  height: 274px;
  object-fit: cover;
}
.pick-your-snut *{
  margin-top: 15px;
  font-family: 'Alegreya Sans', 'sans-serif';
  font-size: 40px;
  letter-spacing: 2.5px;
  font-weight: 800;
}
.pick-your-snut span:nth-child(1) {
  color: #292F6D;
}
.pick-your-snut span:nth-child(2) {
  color: #4F4F4F;
}
.pick-your-snut span:nth-child(3) {
  color: #FBE017;
}

/* 인기컬렉션 구간 */
.hot-col {
  width: calc(100%-200px);
  max-width: 1200px;
  height: 420px;
  background: green;
  padding: 0 100px;
}
.hot-col-title {
  margin-bottom: 120px;
  font-size: 30px;
  font-weight: bold;
}
.hot-col-area {
  width: 100%;
}
</style>