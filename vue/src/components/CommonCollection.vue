<template>
  <div class="common-collection" @mouseover="inCollection(num)" @mouseleave="outCollection(num)">
    <img class="col-img" :src="image[num].url" alt="col_image" />
    <div class="text1" v-if="image[num].testBoolean">
      <p>테스트 중입니다 아아아 {{ num }}</p>
    </div>
  </div>
</template>

<script>
export default{
  name: 'CommonCollection',
  props: ['num'],
  data() {
    return {
      image: [
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-3gzlhroziqg@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-jhog6v6riis@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-wc8k-kryepm@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-btxmlujoff4@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-id5avjfcxjg@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-fzuleefea1q@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-g6wx5j5-dr8@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-ezsm8xrjnx0@2x.svg",
          testBoolean: false 
        },
        { url: "https://anima-uploads.s3.amazonaws.com/projects/622477ed97d6dc299d099cef/releases/6225b71a2f7ce77516e62bc1/img/unsplash-3gzlhroziqg-1@2x.svg",
          testBoolean: false 
        }
      ]
    }
  },
  methods: {
    inCollection(num) {
      this.image[num].testBoolean = true;
      document.querySelector('.col-img').classList.add('lowerBrightness');
      // console.log(document.querySelectorAll('.col-img').)
    },
    outCollection(num) {
      this.image[num].testBoolean = false;
      document.querySelector('.col-img').classList.remove('lowerBrightness');
    }
  }
};
</script>

<style scoped>
.common-collection {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 250px;
  height: 250px;
  position: relative
}
.col-img{
  width: 250px;
  height: 250px;
  /* background: red; */
  transition: all .3s;
}
.col-img:hover {
  transition: all .3s;
  filter: brightness(60%);
  }
.text1 {
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  opacity: 100%;
}
.text1 p {
  color: white;
  font-weight: bold;
  position: relative;
}
</style>