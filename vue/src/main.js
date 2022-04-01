import { createApp } from 'vue'
import App from './App.vue'
import router  from './router/index'
import Vue3ColorPicker from "vue3-colorpicker";
import "vue3-colorpicker/style.css";

const app = createApp(App);

app
  .use(router)
  .use(Vue3ColorPicker)
  .mount('#app');
