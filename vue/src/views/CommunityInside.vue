<template>
  <div class="com-inside-page">
    <div class="com-inside-wrapper">

      <div class="com-form-wrapper">
        <div class="com-btn-area" v-if="!modifyBool">
          <template v-for="(btn, idx) in comInBtnData" :key="idx">
          <common-button :buttonName="btn.name" v-if="canModify ? (btn.id == 1 || btn.id == 3): btn.id == 2"
                        @click="separateMethods(idx)"
                        width="150" height="40" border-radius="12" :background="btn.id == 3 ? '#df0000' : 'white'" 
                        border="none" marginTop="50" marginRight="20" :color="btn.id == 3 ? 'white' : 'black'" />
          </template>
        </div>
        <div class="com-btn-area" v-if="modifyBool">
          <common-button v-for="(btn,idx) in modifyBtnData" :buttonName="btn.name" 
                        @click="modifyMethods(idx)" :key="idx" 
                        width="150" height="40" border-radius="12" background="white"
                        border="none" marginTop="50" marginRight="20" />
        </div>

        <div class="com-form-main-wrapper">
          <div class="com-form-main">

            <div class="com-body">
              <TipTap 
                  expand="expandable"
                  ref="textEditor"
                  :curationContents="communityData.text"
                  :isEditable="modifyBool"
                  @sendContents="receiveContent"
                  :key="[communityData.text, modifyBool]" />
            </div>

            <div class="com-form-comment-wrapper">
              <div class="com-form-comment">
                <comInsideComment :comId="communityData.no" />
              </div>
            </div>

          </div>
        </div>

      </div>
      
    </div>
    <big-modal
        ref="modal"
        :modalBtnData="modalBtnData"
        smallModal="이 커뮤니티에 가입하시겠습니까?"
        width="600" height="300" margin-top="200" />
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import ComInsideComment from '@/components/ComInsideComment.vue';
import TipTap from '@/components/TextEditor.vue';
import BigModal from '@/components/BigModal.vue'

export default {
  name: "CommunityInside-page",
  components: { CommonButton, ComInsideComment, TipTap, BigModal },
  data() {
    return {
      modifyBool: false,
      canModify: false,
      communityData: {},
      modifyContent: '',
      modalBtnData: [
        {
          name: '취소',
          background: 'white',
          color: 'black'
        },
        {
          name: '가입',
          background: 'black',
          color: 'white'
        }
      ],
      comInBtnData: [
        {
          id: 1,
          name: '수정하기',
          src: ''
        },
        {
          id: 2,
          name: '가입하기',
          src: ''
        },
        {
          id: 3,
          name: '삭제하기',
          src: ''
        },

      ],
      modifyBtnData: [
        {
          name: '확인',
          src: ''
        },
        {
          name: '취소',
          src: ''
        }
      ]
    }
  },
  methods: {
    separateMethods(idx) {
      if(idx == 0) {
        this.modifyBool = true;
      }
      else if (idx == 1){
        this.$refs.modal.openModal(true);
      } else if (idx == 2) {
        console.log("삭제")
      }
    },
    receiveContent(content) {
      this.modifyContent = content;
      this.communityData.text = content;
      console.log("this.modifyContent", this.modifyContent);

      const calledAxios = this.$store.state.storedAxios;
      calledAxios.post('/com/in/mod', {
          no: this.communityData.no,
          content: content
        })
    },
    modifyMethods(idx) {
      if(idx == 0) {
        console.log('확인을 눌렀다!, 서버로 데이터를 보내자!');
        this.$refs.textEditor.sendContents();
        
        this.modifyBool = false;
      } else if (idx == 1) {
        this.modifyBool = false;
      }
    },
    doAxios(comNo) {
      const calledAxios = this.$store.state.storedAxios;
      calledAxios.get('/com/in', {
        params: {
          no: comNo
        }
      })
        .then(res => {
          console.log(res.data);
          this.communityData = res.data;
          this.canModify = this.communityData.creater.email 
                            == sessionStorage.getItem('email');
        })

    }
  },
  created() {
    let comNo = this.$route.params.communityNo;
    this.doAxios(comNo);
    console.log("communityNo >>>>> ",this.$route.params.communityNo)
  }
}
</script>

<style scoped>
.com-inside-page {
  max-width: 1200px;
  min-width: 1200px;
  width: 100vw;
  height: 100vh;
  /* background: lightcoral; */
  margin: 0 auto;
}

.com-btn-area {
  display: flex;
  justify-content: flex-end;

}
.com-body::-webkit-scrollbar{
  display: none;
  width: 0
}
.com-form-main-wrapper {
  display: flex;
  justify-content: center;
}

.com-form-main {
  width: 1000px;
  background: #F6F6F6;
  margin-top: 50px;
  margin-bottom: 60px;
  padding-bottom: 50px;
}

.com-body {
  height: 800px;
  background: white;
  margin: 50px 50px auto;
  padding: 20px;
}

.com-form-comment {
  background: #F4F0F0;
  margin: 0 50px auto 50px;
  min-height: 1100px;
  padding-bottom: 50px;

}


</style>