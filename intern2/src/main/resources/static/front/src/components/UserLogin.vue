<template>
  <div class="vue-template">
    <form>
      <h3>로그인</h3>
      <div class="form-group">
        <label>아이디</label>
        <input type="email" name="" id="userId" v-model="userId" class="form-control form-control-lg" />
      </div>
      <div class="form-group">
        <label>비밀번호</label>
        <input type="password" name="" id="userPw" v-model="userPw" class="form-control form-control-lg" />
      </div>
      <button type="submit" class="btn btn-dark btn-lg btn-block">
        로그인
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
    };
  },
  methods: {
    data : function () {
      console.log(this.userId, this.userPw);
      const URL = 'http://localhost:8001/api/login'
      var data = {
        userId: this.userId,
        userPw: this.userPw,
      }
      axios.post(URL , data)
          .then(function (response) {
            console.log(response)
          })
          .catch(function (error) {
            console.log(error)
          });
    }
  }
}
</script>
<style scoped>
</style>
