<template>
  <header>
      <nav class="header-nav">
          <div>
              <router-link to="/">Main</router-link>
          </div>
          <div>
              <router-link to="/video">Video </router-link>
              <router-link to="/user">Login </router-link>
              <router-link to="/myPage">MyPage</router-link>
          </div>
      </nav>
  </header>
</template>

<script>
export default {

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