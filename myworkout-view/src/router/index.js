import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import VideoView from '@/views/VideoView.vue'
import LoginPage from '@/views/LoginPage.vue'
import MyPage from '@/views/MyPage.vue'
import VideoList from '@/components/video/VideoList.vue'
import VideoDetail from '@/components/video/VideoDetail.vue'
import JoinForm from '@/components/User/JoinForm.vue'
import PwFind from '@/components/User/PwFind.vue'
import PwReset from '@/components/User/PwReset.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/video',
    component: VideoView,
    children:[
      {
        path:"",
        name:"videoList",
        component: VideoList,
      },
    ]
  },
  {
    path: '/user/login',
    name: 'login',
    component: LoginPage,
  },
  {
    path: '/myPage',
    name: 'myPage',
    component: MyPage
  },
  {
    path: '/video/:videoId',
    name: 'videoDetail',
    component: VideoDetail
  },
  {
    path:"/user/Join",
    name:"joinForm",
    component: JoinForm,
  },
  {
    path:"/user/pw",
    name:"pwFind",
    component: PwFind,
  },
  {
    path:"/user/pw",
    name:"pwReset",
    component: PwReset,
  },
  

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
