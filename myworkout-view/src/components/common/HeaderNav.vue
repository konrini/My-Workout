<template>
  <header v-if="showHeader">
      <nav  class="header-nav">
        <div>
            <router-link to="/">HOME</router-link>
        </div>
          <div>
              <router-link to="/video">Video </router-link>
              <router-link to="/user/login">Login </router-link>
              <router-link to="/myPage">MyPage</router-link>
          </div>
      </nav>
  </header>
</template>

<script>

export default {
    data(){
        this.$route.path === '/' ? this.showHeader = false : this.showHeader = true
    }
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