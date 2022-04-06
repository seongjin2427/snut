<template>
  <div class="com-inside-page">
    <div class="com-inside-wrapper">

      <div class="com-form-wrapper">
        <div class="com-btn-area">
          <common-button class="com-btn" :buttonName="btn.name" v-for="(btn,idx) in comInBtnData" :key="idx" width="150"
                        height="40" border-radius="12" background="white" border="none"
                        fontWeight="400" font-size="16" marginTop="50" marginRight="20"
                         @click="joincomm($event, btn)"
                         />
        </div>

        <div class="com-form-main-wrapper">
          <div class="com-form-main">

            <div class="com-body">
              <TipTap :isEditable="false" />
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
    <small-modal ref="modal" :modalBtnData="modalBtnData" smallModal="이 커뮤니티에 가입하시겠습니까?" width="600" height="300" margin-top="200">

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
  components: {CommonButton, ComInsideComment, TipTap, SmallModal},
  data() {
    return {
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
      ]
    }

  },
  methods: {
    joincomm(e, join) {
      console.log(join.id);
      if (join.id == 2) {
        this.$refs.modal.openModal(true);
      }
    }
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
  background: white;
  margin: 50px 50px auto;
  height: 800px;

}

.com-form-comment {
  background: #F4F0F0;
  margin: 0 50px auto 50px;
  height: 1100px;

}


</style>