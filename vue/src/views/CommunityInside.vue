<template>
  <div class="com-inside-page">
    <div class="com-inside-wrapper">

      <div class="com-form-wrapper">
        <div class="com-btn-area">
          <common-button class="com-btn" :buttonName="btn.name" v-for="(btn,idx) in comInBtnData" :key="idx" width="150"
                        height="40" border-radius="12" background="white" border="none"
                        fontWeight="400" font-size="16" marginTop="50" marginRight="20"/>
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
  </div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import ComInsideComment from '@/components/ComInsideComment.vue';
import TipTap from '@/components/TextEditor.vue';

export default {
  name: "CommunityInside-page",
  components: { CommonButton, ComInsideComment, TipTap },
  data() {
    return {
      comInBtnData: [
        {
          name: '수정하기',
          src: ''
        },
        {
          name: '가입하기',
          src: ''
        },
        {
          name: '북마크',
          src: ''
        }
      ]
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