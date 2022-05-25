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
              <b-form-input type="number" id="height" v-model="daily.height" trim></b-form-input>
            </b-form-group>
            <b-form-group label="몸무게" label-for="weight">
              <b-form-input type="number" id="weight" v-model="daily.weight" trim></b-form-input>
            </b-form-group>
            <b-form-group label="운동 종류">
              <b-form-radio-group
                v-model="daily.selectedWork"
                :options="options"
              ></b-form-radio-group>
            </b-form-group>
            <b-form-group label="운동일지" label-for="content">
              <b-form-textarea
                id="textarea"
                v-model="daily.content"
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
export default {
  name: 'RegistWork',
  data(){
    return{
      daily:{
        height:0,
        weight:0,
        selectedWork:0,
        content:'',
      },
      options:[
        {value: 1, text: "수영"},
        {value: 2, text: "골프"},
        {value: 3, text: "요가"},
        {value: 4, text: "피트니스"},
        {value: 5, text: "배드민턴"},
        {value: 6, text: "야구"},
      ]
    }
  },
  methods:{
    regist(){
      this.$store.dispatch('dailyRegist', this.daily)
    }
  }
}
</script>

<style>

</style>