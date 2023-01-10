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
      token :''
    };
  },
  methods: {
     submitForm() {
      var data = {
        userId: this.userId,
        userPw: this.userPw
      };

      if (!data.userId || !data.userPw) {
        alert("사용자 정보가 없습니다.")
      }
       axios
          .post("http://localhost:8001/api/login", data)
          .then(res => {
            if (res.status === 200) {
              this.result = res.data
              console.log(this.result)
              this.token = this.result.data
              console.log("token" + this.token)

              this.$cookie.set("accessToken", res.data, 1);

              axios.defaults.headers.common["x-access-token"] = res.data;
              alert("로그인 성공")
            }
          })
          .catch(err => {
            alert("로그인 실패 " + err)
          })
    }
  }

};
</script>
<style scoped>
</style>
