<template>
  <div class="main-with-login">
    
    <!-- 네비바 구역 -->
    <hamburger-button @click="occurNavBarEvent"/>
    <navigator-bar ref="navbar" />

    <div class="mcol-header">
      <div class="levelArea mcol-text">
        <p>활동레벨</p>
      </div>
      <div class="button-container">
        <common-button buttonName="나만의 기록" class="commonBtn mcol-text" width="250" height="50" border="none" bgcolor="white" />
        <common-button buttonName="내 컬렉션 보기" class="commonBtn mcol-text" width="250" height="50" border="none" bgcolor="white" />
        <common-button buttonName="Collection 만들기" class="commonBtn mcol-text" width="250" height="50" border="none" bgcolor="white" />
        <common-button buttonName="Community 만들기" class="commonBtn mcol-text" width="250" height="50" border="none" bgcolor="white" />
      </div>
    </div>

    <!-- 인기 컬렉션 구간 -->
    <div class="col-container1">
      <div class="text-area1">
        <span class="hot-col1 mcol-text">인기컬렉션</span>
        <span class="more-col1 mcol-text"><a href="#">더보기</a></span>
      </div>
      <div class="col-area1">
          <common-collection class="recom-col" :info="num1" v-for="(num1, idx) in number1" :key="idx"/>
      </div>
    </div>

    <!-- 취향분석 구간 -->
    <div class="col-container2" v-if="loginBool">
      <div class="text-area2">
        <span class="hot-col2 mcol-text">취향분석</span>
      </div>
      <div class="col-area2">
        <div class="sampleBtn mcol-text" v-for="(text, idx) in tasteAnalysisText" :key="idx">
          <p>{{ text }}</p>
        </div>
      </div>
    </div>

    <!-- 푸터 구간 -->
    <main-footer class="main-footer" />

  </div>
</template>

<script>
import CommonButton from "@/components/CommonButton.vue";
import CommonCollection from '@/components/CommonCollection.vue';
import MainFooter from '@/components/MainFooter.vue';
import HamburgerButton from '@/components/HamburgerButton.vue';
import NavigatorBar from '../components/NavigatorBar.vue';

import sampleData from '@/assets/sampleData.json';

// import axios from 'axios';


export default {
  name: "MyCollection",
  components: {
    CommonButton, 
    CommonCollection, 
    MainFooter, 
    HamburgerButton,
    NavigatorBar
  },
  data() {
    return {
      loginBool: true,
      number1: {},
      number2: {},
      tasteAnalysisText: ['더 추천받기', '현 활동에 대한 분석', '내 커뮤니티 보기']
    }
  },
  methods: {
    occurNavBarEvent() {
      this.$refs.navbar.openNavBar();
    }
  },
  mounted() {
    for(var i = 0; i < 5; i++) {
      var random = Math.floor(Math.random() * 9) + 1;
      sampleData.data[i] = {};
      sampleData.data[i].id = i;
      sampleData.data[i].email = "user" + i + "@naver.com"; 
      sampleData.data[i].nickName = "nickName" + i; 
      sampleData.data[i].colNum = "colId" + i;
      sampleData.data[i].title = "Title..." + i;
      sampleData.data[i].content = "Content..." + i;
      sampleData.data[i].open = true;
      sampleData.data[i].redDate = "2022-01-01";
      sampleData.data[i].modDate = "2022-01-02";
      sampleData.data[i].imgUrl = sampleData.imgUrl[random];
    }
    this.number1 = sampleData.data;

    sampleData.data = {};
    for(let i = 5; i < 10; i++) {
      let random = Math.floor(Math.random() * 9) + 1;
      sampleData.data[i] = {};
      sampleData.data[i].id = i;
      sampleData.data[i].email = "user" + i + "@naver.com"; 
      sampleData.data[i].nickName = "nickName" + i; 
      sampleData.data[i].colNum = "colId" + i;
      sampleData.data[i].title = "Title..." + i;
      sampleData.data[i].content = "Content..." + i;
      sampleData.data[i].open = true;
      sampleData.data[i].redDate = "2022-01-01";
      sampleData.data[i].modDate = "2022-01-02";
      sampleData.data[i].imgUrl = sampleData.imgUrl[random];
    }
    this.number2 = sampleData.data;
    
    console.log("this.number1", this.number1)
    console.log("this.number2", this.number2)
  }
}
</script>

<style scoped>
.mcol-text {
  font-family: 'noto-sans';
  font-weight: 600;
  font-size: 30px;
  margin-bottom: 40px;
}
.hamburgerBtn {
  position: absolute;
  left: 1768px;
  top: 66px;
  height: 50px;
  width: 40px;
  cursor: pointer;
}
.mcol-header {
  width: 1920px;
  height: 800px;
}
.levelArea {
  width: 1920px;
  height: 494px;
  display: flex;
  align-items: flex-end;
  justify-content: center;
}
.levelArea p {
  display: flex;
  width: 350px;
  height: 350px;
  background: white;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
}
.button-container {
  display: flex;
  justify-content: center;
  margin-top: 110px;
}
.commonBtn {
  margin: 0 75px;
  font-size: 25px;
}
.col-container1 {
  position: absolute;
  top: 800px;
  width: 1920px;
}
.text-area1 {
  display: flex;
  width: 90%;
  margin: 0 auto;
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
  top: 1205px;
  width: 1920px;
}
.text-area2 {
  display: flex;
  width: 90%;
  margin: 10px auto 50px auto;
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
  justify-content: center;
}
.sampleBtn {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 350px;
  height: 130px;
  color: white;
  background: #dc8552;
  margin: 0 23px;
  border-radius: 12px;
}
.main-footer {
  top: 1400px;
}
</style>