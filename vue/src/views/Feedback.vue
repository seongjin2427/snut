<template>
<div class="feedback-page">
  <!--  header-->
  <header>
    <div class="feedback-p">
      <div class="snutlogo-text">
        <router-link to="/">
          <img class="homebu" src="@/assets/logo_text.png" alt="logo_text">
        </router-link>
      </div>
      <div class="text-feedback">FEEDBACK</div>
    </div>
  </header>
<div class="feedback-form-wrapper">
  <div class="feedback-form">

  </div>
</div>
</div>
</template>

<script>
export default {
  name: "Feedback-page"
}
</script>

<style scoped>
.feedback-page{
  width: 100%;
  height: 100%;
}
header {
  height: 160px;
  width: 100%;
  background: #EECAC6;
  display: flex;
  align-items: center;
  justify-content: center;

}
.feedback-p {
  width: 90%;
  max-width: 1200px;
  margin: 0 auto;
  height: 100%;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;


}
.snutlogo-text{
  width: 113px;
  height: 39px;
  position: absolute;
  left: 5px;
  align-items: center;
  justify-content: center;
  text-align: center;
}
.text-feedback {
  display: flex;
  position: relative;
  text-align: center;
  font-style: normal;
  font-weight: 800;
  font-size: 40px;
  letter-spacing: 0.1em;
  color: #F6F6F6;

}
.feedback-form-wrapper{
  margin: 120px auto;
  width:1000px;
  height: 600px;
  color: #F6F6F6;

}
</style>