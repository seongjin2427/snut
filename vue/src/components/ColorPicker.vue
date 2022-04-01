<template>
  <div>
    <color-picker 
        v-model:pureColor="pureColor"
        v-model:gradientColor="gradientColor"
        shape="circle" />
  </div>
</template>
<script>
  import { ref } from "vue";
  import { ColorInputWithoutInstance } from "tinycolor2";
  import { ColorPicker } from "vue3-colorpicker";
  import "vue3-colorpicker/style.css";

  export default ({
    components: { ColorPicker },
    setup() {
      const pureColor = ref<ColorInputWithoutInstance>("red");
      const gradientColor = ref("linear-gradient(0deg, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 1) 100%)");

      return { pureColor, gradientColor }
    }
  });
</script>