<template>
  <div class="container" style="width: 600px;"><br><br>
    <h3>비밀번호 재설정하기
    </h3>
    <div class="m-4">
      <b-form-group label="새로운 비밀번호" label-for="input-1">
        <b-form-input id="input-1" v-model="user.password" trim type="password"></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호 확인" label-for="input-2">
        <b-form-input @keydown.13="pwReset" id="input-2" v-model="pw_confirm" trim type="password"></b-form-input>
      </b-form-group>
      <b-button variant="success" @click="pwReset">확인</b-button>      
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      user: {
        userId: '',
        password: null,
      },
      pw_confirm: null,
      }
  },
  methods:{
    pwReset() {
      this.$store.dispatch('pwReset', this.user)
    },
  },
  created() {
    this.user.userId = this.$store.state.resetId
  }
}
</script>

<style>

</style>