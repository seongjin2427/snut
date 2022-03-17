<template>
  <div class="common-collection" @mouseover="inCollection(num)" @mouseleave="outCollection(num)">
    <img :class="colSelect" :src="image[num[0]].url" alt="col_image" />
    <div class="text1" v-if="image[num[0]].testBoolean">
      <p>테스트 중입니다 아아아 {{ num[0] }}</p>
    </div>
  </div>
</template>

<script>
export default{
  name: 'CommonCollection',
  props: ['num'],
  data() {
    return {
      colSelect: 'col-img' + this.num[1],
      colModal: {
        id: 'col-modal' + this.num[1]
      },
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
        },
        { url: "https://static.wixstatic.com/media/98207d_fddf0e41afb8497b90ea40aa9513f622~mv2.jpg/v1/fill/w_250,h_250,al_c,q_90/98207d_fddf0e41afb8497b90ea40aa9513f622~mv2.jpg",
          testBoolean: false 
        }
      ]
    }
  },
  methods: {
    inCollection(num) {
      this.image[num[0]].testBoolean = true;
      document.querySelector('.col-img'+num[1]).classList.add('lowerBrightness');
      // console.log(num[1]);
    },
    outCollection(num) {
      this.image[num[0]].testBoolean = false;
      document.querySelector('.col-img'+num[1]).classList.remove('lowerBrightness');
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
.common-collection img{
  width: 250px;
  height: 250px;
  transition: all .3s;
}
.text1 {
  width: 250px;
  height: 250px;
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
.lowerBrightness {
  transition: all .3s;
  filter: brightness(60%);
  }
</style>