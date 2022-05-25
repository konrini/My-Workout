import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'
import creatPersistedState from 'vuex-persistedstate';

Vue.use(Vuex)

const connect = `http://localhost:9999`

export default new Vuex.Store({
  plugins: [
    creatPersistedState({
      paths: ['isLogin', 'resetId', 'user', 'diary'],
    })
  ],
  state: {
    // vuex data storage
    videos:[],
    reviews:[],
    daily:[],
    isLogin: false,
    user: '',
    resetId: '',
    diary: ''
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
    },
    DAILY_REGIST(state, payload){
      state.daily = payload
    },
    USER_LOGIN(state, payload){
      state.isLogin = true
      state.user = payload
    },
    USER_LOGOUT(state){
      state.isLogin = false
      state.user = ''
      state.diary = ''
    },
    PW_RESET(state, payload){
      state.resetId = payload
    },
    GET_DIARY(state, payload){
      state.diary = payload
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
    },
    userLogin({commit}, user) {
      const API_URL = `${connect}/user/login`
      axios({
        url: API_URL,
        method: 'POST',
        params: user
      }).then(res =>{
        console.log(res)
        if (res.data["access-token"]) {
          sessionStorage.setItem("access-token", res.data["access-token"])
          commit('USER_LOGIN', res.data["user"])
          router.push({name: 'home'})
        }
        else {
          alert("아이디나 비밀번호가 일치하지 않습니다.")
        }
      }).catch((err)=>{
        alert("아이디나 비밀번호가 일치하지 않습니다.")
        console.log(err)
      })
    },
    userJoin({commit}, user) {
      const API_URL = `${connect}/user/join`
      axios({
        url: API_URL,
        method: 'POST',
        params: user
      }).then(res =>{
        console.log(res)
        commit
        router.push({name: 'home'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    userLogout({commit}) {
      const API_URL = `${connect}/user/logout`
      axios({
        url: API_URL,
        method: 'GET'
      }).then(res =>{
        console.log(res)
        localStorage.clear()
        sessionStorage.clear()
        commit('USER_LOGOUT')
      }).catch((err)=>{
        console.log(err)
      })
    },
    pwFind({commit}, info) {
      const API_URL = `${connect}/user/pw`
      axios({
        url: API_URL,
        method: 'GET',
        params: info
      }).then(res =>{
        if (res["data"] === "success") {
          commit('PW_RESET', info.userId)
          router.push({name: 'pwReset'})
        }
        else {
          alert("아이디와 보물 1호가 일치하지 않습니다.")
        }
      }).catch((err)=>{
        console.log(err)
      })
    },
    pwReset({commit}, user) {
      const API_URL = `${connect}/user/pw`
      axios({
        url: API_URL,
        method: 'PUT',
        params: user
      }).then(res =>{
        console.log(res)
        commit
        router.push({name: 'home'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    writeReview({commit}, new_review) {
      console.log(new_review)
      const API_URL = `${connect}/video/`
      axios({
        url: API_URL,
        method: 'POST',
        params: new_review
      }).then(res =>{
        console.log(res)
        commit('WRITE_REVIEW')
      }).catch((err)=>{
        console.log(err)
      })
    },
    deleteReview({commit}, reviewId) {
      const API_URL = `${connect}/video/` + reviewId
      axios({
        url: API_URL,
        method: 'DELETE',
      }).then(res =>{
        console.log(res)
        commit('DELETE_REVIEW')
      }).catch((err)=>{
        console.log(err)
      })
    },
    modifyReview({commit}, new_review) {
      const API_URL = `${connect}/video/`
      axios({
        url: API_URL,
        method: 'PUT',
        params: new_review
      }).then(res =>{
        console.log(new_review)
        console.log(res)
        commit()
      }).catch((err)=>{
        console.log(err)
      })
    },
    writeDiary({commit}, diary) {
      const API_URL = `${connect}/dailyView/regist`
      axios({
        url: API_URL,
        method: 'POST',
        params: diary
      }).then(res =>{
        console.log(res)
        commit()
        router.push({name: 'dailyView'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    getDiary({commit}, info) {
      const API_URL = `${connect}/dailyView/regist`
      axios({
        url: API_URL,
        method: 'GET',
        params: info
      }).then(res =>{
        if (res.data.daily != null) {
          commit('GET_DIARY', res.data.daily)
        }
        router.push({name: 'RegistWork'})
        commit()
      }).catch((err)=>{
        console.log(err)
      })
    }
  },

  modules: {
  }
})
