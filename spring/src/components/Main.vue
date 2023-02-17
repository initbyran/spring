<template>
  <div>
    어뜩하지

    <router-link :to="{ name: 'BoardDetail', params: { bnum: 2 }}">2번 게시글</router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    mounted() {
        console.log('asdfasdf')
        axios.post('http://localhost:8080/board/api/login')
        .then((result) => {
            console.log(result);
        })
        .catch((result) => {
            console.error(result);
        });
    }
}
</script>

<style>

</style>
