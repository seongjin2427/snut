
import { createStore } from 'vuex';

export const store = createStore({
  state() {
    return {
      message: 'store 실행',
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