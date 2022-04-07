<template>
  <div class="comInsideComment">
    <!--  form-->
    <div class="comment-view">
      <ul class="list-comment">
        <!--list-->
        <li>
          <div class="comment-section">
            <div class="comment-info">
              <div class="comment-post">

                <div class="profile-info">
                  <div class="nickName">{{ communityDataSet.nickName }}</div>
                  <span class="time">{{ communityDataSet.getTime }}</span>
                </div>

                <div class="box-post">
                  <p class="desc-info">
                    <span class="origin-comment" tabindex="0"> 이건 댓글입니다.</span>
                  </p>
                </div>

                <div class="comment-more">
                  <div class="reply">reply</div>
                  <button class="action" @click="modifyModal($event)">
                    <img src="@/assets/icon/com-button.png" alt="com-button" class="actbu">
                  </button>
                  <!-- 더보기 버튼 클릭시 노출될 항목 -->
                  <div class="modifyCon" :style="{left:modifyleft+140+'px', top:modifytop-80+'px'}">


                  <div id="moreContent">
                  <span id="Content">
                <span class="moreDetail" id="modifyBoard" @click="modifycom($event)">수정</span><br>
                    <span class="moreDetail" id="deleteBoard" @click="deletecom($event)">삭제</span><br>
                  </span>
                  </div>
                  </div>


                </div>
              </div>
            </div>
          </div>
        </li>

        <!--list-->
        <li>
          <div class="comment-section">
            <div class="comment-info">
              <div class="comment-post">

                <div class="profile-info">
                  <div class="nickName">{{ communityDataSet.nickName }}</div>
                  <span class="time">{{ communityDataSet.getTime }}</span>
                </div>

                <div class="box-post">
                  <p class="desc-info">
                    <span class="origin-comment" tabindex="0"> 이건 댓글입니다.</span>
                  </p>
                </div>

                <div class="comment-more">
                  <div class="reply">reply</div>
                  <button class="action" @click="modifyModal($event)">
                    <img src="@/assets/icon/com-button.png" alt="com-button" class="actbu">
                  </button>
                </div>

              </div>
            </div>
          </div>
        </li>

        <!-- 하나의 댓글 끝 -->
      </ul>
    </div>
    <div class="comment-paging">
      <pagenationnum scale="scale(0.5, 0.5)"></pagenationnum>
    </div>

    <!-- 댓글 페이징 처리-->
    <div class="comment-text-write">
      <div class="inner-text-write">
        <div class="box-text-area">
          <textarea maxlength="800" placeholder="Enter your comments">
          </textarea>
        </div>
        <div class="wrap-menu">
          <div class="area">
            <span class="num-text-area">
            <span class="num-text">글자 수</span>
            <span class="num-count-empty">0</span>
              /
            <span class="num-text">총 글자 개수</span>
              600
            </span>
            <div class="btn-post">
              <common-button class="post-btn" buttonName="post" width="40" height="20" border-radius="12" font-size="14"
                             background="#FBBC05"
                             color="white" border="none"></common-button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
import Pagenationnum from "@/components/Pagenationnum.vue";
import CommonButton from "@/components/CommonButton.vue";

export default {
  name: "ComInsideComment-page",
  components: {
    Pagenationnum, CommonButton
  },
  data() {
    return {
      communityDataSet: {
        getTime: "time",
        nickName: "nickName"
      },
      modifyleft: 0,
      modifytop: 0
    }
  },
  methods:{
    modifyModal(e){
      console.log(e)
      console.log(e.clientX)
      console.log(e.clientY)
      this.modifyleft = e.x
      this.modifytop = e.y
    },
    modifycom(){

    },
    deletecom(){
      alert("정말 삭제하시겠습니까?")
    }

  }
}
</script>

<style scoped>
li {
  display: list-item;
  list-style: none;
  padding-top: 20px;
}

.comment-section::after {
  content: "";
  display: block;
  width: 900px;
  border-bottom: 1px solid #D9D9D9;
  margin: 20px auto;
}

.box-post {
  margin-left: 20px;
}

.comment-more {
  display: flex;
  justify-content: flex-end;
  padding-right: 20px;
}
.comment-more button {
  cursor: pointer;
}

.reply {
  padding-right: 10px;
}

.profile-info {
  display: flex;
  align-items: center;
  padding-left: 20px;
}

.time {
  padding-left: 10px;
  font-weight: 400;
  font-size: 16px;
  color: #868686;
}

.action {
  border: none;
  background: none;
}

.comment-text-write {
  margin-top: 30px;
  padding: 0 30px;
}

.inner-text-write {
  background: white;
  padding: 12px 10px 10px 20px;
  border: 1px solid #e4e4e4;
  border-radius: 2px;
}

textarea {
  height: 90px;
  resize: none;
  width: 100%;
  margin: -5px -5px 0;
  padding: 5px 5px 0;
  font-size: 13px;
  vertical-align: top;
  background-color: transparent;
  border: 0 none;
}

button {
  border: none;
  background: none;
}

.area {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  margin-top: 20px;
}


.num-text-area {
  display: inline-block;
  margin: 10px 10px 0 3px;
  vertical-align: top;
  font-size: 13px;

}

.num-text {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;

}

.num-text-area .num-text {

  color: #959595;
  font-size: 11px;
}

.actbu {
  width: 4px;
  height: 16px;
  scale: 1;
}
.modifyCon{
  position: fixed;
}
#moreContent{
  display: block;
  top: 22px;
  right: 33px;
  min-width: 56px;
  background-color: #fff;
  border-color: #d2d2d2;
  box-shadow: 0 2px 3px 0 rgba(0,0,0,.1);
  border: 1px solid #d2d2d2;
  position: relative;
  z-index: 10;
  padding: 5px 0;
  border-radius: 2px;
  box-sizing: border-box;
}
#Content{
  display: inline-block;
  width: 100%;
  min-height: 34px;
  padding: 6px 15px 0;
  font-size: 13px;
  box-sizing: border-box;
}
</style>