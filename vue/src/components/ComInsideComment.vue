<template>
  <div class="comInsideComment">
    <!--  form-->
    <div class="comment-view">
      <ul class="list-comment">

        <!--list-->
        <li v-for="(reply, idx) in communityDataSet" :key="idx" >
          <div class="comment-section">
            <div class="comment-info">
              <div class="comment-post">

                <div class="profile-info">
                  <div class="nickName">{{ reply.nickName }}</div>
                  <span class="time">{{ reply.getTime }}</span>
                </div>

                <div class="box-post">
                  <p class="desc-info">
                    <span class="origin-comment" tabindex="0">{{ reply.content }}</span>
                  </p>
                </div>

                <div class="comment-more">
                  <div class="reply">reply</div>
                  <button  class="action" @click="modifyModal($event,idx)">
                    <img src="@/assets/icon/com-button.png" alt="com-button" class="actbu">
                  </button>
                  <!-- 더보기 버튼 클릭시 노출될 항목 -->
                  <div  v-if="modalnumber==idx" class="modifyCon" :style="{left:modifyleft+40+'px', top:modifytop-40+'px'}">


                  <div id="moreContent">
                  <span id="Content">
                <span class="moreDetail" id="modifyBoard" @click="modifycom($event,idx)">수정</span><br>
                    <span class="moreDetail" id="deleteBoard" @click="deletecom($event,idx)">삭제</span><br>
                  </span>
                  </div>
                  </div>


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
      communityDataSet: [
        {
          getTime: "time1",
          nickName: "nickName1",
          content: "comment1"
        },
        {
          getTime: "time2",
          nickName: "nickName2",
          content: "comment2"
        },
        {
          getTime: "time3",
          nickName: "nickName3",
          content: "comment3"
        },
      ],
      modifyleft: 0,
      modifytop: 0,
      show: false,
      modalnumber: -1
    }
  },
  methods:{
    modifyModal(e,idx){
      if (this.modalnumber == -1) {
        // console.log(e)
        // console.log(e.offsetX)
        // console.log(e.offsetY)
        this.modifyleft = e.x
        this.modifytop = e.y
        this.modalnumber = idx;

      }else {this.modalnumber = -1}
    },
    modifycom(){

    },
    deletecom(e,idx){
      // alert("정말 삭제하시겠습니까?")
      console.log('ComInsideComment' ,idx);
      console.log(e)
      this.communityDataSet.splice(idx,1)
      // this.$emit('deletecom', this);
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

button img {
  object-fit: contain;
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