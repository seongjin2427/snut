<template>
  <div class="footer">
    <div class="footerMenu" v-for="(title, idx) in footerTitle" :key="idx">
      <p><a :href="title.src">{{ title.name }}</a></p>
    </div>
    <div class="footer-logo">
      <img src="@/assets/small_logo.png" alt="footer_img">
      {{ writeCmt }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainFooter',
  data() {
    return {
      footerTitle: [
        { name: 'ABOUT', 
          src: ''
        },
        { name: 'FAQ', 
          src: ''
        },
        { name: 'FEEDBACK', 
          src: ''
        },
        { name: 'MY PROFILE', 
          src: ''
        },
      ],
      writeCmt: '© snut. 2021 We love our users!'
    }
  }
}
</script>

<style scoped>
.footer {
  /* background: lightgreen; */
  height: 340px;
  position: relative;
  display: flex;
  justify-content: center;
  padding: 0 100px;
  justify-content: center;
  align-items: center;
}
.footerMenu {
  width: 300px;
  height: 100%;
  /* background: lightgray; */
  display: flex;
  justify-content: center;
  align-items: center;
  color: #292F6D;
  font-size: 25px;
  margin-bottom: 30px;
}
.footerMenu:nth-child(2) {
  margin-right: 200px;
}
.footer-logo {
  height: 100%;
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.footer-logo img {
  margin-bottom: 30px;
}
a {
  text-decoration: none;
  color: #292F6D;
}
</style>