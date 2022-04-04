<template>
  <div class="bookmark-block">
    <div class="icon"><img :src="require(`@/assets/icon/${bookmarkData.icon}.png`)" width="20" height="20" alt="circle"></div>
    <div class="bookmark">{{ bookmarkData.bookmarkTitle}}</div>
  </div>
</template>

<script>
export default {
  name: "Bookmark-block",
  props: ['bookmarkData']
}
</script>

<style scoped>
.bookmark-block{
  display: flex;
  text-align: center;
  align-items: center;
  padding-bottom: 10px;
  padding-top: 10px;
  border-bottom: 1px solid black;
}
.icon{
  margin-right: 10px;
  padding-left: 10px;
  padding-top: 5px;
}
.bookmark{
  font-size: 18px;
}

</style>