<template>
<!-- form -->
<div class="alarm-block">
<!--  text list -->
<div class="comment-list">
<div class="com-icon"><img :src="require(`@/assets/icon/${alarmData.icon}.png`)" alt="bell"></div>
  <div class="com-list">{{ alarmData.alarmTitle }}</div>
</div>
</div>
</template>

<script>
export default {
  name: "alarm-block",
  props: ['alarmData']
}
</script>

<style scoped>
.comment-list{
  display: flex;
  text-align: center;
  align-items: center;
  padding-bottom: 10px;
  padding-top: 10px;
  border-bottom: 1px solid black;
}
.com-icon{
  margin-right: 10px;
  padding-left: 10px;
  padding-top: 5px;
}
.com-list{
  font-size: 18px;
}
</style>