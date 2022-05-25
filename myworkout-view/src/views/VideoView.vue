<template>
  <div>
    <br>
    <b-row class="justify-content-md-center">
    <h5>
      <b-button @click="changeClass1" :class="{'animate__animated animate__flip' : turn1}" style="border:0" variant="outline-light">
        <img src="@/assets/sports/all.png" @click="getAll">
      </b-button>
      <b-button @click="changeClass2" :class="{'animate__animated animate__flip' : turn2}" style="border:0" variant="outline-light">
      <img v-if="user.gender == 1" src="@/assets/sports/swm1.png" @click="filter('swm')">
      <img v-else src="@/assets/sports/swm2.png" @click="filter('swm')">
      </b-button>
      <b-button @click="changeClass3" :class="{'animate__animated animate__flip' : turn3}" style="border:0" variant="outline-light">
      <img src="@/assets/sports/glf.png" @click="filter('glf')">
      </b-button>
      <b-button @click="changeClass4" :class="{'animate__animated animate__flip' : turn4}" style="border:0" variant="outline-light">
      <img src="@/assets/sports/yog.png" @click="filter('yog')">
      </b-button>
      <b-button @click="changeClass5" :class="{'animate__animated animate__flip' : turn5}" style="border:0" variant="outline-light">
      <img src="@/assets/sports/ftn.png" @click="filter('ftn')">
      </b-button>
      <b-button @click="changeClass6" :class="{'animate__animated animate__flip' : turn6}" style="border:0" variant="outline-light">
      <img src="@/assets/sports/bmt.png" @click="filter('bmt')">
      </b-button>
      <b-button @click="changeClass7" :class="{'animate__animated animate__flip' : turn7}" style="border:0" variant="outline-light">
      <img src="@/assets/sports/bsb.png" @click="filter('bsb')">
      </b-button>
    </h5>
    </b-row>
    <br>

  <b-input-group>
    <b-form-input v-model="keyword"></b-form-input>
    <b-input-group-append>
      <b-button @click="search" variant="outline-success">Search</b-button>
    </b-input-group-append>
  </b-input-group>

  <router-view/>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    name: "VideoView",
    data(){
      return{
        turn1: false,
        turn2: false,
        turn3: false,
        turn4: false,
        turn5: false,
        turn6: false,
        turn7: false,
        keyword: ""
      }
    },
    computed:{
        ...mapState([
            "category",
            "user"
        ])
    },
    methods: {
        filter(category){
          this.$store.dispatch("getFilter", category);
        },
        getAll(){
          this.$store.dispatch("getVideos");
        },
        changeClass1(){
          this.turn1 = !this.turn1
        },
        changeClass2(){
          this.turn2 = !this.turn2
        },
        changeClass3(){
          this.turn3 = !this.turn3
        },
        changeClass4(){
          this.turn4 = !this.turn4
        },
        changeClass5(){
          this.turn5 = !this.turn5
        },
        changeClass6(){
          this.turn6 = !this.turn6
        },
        changeClass7(){
          this.turn7 = !this.turn7
        },
        search(){
            this.$store.dispatch("searchYoutube", this.keyword)
        }
  }
}
</script>
<style>
</style>