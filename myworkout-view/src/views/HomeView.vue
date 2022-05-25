<template>
  <div class="home">
    <br><br>
    <h3>MIMIZZANG HOME</h3>
    <br><hr>
    <b-button variant="primary" href="/video">Video</b-button>
    <b-button variant="primary" href="/myPage">MyPage</b-button>
    <div v-if="this.isLogin == true">
        <b-button variant="primary" @click="logout">Logout</b-button>
    </div>
    <div v-else>
      <b-button variant="primary" href="user/login">Login</b-button>
    </div>
  </div>
</template>

<script>
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
