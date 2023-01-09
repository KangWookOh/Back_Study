import axios from "axios";



function createInstance() {
    const instance = axios.create({
        baseURL: process.env.VUE_APP_API_URL,
    });

    return setInterceptors(instance);
}

const instance = createInstance();
