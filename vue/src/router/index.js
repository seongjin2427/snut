import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import SearchCurations from '@/views/SearchCurations.vue'
import MyCollection from "@/views/MyCollection";
import Feedback from "@/views/Feedback";

const routes = [
  {
    path: "/",
    component: MainWithLogin
  },
  {
    path: "/col/:searchWord",
    component: SearchCurations
  },
  {
    path: "/mcol/main",
    component: MyCollection
  },
  {
    path:"/fb",
    component: Feedback

  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;