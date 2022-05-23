<template>
  <div>
    <h2>Video Detail</h2>
    <br><br><br>
    <hr>
     <iframe :src="'https://www.youtube.com/embed/'+ videos[id-1].url"/>
    <br><hr>
    <table>
        <tr>
          <th>Id</th>
          <th>Nickname</th>
          <th>content</th>
          <th>time</th>
        </tr>
        <tr v-for="review in reviews" :key="review.reviewId">
          <td>{{review.userId}}</td>
          <td>{{review.userNickname}}</td>
          <td>{{review.content}}</td>
          <td>{{review.time}}</td>
        </tr>
      </table>

  </div>
</template>


<script>
import {mapState} from 'vuex'

export default {
  name: "VideoDetail",
  data() {
    return {
      id : "",
    }
  },
  computed: {
    ...mapState([
      "reviews",
      "videos"
    ])
  },
  created(){
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length-1]
    this.id = id
    this.$store.dispatch('getReviews', id)
    this.$store.dispatch('getVideos')
  },
}
</script>
<style>

</style>