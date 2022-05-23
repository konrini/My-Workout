<template>
  <div class="container">
    <h3>로그인
      <router-link :to="`/user/join`">
        Join
      </router-link>
    </h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="input-1">
        <b-form-input id="input-1" v-model="user.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="input-2">
        <b-form-input id="input-2" v-model="user.password" trim></b-form-input>
      </b-form-group>
      <b-button variant="outline-success" @click="login">로그인</b-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserView",
  data() {
    return {
      user: {
        userId: "",
        password: ""
      }
    }
  },
  methods: {
    login() {
      this.$store.dispatch('userLogin', this.user)
    }
  }
}
</script>

<style>

</style>