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
        },
      }),
      imbbKey: "8749b3a6ce349d7a69b2f7ad2994ee28",
      imageBaseURL: 'http://localhost:8080/get/img?fileName=',
      sendToCuration: [],
      curationData:{},
      searchWord:{}
    }
  },
  getters: {
    getMessage(state) {
      return state.message;
    },
    getImageBaseURL(state) {
      return state.ImageBaseURL;
    },
    getSendToCuration(state) {
      return state.sendToCuration;
    },
    getcurationData(state) {
      return state.curationData;
    }
  }, 
  mutations: {
    setMessage(state, text) {
      state.message = text;
    },
    setSendToCuration(state, arr) {
      console.log("arr", arr);
      state.sendToCuration = arr;
    },
    setCurationData(state, data) {
      state.curationData = data;
    },
    setSearchWord(state, word) {
      state.searchWord = word;
    }
  }, 
  actions: {
    setCurationData({commit, state}, payload) {
      console.log(payload);
      state.storedAxios.get(payload.url, {
        params: {
          [payload.paramName]: payload.email
        }
      }).then(res => {
        // console.log(res.data);
        commit('setCurationData', res.data)
      })
    }
  }
});