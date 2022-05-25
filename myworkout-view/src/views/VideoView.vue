<template>
  <div>
    <br>
    <h5>Video Page

      <b-button @click="getAll">All</b-button>

      <b-button @click="filter('swm')">
        수영
      </b-button>
      <b-button @click="filter('glf')">
        골프
      </b-button>
      <b-button @click="filter('yog')">
        요가
      </b-button>
      <b-button @click="filter('ftn')">
        피트니스
      </b-button>
      <b-button @click="filter('bmt')">
        배드민턴
      </b-button>
      <b-button @click="filter('bsb')">
        야구
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