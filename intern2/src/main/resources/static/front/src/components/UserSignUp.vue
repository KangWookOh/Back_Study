<template>
  <div class="vue-template">
    <form>
      <h3>회원가입</h3>
      <div class="form-group">
        <label>아이디</label>
        <input type="text" name="" id="userId" v-model="userId" class="form-control form-control-lg" />
      </div>

      <div class="form-group">
        <label>비밀번호</label>
        <input type="password" name="" id="userPw" v-model="userPw" class="form-control form-control-lg" />
      </div>
      <div class="form-group">
        <label>이름</label>
        <input type="text" name="" id="userName" v-model="userName" class="form-control form-control-lg" />
      </div>
      <div>
        <button @click="submitForm" type="submit">
          <router-link to="/login">회원가입</router-link>
        </button>
      </div>

    </form>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  name: "UserSignUp",
  data() {
    return {
      id:'',
      userId: '',
      userPw: '',
      userName:'',
    };

  },
  methods:{
    submitForm: function (){
      console.log(this.userId,this.userPw,this.userName,this.id);
      const URL ='http://localhost:8001/api/signup'
      var data ={

        userId :this.userId,
        userPw : this.userPw,
        userName :this.userName,
        id:this.id
      }

      axios.post(URL,data)

          .then(function (response)
          {
            console.log(response)
            data.id =JSON.parse(response.data.id)
          })
          .catch(function (error)
          {
            console.log(error)
            alert("회원가입에 실패했습니다")
          });

    }
  }
}
</script>

<style scoped>

</style>
