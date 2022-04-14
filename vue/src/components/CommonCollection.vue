<template>
  <div class="collection" @mouseover="!selectMode && inCuration(info.cuCo)" @mouseleave="outCuration(info.cuCo)">

    <div class="img-area" v-if="info.cuCo == 'Collection'">
      <img :class="cuSelect" :src="info.src[0]" alt="sample_img">
      <img :class="cuSelect" :src="info.src[1]" alt="sample_img" v-if="info.src[1]">
      <img :class="cuSelect" :src="info.src[2]" alt="sample_img" v-if="info.src[2]">
      <div class="replace" v-if="!info.src[1]"></div>
      <div class="check-icon" v-if="selected"></div>
    </div>

    <div class="img-area" v-if="info.cuCo == 'Curation'">
      <img :class="cuSelect" :src="info.src[0]" alt="sample_img">
      <div class="check-icon" v-if="selected"></div>
    </div>

    <div class="img-area" v-if="info.cuCo == 'Folder'">
      <div id="folder" :class="folderSelect">
        <textarea 
            class="folderName"
            type="text" 
            rows="3"
            col="2"
            maxlength="28"
            :value="info.title"
            :readonly="info.folderNameIsDisabled"
            placeholder="폴더명을 입력해주세요"
            />
        <button 
            class="folder-confirm-btn"
            v-if="!info.folderNameIsDisabled"
            @click="confirmFolderName(id)">
            확인
        </button>
      </div>
    </div>

    <div class="text1" 
        v-if="!selectMode && (info.cuCo == 'Curation' 
              || info.cuCo == 'Collection')
              && hoverBool 
              && (!storeBool || !delColBoolean || !loginBool)">
      <p>{{ '#'+info.hashTag[0] }}</p>
      <p>{{ '#'+info.hashTag[1] }}</p>
      <p>{{ '#'+info.hashTag[2] }}</p>
      <p>{{ info.modDate }}</p>
      <!-- <p>{{ info.cuCo }}</p> -->
    </div>
    
    <div class="text1" v-if="!selectMode && info.cuCo != 'Folder' && storeBool && delColBoolean && loginBool"> 
      <button @click.stop="deleteCol()">삭제</button>
      <button @click.stop="shareCol()">공유</button>
    </div>
    <div class="text1" 
        v-if="!selectMode && info.cuCo == 'Folder' && info.folderNameIsDisabled && storeBool && delColBoolean && loginBool"
        @click="!selectMode && moveToPage()"
        > 
      <button @click.stop="deleteCol()">삭제</button>
      <button @click.stop="modifyFolderName(id)">수정</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommonCollection",
  props: ['info', 'id', 'delColBoolean', 'loginBool', 'selectMode'],
  data() {
    return {
      cuSelect: 'cu-img' + this.id,
      folderSelect: 'folder' + this.id,
      // folderNameIsDisabled: false,
      
      // hashTag들만 뜨게 만들기
      hoverBool: false,

      // 내꺼가 아닌 다른 사람의 컬렉션을 보기
      storeBool: false,

      // 클릭했을 때 체크버튼 만들기
      selected: false
    }
  },
  methods: {
    inCuration(cuCo) {
      this.hoverBool = true;
      this.storeBool = true;
      if(cuCo == 'Folder' && this.info.folderNameIsDisabled) {
        document.querySelector('.'+this.folderSelect).classList.add('lowerBrightness');
      } 
      if(cuCo != 'Folder') {
        document.querySelector('.'+this.cuSelect).classList.add('lowerBrightness');
      }
    },
    outCuration(cuCo) {
      this.hoverBool = false;
      this.storeBool = false;
      if(cuCo == 'Folder'&& this.info.folderNameIsDisabled) {
        document.querySelector('.'+this.folderSelect).classList.remove('lowerBrightness');
      } 
      if(cuCo != 'Folder') {
        document.querySelector('.'+this.cuSelect).classList.remove('lowerBrightness');
      }
    },
    confirmFolderName(id) {
      let folderName = document.querySelector('.folderName').value;
      console.log(folderName)
      console.log(id);
      // if(folderName.trim() != '') this.folderNameIsDisabled = true;
      if(folderName.trim() != '') this.$emit('convertDisabled', true, id);
      
      this.$emit('sendFolderData', folderName, id);
    },
    modifyFolderName(id) {
      // this.folderNameIsDisabled = false;
      this.$emit('convertDisabled', false, id);
      document.querySelector('.'+this.folderSelect).classList.remove('lowerBrightness');
    },
    deleteCol() {
      console.log('CommonCollection', this.id);
      this.$emit('deleteCol', [this.id]);
    },
    shareCol() {
      console.log("공유 버튼을 눌렀다!");
    },
    selectedMethod() {
      this.selected == true ? this.selected = false : this.selected = true;
    },
    moveToPage() {
      console.log(this.info);
      console.log('이제 움직여 볼까나?');
    }
  }
}
</script>

<style scoped>
.collection {
  position: relative;
}
.img-area {
  position: relative;
  background: none;
}
.collection img:nth-child(1) {
  position: relative;
  width: 180px;
  height: 180px;
  object-fit: cover;
  /* margin-right: 0px; */
  z-index: 2;
}
.collection img:nth-child(2) {
  width: 180px;
  height: 180px;
  position: absolute;
  left: 7.5px;
  top: 7.5px;
  object-fit: cover;
  filter: brightness(70%);
  /* -webkit-filter: blur(1px); */
  /* margin-right: 0px; */
  z-index: 1;
}
.collection img:nth-child(3) {
  width: 180px;
  height: 180px;
  position: absolute;
  left: 15px;
  top: 15px;
  object-fit: cover;
  filter: brightness(70%);
  /* -webkit-filter: blur(1px); */
  /* margin-right: 0px; */
  z-index: 0;
}
.check-icon {
  display: flex;
  width: 180px;
  height: 180px;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 0;
  left: 0;
  background: rgba(0, 0, 0, .7);
  z-index:3;
}
.replace {
  width: 180px;
  height: 180px;
  position: absolute;
  background: grey;
  left: 5px;
  top: 5px;
  object-fit: cover;
  filter: brightness(80%);
  -webkit-filter: blur(2px);
  /* margin-right: 0px; */
  z-index: 0;
}
#folder {
  width: 180px;
  height: 180px;
  background: lightgrey;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 5px 5px 5px grey;
  border-radius: 20px;
}
#folder textarea {
  height: 60px;
  background: none;
  border: none;
  text-align: center;
  resize: none;
  margin-bottom: 10px;
}
#folder textarea::placeholder, #folder textarea:focus {
  outline: none;
}
.text1 {
  width: 180px;
  height: 180px;
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  top: 0;
  left: 0;
  opacity: 100%;
  z-index: 3;
}
.text1 p {
  color: white;
  font-weight: bold;
  position: relative;
}
.text1 button {
  width: 70px;
  height: 35px;
  margin: 10px;
  background: #DC8552;
  color: white;
  border: none;
  border-radius: 100px;
  cursor: pointer;
}
.folder-confirm-btn {
  width: 70px;
  height: 35px;
  margin: 10px;
  background: #DC8552;
  color: white;
  border: none;
  border-radius: 100px;
  cursor: pointer;
}
.lowerBrightness {
  transition: all .3s;
  filter: brightness(60%);
}


</style>