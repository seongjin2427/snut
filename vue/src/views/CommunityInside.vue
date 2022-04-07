<template>
  <div class="com-inside-page">
    <div class="com-inside-wrapper">

      <div class="com-form-wrapper">
        <div class="com-btn-area" v-if="!modifyBool">
          <common-button @click="separateMethods(idx)" class="com-btn" :buttonName="btn.name" v-for="(btn,idx) in comInBtnData" 
                        :key="idx" width="150" height="40" border-radius="12" background="white" border="none"
                        fontWeight="400" font-size="16" marginTop="50" marginRight="20" />


        </div>
        <div class="com-btn-area" v-if="modifyBool">
          <common-button @click="modifyMethods(idx)" class="com-btn" :buttonName="btn.name" v-for="(btn,idx) in modifyBtnData"
                        :key="idx" width="150" height="40" border-radius="12" background="white" border="none"
                         fontWeight="400" font-size="16" marginTop="50" marginRight="20"/>

        </div>

        <div class="com-form-main-wrapper">
          <div class="com-form-main">

            <div class="com-body">
              <TipTap 
                  ref="textEditor" 
                  :isEditable="modifyBool"
                  @sendContents="receiveContent"
                  :key="modifyBool" />
            </div>

            <div class="com-form-comment-wrapper">
              <div class="com-form-comment">
                <comInsideComment />
              </div>
            </div>

          </div>
        </div>

      </div>
      
    </div>
    <small-modal
        ref="modal"
        :modalBtnData="modalBtnData"
        smallModal="이 커뮤니티에 가입하시겠습니까?"
        width="600" height="300" margin-top="200">

    </small-modal>
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import ComInsideComment from '@/components/ComInsideComment.vue';
import TipTap from '@/components/TextEditor.vue';
import SmallModal from "@/components/SmallModal";

export default {
  name: "CommunityInside-page",
  components: { CommonButton, ComInsideComment, TipTap, SmallModal },
  data() {
    return {
      modifyBool: false,
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
          name: '북마크',
          src: ''
        }
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
        this.$refs.textEditor.extendsEditor();
      }
    else if (idx == 1){
        this.$refs.modal.openModal(true);
      }
    },
    receiveContent(content) {
      console.log(content);
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

.com-form-main-wrapper {
  display: flex;
  justify-content: center;
}

.com-form-main {
  width: 1000px;
  height: 2000px;
  background: #F6F6F6;
  margin-top: 50px;
  margin-bottom: 60px;
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
  height: 1100px;

}


</style>