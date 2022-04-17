<template>
  <div class="main-with-login">
    <div class="main-with-login-body">
      <header>
        <div class="logo-area header-area">
          <img class="main-logo-text" src="@/assets/logo_text.png" @click="$router.push('/')" alt="text_logo">
        </div>
        <div class="button-area">
          <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar">
        </div>
      </header>

      <main>
          <div class="action-level">
            <div class="action-level-img">
              <img src="@/assets/level/peanut.png" alt="level" width="150" height="260">
              <p style="font-weight: 700;">hi! I’m your peanut :)</p>
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
                class="main-searched-col"
                @click="openModal(col, true)"
                v-for="(col, idx) in sampleData" 
                :info="col" 
                :id="idx"
                :loginBool="loginBool"
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
                   @click="moveToPage(btn.src)"
                  :key="idx">
                <p>{{ btn.name }}</p>
              </div>
            </div>
          </div>
        <navigator-bar ref="navBar" />
      </main>
      
      <footer>
        <main-footer/>
        <common-modal ref="modal" />
      </footer>

    </div>
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import CommonCollection from '@/components/CommonCollection.vue';
import MainFooter from '@/components/MainFooter.vue'
import NavigatorBar from '../components/NavigatorBar.vue';
import CommonModal from '@/components/CommonModal.vue'
import axios from 'axios';


export default {
  components: { CommonButton, MainFooter, NavigatorBar, CommonModal, CommonCollection,},
  name: "MyCollection",
  data() {
    return {
      loginBool: false,
      sampleData: {dataSet:[]},
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
          src: '/mcol/mc',
        },
        {
          name: 'Community 만들기', 
          src: '/com/mcom',
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
          src: '/mc',
        },
      ]
    }
  },
  methods: {
    openNavBar() {
      this.$refs.navBar.openNavBar()
    },
    openModal(colData, moveToPageBool) {
      this.$refs.modal.openModal(colData, moveToPageBool);
    },
    moveToPage(src) {
      console.log(src);
      this.$router.push(src);
    },
    doAxios() {
      axios.get('http://localhost:8080/main/hot',)
        .then(res => { 
            this.sampleData = res.data.dtoList;
            this.sampleData.map(i => {
            i.cuCo = "Collection";
          })
        })
        .catch(error => console.log(error));
    },
  },
  created() {
    this.doAxios();
  },
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
  cursor: pointer;
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
  display: flex;
  flex-direction: column;
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