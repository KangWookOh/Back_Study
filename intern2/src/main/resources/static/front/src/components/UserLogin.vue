<template>
  <div class="vue-template">
    <form>
      <h3>로그인</h3>
      <div class="form-group">
        <label>아이디</label>
        <input type="text" name="" id="userId" v-model="userId" class="form-control form-control-lg" />
      </div>
      <div class="form-group">
        <label>비밀번호</label>
        <input type="password" name="" id="userPw" v-model="userPw" class="form-control form-control-lg" />
      </div>

      <button @click="submitForm" type="submit">
        <router-link to="/add">로그인</router-link>
      </button>

    </form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "UserLogin",
  data() {
    return {
      userId: '',
      userPw: '',
      result :''
    };
  },
  methods: {

    submitForm : function () {
      console.log(this.userId, this.userPw,this.result);
      const URL = 'http://localhost:8001/api/login'
      var data = {
        userId: this.userId,
        userPw: this.userPw,
      }
      var data2={
        result : this.result
      }
      axios.post(URL , data)
          .then(function (response) {
            console.log(response)
             data2.result=response.data
            console.log(data2.result)
            alert("로그인에 성공했습니다.")
          })
          .catch(function (error) {
            console.log(error)
            alert("로그인에 실패 하였습니다")
          });
    }
  }

}
</script>
<style scoped>
</style>
