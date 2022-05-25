<template>
  <div class="container" style="width: 600px;">
    <h3>로그인
    </h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="input-1">
        <b-form-input id="input-1" v-model="user.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="input-2">
        <b-form-input id="input-2" v-model="user.password" trim type="password"></b-form-input>
      </b-form-group>
      <b-button variant="success" @click="login">로그인</b-button>
      <router-link :to="`/user/join`">
        <b-button variant="warning">회원가입</b-button>
      </router-link>
      <router-link :to="`/user/pw`">
        <b-button variant="info">비밀번호 찾기</b-button>
      </router-link>
      
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
      this.user.userId = ''
      this.user.password = ''
    }
  }
}
</script>

<style>

</style>