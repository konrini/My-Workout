<template>
  <div>
      <br><br>
      <b-row class="justify-content-md-center">
        <h3>
          My Page
        </h3>
      </b-row><br>
      <b-nav tabs align="center"> 
        <b-nav-item to="/MyPage/info" :active="$route.name == 'personalInfocheck'" >내 정보</b-nav-item>
        <b-nav-item to="/MyPage/follower" :active="$route.name == 'followerList'">Follow</b-nav-item>
      </b-nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>