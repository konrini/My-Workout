<template>
  <div>
    <header-nav/>
    <router-view/>
    <footer-view/>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue"
import FooterView from "@/components/common/FooterView.vue"
export default {
  components:{
    HeaderNav,
    FooterView
  }
}
</script>

<style>

</style>