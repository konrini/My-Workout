<template>
  <div>
    <br><br><br>
    <hr>
<!-- 비디오 영역 -->
<b-row class="justify-content-md-center">
    <div class="card m-3 p-2" style="background: red; width: 820px; height: 470px;">
      <iframe style="width: 800px; height: 450px" :src="'https://www.youtube.com/embed/'+ this.videos[id-1].url" frameborder="0"></iframe>
    </div>
</b-row> <br>
<!-- 비디오 영역 끝 -->
<!-- 댓글 영역 -->
      <div class="container">
        <div class="ml-5" v-if="this.isLogin == true">
          <b-form inline>
            <img :src='"@/assets/photo/"+user.photo+".png"'/>
            <b-form-input @keydown.13="create" class="mr-2" v-model="new_review.content" placeholder="댓글을 등록하세요."/>
            <b-button variant="success" @click="create">등록</b-button>
          </b-form>
        </div><br>
        <table class="table">
          <tr>
            <th class="th-1" />
            <th class="th-2">별명</th>
            <th class="th-3" style="text-align: center;">댓글</th>
            <th class="th-4">작성 시간</th>
            <th class="th-5"/>
          </tr>
          <tr v-for="review in reviews" :key="review.reviewId">
            <td class="th-1">
              <img v-if="(review.userNickname != user.nickname) & followings.includes(review.userId)" @click="unfollow(review.userNickname, review.userId)" :src='"@/assets/photo/"+review.userPhoto+".png"'/>
              <img v-else-if="review.userNickname != user.nickname" @click="follow(review.userNickname, review.userId)" :src='"@/assets/photo/"+review.userPhoto+".png"'/>
              <img v-else :src='"@/assets/photo/"+review.userPhoto+".png"'/>
            </td>
            <td class="th-2">
              <span v-if="(review.userNickname != user.nickname) & followings.includes(review.userId)" @click="unfollow(review.userNickname, review.userId)">{{review.userNickname}}</span>
              <span v-else-if="review.userNickname != user.nickname" @click="follow(review.userNickname, review.userId)">{{review.userNickname}}</span>
              <span v-else>{{review.userNickname}}</span>
            </td>
            <td class="th-3">{{review.content}}</td>
            <td class="th-4">{{review.time}}</td>
            <td class="th-5"><b-button v-if="review.userId == user.userId" class="mr-1" variant="success" style="color: black" @click="update(review.reviewId)">수정</b-button>
                             <b-button v-if="review.userId == user.userId" variant="warning" @click="doDel(review.reviewId, review.videoId)">삭제</b-button></td>
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
      del_info: {
        reviewId: "",
        videoId: ""
      },
      following: {
        targetId: "",
        followerId: ""
      }
    }
  },
  computed: {
    ...mapState([
      "reviews",
      "videos",
      "isLogin",
      "user",
      "followings"
    ]),
  },
  created(){
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length-1]
    this.id = id
    this.new_review.videoId = id
    this.following.targetId = this.user.userId
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
    doDel(reviewId, videoId) {
      this.del_info.reviewId = reviewId
      this.del_info.videoId = videoId
      this.$store.dispatch('deleteReview', this.del_info)
      this.$router.go();
    },
    update(reviewId) {
      this.new_review.reviewId = reviewId
      this.$store.dispatch('modifyReview', this.new_review)
      this.new_review.content = ""
      this.$router.go();
    },
    follow(userNickname, userId) {
      this.$bvModal.msgBoxConfirm(userNickname + '님을 팔로우 하시겠습니까?')
        .then(value => {
          if (value == true) {
            this.following.followerId = userId
            this.$store.dispatch('insertFollowing', this.following)
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
    unfollow(userNickname, userId) {
      this.$bvModal.msgBoxConfirm(userNickname + '님을 팔로우 취소하시겠습니까?')
        .then(value => {
          if (value == true) {
            this.following.followerId = userId
            this.$store.dispatch('deleteFollowing', this.following)
          }
        })
        .catch(err => {
          console.log(err)
        })
    },
  }
}
</script>
<style>
.th-1{
  text-align: center;
  width: 20px
}
.th-2{
  text-align: center;
  width: 90px
}
.th-3{
  width: 400px
}
.th-4{
  text-align: center;
  width: 150px
}
.th-5{
  text-align: center;
  width: 120px
}
</style>