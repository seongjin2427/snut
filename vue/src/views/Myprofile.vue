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
    <!--  profile form -->
    <div class="profile-wrapper">
      <div class="profile-form">
        <!--form inside-->
        <!--profile-->
        <div class="profile flex">
          <p>프로필 변경</p>
          <div>
            <img src="@/assets/icon/profile.png" alt="pf">
            <button>프로필 변경</button>
          </div>
        </div>
        <!--  password -->
        <div class="repw flex">
          <p>비밀번호</p>
          <div class="span">
            <div class="repw2">Re-Password</div>
            <div class="flex">
              <img src="@/assets/icon/Key-Line.png" alt="pw">
              <input placeholder="Re-Password">
            </div>
          </div>
          <div class="span">
            <div class="repw3">Confirm-Password</div>
            <div class="flex">
              <img src="@/assets/icon/Key-Line.png" alt="pw">
              <input placeholder="Confirm-Password">
            </div>
          </div>
        </div>
        <!--email-->
        <div class="mail flex">
          <p>이메일</p>
          <div class="span">
            <div class="mail2">Email</div>
            <div class="flex">
              <img src="@/assets/icon/Mail-Closed-Line.png" alt="email">
              <input placeholder="Email">
            </div>
          </div>
        </div>
        <!--Mobile-->
        <div class="mobile flex">
          <p>핸드폰 번호</p>
          <div class="span">
            <div class="mobile2">Mobile</div>
                <div class="flex">
            <img src="@/assets/icon/Call-Line.png" alt="mobile">
            <input placeholder="Mobile">
                </div>
          </div>
        </div>
        <!--Nickname-->
        <div class="nick flex">
          <p>큐레이터명</p>
          <div class="span">
            <div class="nick2">Nickname</div>
            <div class="flex">
              <img src="@/assets/icon/Flag-Triangular-Line.png" alt="nick">
              <input placeholder="Nickname">
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Myprofile-page"
}
</script>

<style scoped>
.myprofile-page {
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

.snutlogo-text {
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

.profile-form {
  margin: 120px auto 40px auto;
  width: 1000px;
  height: 620px;
  background: #F7F7F7;
  border: 1px solid #707070;
  border-radius: 12px;
  box-sizing: border-box;
}

input:focus {
  outline: none;
}

input {
  color: #868686;
  flex: none;
  order: 0;
  flex-grow: 1;
  height: 38px;
  border: none;
  font-size: 16px;
  background: #F7F7F7;
  margin-bottom: 3px;

}

.span {
  display: inline-block;

  border-bottom: 1px solid #000000;
}

.flex {
  display: flex;
  align-items: center;
}

.flex > p {
  width: 200px;
  margin-left: 50px;
}

</style>