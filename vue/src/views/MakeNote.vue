<template>
  <div class="my-note">
    <div class="my-note-body">
      <header>
        <div class="logo-area header-area">
          <img class="logo-text" src="@/assets/logo_text.png" alt="text_logo">
        </div>
        <div class="make-note-header">
          <common-button 
              v-for="(btn, idx) in btnSet"
              width="150" 
              height="40" 
              :buttonName="btn.name" 
              background="white" 
              border="none"
              fontSize="16"
              marginRight="20"
              :key="idx" />
        </div>
      </header>
      <main>

        <div class="write-container">
          <div class="write-with-picture">

            <div class="write-with-picture-header">
              <div class="circle-btn" 
                  @click="withPicEvent(idx)"
                  v-for="(btn, idx) in circleBtnSet" 
                  :style="{ background: btn.color }"
                  :key="idx"></div>
            </div>

            <div class="write-area">
              
              <div class="write-area-with-pic" v-if="withPic">
                <div class="piture-div">
                </div>
                <div class="write-div">
                  
                </div>
              </div>
              <div class="write-area-with-nonpic" v-if="!withPic">
                <div class="write-div nonpic">
                  <TipTap width="2000" height="5000" />
                </div>
              </div>
            </div>

            <div class="hash-tag-div">
              <input class="hash-tag" type="text"
                  style="width: 130px;"
                  @input="inputAutoWidth($event, idx)"
                  v-model="tag.content" 
                  v-for="(tag, idx) in hashTagSet" 
                  :key="idx">
            </div>
          </div>

        </div>

      </main>
      
      <footer>
        <main-footer/>
      </footer>

    </div>
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import MainFooter from '@/components/MainFooter.vue'
import TipTap from '@/components/TextEditor.vue'


export default {
  components: { CommonButton, MainFooter, TipTap },
  name: "MakeNote",
  data() {
    return {
      circleBtnSet: [
        {
          id: 1, 
          color: '#EECAC6'
        },
        {
          id: 2, 
          color: '#F3D675'
        }
      ],
      btnSet: [{
        id: 1,
        name: '저장',
        src: ''
      },
      {
        id: 2,
        name: '글쓰기 취소',
        src: ''
      },
      {
        id: 3,
        name: '임시저장',
        src: ''
      },
      {
        id: 4,
        name: '공개',
        src: ''
      },
      {
        id: 5,
        name: '비공개',
        src: ''
      }],
      hashTagSet: [
        {
          id: 1,
          content: ''
        },
        {
          id: 2,
          content: ''
        },
        {
          id: 3,
          content: ''
        },
      ],
      withPic: true
    }
  },
  methods: {
    inputAutoWidth(e, idx) {
      console.log(e, idx);
      e.target.style.width = 100 + (16 * e.target.value.length)+'px';
      console.log(e.target.value.trim() == '')
      if(e.target.value.trim() == '') {
        e.target.style.width = 130+'px';
      }
    },
    withPicEvent(id) {
      id == 1 ? this.withPic = false : this.withPic = true;
    }
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
.logo-text {
  width: 113px;
  height: 39px;
  margin-top: 60px;
  /* position: absolute; */
  left: 0;
  top: 0;
}
.make-note-header {
  width: 70%;
  display: flex;
  justify-content: center;
  margin-top: 60px;
}

/* main 구간 */
.write-container {
  width: calc(100%-100px);
  max-width: 1200px;
  height: 800px;
  padding: 0 50px;
  background: white;
  border: 1px solid black;
  border-radius: 12px;
}
.write-with-picture {
  width: 100%;
  height: 100%;
}
.write-with-picture-header {
  width: 100%;
  height: 120px;
  /* background: red; */
  display: flex;
}
.circle-btn {
  width: 30px;
  height: 30px;
  border-radius: 15px;
  margin-top: 40px;
  margin-right: 60px;
  cursor: pointer;
}
.write-area {
  width: 100%;
  height: 500px;
}
.write-area-with-pic {
  display: flex;
  justify-content: space-between;
}
.piture-div {
  width: 500px;
  height: 500px;
  background: blue;
}
.write-div {
  width: 460px;
  height: 420px;
  border-radius: 12px;
  padding: 40px 20px;
}
.nonpic {
  width: 1060px;
  height: 460px;
  /* background: lightcoral; */
  border-radius: 12px;
  padding: 20px 20px;

}
.hash-tag-div {
  width: 100%;
  background: mintcream;
  text-align: right;
  margin-top: 30px;
}
.hash-tag {
  width: 150px;
  height: 40px;
  background: white;
  border-radius: 20px;;
  margin-left: 20px;
  font-size: 18px;
  font-weight: bold;
  text-align: center;
}
</style>