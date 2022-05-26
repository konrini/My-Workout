<template>
  <div><br><br>
      <b-row class="justify-content-md-center">
        <h3>
          Daily Workout
        </h3>
      </b-row><br>
      <b-row class="justify-content-md-center">
        <h3>
          <b-button disabled variant="primary">수영</b-button>
          <b-button disabled variant="success">골프</b-button>
          <b-button disabled variant="secondary">요가</b-button>
          <b-button disabled variant="danger">피트니스</b-button>
          <b-button disabled variant="warning">배드민턴</b-button>
          <b-button disabled variant="info">야구</b-button>
          <b-button disabled variant="dark">기타 운동</b-button>
        </h3>
      </b-row><br>

      <b-calendar
        v-model="value"
        :date-info-fn="dateClass"
        block locale="ko"
        class="py-3 px-5 mx-5"
      ></b-calendar>

      <b-row class="justify-content-md-end">
        <b-button variant="light" class="mr-5" @click="check">오늘의 운동 완료</b-button>
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
      "daily"
      ])
  },
  methods:{
    dateClass(ymd, date){
      const month = ymd.substr(5,2)
      const day = ymd.substr(8,2)
      date
      for (let i = 0; i < this.daily.length; i++) {
        if (month == this.daily[i].date.substr(5, 2)) {
          if (day == this.daily[i].date.substr(8, 2)) {
            if (this.daily[i].category == "swm") {
              return 'table-primary'
            }
            else if (this.daily[i].category == "glf") {
              return 'table-success'
            }
            else if (this.daily[i].category == "yog") {
              return 'table-secondary'
            }
            else if (this.daily[i].category == "ftn") {
              return 'table-danger'
            }
            else if (this.daily[i].category == "bmt") {
              return 'table-warning'
            }
            else if (this.daily[i].category == "bsb") {
              return 'table-info'
            }
            }
            }
      }
    },
    check() {
      this.info.userId = this.user.userId
      this.$store.dispatch('getDiary', this.info)
    }
  },
  created() {
      this.$store.dispatch('getDiaries', this.user)
  }
}
</script>

<style>

</style>