import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import SearchCollections from '@/views/SearchCollections.vue'
import About from "@/views/About.vue";
import Faq from "@/views/Faq.vue";

const routes = [
  {
    path: "/",
    component: MainWithLogin
  },
  {
    path: "/col",
    component: SearchCollections
  },
  {
    path:"/ab",
    component: About

  },
  {
    path:"/faq",
    component: Faq
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;