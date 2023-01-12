<template>
  <h2>혈압 관리 </h2>
  <button type="submit">
    <router-link to="/signup">회원가입</router-link>
  </button>
  <button type="submit">
    <router-link to="/login">로그인</router-link>
  </button>

  <button type="submit">
    <router-link to="/add">혈압입력</router-link>
  </button>
  <button variant="primary" type="submit">
    <router-link to="/list">내정보 </router-link>
  </button>

</template>

<script>
export default {
  name: "MainPage"
}
</script>


<style scoped>
.button
{color: #42b983}

</style>