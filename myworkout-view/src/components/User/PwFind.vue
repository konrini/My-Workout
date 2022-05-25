<template>
  <div class="container" style="width: 600px;">
    <h3>비밀번호 찾기
    </h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="input-1">
        <b-form-input id="input-1" v-model="info.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="나의 보물 1호는?" label-for="input-2">
        <b-form-input id="input-2" v-model="info.treasure" trim></b-form-input>
      </b-form-group>
      <b-button variant="info" @click="pwFind">확인</b-button>      
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      info: {
        userId: null,
        treasure: null,
        }
      }
  },
  methods:{
    pwFind() {
      this.$store.dispatch('pwFind', this.info)
    },
  }
}
</script>

<style>

</style>