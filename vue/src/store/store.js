import { createStore } from 'vuex';
import axios from 'axios';

export const store = createStore({
  state() {
    return {
      message: 'store 실행',
      storedAxios: axios.create({
        baseURL: 'http://localhost:8080/api',
        headers: {
          token: sessionStorage.getItem('token'), // header의 속성
        }
      })
    }
  },
  getters: {
    getMessage(state) {
      return state.message;
    },
  }, 
  mutations: {
    setMessage(state, text) {
      state.message = text;
    },
  }, 
  actions: {

  }
});