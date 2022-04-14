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
          <common-button @click="list" v-for="(list,idx) in dropdownData" :key="idx" buttonName="정렬" width="80" height="35" marginTop="5" marginRight="20" />
          <div v-if="active">
            Menu
          </div>
          <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar">
        </div>
      </header>
      <main>

        <div class="main-col">
          <div class="main-col-area">
            <common-collection 
                class="main-searched-col"
                @click="openModal(col, true)"
                v-for="(col, idx) in sampleData.Collection" 
                :info="col" 
                :id="idx"
                :loginBool="loginBool"
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
      sampleData: { 
        Collection: [],
        Curation: [],
        Folder: {
          Curation:[],
          Collection: []
        },
      }, 
      loginSignText: 'If You Want To See More, Just Sign In!',
      searchedWord: '',
      active:false,

      dropdownData: [
      {list:"전체보기"},
      {list: "큐레이션"},
      {list:"컬렉션"},
      {list:"최신순"},
      {list:"오래된순"}
    ]
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
        console.log(searchWord);
        this.$refs.inputBox.clearWord();
      }
    },
list(){
this.active = !this.active
},
    createDummies(store) {
      const INPUT_NUMBER = 11;

      // 큐레이션 구간
      let sampleCuration = [];
      for(let i = 0; i < INPUT_NUMBER; i++) {
        let random = Math.floor(Math.random()*10);
        let date = Math.floor(Math.random()*8)+1;
        sampleCuration[i] = {};
        sampleCuration[i].id = i;
        sampleCuration[i].author = 'Author....' + i;
        sampleCuration[i].nickName = 'NickName....' + i;
        sampleCuration[i].title = 'Title....' + i;
        sampleCuration[i].content = `Lorem ipsum` + i;
        sampleCuration[i].folder = 'FolderNo...' + i;
        sampleCuration[i].src = [SampleData.imgUrl[random], SampleData.imgUrl[random]];
        sampleCuration[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
        sampleCuration[i].regDate = '2022-03-0'+date;
        sampleCuration[i].modDate = '2022-03-0'+date;
        sampleCuration[i].cuCo = 'Curation';
      }



      // Curation
      let Collection = [];
      for(let i = 0; i < INPUT_NUMBER; i++) {
        let random = Math.floor(Math.random()*9);
        let date = Math.floor(Math.random()*8)+1;
        Collection[i] = {};
        Collection[i].id = i;
        Collection[i].author = 'Author....' + i;
        Collection[i].nickName = 'NickName....' + i;
        Collection[i].title = 'Title....' + i;
        Collection[i].content = `Lorem ipsum` + i;
        Collection[i].folder = 'FolderNo...' + i;
        Collection[i].src = [sampleCuration[random].src[0], sampleCuration[random].src[0]];
        Collection[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
        Collection[i].regDate = '2022-03-0'+date;
        Collection[i].modDate = '2022-03-0'+date;
        Collection[i].cuCo = 'Collection';
      }

      // 큐레이션 구간
      let Curation = [];
      for(let i = 0; i < INPUT_NUMBER; i++) {
        let random = Math.floor(Math.random()*10);
        let date = Math.floor(Math.random()*8)+1;
        Curation[i] = {};
        Curation[i].id = i;
        Curation[i].author = 'Author....' + i;
        Curation[i].nickName = 'NickName....' + i;
        Curation[i].title = 'Title....' + i;
        Curation[i].content = `Lorem ipsum` + i;
        Curation[i].folder = 'FolderNo...' + i;
        Curation[i].src = [SampleData.imgUrl[random], SampleData.imgUrl[random]];
        Curation[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
        Curation[i].regDate = '2022-03-0'+date;
        Curation[i].modDate = '2022-03-0'+date;
        Curation[i].cuCo = 'Curation';
      }

      // console.log(this.sampleData);
      
      let a = Array.from(Collection);
      let b = Array.from(Curation);
      let c = Array.from(this.sampleData.Folder);
      
      let arr = [];
      let d = arr.concat(a, b, c);

      d.sort((a, b) => {
        if(a.modDate > b.modDate) return -1;
        if(a.modDate === b.modDate) return 0;
        if(a.modDate < b.modDate) return 1;
      });

      
      store.Collection = d;
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
  width: 100%;
  max-width: 1200px;
  /* background: green; */
}
.main-col-area {
  width: 100%;
  display: flex;
  /* justify-content: space-between; */
  flex-wrap: wrap;
}
.main-searched-col {
  margin-top: 20px;
  margin-right: 20px;
}
</style>