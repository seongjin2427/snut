<template>
  <div class="my-note">
    <div class="my-note-body">
      <header>
        <div class="logo-area header-area">
          <!-- <img class="main-logo-text" src="@/assets/logo_text.png" alt="text_logo"> -->
        </div>
        <div class="my-note-title">
          <common-button 
              @click="moveToPage()"
              width="300" 
              height="40" 
              buttonName="오늘의 기록"
              background="white" 
              border="none"
              fontSize="20" />
        </div>
        <div class="button-area">
          <!-- <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar"> -->
        </div>
      </header>
      <main>

        <div class="main-col">
          <div class="main-col-area">
            <common-collection 
                class="main-searched-col"
                @click="openModal(col, true)"
                v-for="(col, idx) in sampleData.dataSet" 
                :info="col" 
                :id="col.id"
                :key="idx" />
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
import SampleData from '@/assets/sampleData.json';
import CommonModal from '../components/CommonModal.vue';


export default {
  components: { CommonButton, CommonCollection, MainFooter, NavigatorBar, CommonModal },
  name: "MainWithLogin",
  data() {
    return {
      loginBool: false,
      sampleData: {dataSet:[]},
    }
  },
  methods: {
    openNavBar() {
      this.$refs.navBar.openNavBar()
    },
    openModal(cuData, moveToPageBool) {
      this.$refs.modal.openModal(cuData, moveToPageBool);
    },
    moveToPage() {
      this.$router.push({path: '/mcol/note/makenote'})
    },
    createDummies(store) {
      for(var i = 0; i < 20; i++) {
        var random = Math.floor(Math.random()*10);
        store.dataSet[i] = {};
        store.dataSet[i].id = i;
        store.dataSet[i].author = 'Author....' + i;
        store.dataSet[i].nickName = 'NickName....' + i;
        store.dataSet[i].title = 'Title....' + i;
        store.dataSet[i].content = 'Content...' + i;
        store.dataSet[i].folder = 'FolerNo...' + i;
        store.dataSet[i].src = [SampleData.imgUrl[random], SampleData.imgUrl[random]];
        store.dataSet[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
        store.dataSet[i].regDate = '2022-03-01';
        store.dataSet[i].modDate = '2022-03-02';

      }
    }
  },
  created() {
    this.createDummies(this.sampleData);
  }
}
</script>

<style scoped>
.my-note-body {
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
.header-area {
  width: 30%;
}
.main-logo-text {
  width: 113px;
  height: 39px;
  margin-top: 60px;
  /* position: absolute; */
  left: 0;
  top: 0;
}
.my-note-title {
  width: 40%;
  display: flex;
  justify-content: center;
  margin-top: 60px;
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

/* 컬렉션 구간 */
.main-col {
  width: calc(100%-200px);
  max-width: 1200px;
  /* background: green; */
  padding: 0 100px;
}
.main-col-area {
  width: 100%;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}
.main-searched-col {
  margin-top: 20px;
}
</style>