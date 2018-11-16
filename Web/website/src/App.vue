<template>
<div id="app">
    <!-- <img src="./assets/logo.png">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <ul>
      <li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>
      <li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>
      <li><a href="https://chat.vuejs.org" target="_blank">Community Chat</a></li>
      <li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>
    </ul>
    <h2>Ecosystem</h2>
    <ul>
      <li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>
      <li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>
      <li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>
      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>
    </ul> -->

    <h1></h1>
    <div v-on:click="doTest"> test </div>

    <br>

    <div v-on:click="postD"> getValue</div>
</div>
</template>

<script>
import Vue from "vue";
import webAPI from './service/webAPI.js';

export default {
    name: 'app',
    data() {
        return {
            msg: 'Welcome to Your Vue.js App'
        }
    },
    methods: {

        postD() {
                    const data1 = {
                orderId: "order004",
                orderCode: "order-code-004",
                orderType: "1"
            };

            Vue.http.post("http://localhost:6011/order/setValueWithPost", data1, {
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                .then(
                    response => {

                        if (response.body.success) {
                            callBack(response.body.data, response);
                        }
                    },

                );
        },

        postInfo() {
            const postData = {
                orderId: "order004",
                orderCode: "order-code-004",
                orderType: "1"
            };

            alert(postData);

            webAPI.webClient.post("http://localhost:6011/order/setValueWithPost", postData );
        },

        doTest() {
            webAPI.test.valid();
        },
        query() {
            alert("dd");
        }

    }
}
</script>

<style>
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}

h1,
h2 {
    font-weight: normal;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    display: inline-block;
    margin: 0 10px;
}

a {
    color: #42b983;
}
</style>
