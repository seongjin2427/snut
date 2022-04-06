<template>
  <div class="faq-page">
    <!--  header-->
    <header>
      <div class="faqp">
        <div class="snutlogo-text">
          <router-link to="/">
            <img class="homebu" src="@/assets/logo_text.png" alt="logo_text">
          </router-link>
        </div>
        <div class="text-faq">FAQ</div>
      </div>
    </header>

   <!--  expandable-faqlist-->
<div class="faq-wrapper">
      <div class="expandable">
        <div class="expandable-title-wrapper">
          <div class="expandable-title" >
          <p @click="toggleOnOff">01 title</p>
          </div>
          </div>
          <div class="expandable-text-wrapper" v-if="isStatusOn">
            <div class="expandable-text">
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
        </div>
      </div>
</div>


  </div>
</template>

<script>
export default {
  name: "Faq-page"
  ,
  data() {
    return {
      isStatusOn: false,

    }
  },
  methods:{
    toggleOnOff: function() {
      this.isStatusOn = !this.isStatusOn;
    }
  }
}
</script>

<style scoped>
.faq-page {
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

.faqp {
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
.faq-wrapper{
  margin: 120px auto;
  max-width: 800px;
}

.text-faq {
  display: flex;
  position: relative;
  text-align: center;
  font-family: 'Alegreya Sans', sans-serif;
  font-style: normal;
  font-weight: 800;
  font-size: 40px;
  letter-spacing: 0.1em;
  color: #F6F6F6;

}

.expandable {
  cursor: s-resize;
  padding-top: 200px;
  font-size: 30px;
  border-bottom: 3px solid #292f6d;
  text-align: center;
  transition: all .5s;

}

.expandable-title-wrapper {
  display: flex;
  justify-content: space-between;

}

.expandable-title {
  display: flex;
  align-items: center;
  font-weight: 600;
  font-size: 30px;
  color: #292f6d;
}
.expandable-text-wrapper{
  transition: all .5s;
}
.expandable-text{
  padding-top: 50px;
  padding-bottom: 30px;
  font-weight: 300;
  font-size: 25px;

}

</style>