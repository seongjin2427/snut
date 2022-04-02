<template>
  <div class="search-collections">
    <div class="search-collections-body">
      <header>
        <div class="logo-area header-area">
          <img class="main-logo-text" src="@/assets/logo_text.png" @click="$router.push('/')" alt="text_logo">
        </div>
        <div class="input-area">
          <input-box 
              ref="inputBox"
              class="search-input"
              @doSearch="doSearch"
              placeholder="SEARCH"
              width="100"
              height="38" />
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
import InputBox from '@/components/InputBox.vue';
import MainFooter from '@/components/MainFooter.vue'
import NavigatorBar from '../components/NavigatorBar.vue';
import SampleData from '@/assets/sampleData.json';
import CommonModal from '../components/CommonModal.vue';


export default {
  components: { InputBox, CommonButton, CommonCollection, MainFooter, NavigatorBar, CommonModal },
  name: "SearchCollections",
  data() {
    return {
      loginBool: false,
      sampleData: {dataSet: [] },
      loginSignText: 'If You Want To See More, Just Sign In!',
      searchedWord: ''
    }
  },
  methods: {
    openNavBar() {
      console.log('a');
      this.$refs.navBar.openNavBar()
    },
    openModal(cuData, moveToPageBool) {
      this.$refs.modal.openModal(cuData, moveToPageBool);
    },
    doSearch(searchWord) {
      if(searchWord != '') {
        this.$router.push(`/col/${searchWord}`);
        this.$refs.inputBox.clearWord();
      }
    },
    createDummies(store) {
      for(var i = 0; i < 50; i++) {
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
.search-collections-body {
  max-width: 1200px;
  min-width: 1200px;
  /* width: 100vw;
  height: 100vh; */
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
  cursor: pointer;
}
.input-area {
  width: 40%;
  text-align: center;
}
.search-input {
  margin-top: 67px;
  margin-right: 5%;
}
.button-area {
  width: 30%;
  /* background: red; */
  display: flex;
  justify-content: space-between;
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