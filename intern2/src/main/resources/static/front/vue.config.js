const { defineConfig } = require('@vue/cli-service')
const target = 'http://localhost:8001/api'

module.exports = defineConfig({

  transpileDependencies: true,

  devServer : {
    port:8080,
    proxy:{
      api:{
        target: process.env.VUE_APP_API_URL,
        changeOrigin:true
      }
    }
  }

});

