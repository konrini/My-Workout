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
    reviews:[],
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
    },
    GET_REVIEWS(state, payload){
      state.reviews = payload
    }, 
    GET_FILTER(state, payload){
      state.videos = payload
    }
  },
  actions: {
    // 전체 영상 가져오기
    getVideos({commit}){
      const API_URL = `${connect}/video/`
      axios({
        url: API_URL,
        method: 'GET'
      }).then((res) =>{
        commit('GET_VIDEOS', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    },
    // 영상별 리뷰 가져오기
    getReviews({commit}, id){
      const API_URL = `${connect}/video/${id}`
      axios({
        url: API_URL,
        method: 'GET'
      }).then((res)=>{
        commit('GET_REVIEWS', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    },
    // 카테고리별 영상 가져오기
    getFilter({commit}, category){
      const API_URL = `${connect}/video/c/${category}`
      axios({
        url: API_URL,
        method: 'GET',
        params: category
      }).then((res)=>{
        commit('GET_FILTER', res.data)
      }).catch((err)=>{
        console.log(err)
      })
    }
  },
  modules: {
  }
})
