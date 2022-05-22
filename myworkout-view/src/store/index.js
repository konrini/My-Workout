//import axios from 'axios'
import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
//import router from '@/router'

Vue.use(Vuex)

const connect = `http://localhost:9999`

export default new Vuex.Store({
  state: {
    // vuex data storage
    videos:[],
    reviews:[]
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
    },
    GET_REVIEWS(state, payload){
      state.reviews = payload
    }
  },
  actions: {
    getVideos({commit}){
      const API_URL = `${connect}/video/`
      axios({
        url: API_URL,
        method: 'GET'
      }).then((res) =>{
        console.log(res)
        commit('GET_VIDEOS', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    },
    getReviews({commit}, id){
      const API_URL = `${connect}/video/${id}`
      axios({
        url: API_URL,
        method: 'GET'
      }).then((res)=>{
        console.log(res)
        commit('GET_REVIEWS', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    }
  },
  modules: {
  }
})
