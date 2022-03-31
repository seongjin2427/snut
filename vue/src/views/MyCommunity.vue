<template>
  <div class="mycom-page">
    <!--  header-->
    <header>
      <div class="mycom-head">
        <div class="snutlogo-text">
          <router-link to="/">
            <img class="homebu" src="@/assets/logo_text.png" alt="logo_text">
          </router-link>
        </div>
      </div>
      <div class="mycom-head-bu">
        <common-button width="150" height="40" buttonName="알림" border="none" background="white" margin-right="20" />
        <common-button width="150" height="40" buttonName="커뮤니티 만들기" border="none" background="black" color="white"/>
      </div>
    </header>
    <!--header-->

<!--body-->
    <div class="mycom-body-wrapper">
<!--bookmark-->
      <div class="bookmark-wrapper">
        <div class="mycom-font">북마크</div>
        <div class="bookmark-form">
          <Bookmark
              :bookmarkData="bookmark" v-for="(bookmark, idx) in bookmarkDataSet" :key="idx"/>
        </div>
      </div>


<!-- alarm-->
      <div class="alarm-wrapper">
        <div class="mycom-font">알람</div>
        <div class="alarm-form">
          <alarm :alarmData="alarm" v-for="(alarm, idx) in alarmDataSet" :key="idx" @click="permi($event, alarm)"/>
        </div>
      </div>
    </div>
<small-modal ref="modal" :modalBtnData="modalBtnData" smallModal="닉네임 가입을 승인하시겠습니까?">

</small-modal>

  </div>
</template>

<script>
import CommonButton from "@/components/CommonButton";
import Bookmark from "@/components/Bookmark";
import Alarm from "@/components/Alarm";
import SmallModal from "@/components/SmallModal";

export default {
  name: "MyCommunity-page",
  components: { CommonButton, Bookmark,Alarm, SmallModal},
  data() {
    return {
      modalBtnData: [
        {
          name: '확인',
          background: 'white',
          color:'black'
        },
        {
          name: '취소',
          background: 'black',
          color: 'white'
        }
      ],
      alarmDataSet: [
        {
          id: 1,
          alarmTitle: '댓글 알람',
          src: '',
          icon: 'Bell-Line'
        },
        {
          id: 2,
          alarmTitle: '커뮤니티 공지사항',
          src: '',
          icon:'Keyhole-Line'
        },
        {
          id: 3,
          alarmTitle: '커뮤니티 가입 승인',
          src: '',
          icon: 'Users-Line'
        },
      ],
      bookmarkDataSet:[
        {
          id: 1,
          bookmarkTitle: '커뮤니티 리스트',
          src:'',
          icon: 'circle'
        }
      ]
    }
  },
  methods:{
    permi(e, alarm){
      console.log(alarm.id);
      if (alarm.id == 3) {
        this.$refs.modal.openModal();
      }
    }
  },

}
</script>

<style scoped>
.mycom-page {
  width: 100%;
  height: 100%;
}

.mycom-head {
  width: 70%;
  max-width: 1200px;
  margin: 0 auto;
  height: 100%;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;

}

header {
  height: 160px;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  max-width: 1200px;
  margin: 0 auto;

}

.snutlogo-text {
  width: 113px;
  height: 39px;
  position: absolute;
  left: 5px;
  align-items: center;
  justify-content: center;
  text-align: center;
}

.mycom-head-bu {
  display: flex;
  align-items: center;
  width: 30%;
}

.mycom-body-wrapper{
  display: flex;
  align-items: center;
  justify-content: center;
}
.bookmark-wrapper{
  display: inline-block;
  justify-content: center;
  text-align: center;
  margin-right: 65px;
}
.bookmark-form{
  width: 500px;
  height: 837px;
  border: 0.5px solid #000000;
  border-radius: 12px;
  background: white;

}
.alarm-wrapper{
  display: inline-block;
  justify-content: center;
  text-align: center;

}
.alarm-form{
  width: 500px;
  height: 837px;
  border: 0.5px solid #000000;
  border-radius: 12px;
  background: white;
}
.mycom-font{
  font-size: 30px;
  font-weight: 400;
  margin-bottom: 30px;
}

</style>