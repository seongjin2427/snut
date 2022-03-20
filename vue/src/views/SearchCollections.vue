<template>
  <div class="collections">
    <div class="main-header">
      <button @click="testClick()">테스트ㅎㅎ</button>
      <img class="main-logo-text" src="@/assets/logo_text.png" alt="logo_text">
      <common-input-box placeholderContent="SEARCH" />
      <common-button class="sort-btn" buttonName="정렬"/>
      <hamburger-button @click="occurNavBarEvent"/>
    </div>
    <div class="col-container">
      <div class="col-area">
        <common-curation :info="info" v-for="(info, idx) in testContent" :key="idx" @click="sendInfo(info.id)" />
      </div>
    </div>

    <!-- 푸터 구간 -->
    <main-footer />
    <!-- 네브 바 구역 -->
    <navigator-bar ref="navbar" />
    <!-- 모달창 구역 -->
    <common-modal 
        @returnModal="returnShow" 
        :curShow="curInfo" 
        :curationInfo="testCuration" 
        :involedPic="testCuration.involvePicBoolean" />

  </div>
</template>

<script>
import CommonInputBox from '@/components/CommonInputBox.vue';
import HamburgerButton from '@/components/HamburgerButton.vue';
import NavigatorBar from '@/components/NavigatorBar.vue';
import CommonCuration from '@/components/CommonCuration.vue';
import MainFooter from '@/components/MainFooter.vue';
import CommonButton from '@/components/CommonButton.vue';
import CommonModal from '@/components/CommonModal.vue';

import sampleData from '@/assets/sampleData.json';


export default {
  name: 'SearchCurations',
  components: {
    CommonInputBox, 
    HamburgerButton, 
    NavigatorBar, 
    CommonCuration, 
    MainFooter,
    CommonButton,
    CommonModal
  },
  data() {
    return {
      number3: [],
      curInfo: false,
      testContent: {},
      testCuration: {}
    }
  },
  methods: {
    occurNavBarEvent() {
      this.$refs.navbar.openNavBar();
    },
    sendInfo(id) {
      this.curInfo = true;
      this.testCuration = this.testContent[id];
      this.$refs.navbar.closeNavBar();

    },
    returnShow() {
      this.curInfo = false;
    },
    testClick() {
      console.log(this.testContent);
    }
  },
  created() {
    for(let i = 0; i < 100; i++) {
      sampleData.data[i] = {};
      sampleData.data[i].id = i;
      sampleData.data[i].email = "user" + i + "@naver.com"; 
      sampleData.data[i].nickName = "nickName" + i; 
      sampleData.data[i].colNum = "colId" + i;
      sampleData.data[i].title = "Title..." + i;
      sampleData.data[i].content = "Content..." + i;

      sampleData.data[i].open = true;

      if(i < 50) {
        sampleData.data[i].involvePicBoolean = true;
      } else {
        sampleData.data[i].involvePicBoolean = false;
      }


      sampleData.data[i].redDate = "2022-01-01";
      sampleData.data[i].modDate = "2022-01-02";
      
      sampleData.data[i].hashtag = [];
      sampleData.data[i].imgUrl = [];
      for(let j = 0; j < 3; j++) {
        let random = Math.floor(Math.random() * 9) + 1;
        sampleData.data[i].hashtag[j] = `Hash${i}${j}`;
        sampleData.data[i].imgUrl[j] = sampleData.imgUrl[random];
      }
    }
    this.testContent = sampleData.data;
    // console.log(sampleData.data[0].imgUrl)
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
.sort-btn {
  position: absolute;
  left: 1318px;
  top: 70px;
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
  position: relative;
}
.col-area {
  width: 1700px;
  display: flex;
  flex-wrap: wrap;
  flex-basis: 6;
  margin-top: 20px;
}
.common-collection {
  margin-right: 20px;
  margin-bottom: 22px;
}
</style>