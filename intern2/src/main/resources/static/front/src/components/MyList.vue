<template>
<div id="app">
  <button @click="getList">데이터 가져오기 </button>
</div>

</template>

<script>
import axios from "axios";
import UserLogin from "@/components/UserLogin.vue";
export default {
  name: "MyList",
  data(){
    return {
      result:'',
      token : UserLogin.data().result
  };
  },
  methods:{
    getList : function () {
      console.log(this.result)

      var data ={
        result:this.result

      }
      var data2 ={
        token:UserLogin.data().result
      }
      const URL ='http://localhost:8001/api/list'
      axios.get(URL,data,data2)

          .then(res =>{
            this.result =JSON.stringify(res.data)
            console.log(res)
            console.log(data2.token)
          })
          .catch(err =>{
            this.result =JSON.stringify(err);
          });
    },
  }

}
</script>

<style scoped>

</style>