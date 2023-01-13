<template>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>내정보 확인</title>

</head>
  <body>
  <div>
    <table class="table-bordered">
      <thead>
      <tr>
        <th>SYS</th>
        <th>DIA</th>
        <th>PULSE</th>
        <th>DATE</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(user,index) in users" :key="index">
        <td v-text="user.sys"></td>
        <td v-text="user.dia"></td>
        <td v-text="user.pulse"></td>
        <td v-text="user.dateTime"></td>



      </tr>
      </tbody>
    </table>
  </div>
  </body>


</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "MyList",
  data(){
    return {
      result:[],
      users:[ ]

  };
  },
  created() {
    this.getList();
  },
  methods:{
     getList : async function () {
       var data = {
         user_id: this.user_id,
         dia: this.dia,
         sys: this.sys,
         pulse: this.pulse,
         date: this.date,
         result: this.result,
         users: this.users

       }
       const URL = 'http://localhost:8001/api/list'
       await axios
           .get(URL, data, {
             headers: {
               'Accept': 'application/json',
               'Content-Type':'application/json'
             }
           })
           .then(res => {

             res.data.map((userList) => {
               this.result = userList;
               console.log(this.result)
               this.users = userList;
               console.log(this.users)

             })
           })
           .catch(err => {
             alert("정보를 가져 오지 못햇습니다 로그인 해주세요 ", err);
             console.log(err)
             router.push("/login")

           });
     },
  }

}
</script>

<style scoped>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>