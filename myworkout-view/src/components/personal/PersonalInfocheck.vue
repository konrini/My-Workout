<template>
  <div class="container" style="width: 600px;"><br><br>
    <h3>회원 정보 수정</h3>
    <div class="m-4">
      <b-form-group label="비밀번호를 입력하세요." label-for="pw">
        <b-form-input id="pw" v-model="user_check.password" trim type="password" required></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="outline-success" @click="check">확인</b-button>
      <br><br><br>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  data(){
    return{
      user_check: {
        userId: "",
        password: ""
      }
    }
  },
  methods:{
    check() {
      this.user_check.userId = this.user.userId
      this.$store.dispatch("pwCheck", this.user_check)
    }
  },
  computed: {
    ...mapState([
      "user"
    ]),
  },
}
</script>

<style>

</style>