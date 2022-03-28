import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import UserCollection from "@/views/UserCollection.vue";
import SearchCollections from '@/views/SearchCollections.vue';
import MyCollection from '@/views/MyCollection.vue';
import ShowMyCollections from '@/views/ShowMyCollections.vue';
import About from "@/views/About.vue";
import Faq from "@/views/Faq.vue";
import MyNote from "@/views/MyNote.vue";

const routes = [
  {
    path: "/",
    component: MainWithLogin,
    name: "MainWithLogin"
  },
  {
    path: "/col",
    component: SearchCollections,
    name: "SearchCollections"
  },
  {
    path: "/ucol/:id/:nickName",
    component: UserCollection,
    name: "UserCollection"
  },
  {
    path: "/mcol/main",
    component: MyCollection,
    name: "MyCollection"
  },
  { 
    path: '/mcol/note',
    component: MyNote,
    name: "MyNote"
  },
  { 
    path: '/mcol/folder',
    component: ShowMyCollections,
    name: "ShowMyCollections"
  },
  {
    path:"/ab",
    component: About,
    name: "About"
  },
  {
    path:"/faq",
    component: Faq,
    name: "Faq"
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router;