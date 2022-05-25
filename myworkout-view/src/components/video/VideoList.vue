<template>
  <div>
    <br><br>
    <h4>
      Video List
    </h4>
    <hr>
    <!-- <div v-for="video in videos" :key="video.id">
      <b-card
        title="Card Title"
        img-src="https://img.youtube.com/vi/{video.url}/0"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
        <b-button href="#" variant="primary">Go somewhere</b-button>
      </b-card>
    </div> -->
    <div v-for="video in videos" :key="video.id">
      <b-embed
              type="iframe"
              aspect="16by9"
              :src="'https://www.youtube.com/embed/'+ video.url"
              allowfullscreen
        ></b-embed>
        <router-link :to="`/video/${video.videoId}`">
          리뷰 수 : {{ video.reviewCount}}개 <br>
          좋아요 수: {{ video.likeCount}}개
        </router-link>
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