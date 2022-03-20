import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import SearchCollections from '@/views/SearchCollections.vue'
import MyCollection from '@/views/MyCollection.vue'

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
    path: "/mcol/main",
    component: MyCollection
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;