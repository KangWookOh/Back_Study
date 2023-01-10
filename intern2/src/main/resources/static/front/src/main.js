import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cookie from "@/plugins/cookie";




const app = createApp(App).use(cookie).use(store).use(router).use(router);
app.use(router);

app.mount("#app");
