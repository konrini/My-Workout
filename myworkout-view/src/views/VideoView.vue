<template>
  <div>
    <br>
    <h5>
      <b-button style="border:0" variant="outline-light">
        <img src="@/assets/sports/all.png" @click="getAll">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img v-if="user.gender == 1" src="@/assets/sports/swm1.png" @click="filter('swm')">
      <img v-else src="@/assets/sports/swm2.png" @click="filter('swm')">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img src="@/assets/sports/glf.png" @click="filter('glf')">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img src="@/assets/sports/yog.png" @click="filter('yog')">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img src="@/assets/sports/ftn.png" @click="filter('ftn')">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img src="@/assets/sports/bmt.png" @click="filter('bmt')">
      </b-button>
      <b-button style="border:0" variant="outline-light">
      <img src="@/assets/sports/bsb.png" @click="filter('bsb')">
      </b-button>
    </h5>
    <br>
  <router-view/>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
    name: "VideoView",
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
        }
        
  }
}
</script>
<style>
</style>