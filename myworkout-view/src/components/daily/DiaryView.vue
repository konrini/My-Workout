<template>
  <div>
      <br><br>
      <b-row class="justify-content-md-center">
        <h3>View my Workout</h3>
      </b-row>

      <b-row class="justify-content-md-center">
        <div class="container">
          <div class="m-4">
            <b-form-group label="키" label-for="height">
              <b-form-input type="number" id="height" v-model="olddiary.changedHeight" trim disabled></b-form-input>
            </b-form-group>
            <b-form-group label="몸무게" label-for="weight">
              <b-form-input type="number" id="weight" v-model="olddiary.changedWeight" trim disabled></b-form-input>
            </b-form-group>
            <b-form-group label="운동 종류">
              <b-form-radio-group
                v-model="olddiary.category"
                :options="options"
                disabled
              ></b-form-radio-group>
            </b-form-group>
            <b-form-group label="운동일지" label-for="content">
              <b-form-textarea
                id="textarea"
                v-model="olddiary.diary"
                placeholder="오늘의 운동 일지"
                rows="10"
                disabled
              ></b-form-textarea>
            </b-form-group>
            <b-row class="justify-content-md-end">
             <b-button variant="light" class="mr-3" href="/dailyView/">뒤로 가기</b-button>
            </b-row>
          </div>
        </div>
      </b-row>

  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  data(){
    return{
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
  computed: {
      ...mapState([
      "user",
      "olddiary",
      ])
  },
}
</script>

<style>

</style>