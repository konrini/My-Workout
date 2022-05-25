<template>
  <div><br><br>
      <b-row class="justify-content-md-center">
        <h3>
          Daily Workout
        </h3>
      </b-row>

      <b-calendar
        v-model="value"
        :date-info-fn="dateClass"
        block locale="ko"
        class="border rounded p-2"
      ></b-calendar>

      <b-row class="justify-content-md-end">
        <b-button class="mr-4" @click="check">오늘의 운동 완료</b-button>
      </b-row>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  data(){
    return{
      value: "",
      info: {
        userId: "",
      }
    }
  },
  computed: {
      ...mapState([
      "user",
      ])
  },
  methods:{
    dateClass(ymd, date){
      const day = date.getDate()
      if(day==10){
        return 'table-info'
      }else if(day==11){
        return 'table-danger'
      }
    },
    check() {
      this.info.userId = this.user.userId
      this.$store.dispatch('getDiary', this.info)
    }
  }
}
</script>

<style>

</style>