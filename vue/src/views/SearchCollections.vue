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
                @click="openModal(col)"
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
      this.sampleData.dataSet[i].folder = 'FolerNo...' + i;
      this.sampleData.dataSet[i].src = this.sampleData.imgUrl[random];
      this.sampleData.dataSet[i].hashTag = ['HashTag...'+i, 'HashTag...'+(i+1), 'HashTag...'+(i+2)];
      this.sampleData.dataSet[i].regDate = '2022-03-01';
      this.sampleData.dataSet[i].modDate = '2022-03-02';
    }
    console.log(this.sampleData.dataSet[0].hashTag)
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
  font-family: 'Noto-sans KR','Apple SD Gothic Neo', sans-serif ;
}
</style>