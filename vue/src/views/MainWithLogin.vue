<template>
  <div class="main-with-login">
    
    <!-- header 구간 -->
    <div class="main-header">
      <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
      <common-input-box placeholderContent="SEARCH" @mainDoSearch="mainDoSearch" />

      <!-- 미 로그인 시 Login 버튼 활성화 -->
      <common-button v-if="!loginBool" class="commonBtn" buttonName="Log in" />

      <!-- 로그인 시 Log out 버튼 활성화 -->
      <common-button v-if="loginBool" class="commonBtn" buttonName="Log out" />

      <common-button class="registerBtn" buttonName="Register" />
      <hamburger-button @click="occurNavBarEvent"/>

      <!-- 미 로그인/로그인 전환 테스트용 버튼 -->
      <br>
      <button @click="testBtn">test</button><br>
      <button @click="getUserInfo">getUserInfo</button><br>
      <input type="text" v-model="userId"><br>
      <button @click="getAllUserInfo">gitAllUserInfo</button>
    </div>

    <!-- 메인 로고 -->
    <div class="main-logo">
      <pick-your-snut />
    </div>

    <!-- 인기 컬렉션 구간 -->
    <div class="col-container1">
      <div class="text-area1">
        <span class="hot-col1 text-area-text">인기컬렉션</span>
        <span class="more-col1 text-area-text"><a href="#">더보기</a></span>
      </div>
      <div class="col-area1">
          <common-collection class="recom-col" :num="[num1, idx]" v-for="(num1, idx) in number1" :key="num1"/>
      </div>
    </div>

    <!-- 개인 추천 컬렉션 구간 -->
    <div class="col-container2" v-if="loginBool">
      <div class="text-area2">
        <span class="hot-col2 text-area-text">개인 추천 컬렉션</span>
      </div>
      <div class="col-area2">
          <common-collection class="personal-col" :num="[num2, num2]" v-for="num2 in number2" :key="num2"/>
      </div>
    </div>
    
    <!-- 로그인 안됐을 때, 회원가입 유도 버튼 -->
    <div class="sign-recommend" v-if="!loginBool">
      <p class="sign-recommend-area">{{ signText }}</p>
    </div>

    <!-- 네브 바 구역 -->
    <navigator-bar ref="navbar" />

    <!-- 푸터 구간 -->
    <main-footer class="main-footer" />

  </div>
</template>

<script>
import CommonButton from "@/components/CommonButton.vue";
import CommonInputBox from "@/components/CommonInputBox.vue";
import PickYourSnut from "@/components/PickYourSnut.vue";
import CommonCollection from '@/components/CommonCollection.vue';
import MainFooter from '@/components/MainFooter.vue';
import HamburgerButton from '@/components/HamburgerButton.vue';
import NavigatorBar from '../components/NavigatorBar.vue';

import axios from 'axios';


export default {
  name: "MainWithLogin",
  components: {
    CommonButton, 
    CommonInputBox, 
    PickYourSnut, 
    CommonCollection, 
    MainFooter, 
    HamburgerButton,
    NavigatorBar
  },
  data() {
    return {
      loginBool: true,
      number1: [0, 1, 2, 3, 4],
      number2: [5, 6, 7, 8, 9],
      signText: "if you want to see more, just sign in!",
      userId: ''
    }
  },
  methods: {
    testBtn() {
      console.log(this.loginBool);
      this.loginBool = !this.loginBool;
    },
    occurNavBarEvent() {
      this.$refs.navbar.openNavBar();
    },
    getUserInfo() {
      axios.get("http://localhost:8080/get/" + this.userId).then((res) => {
        var data = res.data;
        console.log(data);
      });
    },
    getAllUserInfo() {
      axios.get("http://localhost:8080/get/all").then((res) => {
        console.log(res.data);
      })
    },
    mainDoSearch(searchWord) {
      // this.$router.push(`/col/${searchWord}`);
      console.log(searchWord);
      this.$router.push(`/col`);
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
.commonBtn {
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
.hamburgerBtn {
  position: absolute;
  left: 1768px;
  top: 66px;
  height: 50px;
  width: 40px;
  cursor: pointer;
}
.main-logo {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: absolute;
  top: 230px;
  left: 700px;
  height: 700px;
  margin: 0 auto;
  text-align: center;
}
.col-container1 {
  position: absolute;
  top: 920px;
  width: 1920px;
}
.text-area1 {
  display: flex;
  width: 90%;
  margin: 0 auto;
}
.text-area-text {
  font-family: 'noto-sans';
  font-weight: 600;
  font-size: 30px;
  margin-bottom: 40px;
}
.hot-col1 {
  display: inline-block;
  width: 70%;
  margin-left: 3rem;
}
.more-col1{
  display: inline-block;
  width: 30%;
  text-align: right;
  margin-right: 60px;
}
.more-col1 a {
  text-decoration: none;
  outline: none;
  color: rgba(102, 102, 102, 1);
}
.col-area1 {
  display: flex;
  margin: 0 auto;
  justify-content: space-around;
}
.recom-col {
  top: 90px;
  mix-blend-mode: normal;
  position: absolute;
}
.recom-col:nth-child(1) {
    left: 136px;
}
.recom-col:nth-child(2) {
    left: 484px;
}
.recom-col:nth-child(3) {
    left: 832px;
}
.recom-col:nth-child(4) {
    left: 1180px;
}
.recom-col:nth-child(5) {
    left: 1528px;
}
.col-container2 {
  position: absolute;
  top: 1325px;
  width: 1920px;
}
.text-area2 {
  display: flex;
  width: 90%;
  margin: 0 auto;
}
.hot-col2 {
  display: inline-block;
  width: 70%;
  margin-left: 3rem;
}
.more-col2{
  display: inline-block;
  width: 30%;
  text-align: right;
  margin-right: 40px;
}
.more-col2 a {
  text-decoration: none;
  outline: none;
  color: rgba(102, 102, 102, 1);
}
.col-area2 {
  display: flex;
  margin: 0 auto;
  justify-content: space-around;
}
.personal-col {
  top: 90px;
  mix-blend-mode: normal;
  position: absolute;
}
.personal-col:nth-child(1) {
    left: 136px;
}
.personal-col:nth-child(2) {
    left: 484px;
}
.personal-col:nth-child(3) {
    left: 832px;
}
.personal-col:nth-child(4) {
    left: 1180px;
}
.personal-col:nth-child(5) {
    left: 1528px;
}
.sign-recommend {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1142px;
  height: 250px;
  position: absolute;
  top: 1376px;
  left: 397px;
  background-color: #AED8ED;
  border-radius: 12px;
  cursor: pointer;
}
.sign-recommend-area {
  font-family: 'alegreya';
  font-size: 30px;
  font-weight: 800;
}
.main-footer {
  top: 1600px;
}
</style>