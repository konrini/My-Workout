<template>
    <nav class="header-nav">
    <b-container fluid class="text-light text-center my-2">
        <b-row>
            <b-col md="4">
                <router-link to="/"><b-icon class="mr-2" icon="house-fill" aria-hidden="true"/></router-link>
                <router-link to="/video"><b-icon class="ml-2 mr-4" icon="camera-video-fill" aria-hidden="true"/></router-link>
                <router-link v-if="this.isLogin == true" to="/dailyView"><b-icon icon="calendar2-check" aria-hidden="true"/></router-link>
                <router-link v-else to="/user/login"><b-icon icon="key-fill" aria-hidden="true"/></router-link>
            </b-col>
            <b-col md="6"></b-col>
            <b-col md="2">
                <router-link v-if="this.isLogin == true" :to="{name: 'personalInfocheck'}"><img :src='"@/assets/photo/"+user.photo+".png"'/></router-link>
                <!-- <b-dropdown text="" variant="light" class="m-2">
                    <b-dropdown-item href="#">Action</b-dropdown-item>
                    <b-dropdown-item href="#">Another action</b-dropdown-item>
                </b-dropdown> -->
            </b-col>
        </b-row>
    </b-container>
    </nav>
</template>

<script>
import {mapState} from 'vuex'

export default {
  computed: {
      ...mapState([
      "isLogin",
      "user"
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