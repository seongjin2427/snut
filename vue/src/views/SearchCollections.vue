<template>
  <div class="main-with-login">
    <div class="main-with-login-body">
      <header>
        <div class="logo-area header-area">
          <img class="main-logo-text" src="@/assets/logo_text.png" alt="text_logo">
        </div>
        <div class="input-area">
          <input-box class="main-input" placeholder="SEARCH" width="100" height="38" />
        </div>
        <div class="button-area">
          <common-button buttonName="정렬" width="80" height="35" marginTop="5" marginRight="20" />
          <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar">
        </div>
      </header>
      <main>

        <div class="main-col">
          <div class="main-col-area">
            <common-collection 
                class="main-searched-col"
                @click="openModal(sampleData.data[col])"
                v-for="(col, idx) in searchedCu" 
                :info="sampleData.data" 
                :id="col"
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
import InputBox from '@/components/InputBox.vue';
import MainFooter from '@/components/MainFooter.vue'
import NavigatorBar from '../components/NavigatorBar.vue';
import SampleData from '@/assets/sampleData.json';
import CommonModal from '../components/CommonModal.vue';


export default {
  components: { InputBox, CommonButton, CommonCollection, MainFooter, NavigatorBar, CommonModal },
  name: "MainWithLogin",
  data() {
    return {
      loginBool: false,
      sampleData: SampleData,
      loginSignText: 'If You Want To See More, Just Sign In!',
      searchedCu: []
    }
  },
  methods: {
    openNavBar() {
      console.log('a');
      this.$refs.navBar.openNavBar()
    },
    openModal(cuData) {
      this.$refs.modal.openModal(cuData);
    }
  },
  created() {
    const INPUT_NUMBER = 21;
    for(var j = 0; j < INPUT_NUMBER; j++) {
      this.searchedCu[j] = j;
    }

    for(var i = 0; i < INPUT_NUMBER; i++) {
      var random = Math.floor(Math.random()*10);
      this.sampleData.data[i] = {};
      this.sampleData.data[i].id = i;
      this.sampleData.data[i].author = 'Author....' + i;
      this.sampleData.data[i].nickName = 'NickName....' + i;
      this.sampleData.data[i].title = 'Title....' + i;
      this.sampleData.data[i].content = 'Content...' + i;
      this.sampleData.data[i].folder = 'FolerNo...' + i;
      this.sampleData.data[i].src = this.sampleData.imgUrl[random];
      this.sampleData.data[i].regDate = '2022-03-01';
      this.sampleData.data[i].modDate = '2022-03-02';
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
.input-area {
  width: 40%;
  text-align: center;
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