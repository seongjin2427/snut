<template>
  <div class="store-collections">
    <div class="store-collections-body">

      <header>
        <div class="header-area">
          <div class="toggleBtn" 
              @click="changeTitle(btn)"
              v-for="(btn, idx) in storeCollectionsData" 
              :key="idx" 
              :style="{background: btn.color}">
          </div>
        </div>
        <div class="store-col-header-center">
          <common-button 
              width="300" 
              height="40" 
              :buttonName="toggleBtnTitle" 
              background="white" 
              border="none"
              fontSize="20" />
          <div class="addBtn" @click="addFolder()">
            <p>+</p>
          </div>
        </div>
        <div class="button-area">
          <common-button 
              width="150" 
              height="40" 
              buttonName="선택하기" 
              background="white" 
              border="none"
              fontSize="20"
              marginRight="20"
              @click="saveCol" />
          <common-button 
              width="150" 
              height="40" 
              buttonName="저장" 
              background="white" 
              border="none"
              fontSize="20"
              @click="saveCol" />
        </div>
      </header>

      <main>

        <div class="main-col">
          <div class="main-col-area">
            <common-collection
                ref="showCol"
                class="main-show-col"
                @dragstart="startDrag($event, idx, col)"
                @drop="onDrop($event, idx, col)"
                @dragenter.prevent
                @dragover.prevent
                @click="openModal(col, true)"
                v-for="(col, idx) in sampleData.Collection"
                :info="col"
                :id="idx"
                :delColBoolean="true"
                :loginBool="loginBool"
                @deleteCol="deleteCol"
                @sendFolderData="receivedFolderData" 
                :key="idx"
                draggable="true" />
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
import CommonModal from '@/components/CommonModal.vue';


export default {
  components: { CommonButton, CommonCollection, MainFooter, NavigatorBar, CommonModal},
  name: "StoreCollections",
  data() {
    return {
      loginBool: true,
      sampleData: { Collection: [],
                    Curation: [],
                    Folder: {
                      Curation:[],
                      Collection: []
                      } 
                  }, 
      userCollection: [],
      toggleBtnTitle: '전부',
      storeCollectionsData: [
        {
          id: 1,
          name: '전부',
          color: '#EECAC6'
        },
        {
          id: 2,
          name: '큐레이션',
          color: '#F3D675'
        },
        {
          id: 3,
          name: '컬렉션',
          color: '#AED8EA'
        },
        {
          id: 4,
          name: '폴더별',
          color: '#F6F6F6'
        },
      ]
    }
  },
  methods: {
    openNavBar() {
      this.$refs.navBar.openNavBar()
    },
    openModal(cuData, moveToPageBool) {
      if(cuData.cuCo != 'Folder') {
        this.$refs.modal.openModal(cuData, moveToPageBool);
      }
    },
    startDrag(event, idx, dragStartItem) {
      event.dataTransfer.dropEffect = "move";
      event.dataTransfer.effectAllowed = "move";

      event.dataTransfer.setData("itemId", idx);
      event.dataTransfer.setData("dragStartItem", JSON.stringify(dragStartItem));
    },
    onDrop(event, start, dragEndItem) {
      let itemId = Number(event.dataTransfer.getData("itemId"));
      let end = this.userCollection.find((item) => item == itemId);

      // 드래그 시 위치 바꾸기
      let comp = this.sampleData.Collection[end];
      this.sampleData.Collection[end] = this.sampleData.Collection[start];
      this.sampleData.Collection[start] = comp;

      // 폴더에 담기 위한 dragStart 데이터 가져오기
      let dragStartItem = JSON.parse(event.dataTransfer.getData("dragStartItem"));

      // dragStart한 아이템을 해당 목적에 맞게 폴더에 담고, 기존 아이템 지우기
      if(dragEndItem.cuCo == 'Folder') {
        if(dragStartItem.cuCo == 'Collection') {
          this.sampleData.Folder.Collection.push(dragStartItem);
        } else if(dragStartItem.cuCo == 'Curation') {
          this.sampleData.Folder.Curation.push(dragStartItem);
        }
      }

      if(itemId != start && dragEndItem.cuCo == 'Folder') {
        this.deleteCol(start);
      }

      console.log(this.sampleData.Folder);
    },
    changeTitle(btnData) {
      this.toggleBtnTitle = btnData.name;
      this.makeDummies();

      if(btnData.id == 2) {
        let curations = this.sampleData.Collection.filter(i => i.cuCo == 'Curation');
        this.sampleData.Collection = [];
        this.sampleData.Collection = curations;
      } else if (btnData.id == 3) {
        let collections = this.sampleData.Collection.filter(i => i.cuCo == 'Collection');
        this.sampleData.Collection = [];
        this.sampleData.Collection = collections;
      }
    },


    deleteCol(id) {
      // console.log("StoreCollections.info", info);
      this.sampleData.Collection.splice(id, 1);
    },
    saveCol() {
      if(!(this.sampleData.Collection.find((data) => data.title == ''))) {
        console.log(this.sampleData);
      }
    },
    addFolder() {
        let sampleFolder = {};
        let random = Math.floor(Math.random()*20);
        let i = random;

        sampleFolder.id = i;
        sampleFolder.author = 'Author....' + i;
        sampleFolder.nickName = 'NickName....' + i;
        sampleFolder.title = '';
        sampleFolder.regDate = '2022-03-01';
        sampleFolder.modDate = '2022-03-11';
        sampleFolder.folderNameIsDisabled = false;

        sampleFolder.cuCo = 'Folder';

      this.sampleData.Collection.unshift(sampleFolder);
      console.log(this.sampleData.Collection);
    },
    receivedFolderData(folderName, id) {
      this.sampleData.Collection.find((data) => data.id == id).title = folderName;
    },


    makeDummies() {
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

      // console.log(d);

      this.sampleData.Collection = d;

      
      for(var j = 0; j < this.sampleData.Collection.length; j++) {
        this.userCollection[j] = j;
      }
    }
  },
  mounted() {
    this.makeDummies();
  }
}
</script>

<style scoped>
.store-collections-body {
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
  display: flex;
  width: 30%;
  margin-top: 70px;
}
.toggleBtn {
  width: 30px;
  height: 30px;
  border-radius: 15px;
  cursor: pointer;
  margin-right: 50px;
}
.store-col-header-center {
  width: 40%;
  display: flex;
  justify-content: center;
  margin-top: 60px;
  margin-left: 50px;
}
.addBtn {
  width: 40px;
  height: 40px;
  position: relative;
  background: white;
  border-radius: 20px;
  margin-left: 10px;
  cursor: pointer;
}
.addBtn p {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 30px;
}
.button-area {
  width: 30%;
  /* background: red; */
  display: flex;
  justify-content: flex-end;
  align-items: flex-start;
  margin-top: 60px;
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
.main-show-col {
  margin-top: 20px;
  margin-right: 20px;
}
</style>