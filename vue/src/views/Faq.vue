<template>
  <div class="faq-page">
    <!--  header-->
    <header>
      <div class="faqp">
        <img class="homebu" src="@/assets/logo_text.png" alt="logo_text">
        <div class="text-faq">FAQ</div>
      </div>
    </header>
    <!--  expandable-faqlist-->


      <div class="expandable">
        <div class="expandable-title-wrapper">
          <p class="expandable-title">01 title</p>
          <div class="expandable-text-wrapper">
            <p class="expandable-text">texting</p>
          </div>
        </div>
      </div>


  </div>
</template>

<script>
export default {
  name: "Faq-page"
}
</script>

<style scoped>
.faq {
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

.homebu {
  width: 113px;
  height: 39px;
  position: absolute;
  left: 5px;
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
  padding-top: 300px;
  font-size: 30px;
  bottom-border: 3px solid #292f6d;
  text-align: center;

}

.expandable-title-wrapper {
  display: flex;
  justify-content: space-between;

}

.expandable-title {
  display: flex;
  align-items: center;
  font-family: 'Noto-sans KR', 'Apple SD Gothic Neo', 'Alegreya Sans', sans-serif;
  font-weight: 600;
  font-size: 30px;
  color: #292f6d;
}


</style>