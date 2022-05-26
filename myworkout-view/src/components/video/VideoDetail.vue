<template>
  <div>
    <br><br><br>
    <hr>
<!-- 비디오 영역 -->
<b-row class="justify-content-md-center">
    <div class="card m-3 p-2" style="background: red; width: 820px; height: 470px;">
      <iframe style="width: 800px; height: 450px" :src="'https://www.youtube.com/embed/'+ videos[id-1].url" frameborder="0"></iframe>
    </div>
</b-row> 
<!-- 비디오 영역 끝 -->
<!-- 댓글 영역 -->
      <div class="container">
        <div v-if="this.isLogin == true">
          <b-form inline>
            <img :src='"@/assets/photo/"+user.photo+".png"'/>
            <b-form-input class="mr-2" v-model="new_review.content" placeholder="댓글을 등록하세요."/>
            <b-button variant="success" @click="create">등록</b-button>
          </b-form>
        </div>
        <table class="table">
          <tr>
            <th/>
            <th>별명</th>
            <th>댓글</th>
            <th>작성 시간</th>
            <th/>
            <th/>
          </tr>
          <tr v-for="review in reviews" :key="review.reviewId">
            <td><img :src='"@/assets/photo/"+review.userPhoto+".png"'/></td>
            <td>{{review.userNickname}}</td>
            <td>{{review.content}}</td>
            <td>{{review.time}}</td>
            <td><b-button v-if="review.userId == user.userId" variant="success" style="color: black" @click="update(review.reviewId)">수정</b-button></td>
            <td><b-button v-if="review.userId == user.userId" variant="warning" @click="doDel(review.reviewId)">삭제</b-button></td>
          </tr>
        </table>
      </div>
<!-- 댓글 영역 끝 -->
  </div>
</template>


<script>
import {mapState} from 'vuex'

export default {
  name: "VideoDetail",
  data() {
    return {
      id : "",
      new_review: {
        content: "",
        userPhoto: this.$store.state.user.photo,
        userId: this.$store.state.user.userId,
        userNickname: this.$store.state.user.nickname,
        videoId: "",
        reviewId: "",
      },
      reviewId: "",
    }
  },
  computed: {
    ...mapState([
      "reviews",
      "videos",
      "isLogin",
      "user"
    ]),
  },
  created(){
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length-1]
    this.id = id
    this.new_review.videoId = id
    this.$store.dispatch('getReviews', id)
    this.$store.dispatch('getVideos')
  },
  methods: {
    create() {
      console.log(this.new_review)
      this.$store.dispatch('writeReview', this.new_review)
      this.new_review.content = ""
      this.$router.go();
    },
    doDel(reviewId) {
      this.$store.dispatch('deleteReview', reviewId)
      this.$router.go();
    },
    update(reviewId) {
      this.new_review.reviewId = reviewId
      this.$store.dispatch('modifyReview', this.new_review)
      this.new_review.content = ""
      this.$router.go();
    },
  }
}
</script>
<style>

</style>