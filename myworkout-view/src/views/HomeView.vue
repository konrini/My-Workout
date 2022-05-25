<template>
  <div class="home">
    <br><br>
    <b-row class="justify-content-md-center">
    <h2 class="animate__animated animate__tada">
      Today's Workout
    </h2>
    </b-row>
    <br><hr><br><br>
    <b-row class="justify-content-md-center">
      
      <router-link class="animate__animated animate__fadeInLeftBig mx-3" to="/video">
        <img src="../assets/homeimg/video.png">
      </router-link>
      
      <router-link class="animate__animated animate__fadeInRightBig mx-3" to="/dailyView">
        <img src="../assets/homeimg/calendar.png">
      </router-link>
    </b-row><br><br>
    <b-row class="justify-content-md-center">
      <div v-if="this.isLogin == true">
        <b-button @click="logout" variant="outline-secondary" class="mb-2">
          <b-icon icon="power" aria-hidden="true"></b-icon> Logout
        </b-button>
      </div>
      <div v-else>
        <b-button href="user/login" variant="outline-success" class="mb-2 mr-2">
          <b-icon icon="power" aria-hidden="true"></b-icon> Login
        </b-button>
        <b-button href="user/join" variant="outline-info" class="mb-2">
          <b-icon icon="person-check" aria-hidden="true"></b-icon> Join
        </b-button>
      </div>
    </b-row>
  </div>
</template>

<script>
import 'animate.css'
import {mapState} from 'vuex'

export default {
  data(){
    return {
    }
  },
  methods: {
    logout() {
      this.$store.dispatch("userLogout")
      }
  },
  computed: {
      ...mapState([
      "isLogin",
      ])
  },
}
</script>

<style scoped>
img{
  width:200px;
  height:200px
}
</style>