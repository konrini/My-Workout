<template>
  <div>
    <br><br>
      <b-row class="justify-content-md-center">
        <h3>Regist Today's Workout</h3>
      </b-row>

      <b-row class="justify-content-md-center">
        <div class="container">
          <div class="m-4">
            <b-form-group label="키" label-for="height">
              <b-form-input type="number" id="height" v-model="daily.changedHeight" trim></b-form-input>
            </b-form-group>
            <b-form-group label="몸무게" label-for="weight">
              <b-form-input type="number" id="weight" v-model="daily.changedWeight" trim></b-form-input>
            </b-form-group>
            <b-form-group label="운동 종류">
              <b-form-radio-group
                v-model="daily.category"
                :options="options"
              ></b-form-radio-group>
            </b-form-group>
            <b-form-group label="운동일지" label-for="content">
              <b-form-textarea
                id="textarea"
                v-model="daily.diary"
                placeholder="오늘의 운동 일지"
                rows="10"
              ></b-form-textarea>
            </b-form-group>
            <b-row class="justify-content-md-end">
              <b-button variant="outline-success" @click="regist">등록</b-button>
            </b-row>
          </div>
        </div>
      </b-row>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: 'RegistWork',
  data(){
    return{
      daily: {
        userId: "",
        changedHeight: 0,
        changedWeight: 0,
        category: 0,
        diary:'',
      },
      options:[
        {value: "swm", text: "수영"},
        {value: "glf", text: "골프"},
        {value: "yog", text: "요가"},
        {value: "ftn", text: "피트니스"},
        {value: "bmt", text: "배드민턴"},
        {value: "bsb", text: "야구"},
        {value: "etc", text: "기타"},
      ]
    }
  },
  methods:{
    regist(){
      this.daily.userId = this.user.userId
      this.$store.dispatch('writeDiary', this.daily)
    }
  },
  computed: {
      ...mapState([
      "user",
      "diary"
      ])
  },
  created() {
    this.daily.changedHeight = this.user.height
    this.daily.changedWeight = this.user.weight
    if (this.diary != "") {
      this.daily.changedHeight = this.diary.changedHeight
      this.daily.changedWeight = this.diary.changedWeight
      this.daily.category = this.diary.category
      this.daily.diary = this.diary.diary
    }
  }
}
</script>

<style>

</style>