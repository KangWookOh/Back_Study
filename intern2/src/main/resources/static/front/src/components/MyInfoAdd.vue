<template>
  <div class="vue-class">
    <form>
      <H1>혈압 수동 입력</H1>
      <div class="form-group">
      <label>DIA</label>
      <input type="text" name="" id="dia" v-model="dia" class="form-control form-control-lg" />
    </div>
        <div class="form-group">
          <label>SYS</label>
          <input type="text" name="" id="sys" v-model="sys" class="form-control form-control-lg" />
        </div>
        <div class="form-group">
          <label>PULSE</label>
          <input type="text" name="" id="pulse" v-model="pulse" class="form-control form-control-lg" />
        </div>

      <div class="form-group">
        <label>USERID</label>
        <input type="text" name="" id="userId" v-model="userId" class="form-control form-control-lg" />
      </div>


      <button @click="submitForm" type="submit">
        <router-link to="/list">협압등록 </router-link>
      </button>

      <button type="submit">
        <router-link to="/">홈으로 </router-link>
      </button>

    </form>
  </div>
</template>

<script>
import axios from "axios";

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
    submitForm : function () {
      console.log(this.dia, this.sys,this.pulse,this.userId);
      const URL = 'http://localhost:8001/api/register'
      var data = {
        dia: this.dia,
        sys: this.sys,
        pulse:this.pulse,
        userId:this.userId
      }
      axios.post(URL , data,{

      })
          .then(function (response) {
            console.log(response)
            console.log(data.userId)
            alert("등록에 성공했습니다.")
          })
          .catch(function (error) {
            console.log(error)
            alert("등록 실패 하였습니다")
          });
    }
  }
}
</script>

<style scoped>

</style>