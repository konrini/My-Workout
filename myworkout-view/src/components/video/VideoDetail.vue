<template>
  <div>
    <h2>Video Detail</h2>
    <br><br><br>
    <hr>
    
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
  computed: {
    ...mapState([
      "reviews"
    ])
  },
  created(){
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length-1]
    this.$store.dispatch('getReviews', id)
  }
}
</script>
<style>

</style>