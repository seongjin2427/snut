<template>
  <div class="btn-container">
    <ul class="btn-list">
      <li class="previous">
        <img @click="(getStart && moveToPage(pageData.page - 1))
                  || (pageData.prev && moveToPage(pageData.page - 1))" 
            src="@/assets/icon/pre-page.png" alt="arrow" />
      </li>
      <li v-for="(page, idx) in pageData.pageList" 
          @click="moveToPage(page)" :key="idx">
        {{ page }}
      </li>
      <li class="next">
        <img @click="(getEnd && moveToPage(pageData.page + 1))
            || pageData.next && moveToPage(pageData.page + 1)" 
            src="@/assets/icon/next-page.png" alt="arrow"/>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Pagenation-num",
  props: ['pageData', 'word'],
  data() {
    return {
      page: this.pageData,
      pageWord: this.word
    }
  },
  methods: {
    moveToPage(page) {
      this.$emit('move', page);
    }
  },
  computed: {
    getStart() {
      if (this.pageData.start == this.pageData.page) return false;
      else return true;
    },
    getEnd() {
      if (this.pageData.end == this.pageData.page) return false;
      else return true;
    }
  }
}
</script>

<style scoped>
.btn-container {
  display: flex;
  justify-content: center;
  align-items: center;
  background: red;
  margin-top: 30px;
  padding-bottom: 50px;
}
ul {
  list-style: none;
  display: flex;
}
li {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
  font-weight: 600;
  margin-right: 40px;
  cursor: pointer;
}
</style>