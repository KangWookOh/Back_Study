import { createRouter, createWebHashHistory } from 'vue-router'


const routes = [
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
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
