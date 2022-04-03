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
          <div class="addBtn"><p>+</p></div>
        </div>
        <div class="button-area">
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
                @dragstart="startDrag($event, idx)"
                @drop="onDrop($event, idx)"
                @dragenter.prevent
                @dragover.prevent
                @click="openModal(col, true)"
                v-for="(col, idx) in sampleData.dataSet"
                :info="col"
                :id="idx"
                :delColBoolean="true"
                :loginBool="loginBool"
                @deleteCol="deleteCol"
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
import CommonModal from '../components/CommonModal.vue';


export default {
  components: { CommonButton, CommonCollection, MainFooter, NavigatorBar, CommonModal },
  name: "StoreCollections",
  data() {
    return {
      loginBool: true,
      sampleData: {dataSet:[]}, 
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
      this.$refs.modal.openModal(cuData, moveToPageBool);
      
      // if (cuData.cuCo == 'Curation') {
      //   this.$refs.modal.openModal(cuData, moveToPageBool);
      // } else if (cuData.cuCo == "Collection") {
      //   console.log("StoreCollections id", cuData.id);
      //   this.$router.push({
      //     path: `/mcol/store/${cuData.id}/${cuData.nickName}`
      //   });
      // }
    },
    startDrag(event, item) {
      event.dataTransfer.dropEffect = "move";
      event.dataTransfer.effectAllowed = "move";
      event.dataTransfer.setData("itemId", item);
    },
    onDrop(event, start) {
      let itemId = Number(event.dataTransfer.getData("itemId"));
      let end = this.userCollection.find((item) => item == itemId);

      let comp = this.sampleData.dataSet[end];
      this.sampleData.dataSet[end] = this.sampleData.dataSet[start];
      this.sampleData.dataSet[start] = comp;
    },
    changeTitle(btnData) {
      this.toggleBtnTitle = btnData.name;
      this.makeDummies();
      if(btnData.id == 2) {
        let curations = this.sampleData.dataSet.filter(i => i.cuCo == 'Curation');
        this.sampleData.dataSet = [];
        this.sampleData.dataSet = curations;
      } else if (btnData.id == 3) {
        let collections = this.sampleData.dataSet.filter(i => i.cuCo == 'Collection');
        this.sampleData.dataSet = [];
        this.sampleData.dataSet = collections;
      }
    },


    deleteCol(id) {
      // console.log("StoreCollections.info", info);
      this.sampleData.dataSet.splice(id, 1);
    },


    saveCol() {
      console.log(this.sampleData);
    },
    makeDummies() {
      const INPUT_NUMBER = 20;

      for(var j = 0; j < INPUT_NUMBER; j++) {
        this.userCollection[j] = j;
      }

      for(var i = 0; i < INPUT_NUMBER; i++) {
        var random = Math.floor(Math.random()*10);
        this.sampleData.dataSet[i] = {};
        this.sampleData.dataSet[i].id = i;
        this.sampleData.dataSet[i].author = 'Author....' + i;
        this.sampleData.dataSet[i].nickName = 'NickName....' + i;
        this.sampleData.dataSet[i].title = 'Title....' + i;
        this.sampleData.dataSet[i].content = `Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sit amet nisi malesuada ligula accumsan rutrum. In felis velit, ultrices vitae dignissim eu, sollicitudin at mi. Fusce in porttitor libero. Duis gravida ullamcorper eros, eu feugiat dolor ornare sed. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Ut et libero rhoncus, venenatis quam nec, tempus tellus. Curabitur elementum posuere dignissim. Maecenas eget molestie libero. Fusce sollicitudin metus enim. Integer fringilla posuere dolor sed dignissim. Sed non viverra quam. Pellentesque eros diam, maximus id ex quis, posuere cursus urna. Curabitur sit amet lectus neque. Sed feugiat magna sed risus pharetra, vitae eleifend lectus gravida.
                                          Nam cursus augue ut ante dictum tempor. Duis volutpat dapibus eros id vehicula. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus quis dictum odio. Vestibulum et ligula eget nisi commodo aliquam. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut ut tincidunt risus. Duis vel velit ante. Morbi sit amet metus convallis elit aliquam viverra.
                                          Mauris congue, libero ac vehicula molestie, risus tellus porttitor ex, quis lobortis lorem odio vitae nibh. Morbi sollicitudin metus at eros mattis, quis finibus quam efficitur. Aliquam erat volutpat. Aliquam ut vestibulum odio. Fusce lorem felis, porttitor quis ultrices eu, commodo eget massa. Vivamus vitae nisl bibendum, vulputate justo sit amet, pellentesque est. Aliquam rhoncus vitae tellus vel lacinia. Curabitur consectetur tempor felis condimentum varius. Integer at lorem in eros sollicitudin fringilla. Nam orci nulla, blandit eget mollis at, ultricies vitae urna.
                                          Aenean id elit a nisi sollicitudin tincidunt. Vivamus sapien enim, mollis sit amet leo nec, porta accumsan nunc. Praesent lorem felis, fermentum sit amet congue sit amet, ornare a ligula. Pellentesque eu malesuada magna. Nunc libero enim, ultrices sit amet rhoncus sollicitudin, sollicitudin pellentesque tortor. Nam sed mattis urna. Maecenas vitae commodo erat. Nullam consequat mauris sodales, accumsan urna ornare, vestibulum nunc. Nullam congue congue ipsum. Aenean imperdiet aliquam urna eget mattis.
                                          Proin sed molestie neque. Donec eu odio a nulla porta mattis. Phasellus vulputate eget ligula non pulvinar. Fusce semper ex purus, quis euismod lorem dictum eget. Aenean lacus felis, sagittis at pretium ultricies, ultrices id dui. Etiam ac tincidunt leo. In hac habitasse platea dictumst.`
                                          + i;
        this.sampleData.dataSet[i].folder = 'FolderNo...' + i;
        this.sampleData.dataSet[i].src = [SampleData.imgUrl[random], SampleData.imgUrl[random]];
        this.sampleData.dataSet[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
        this.sampleData.dataSet[i].regDate = '2022-03-01';
        this.sampleData.dataSet[i].modDate = '2022-03-02';

        if(i <= Math.floor(INPUT_NUMBER / 2)) {
          this.sampleData.dataSet[i].cuCo = 'Curation';
        } else {
          this.sampleData.dataSet[i].cuCo = 'Collection';
        }
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
  top: -3px;
  left: 10px;
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