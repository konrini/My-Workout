<template>
  <div>
    <br><br>
    <h4>
      Video List
    </h4>
    <hr>
    <div>
      <table>
        <tr>
          <th>url</th>
          <th>like_count</th>
          <th>review_count</th>
          <th>category</th>
        </tr>
        <tr v-for="video in videos" :key="video.id">
          <td>
            <router-link :to="`/video/${video.videoId}`">
              {{video.url}}
            </router-link>
          </td>
          <td>{{video.likeCount}}</td>
          <td>{{video.reviewCount}}</td>
          <td>{{video.category}}</td>
        </tr>
      </table>
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