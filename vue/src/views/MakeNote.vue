<template>
  <div class="my-note">
    <div class="my-note-body">
      <header>
        <div class="logo-area header-area">
          <img class="logo-text" src="@/assets/logo_text.png" alt="text_logo">
        </div>
        <div class="make-note-header">
          <common-button 
              ref="makeNoteBtn"
              @click="btnMethod($event, btn, idx)"
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
                <div class="piture-div" @click="openModal()">
                  <!-- <img src="https://www.gcf.or.kr/design/default/images/subpage/sub1417_space1_slide1.jpg" alt=""> -->
                </div>
                <div class="write-div">
                  <input type="text" placeholder="Title:" v-model="contentsWithPic.title">
                  <textarea name="" id="" cols="30" rows="10" maxlength="500" placeholder="Contents"
                  v-model="contentsWithPic.contents"/>
                </div>
              </div>
              <div class="write-area-with-nonpic" v-if="!withPic">
                <div class="write-div nonpic">
                  <TipTap />
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
        <drag-and-drop-modal ref="dndModal" />
      </footer>

    </div>
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import MainFooter from '@/components/MainFooter.vue'
import TipTap from '@/components/TextEditor.vue'
import DragAndDropModal from '@/components/DragAndDropModal.vue'

export default {
  components: { CommonButton, MainFooter, TipTap, DragAndDropModal },
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
      openBool: true,
      withPic: true,
      contentsWithPic: {
        title: '',
        contents: ''
      }
    }
  },
  methods: {
    openModal() {
      this.$refs.dndModal.openModal();
    },
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
    },
    btnMethod(e, btn) {
      console.log("btn", btn);
      if(btn.id == 1) {
        console.log("저장을 눌렀다!")
        } else if (btn.id == 2 ) {
          this.contentsWithPic.title = '';
          this.contentsWithPic.contents = '';
          console.log("글쓰기 취소를 눌렀다!")
      } else if (btn.id == 3) {
        console.log(this.contentsWithPic)
        console.log("임시저장을 눌렀다!")
      } else { 
        this.openBoolToggle(e, btn.id);
      }
    },
    openBoolToggle(e, idx) {
      if (idx == 4) {
        this.openBool = true;
        e.target.style.background = 'lightgrey';
        e.target.nextSibling.style.background = 'white';
      } else if (idx == 5) {
        this.openBool = false;
        e.target.style.background = 'lightgrey';
        e.target.previousSibling.style.background = 'white';
      }
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
  background: #F6F6F6;
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
  width: 420px;
  height: 400px;
  border-radius: 12px;
  padding: 50px 40px;
  background: #FFFFFF;
  display: flex;
  flex-direction: column;
}
.write-div * {
  background: none;
  border: none;
  font-size: 16px;
  font-weight:normal;
}
.write-div *:focus {
  outline: none;
}
.write-div *::placeholder {
  color: #666666;
}
.write-div input{
  padding-bottom: 5px;
  border-bottom: 1px solid #C4C4C4;
}
.write-div textarea {
  margin-top: 50px;
  margin-bottom: 20px;
  height: 380px;
  resize: none;
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