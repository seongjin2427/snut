import { createRouter, createWebHistory  } from 'vue-router';
import MainWithLogin from "@/views/MainWithLogin.vue";
import UserCollection from "@/views/UserCollection.vue";
import SearchCollections from '@/views/SearchCollections.vue';
import MyCollection from '@/views/MyCollection.vue';
import MakeNote from '@/views/MakeNote.vue'
import StoreCollections from '@/views/StoreCollections.vue';
import StoreColCurations from '@/views/StoreColCurations.vue';
import About from "@/views/About.vue";
import Faq from "@/views/Faq.vue";
import MyNote from "@/views/MyNote.vue";
import Myprofile from "@/views/Myprofile";
import Feedback from "@/views/Feedback";

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
    path: '/mcol/note/makenote',
    component: MakeNote,
    name: "MakeNote"
  },
  { 
    path: '/mcol/note',
    component: MyNote,
    name: "MyNote"
  },
  { 
    path: '/mcol/store',
    component: StoreCollections,
    name: "StoreCollections"
  },
  { 
    path: '/mcol/store/:colId/:nickName',
    component: StoreColCurations,
    name: "StoreColCurations"
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
  },
  {
    path:"/pf",
    component: Myprofile
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