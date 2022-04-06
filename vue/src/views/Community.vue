<template>
<div class="community-page">
  <div class="community-wrapper">

<!--header-->
  <header>
    <div class="logo-area header-area">
      <router-link to="/">
        <img class="main-logo-text" src="@/assets/logo_text.png" alt="text_logo">
      </router-link>
    </div>
    <div class="input-area">
      <input-box class="main-input" @keyup.enter="doSearch" placeholder="Enter a keyword" width="100" height="38"/>
    </div>
    <div class="button-area">
      <common-button buttonName="정렬" width="80" height="35" marginTop="5" marginRight="20" />
      <img src="@/assets/btn_hamburger.png" alt="nav_btn" @click="openNavBar">
    </div>
  </header>

<!--body-->
  <div class="community">
    <div class="community-body">
      <div class="button-area-recom">
        <common-button class="recom-bu" v-for="(btn,idx) in comBtnData" :key="idx" :buttonName="btn.name" width="200" height="80"  marginTop="50" marginRight="20" border-radius="12"
                        background="white" border="none" fontWeight="400" font-size="20" />
      </div>
      <div class="com-form">
        <div class="com-list-block">
          <community-list v-for="(list,idx) in commuBlockData" :key="idx" :list="list" @click="moveToPage(list,src)" />
        </div>
      </div>
    </div>
    <navigator-bar ref="navBar" />
  </div>

    <pagenationnum />
  </div>
</div>
</template>

<script>
import CommonButton from '@/components/CommonButton.vue';
import InputBox from '@/components/InputBox.vue';
import NavigatorBar from '../components/NavigatorBar.vue';
import CommunityList from '@/components/CommunityList.vue';
import Pagenationnum from '@/components/Pagenationnum.vue';


export default {
  name: "Community-p",
  components:{InputBox, CommonButton,NavigatorBar, CommunityList, Pagenationnum},
  data(){
    return{
      comBtnData:[
        {
        name: '추천 커뮤니티',
            src:''
        },
        {
          name: '추천 커뮤니티',
          src:''
        },
        {
          name: '추천 커뮤니티',
          src:''
        },
        {
          name: '추천 커뮤니티',
          src:''
        }
      ],
      commuBlockData:[
        {
          id: '01',
          title: 'title',
          text:'text',
          comment: 1,
          img:'',
          src:''
        },
        {
          id: '02',
          title: 'title2',
          text:'text2',
          comment: 2,
          img:'',
          src:''
        },
        {
          id: '03',
          title: 'title2',
          text:'text3',
          comment: 1,
          img:'',
          src:''
        }
      ]
    }
  },
  methods:{
    openNavBar() {
      console.log('a');
      this.$refs.navBar.openNavBar()
    },
    doSearch() {
      this.$router.push('/comlist');
    },
  },

}
</script>

<style scoped>
.community-page{
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
  height: 150px;
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
.community-body{
  display: flex;
  flex-direction: column;
  align-items: center;

}
.button-area-recom{
  display: flex;
  align-items: center;

}
.com-form{
  width: 1000px;
  height: 1025px;
  background: #F6F6F6;
  border: none;
  margin-top: 50px;
}
.recom-bu{
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
}
.com-list-block{
  width: 800px;
  height: 850px;
  background: #FFFFFF;
  border: none;
  margin: 100px auto;
}
</style>