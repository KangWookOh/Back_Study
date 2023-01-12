import { createRouter, createWebHashHistory } from 'vue-router'


const routes = [
  {
    path: '/',
    name: 'MainPage',

    component: () => import(/* webpackChunkName: "about" */ '../components/MainPage.vue')
  },
  {
    path: '/login',
    name: 'UserLogin',
    component: () => import('../components/UserLogin.vue')
  },
  {
    path: '/signup',
    name: 'UserSignUp',
    component: () => import( '../components/UserSignUp.vue')
  },
  {
    path: '/add',
    name: 'MyInfoAdd',
    component: () => import('../components/MyInfoAdd.vue')
  },
  {
    path: '/list',
    name: 'MyList',
    component: () => import ('../components/MyList.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
