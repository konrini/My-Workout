<template>
  <div class="container">
    <h3>Join</h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="id">
        <b-form-input id="id" v-model="user.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="pw">
        <b-form-input id="pw" v-model="user.password" trim></b-form-input>
      </b-form-group>
      <b-form-group label="별명" label-for="nickname">
        <b-form-input id="nickname" v-model="user.nickname" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="pw">
        <b-form-input id="pw" v-model="user.password" trim></b-form-input>
      </b-form-group>
      <b-form-group label="아이디" label-for="id">
        <b-form-input id="id" v-model="user.userId" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호" label-for="pw">
        <b-form-input id="pw" v-model="user.password" trim></b-form-input>
      </b-form-group>
      <b-form-group label="비밀번호 확인" label-for="pw_confirm">
        <b-form-input id="pw_confirm" v-model="user.passwordConfirm" trim></b-form-input>
      </b-form-group>
      <b-form-group label="키" label-for="height">
        <b-form-input id="height" v-model="user.height" trim></b-form-input>
      </b-form-group>
      <b-form-group label="몸무게" label-for="weight">
        <b-form-input id="weight" v-model="user.weight" trim></b-form-input>
      </b-form-group>
      <div>
        <b-form-group label="성별">
          <b-form-radio v-model="user.selectedGender" value="1">남자</b-form-radio>
          <b-form-radio v-model="user.selectedGender" value="2">여자</b-form-radio>
        </b-form-group>
        <div class="mt-3">Selected: <strong>{{ user.selectedGender }}</strong></div>
      </div>

      <div>
        <b-form-group label="캐릭터">
          <b-form-radio-group
            v-model="user.selectedPhoto"
            :options="options"
          ></b-form-radio-group>
          <!-- <b-form-radio v-model="user.selectedPhoto" value="1"><img src="@/assets/photo/1.png" alt="Cat"></b-form-radio>
          <b-form-radio v-model="user.selectedPhoto" value="2"><img src="@/assets/photo/2.png" alt="Dog"></b-form-radio>
          <b-form-radio v-model="user.selectedPhoto" value="3"><img src="@/assets/photo/3.png" alt="Hippo"></b-form-radio>
          <b-form-radio v-model="user.selectedPhoto" value="4"><img src="@/assets/photo/4.png" alt="Giraffe"></b-form-radio>
          <b-form-radio v-model="user.selectedPhoto" value="5"><img src="@/assets/photo/5.png" alt="Tiger"></b-form-radio>
          <b-form-radio v-model="user.selectedPhoto" value="6"><img src="@/assets/photo/6.png" alt="Pig"></b-form-radio> -->
        </b-form-group>
        <div class="mt-3">Selected: <strong>{{ user.selectedPhoto }}</strong></div>
      </div>
      <b-form-group label="나의 보물 1호는?" label-for="treasure">
        <b-form-input id="treasure" v-model="user.treasure" trim></b-form-input>
      </b-form-group>
      <b-button variant="outline-success" @click="join">회원가입</b-button>
    </div>
    <br><br><br>
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
        userId:'',
        password: '',
        passwordConfirm: '',
        height:0,
        weight:0,
        selectedGender: '',
        selectedPhoto: '',
        treasure: '',
      },
      options: [
        {value: 1, text: "Cat"},
        {value: 2, text: "Dog"},
        {value: 3, text: "Hippo"},
        {value: 4, text: "Giraffe"},
        {value: 5, text: "Tiger"},
        {value: 6, text: "Pig"},
      ]
    };
  },
  methods:{
    join() {
      this.$store.dispatch('userJoin', this.user)
    },
  }
}
</script>

<style>
img{
  width: 100px;
  height: 100px;
}
</style>