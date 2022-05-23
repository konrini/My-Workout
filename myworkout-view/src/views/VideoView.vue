<template>
  <div>
    <br>
    <h5>Video Page

      <button @click="getAll">All</button>

      <button @click="filter('swm')">
        수영
      </button>
      <button @click="filter('glf')">
        골프
      </button>
      <button @click="filter('yog')">
        요가
      </button>
      <button @click="filter('ftn')">
        피트니스
      </button>
      <button @click="filter('bmt')">
        배드민턴
      </button>
      <button @click="filter('bsb')">
        야구
      </button>
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