<template>
  <div>
    <h3>Login
      <router-link :to="`/user/join`">
        Join
      </router-link>
    </h3>
    <div class="container">
      <form>
        <div>
          <label for="id">ID</label>
          <input type="text" id="id" v-model="id" />
        </div>
        <div>
          <label for="password">비밀번호</label>
          <input type="password" id="password" v-model="password" />
        </div>
      <button type="submit">로그인</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserView"
}
</script>

<style>

</style>