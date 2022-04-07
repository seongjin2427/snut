<template>
<div class="modal wrapper" v-if="modalBoolean">
  <div class="overlay" @click="modalBoolean = false"></div>
  <div class="modal-block" :style="{
    width: width+'px',
    height: height+'px',
    marginTop: marginTop+'px' ,
    marginRight: marginRight+'px',
    background: background,
    fontSize: fontSize+'px',
    borderRadius: borderRadius+'px',
    border: border,
    color: color
  }">
    {{ smallModal }}
    <div v-if="joinBoolean" class="message">
      <p>닉네임:</p>
      <p class="joinmessage">가입요청메세지:<textarea> </textarea></p>
    </div>
    <div class="modal-btn-area">
<common-button v-for="(btn, idx) in modalBtnData" :button-name="btn.name" :key="idx" width="145" height="45" border-radius="6" :background="btn.background"
:color="btn.color" margin="10" @click="closemodal($event,btn)"/>
    </div>
  </div>

</div>
</template>

<script>
import CommonButton from "@/components/CommonButton";
export default {
  name: "SmallModal",
  components: {CommonButton},
  data() {
    return {
      modalBoolean: false,
      joinBoolean: false
    }
  },
  props:[
    'modalBtnData',
    'smallModal',
    'width',
    'height',
    'margin-top',
    'margin-right',
    'background',
    'fontSize',
    'borderRadius',
    'border',
    'color'
  ],
  methods: {
    openModal(bool) {
      this.modalBoolean = true;
      this.joinBoolean = bool;
    },
    closemodal(e, btn){
      if(btn.name == "취소" || btn.name =="아니오" || btn.name == "확인" || btn.name =="닫기"){
        this.modalBoolean = false;
      }
    }
  }
}
</script>

<style scoped>
.overlay{
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background: rgba(0,0,0,0.5);
  transition: opacity 0.3s ease;
}

.modal-block{
  width: 415px;
  height: 215px;
  background: white;
  display: flex;
  box-shadow: 0px 8px 30px rgba(0, 0, 0, 0.12);
  border-radius: 16px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 40px;
  position: fixed;
  transform: translate(-50%, -50%);
  left: 50%;
  top: 20%;
}
.modal-btn-area{
  display: flex;
  padding-top: 10px;
}
textarea:focus{
  /*outline: none;*/
}
textarea{
  color: #868686;
  flex: none;
  order: 0;
  flex-grow: 1;
  margin: 10px 10px 10px 10px;
  border: none;
  font-size: 16px;
  resize: none;
  width: 400px;
 height: 100px;
}
.message{
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.joinmessage{
  margin-top: 20px;
  display: flex;
  align-items: flex-start;
}

</style>