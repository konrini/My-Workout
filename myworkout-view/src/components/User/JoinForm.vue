<template>
  <div class="container" style="width: 600px;"><br><br>
    <h3>회원가입</h3>
    <div class="m-4">
    <b-form @submit.stop.prevent="onSubmit">
      <b-form-group label="아이디" label-for="id">
        <b-form-input id="id" v-model="user.userId" trim required></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="pw">
        <b-form-input id="pw" v-model="user.password" trim type="password" :state="pwState"></b-form-input>
        <b-form-invalid-feedback id="pw">
          Enter at least 8 letters
        </b-form-invalid-feedback>
    </b-form-group>
      <b-form-group label="비밀번호 확인" label-for="pw_confirm">
        <b-form-input id="pw_confirm" v-model="user.passwordConfirm" trim type="password" :state="pwconfirmState"></b-form-input>
        <b-form-invalid-feedback id="pw_confirm">
          비밀번호가 일치하지 않습니다.
        </b-form-invalid-feedback>
      </b-form-group>
      <b-form-group label="별명" label-for="nickname">
        <b-form-input id="nickname" v-model="user.nickname" trim required></b-form-input>
      </b-form-group>
      <b-form-group label="키" label-for="height">
        <b-form-input id="height" v-model="user.height" trim type="number" required></b-form-input>
      </b-form-group>
      <b-form-group label="몸무게" label-for="weight">
        <b-form-input id="weight" v-model="user.weight" trim type="number" required></b-form-input>
      </b-form-group>
      <div>
        <b-form-group label="성별">
          <b-form-radio v-model="user.selectedGender" value="1">남자</b-form-radio>
          <b-form-radio v-model="user.selectedGender" value="2">여자</b-form-radio>
        </b-form-group>
      </div>
      <div>
        <b-form-group label="캐릭터">
          <b-form-radio-group
            v-model="user.selectedPhoto"
            :options="options"
          ></b-form-radio-group>
          <img src="@/assets/photo/1.png" alt="Cat">
          <img src="@/assets/photo/2.png" alt="Dog">
          <img src="@/assets/photo/3.png" alt="Hippo">
          <img src="@/assets/photo/4.png" alt="Giraffe">
          <img src="@/assets/photo/5.png" alt="Tiger">
          <img src="@/assets/photo/6.png" alt="Pig">
        </b-form-group>
      </div>
      <b-form-group label="나의 보물 1호는?" label-for="treasure">
        <b-form-input id="treasure" v-model="user.treasure" trim required></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="outline-success" @click="join">회원가입</b-button>
      <br><br><br>
    </b-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'JoinForm',
  data(){
    return{
      user : {
        name: '',
        nickname: '',
        userId: '',
        password: '',
        passwordConfirm: '',
        height: 0,
        weight: 0,
        selectedGender: 1,
        selectedPhoto: 1,
        treasure: '',
      },
      options: [
        {value: 1, text: "고양이"},
        {value: 2, text: "강아지"},
        {value: 3, text: "하마"},
        {value: 4, text: "기린"},
        {value: 5, text: "호랑이"},
        {value: 6, text: "돼지"},
      ]
    };
  },
  methods:{
    join() {
      this.$store.dispatch('userJoin', this.user)
    },
  },
  computed: {
    pwState() {
      return this.user.password.length > 7 ? true : false
      },
    pwconfirmState() {
      return this.user.password == this.user.passwordConfirm ? true : false
      },
  }
}
</script>

<style>
img{
  width: 50px;
  height: 50px;
  margin-left: 7px;
  margin-right: 19px;
}
</style>