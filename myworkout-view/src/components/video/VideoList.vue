<template>
  <div>
    <br><br>
    <h4>
      Video List
    </h4>
    <hr>
    <div v-for="(video, index) in $store.state.searchVideos" :key="index">
      <h5>{{video.snippet.title}}</h5>
      <iframe :src="'https://www.youtube.com/embed/'+video.id.videoId" frameborder="0"></iframe>
      <a class="review btn btn-outline-danger" :href="'https://www.youtube.com/embed/'+video.id.videoId">GotoYoutube</a>
    </div>

    <div v-for="video in videos" :key="video.id">
      <b-row class="justify-content-md-center">
      <iframe :src="'https://www.youtube.com/embed/'+ video.url" frameborder="0"></iframe>
      </b-row>
      <b-row class="justify-content-md-center">
       <router-link :to="`/video/${video.videoId}`">
        리뷰 수 : {{ video.reviewCount}}개
        좋아요 수: {{ video.likeCount}}개
      </router-link>
      </b-row>
      <br>
      <!-- <b-embed
              type="iframe"
              aspect="16by9"
              :src="'https://www.youtube.com/embed/'+ video.url"
              allowfullscreen
        ></b-embed> -->
    </div>
    <br><br><br>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: "VideoList",
  computed:{
    ...mapState([
      "videos",
      "category",
    ])
  },
  created(){
    this.$store.dispatch('getVideos')
  },
}
</script>

<style>
  
</style>