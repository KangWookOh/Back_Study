<template>
<div id="app">
  <button @click="getList">데이터 가져오기 </button>
</div>

</template>

<script>
import axios from "axios";


export default {
  name: "MyList",
  data(){

    return {
      result:[]
  };
  },
  methods:{
    async getList() {
      var data ={
        result:this.result

      }
      const URL ='http://localhost:8001/api/list'


      axios.get(URL,data)
          .then(res =>{
            this.result =res.data
            console.log(this.result)
            console.log(res)
          })
          .catch(err =>{
            alert("실패 ",err);
          });
    },
  }

}
</script>

<style scoped>

</style>