import { createStore } from 'vuex'
import Cookie from "@/plugins/cookie";

export default createStore({
  state: {
    saveStateToStorage(state) {
      Cookie.set("accessToken",state.accessToken,60*60*24)
    }

    },
  getters: {
  },
  mutations: {

    setToken(state,token)
    {
      state.token=token;
    }
  },
  actions: {
  },
  modules: {
  }
})



