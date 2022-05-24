<template>
  <div>
    <footer v-if="showFooter">
      copyright
    </footer>
  </div>
</template>

<script>
export default {
  data(){
        this.$route.path === '/' ? this.showFooter = false : this.showFooter = true
    }
}
</script>

<style>
  footer {
   position:fixed;
   left:0px;
   bottom:0px;
   height:50px;
   width:100%;
   background:#EE7785;
   color: white;
}
</style>