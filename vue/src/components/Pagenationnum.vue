<template>
  <div class="btn-cover">
    <v-row no-gutters align="center" justify="center">
      <v-btn
          v-if="buttonDisplay"
          depressed
          text
          :class="['pagination__previous-btn', { 'is-disabled': previousButtonDisabled }]"
          :disabled="previousButtonDisabled"
          @click="previous"></v-btn>
      <span class="pagination__divider ml-2 mr-4" v-if="buttonDisplay"></span>
      <ul class="pagination__inner" :style="{transform:scale}">
        <li>
      <img src="@/assets/icon/pre-page.png" alt="arrow" class="pagination__previous-image"/></li>
        <li class="pagination__btn-con" v-for="number in pageList" :key="number">
          <button type="button" :class="['pagination__btn', { 'is-active': value === number }]" @click="change(number)">
            {{ number }}
          </button>
        </li>
        <li> <img src="@/assets/icon/next-page.png" alt="arrow" class="pagination__next-image"/></li>
      </ul>
      <span class="pagination__divider ml-4 mr-2" v-if="buttonDisplay"></span>
      <v-btn
          v-if="buttonDisplay"
          depressed
          text
          :class="['pagination__next-btn', { 'is-disabled': nextButtonDisabled }]"
          :disabled="nextButtonDisabled"
          @click="next"></v-btn>

    </v-row>

  </div>
</template>

<script>
import {computed} from "vue";

export default {
  name: "Pagenationnum-list",
  props: {
    // 현재 페이지
    value: {
      type: Number,
      default: 1,
    },
    // 총 페이지
    totalPageCount: {
      type: Number,
      default: 5,
    },
    // 보여줄 페이지 수
    pageDisplayCount: {
      type: Number,
      default: 5,
    },
scale:{
      type:String
},
  },
  setup(props, context) {
    // 총 페이지가 5개 이하면 이전/다음 버튼을 보여주지 않음
    const buttonDisplay = computed(() => props.totalPageCount > 5);

    // 현재 페이지의 그룹 번호 (현재 페이지 / 보여줄 페이지의 수)
    const currentPageGroup = computed(() => Math.ceil(props.value / props.pageDisplayCount));

    // 마지막 페이지 번호
    const lastPageNumber = computed(() => {
      const lastNumber = currentPageGroup.value * props.pageDisplayCount;
      if (lastNumber > props.totalPageCount) return props.totalPageCount;
      return lastNumber;
    });

    // 첫번째 페이지 번호
    const firstPageNumber = computed(() => {
      // 끝 번호가 26,27 이렇게 끝날 경우 페이지를 [26,27] 이렇게 보여줘야 하기에 존재하는 로직
      if (lastPageNumber.value == props.totalPageCount) {
        const multipleOfPageDisplayCount = lastPageNumber.value % props.pageDisplayCount === 0;
        return multipleOfPageDisplayCount
            ? lastPageNumber.value - props.pageDisplayCount + 1
            : lastPageNumber.value - (lastPageNumber.value % props.pageDisplayCount) + 1;
      }
      return lastPageNumber.value - (props.pageDisplayCount - 1);
    });
    // 페이지 리스트 (pageDisplayCount가 5일 경우 [1~5], [6~10]...)
    const pageList = computed(() => {
      const list = [];
      for (let i = firstPageNumber.value; i <= lastPageNumber.value; i++) {
        list.push(i);
      }
      return list;
    });
    // 다음 버튼 비활성화 조건
    const nextButtonDisabled = computed(() => lastPageNumber.value >= props.totalPageCount);

    // 이전 버튼 비활성화 조건
    const previousButtonDisabled = computed(() => firstPageNumber.value <= 1);

    // 사용자가 번호를 변경하는 경우 상위 컴포넌트로 값 전달
    const change = clickNumber => {
      if (clickNumber === props.value) return false;
      context.emit('change', clickNumber);
    };
    // 이전 버튼 클릭 시 이전 페이지의 첫번째 값으로 설정
    const previous = () => {
      context.emit('change', firstPageNumber.value - props.pageDisplayCount);
    };
    // 다음 버튼 클릭 시 이후 페이지의 첫번째 값으로 설정
    const next = () => {
      context.emit('change', lastPageNumber.value + 1);
    };
    return {
      next,
      previous,
      change,
      pageList,
      buttonDisplay,
      nextButtonDisabled,
      previousButtonDisabled,
      firstPageNumber,
      lastPageNumber,
      currentPageGroup,
    };
  }
}
</script>

<style scoped>
.btn-cover {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 30px;
  padding-bottom: 50px;
}

ul {
  display: flex;
}

li {
  list-style: none;
  font-size: 30px;
  font-weight: 600;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 40px;

}

button {
  width: 5px;
  height: 23px;
  background: none;
}

.pagination__btn {
  border: none;
  font-size: 30px;
  font-weight: 600;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}


</style>