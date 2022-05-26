<template>
  <div class="container" style="width: 600px;"><br><br>
    <h3>로그인
    </h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="input-1">
        <b-form-input id="input-1" v-model="user.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="input-2">
        <b-form-input @keydown.13="login" id="input-2" v-model="user.password" trim type="password"></b-form-input>
      </b-form-group>
      <b-button @click="login" variant="outline-success" class="mb-2 mr-2">
        <b-icon icon="power" aria-hidden="true"></b-icon> Login
      </b-button>
      <b-button href="join" variant="outline-info" class="mb-2 mr-2">
        <b-icon icon="person-check" aria-hidden="true"></b-icon> Join
      </b-button>
      <b-button href="pw" variant="outline-danger" class="mb-2">
        <b-icon icon="key" aria-hidden="true"></b-icon> Find Password
      </b-button>
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