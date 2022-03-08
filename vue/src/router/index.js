import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "../views/MainWithLogin.vue";


const routes = [
  {
    path: "/",
    component: MainWithLogin
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;