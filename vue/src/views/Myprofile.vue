<template>
<div class="myprofile-page">
  <!--  header-->
  <header>
    <div class="myprofile-p">
      <div class="snutlogo-text">
        <router-link to="/">
          <img class="homebu" src="@/assets/logo_text.png" alt="logo_text">
        </router-link>
      </div>
      <div class="text-myprofile">MY PROFILE</div>
    </div>
  </header>

</div>
</template>

<script>
export default {
  name: "Myprofile-page"
}
</script>

<style scoped>
.myprofile-page{
  width: 100%;
}
header {
  height: 160px;
  width: 100%;
  background: #EECAC6;
  display: flex;
  align-items: center;
  justify-content: center;

}
.myprofile-p {
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
.text-myprofile {
  display: flex;
  position: relative;
  text-align: center;
  font-style: normal;
  font-weight: 800;
  font-size: 40px;
  letter-spacing: 0.1em;
  color: #F6F6F6;

}
</style>