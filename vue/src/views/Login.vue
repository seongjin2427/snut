<template>
<div class="login wrapper">

  <div class="login-p">
  <!--  header-->
  <header>
      <div class="logo-area header-area">
        <img class="logo-text" src="@/assets/logo_text.png" alt="text_logo">
      </div>
  </header>
    <form class="login-form">
      <div class="form-body">
        <div class ="form-title"> LOGIN </div>
      </div>
    </form>


    </div>



</div>
</template>

<script>
export default {
  name: "Login-page"
}
</script>

<style scoped>
.login-p{
  max-width: 1200px;
  min-width: 1200px;
  width: 100vw;
  height: 100vh;
  /* background: lightcoral; */
  margin: 0 auto;
}
.header-area {
  width: 30%;
}
.logo-text {
  width: 113px;
  height: 39px;
  margin-top: 60px;
  /* position: absolute; */
  left: 0;
  top: 0;
}
.login-form{
  display: flex;
  align-items: center;
  justify-content: center;
}

.form-body{
  max-width: 1000px;
  min-width: 1000px;
  height: 700px;
  display: flex;
  justify-content: center;
}
.form-title{
  font-size: 30px;
  font-weight: 700;
  display: flex;
}
</style>