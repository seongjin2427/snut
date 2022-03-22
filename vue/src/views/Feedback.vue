<template>
<div class="feedback">
  <div class="feedback-bar">
    <ul>
      <li @click="gotoInformation">정보</li>
      <li>FAQ</li>
      <li>의견보내기</li>
    </ul>
  </div>
<!--  <Faq></Faq>-->
  <Information></Information>
<!--  <SendFeedback></SendFeedback>-->
</div>

</template>

<script>
// import SendFeedback from "@/components/SendFeedback";
import Information from "@/components/Information";
// import Faq from "@/components/Faq";

export default {
  name: "Feedback-page",
  components:{
    // Faq,
  Information,
  // SendFeedback
},
  methods: {
    gotoInformation(){
      this.$router.push({path: "views/Information.vue"});
    }
  }

};
</script>

<style scoped>
.feedback{
  width: 1680px;
  height: 100%;
  max-width: 1680px;
}
.feedback-bar{
  background: #EECAC6;
  width: 400px;
  position: fixed;
  height: 100%;
  overflow: visible;
  font-family: 'Noto-sans KR','Apple SD Gothic Neo', sans-serif ;
  z-index: 0;
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
}
ul{

  position: relative;
  font-family: 'Noto-sans KR','Apple SD Gothic Neo', sans-serif ;
  list-style: none;
}
li{
  /* Auto layout */
  font-family: 'Noto-sans KR','Apple SD Gothic Neo', sans-serif ;
  display: block;
  margin: 85px auto;
  text-align: center;
  font-weight: 700;
  font-size: 25px;

}
</style>