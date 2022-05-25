<template>
  <header>
      <nav class="header-nav">
        <div>
            <router-link to="/">HOME</router-link>
        </div>    
        <div v-if="this.isLogin == true">
            <router-link to="/video">Video </router-link>
            <router-link to="/myPage">MyPage</router-link>
        </div>
        <div v-else>
            <router-link to="/video">Video </router-link>
            <router-link to="/user/login">Login </router-link>
        </div>
      </nav>
  </header>
</template>

<script>
import {mapState} from 'vuex'

export default {
    data() {
        return {
        }
    },
    computed: {
        ...mapState([
        "isLogin",
        ])
    },
}
</script>

<style>
    header{
        height:50px;
        background-color: black;
    }
    .header{
        display:flex;
    }
    nav a{
        color: white;
    }
    nav a.router-link-exact-active{
        color: #EE7785;
    }
</style>