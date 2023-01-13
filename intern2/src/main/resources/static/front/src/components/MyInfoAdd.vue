<template>
  <div class="vue-class">
    <form>
      <H1>혈압 수동 입력</H1>
      <div class="form-group">
        <div class="form-group">
          <label>SYS</label>
          <input type="text" name="" id="sys" v-model="sys" class="form-control form-control-lg" />
        </div>
      <label>DIA</label>
      <input type="text" name="" id="dia" v-model="dia" class="form-control form-control-lg" />
    </div>

        <div class="form-group">
          <label>PULSE</label>
          <input type="text" name="" id="pulse" v-model="pulse" class="form-control form-control-lg" />
        </div>

      <div class="form-group">
        <label>USERID</label>
        <input type="text" name="" id="userId" v-model="userId" class="form-control form-control-lg" />
      </div>

      <button type="submit" @click="submitForm">
        홈으로
      </button>
      <button type="submit" @click="reload">재측정</button>

    </form>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";
export default {
  name: "MyInfoAdd",
  data() {
    return {
      dia: '',
      sys: '',
      pulse:'',
      userId:''
    };
  },
  methods: {
    reload:function(){
      window.location.ref("/")
    },
    submitForm : function () {
      console.log(this.dia, this.sys,this.pulse,this.userId);
      const URL = 'http://localhost:8001/api/register'
      var data = {
        dia: this.dia,
        sys: this.sys,
        pulse:this.pulse,
        userId:this.userId
      }
      if ((data.sys.value > 90 && data.sys.value < 120) && (data.dia.value > 60 && data.dia < 80)) {
        alert('정상입니다.');
        alert("등록에 성공했습니다.");
      } else if ((data.sys >= 120 &&data.sys <= 139) || (data.dia.value >= 80 && data.dia.value<= 89)) {
        alert('고혈압 전단계입니다.');
        alert("등록에 성공했습니다.");
      } else if ((data.sys >= 140 && data.sys <= 159) || (data.dia.value >= 90 && data.dia.value<= 99)) {
        alert('고혈압 1기입니다.');
        alert("등록에 성공했습니다.");
      } else if (data.sys >= 160 || data.dia.value >= 100) {
        alert('고혈압 2기입니다.');
        alert("등록에 성공했습니다.");
      } else if (data.sys <= 90 || data.dia.value<= 60) {
        alert('저혈압입니다.');
        alert("등록에 성공했습니다.");
      } else{
        alert('정확한 값을 다시 입력해주세요.');
        router.push("/add")
      }
      axios.post(URL , data)
          .then(function (response) {
            console.log(response)
            console.log(data.userId)
            router.push("/")

          }).catch(function (error) {
            console.log(error)
            alert("등록 실패 하였습니다");
            router.push("/add")
          });
    }
  }
}
</script>

<style scoped>

</style>