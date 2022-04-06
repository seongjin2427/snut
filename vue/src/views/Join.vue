<template>
<div class="join-wrapper">
  <div class="join-p">
  <!--  header-->
  <header>
    <div class="logo-area header-area">
      <router-link to="/"><img class="logo-text" src="@/assets/logo_text.png" alt="text_logo"></router-link>
    </div>
  </header>

    <!--  body  -->
    <div class="login-form">
      <div class="form-body">
        <div class ="form-title"> JOIN</div>

        <div class="form-wrapper">
          <div class="form-input">
<!--  name-->
            <div class="name flex">
              <div class="span">
                <div class="name2">Name</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/User-Line.png" width="24" height="24" alt="name"/>
                  <input class="put" placeholder="Name">
                </div>
              </div>
            </div>

            <!--email-->
            <div class="mail flex">
              <div class="span">
                <div class="mail2">Email</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/Mail-Closed-Line.png" width="18" height="18" alt="email"/>
                  <input class="put" placeholder="Email">
                </div>
              </div>
            </div>


            <!--  password -->
            <div class="pw flex">
              <div class="span">
                <div class="pw2">Password</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/Key-Line.png" width="24" height="24" alt="pw">
                  <input class="put" placeholder="Password">
                </div>
              </div>
            </div>

            <!-- confirm pw-->
            <div class="pw flex">
              <div class="span">
                <div class="pw2">Confirm Password</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/Key-Line.png" width="24" height="24" alt="pw">
                  <input class="put" placeholder="Confirm Password">
                </div>
              </div>
            </div>

            <!--Mobile-->
            <div class="mobile flex">
              <div class="span">
                <div class="mobile2">Mobile</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/Call-Line.png" width="24" height="24" alt="mobile">
                  <input placeholder="Mobile">
                </div>
              </div>
              <div class="mobile-bu">
                <common-button buttonName="인증하기" background="white" border="none" width="85" height="35" font-weight="400"></common-button>
              </div>
            </div>

            <!--Nickname-->
            <div class="nick flex">
              <div class="span">
                <div class="nick2">Nickname</div>
                <div class="flex">
                  <img class="icon" src="@/assets/icon/Flag-Triangular-Line.png" width="24" height="24" alt="nick">
                  <input placeholder="Nickname">
                </div>
              </div>
            </div>

            <!--Gender-->
            <div class="gen flex">
              <div class="span">
                <div class="gen2">Gender</div>
                <div class="flex">
                  <input type="radio">남
                  <input type="radio">여
                </div>
              </div>
            </div>
<!--body done-->

          </div>
        </div>
      </div>
    </div>
    <!--send button-->
    <div class="send-button-wrapper">
      <common-button button-name="REGISTER" width="300" height="62" background="#DC8552" color="white" border="none"
                     border-radius="0" margin-top="30" font-size="16"></common-button>
    </div>
  </div>
</div>
</template>

<script>
import CommonButton from "@/components/CommonButton.vue";
export default {
  name: "Join-page",
  components:{CommonButton}
}
</script>

<style scoped>
.join-p{
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
.form-body{
  width:1000px;
  height: 700px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.form-title{
  height: 150px;
  font-size: 30px;
  font-weight: 700;
  display: flex;
  justify-content: center;


}
</style>