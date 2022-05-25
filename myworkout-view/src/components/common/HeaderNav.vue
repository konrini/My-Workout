<template>
    <nav class="header-nav">
    <div>
        <router-link to="/"><b-icon class="ml-3 mr-2" icon="house-fill" aria-hidden="true"/></router-link>
        <router-link to="/video"><b-icon class="ml-2 mr-4" icon="camera-video-fill" aria-hidden="true"/></router-link>
        <router-link v-if="this.isLogin == true" to="/dailyView"><b-icon icon="calendar2-check" aria-hidden="true"/></router-link>
        <router-link v-else to="/user/login"><b-icon icon="key-fill" aria-hidden="true"/></router-link>
    </div>
    </nav>
</template>

<script>

import {mapState} from 'vuex'

export default {
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
        background-color: white;
    }
    .header{
        display:flex;
    }
    nav a{
        color: black;
        font-size: 40px;
    }
    nav a.router-link-exact-active{
        color: #EE7785;
    }
</style>