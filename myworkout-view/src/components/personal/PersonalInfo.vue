<template>
  <div class="container" style="width: 600px;"><br><br>
    <h3>회원 정보 수정</h3>
    <div class="m-4">
      <b-form-group label="아이디" label-for="id">
        <b-form-input id="id" :value="u.userId" trim disabled></b-form-input>
      </b-form-group>
      <b-form-group label="별명" label-for="nickname">
        <b-form-input id="nickname" :value="u.nickname" trim disabled></b-form-input>
      </b-form-group>
      <b-form-group label="키" label-for="height">
        <b-form-input id="height" :value="u.height"  trim type="number"></b-form-input>
      </b-form-group>
      <b-form-group label="몸무게" label-for="weight">
        <b-form-input id="weight" :value="u.weight" trim type="number"></b-form-input>
      </b-form-group>
      <div>
        <b-form-group label="성별" disabled>
          <b-form-radio v-model="u.gender" value="1">남자</b-form-radio>
          <b-form-radio v-model="u.gender" value="2">여자</b-form-radio>
        </b-form-group>
      </div>
      <div>
        <b-form-group label="캐릭터">
          <b-form-radio-group
            v-model="u.photo"
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
        <b-form-input id="treasure" v-model="u.treasure" trim disabled></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="outline-success" href="../">확인</b-button>
      <br><br><br>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  data() {
    return {
      u: {
        userId: "",
        nickname: "",
        height: "",
        weight: "",
        gender: "",
        photo: 0,
        treasure: ""
      },
      options: [
        {value: 1, text: "고양이"},
        {value: 2, text: "강아지"},
        {value: 3, text: "하마"},
        {value: 4, text: "기린"},
        {value: 5, text: "호랑이"},
        {value: 6, text: "돼지"},
      ]
    }
  },
  computed: {
    ...mapState([
      "user"
    ]),
  },
  created() {
    this.u.userId = this.user.userId
    this.u.nickname = this.user.nickname
    this.u.height = this.user.height
    this.u.weight = this.user.weight
    this.u.gender = this.user.gender
    this.u.photo = this.user.photo
    this.u.treasure = this.user.treasure
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