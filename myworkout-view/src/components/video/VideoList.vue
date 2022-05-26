<template>
  <div>
    <br><br>
    <h4>
      영상 목록
    </h4>
    <hr>
    <b-container>
      <b-row>
        <b-col sm="4">
          <b-form-input v-model="keyword" type="text" placeholder="검색어를 입력하세요." class="mx-2"></b-form-input>
        </b-col>
        <b-button @click="search" variant="outline-success">Search</b-button>
      </b-row>
    </b-container>

    <div class="container d-flex flex-wrap">
      <div class="card m-3 p-2" v-for="(video, index) in $store.state.searchVideos" :key="index" style="background: red">
        <iframe :src="'https://www.youtube.com/embed/'+video.id.videoId" frameborder="0"></iframe>
        <a class="review btn btn-light" :href="'https://www.youtube.com/embed/'+video.id.videoId"><b-icon icon="youtube" aria-hidden="true" style="color: red"/></a>
      </div>
    </div>

    <div class="container d-flex flex-wrap">
      <div class="card m-3 p-2" v-for="video in videos" :key="video.id" style="background: skyblue">
        <iframe :src="'https://www.youtube.com/embed/'+ video.url" frameborder="0"></iframe>
        <router-link :to="`/video/${video.videoId}`">
          <span class="badge badge-pill" style="background-color: pink"> Review {{ video.reviewCount}}</span>
          <!-- 리뷰 수 : {{ video.reviewCount}}개
          좋아요 수: {{ video.likeCount}}개 -->
        </router-link>
        <!-- <b-embed
                type="iframe"
                aspect="16by9"
                :src="'https://www.youtube.com/embed/'+ video.url"
                allowfullscreen
          ></b-embed> -->
      </div>
    </div>
    <br><br><br>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  name: "VideoList",
  data() {
    return {
      keyword: ""
    }
  },
  computed:{
    ...mapState([
      "videos",
      "category",
    ])
  },
  created(){
    this.$store.dispatch('getVideos')
  },
  methods: {
    search(){
        this.$store.dispatch("searchYoutube", this.keyword)
        this.keyword = ""
    }
  }
}
</script>

<style>

</style>