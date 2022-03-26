import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import SearchCollections from '@/views/SearchCollections.vue'

const routes = [
  {
    path: "/",
    component: MainWithLogin
  },
  {
    path: "/col",
    component: SearchCollections
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;