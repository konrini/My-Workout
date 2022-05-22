//import axios from 'axios'
import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
//import router from '@/router'

Vue.use(Vuex)

//const connect = `http://localhost:9999/api`

export default new Vuex.Store({
  state: {
    // vuex data storage
    videos:[],
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
    }
  },
  actions: {
    getVideos({commit}){
      const API_URL = `http://localhost:9999/video/`
      axios({
        url: API_URL,
        method: 'GET'
      }).then((res) =>{
        console.log(res)
        commit('GET_VIDEOS', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    }
  },
  modules: {
  }
})
