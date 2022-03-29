<template>
  <div class="main-with-login">
    <div class="main-with-login-body">
      <header>
        <div class="logo-area header-area">
          <img class="main-logo-text" src="@/assets/logo_text.png" alt="text_logo">
        </div>
        <div class="button-area">
          <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar">
        </div>
      </header>

      <main>
          <div class="action-level">
            <div class="action-level-img">
              <p>활동 레벨</p>
            </div>
          </div>
          <div class="mcol-button-area">
            <common-button
                v-for="(btn, idx) in buttonData"
                @click="moveToPage(btn.src)"
                width="250"
                height="50"
                marginRight="40"
                background="white"
                :buttonName="btn.name"
                fontSize="25"
                borderRadius="50"
                border="none"
                :key="idx"/>
          </div>
          
          <div class="main-col">
            <p class="main-col-title">
              인기컬렉션
            </p>
            <div class="main-col-area">
              <common-collection
                  v-for="(col, idx) in sampleData.dataSet"
                  :info="col"
                  :id="col.id"
                  :key="idx" />
            </div>
          </div>
          <div class="main-col main-col-analysis">
            <p class="main-col-title">
              취향분석
            </p>
            <div class="analysis-area">
              <div class="analysis-button-area" 
                  v-for="(btn, idx) in analysis"
                  :key="idx">
                <p>{{ btn.name }}</p>
              </div>
            </div>
          </div>
        <navigator-bar ref="navBar" />
      </main>
      
      <footer>
        <main-footer/>
      </footer>

    </div>
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import CommonCollection from '@/components/CommonCollection.vue';
import MainFooter from '@/components/MainFooter.vue'
import NavigatorBar from '../components/NavigatorBar.vue';
import SampleData from '@/assets/sampleData.json';


export default {
  components: { CommonButton, CommonCollection, MainFooter, NavigatorBar },
  name: "MyCollection",
  data() {
    return {
      loginBool: false,
      sampleData: SampleData,
      hotCol: [1, 2, 3, 4, 5, 6],
      buttonData: [
        {
          name: '나만의 기록', 
          src: '/mcol/note',
        },
        {
          name: '내 컬렉션 보기', 
          src: '/mcol/store',
        },
        {
          name: 'Collection 만들기', 
          src: '',
        },
        {
          name: 'Community 만들기', 
          src: '',
        }
      ],
      analysis: [
        {
          name: '더 추천받기', 
          src: ''
        },
        {
          name: '현 활동에 대한 분석', 
          src: ''
        },
        {
          name: '내 커뮤니티 보기', 
          src: ''
        },
      ]
    }
  },
  methods: {
    openNavBar() {
      this.$refs.navBar.openNavBar()
    },
    moveToPage(src) {
      console.log(src);
      this.$router.push(src);
    }
  },
  created() {
    for(var i = 0; i < 6; i++) {
      var random = Math.floor(Math.random()*10);
      this.sampleData.dataSet[i] = {};
      this.sampleData.dataSet[i].id = i;
      this.sampleData.dataSet[i].author = 'Author....' + i;
      this.sampleData.dataSet[i].nickName = 'NickName....' + i;
      this.sampleData.dataSet[i].title = 'Title....' + i;
      this.sampleData.dataSet[i].content = 'Content...' + i;
      this.sampleData.dataSet[i].folder = 'FolerNo...' + i;
      this.sampleData.dataSet[i].src = this.sampleData.imgUrl[random];
      this.sampleData.dataSet[i].regDate = '2022-03-01';
      this.sampleData.dataSet[i].modDate = '2022-03-02';
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
  height: 135px;
  /* background: lightblue; */
  position: relative;
  display: flex;
  justify-content: flex-end;
}
.header-area {
  width: 70%;
}
.main-logo-text {
  width: 113px;
  height: 39px;
  margin-top: 60px;
  /* position: absolute; */
  left: 0;
  top: 0;
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

.action-level {
  width: 100%;
  height: 450px;
  /* background: lightgreen; */
  display: flex;
  justify-content: center;
}
.action-level-img {
  width: 250px;
  height: 250px;
  background: white;
  border-radius: 125px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
}
.mcol-button-area {
  display: flex;
  height: 200px;
}

/* 컬렉션 구간 */
.main-col {
  width: 100%;
  max-width: 1200px;
  height: 420px;
  /* background: green; */
  /* padding: 0 100px; */
}
.main-col-title {
  margin-bottom: 100px;
  font-size: 30px;
  font-weight: bold;
}
.main-col-area {
  width: 100%;
  display: flex;
  justify-content: space-around;
}
.main-col-analysis {
  height: 300px;
}
.analysis-area {
  padding: 0 40px;
  display: flex;
  justify-content: space-around;
}
.analysis-button-area {
  width: 300px;
  height: 130px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #DC8552;
  border-radius: 12px;
  color: white;
  font-size: 24px;
  font-weight: bold;
  cursor: pointer;
}
</style>