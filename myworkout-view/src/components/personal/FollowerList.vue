<template>
  <div><br><br>
      <b-card-group deck>
        <b-card style="text-align:center" no-body :header="'followings'+' ('+followings.length+')'">
          <b-list-group flush>
            <b-list-group-item v-for="fg in followings" :key="fg" @click="unfollow(fg)">{{fg}} <b-icon icon="x-lg"></b-icon></b-list-group-item>
          </b-list-group>
        </b-card>

        <b-card style="text-align:center" no-body :header="'followers'+' ('+followers.length+')'">
          <b-list-group flush>
            <b-list-group-item v-for="fr in followers" :key="fr">{{fr}} </b-list-group-item>
          </b-list-group>
        </b-card>
      </b-card-group>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  data() {
    return {
      following: {
        targetId: "",
        followerId: ""
      }
    }
  },
  computed: {
    ...mapState([
      "user",
      "followings",
      "followers"
    ]),
  },
  methods: {
    unfollow(userId) {
      this.following.targetId = this.user.userId
      this.following.followerId = userId
      this.$store.dispatch('deleteFollowing', this.following)
    },
  }
}
</script>

<style>

</style>