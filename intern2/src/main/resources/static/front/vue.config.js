const { defineConfig } = require('@vue/cli-service')
const target = 'http://localhost:8001'

module.exports = defineConfig({

  transpileDependencies: true,

  devServer : {
    port:8080,
    proxy:{
      api:{
        target,
        changeOrigin:true
      }
    }
  }

});

