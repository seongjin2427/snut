<template>
  <div>  
    <img class="center-logo" src="@/assets/large_logo.png" alt="Large_logo">
    <div class="pick-your-nut-box">
      <span class="nutbox0">PICK YOUR "</span>
      <span class="nutbox1">S</span>
      <span class="nutbox2">N</span>
      <span class="nutbox3">UT</span>
      <span class="nutbox0">"</span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PickYourSnut'
};
</script>

<style scoped>
.center-logo {
    width: 507px; 
    height: 406px;
    object-fit: cover;
    margin-bottom: 50px;
}
.pick-your-nut-box {
  font-family: 'alegreya';
  font-size: 40px;
  font-style: normal;
  font-weight: 800;
  width: 507px;
  line-height: 100px;
  letter-spacing: 4.00px;
  text-align: center;
  letter-spacing: 1.60px;
}
.nutbox1 {
    color: #292f6d;
}
.nutbox2 {
    color: #4f4f4f;
}
.nutbox3 {
    color: #fbe017;
}
</style>