<template>
  <div class="common-modal" v-if="openModal()">
    <div class="modal-bg" @click="closeModal()"></div>
    <div class="modal-container">
      <img src="../assets/sample/Close-Line.png" alt="x-button" class="xButton" @click="closeModal()">

      <div class="modal-container-body">
        <div class="modal-header">

          <div class="mainHashTag">
            <common-tag 
                class="component-tag" 
                @saveText="saveText"
                :tagName="[idx, tag, editMode]" 
                v-for="(tag, idx) in curationInfo.hashtag" 
                :key="idx" />
          </div>
          <div class="iconBox" v-if="!editMode">
            <img src="../assets/sample/Like-Line.png" alt="heart">
            <img src="../assets/sample/Pin-Line.png" alt="pin">
            <img src="../assets/sample/Save-Line.png" alt="share">
          </div>
          <div class="iconBox iconBoxCenter" v-if="editMode">

          </div>
        </div>
        
        <div class="modal-body">
          <div class="modal-body-picture" v-if="involedPic">
            <div class="moveImg">
              <img :src="img" alt="img" v-for="(img, idx) in curationInfo.imgUrl" :key="idx">
            </div>
          <button @click="previousImg" class="previous">&#60;</button>
          <button @click="nextImg" class="next">&#62;</button>
          </div>

          <div :class="{modalBodyContents: involedPic, noPic: !involedPic, fontSize16:true}">
            <p><b>{{ curationInfo.nickName }}</b></p>
            <p><b>{{ curationInfo.title }}</b></p>
            <p>{{ curationInfo.content }}</p>
          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import CommonTag from './CommonTag.vue';

export default {
  components: { CommonTag },
  name: 'CommonModal',
  props: ['curShow', 'curationInfo', 'involedPic'],
  data() {
    return {
      editMode: false,
      showModal: false,
      isInvolvePic: this.involedPic,
      modalHashTags: ['aa', 'bb', 'cc']
    }
  },
  methods: {
    previousImg() {
      // var temp = '';
      // let imageList = this.curationInfo.imgUrl;
      console.log(this.curationInfo)
      
      // console.log(imageList);

      // for(let i = 0; i < imageList.length; i++) {
      //   if(i == 0) {
      //     temp = imageList[i];
      //     imageList[i] = imageList[imageList.length - 1];
      //   } else {
        //     imageList[i-1] = imageList[i]
      //     imageList[i] = temp;
      //   }
      // }
    },
    nextImg() {

    },
    openModal() {
      this.showModal = this.curShow;
      return this.showModal;
    },
    closeModal() {
      this.$emit('returnModal');
    },
    saveText(text) {
      this.modalHashTags[text[0]] = text[1];
    }
  },
  computed: {
    inspect() {
      return this.curationInfo.involvePicBoolean;
    } 
  }
}
</script>

<style scoped>
.common-modal {
  font-family: 'alegreya';
  position: fixed;
  left: 0;
  top: 0;
  display: block;
  width: 100%;
  height: 100%;
}
.modal-bg {
  background: rgba(0, 0, 0, 0.3);
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  z-index: -1;
}
.modal-container {
  width: 1300px;
  height: 750px;
  background: #FFFFFF;
  border: solid 1px black;
  margin: 100px 300px;
}
.xButton {
  position: absolute;
  top: 130px;
  left: 1535px;
}
.modal-container-body {
  width: 1200px;
  height: 650px;
  padding: 50px;
}
.modal-header {
  width: 100%;
  height: 100px;
  /* background: lightblue; */
  display: flex;
  /* justify-content: space-between; */
}
.mainHashTag {
  display: flex;
  justify-content: right;
  width: 80%;
  text-align: right;
}
.component-tag {
  margin-top: 5px;
  margin-right: 20px;
}
.iconBox {
  width: 20%;
  margin-right: 250px;
}
.iconBoxCenter {
  width: 8%;
}
.modal-body {
  width: 100%;
  height: 550px;
  /* background: lightcoral; */
  display: flex;
  justify-content: center;
}
.modal-body-picture {
  /* background: lightgrey; */
  margin: 25px 25px 50px 50px;
  display: flex;
  position: relative;
  width: 500px;
  height: 500px;
  overflow: hidden;
}
.moveImg {
  width: 100px;
  height: 100%;
  display: flex;
}
.modal-body-picture img {
  width: 500px;
  height: 500px;
  object-fit: contain;
  transition: all .5s;;
}
.moveX {
  transform: translateX(-500px);
  transition: all .5s;;
}
.previous {
  position: absolute;
  top: 200px;
  left: 20px;
  width: 100px;
  height: 100px;
  font-size: 50px;
}
.next {
  position: absolute;
  top: 200px;
  left: 375px;
  width: 100px;
  height: 100px;
  font-size: 50px;
}
.modalBodyContents  {
  width: 470px;
  height: 440px;
  /* background: lightgreen; */
  margin: 25px 50px 50px 25px;
  border: 1px solid black;
  border-radius: 12px;
  padding: 30px 15px;
}
.noPic {
  width: 990px;
  height: 440px;
  /* background: lightgreen; */
  margin: 25px 50px 50px 50px;
  border: 1px solid black;
  border-radius: 12px;
  padding: 30px;
}
.modalBodyContents * {
  font-size: 20px;
}
</style>