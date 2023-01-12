<template>
<h2>내정보</h2>
  <div id="app">
    <button @click="getList">데이터 가져오기 </button>
  </div>

  <div v-for="(user_id,idx) in user_id" :key=idx>
      <h2>{{user_id.username}}</h2>
    </div>
  <div v-for="(id, i) in id" :key=i>
    <h2>{{id.dia}}</h2>
    <h2>{{id.sys}}</h2>
    <h2>{{id.pulse}}</h2>
    <h2>{{id.date}}</h2>

  </div>


</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "MyList",
  data(){
    return {
      dia:'',
      sys:'' ,
      pulse:'',
      date:'',
      user_id:'',

  };
  },
  methods:{
     getList : function () {
      var data ={
        user_id:this.user_id,
        dia:this.dia,
        sys:this.sys ,
        pulse:this.pulse,
        date:this.date,

      }
      const URL ='http://localhost:8001/api/list'


      axios.get(URL,data,{
        headers: { 'Content-Type': 'application/json' }
      })
          .then(res =>{
            if(res.status === 200) {
              console.log(res)
              this.result =res.data;
              this.user = res.data;
              this.sys = res.data.sys;
              this.dia = res.data.dia;
              this.pulse = res.data.pulse;
              this.date = res.data.dateTime;
            }
          })
          .catch(err =>{
            alert("정보를 가져 오지 못햇습니다 로그인 해주세요 ",err);
            router.push("/login")

          });
    },
  }

}
</script>

<style scoped>

</style>