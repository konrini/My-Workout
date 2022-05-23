<template>
  <div>
      Video Page
  <button>
    <router-link :to="`/video/`">
      수영
    </router-link>
  </button>
  <button>
    <router-link :to="`/video/`">
      골프
    </router-link>
  </button>
  <button>
    <router-link :to="`/video/`">
      요가
    </router-link>
  </button>
  <button>
    <router-link :to="`/video/`">
      피트니스
    </router-link>
  </button>
  <button>
    <router-link :to="`/video/`">
      배드민턴
    </router-link>
  </button>
  <button>
    <router-link :to="`/video/`">
      야구
    </router-link>
  </button>
  <router-view/>
  </div>
</template>

<script>
export default {
  name: "VideoView"
}
</script>

<style>

</style>