<template>
  <div class="store-collections">
    <div class="store-collections-body">

      <header>
        <div class="header-area">
          <common-button 
              width="150" 
              height="40" 
              v-for="(btn, idx) in btnDataSet"
              :buttonName="btn.name"
              @click="btnMethods(idx)"
              background="white" 
              marginRight="30"
              border="none" 
              :key="idx" />
        </div>
        <div class="store-col-header-center">
        </div>
        <div class="button-area">
          <common-button 
              width="150" 
              height="40" 
              buttonName="선택하기" 
              :background="selectMode ? 'lightgrey' : 'white'"
              border="none"
              @click="selectCol" />
        </div>
      </header>

      <main>

        <div class="main-col">
          <div class="main-col-area">
            <common-curation
                ref="showCol"
                class="main-show-col"
                @dragstart="!selectMode && startDrag($event, idx)"
                @drop="!selectMode && onDrop($event, idx)"
                @dragenter.prevent
                @dragover.prevent
                @click="!selectMode && openModal(col), selectMode && selectCurations(idx, col.id)"
                @deleteCol="deleteCol"
                v-for="(col, idx) in sampleData.dataSet"
                :info="col"
                :id="idx"
                :delColBoolean="true"
                :loginBool="loginBool"
                :selectMode="selectMode"
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
import CommonCuration from '@/components/CommonCuration.vue';
import MainFooter from '@/components/MainFooter.vue'
import NavigatorBar from '../components/NavigatorBar.vue';
import SampleData from '@/assets/sampleData.json';
import CommonModal from '../components/CommonModal.vue';


export default {
  components: { CommonButton, CommonCuration, MainFooter, NavigatorBar, CommonModal },
  name: "StoreCollections",
  data() {
    return {
      loginBool: true,
      selectMode: false,
      sampleData: {dataSet:[]}, 
      userCollection: [],
      btnDataSet: [
        {
          name: '발행하기',
        },
        {
          name: '발행취소',
        }
      ],
      selectedCurationsData: [],
      sendToCuration: [[]]
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
    deleteCol(id) {
      // console.log("StoreCollections.info", info);
      this.sampleData.dataSet.splice(id, 1);
    },


    selectCol() {
      if (this.selectMode == true) {
        this.selecteMode = false;
        this.resetSelectMode();
      } else {
        this.selectMode = true;
      }
    },
    selectCurations(id, colId) {
      this.$refs.showCol[id].selectedMethod(id);

      let arr = Array.from(this.selectedCurationsData);
      let findIndex = arr.findIndex(v => v === colId)

      if(findIndex == -1) arr.push(colId);
      else arr.splice(findIndex, 1);


      this.selectedCurationsData = arr;
            
      console.log("data", this.selectedCurationsData);
      console.log("arr", arr);
    
    },
    btnMethods(idx){
      if(idx == 0) {
        console.log('발행하기 버튼을 눌렀다!');
        let sendArr = Array.from(this.selectedCurationsData);
        console.log("sendArr", sendArr);

        this.resetSelectMode();
      } else {
        this.resetSelectMode();
      }
    },
    resetSelectMode() {
        this.selectMode = false;
        this.selectedCurationsData = [];
        for(var cu of this.$refs.showCol) {
          cu.selected = false;
        }
    },


    makeDummies() {
      const INPUT_NUMBER = 20;

      for(var j = 0; j < INPUT_NUMBER; j++) {
        this.userCollection[j] = j;
      }

      for(var i = 0; i < INPUT_NUMBER; i++) {
        var random = Math.floor(Math.random()*10);
        this.sampleData.dataSet[i] = {};
        this.sampleData.dataSet[i].id = i+1;
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