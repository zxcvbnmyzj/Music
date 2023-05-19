import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'

import Home from '@/views/home/Home'
import Login from '../views/Login.vue'

Vue.use(Router)

export default new Router({
  routes: [
   
    {
      path:'/login',
      name:'Login',
      component:Login
    },
    {
      path:'/',
      name:'Defalut',
      redirect:'/Home',
      component: Home
    },
    {
      path:'/Home',
      name:'Home',
      component:Home,
      meta:{
        requireAuth:true
      },
      redirect:'/index',
      children:[
        {
          path:'/index',
          name:'Index',
          component:() => import('@/views/index/index'),
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/singer',
          name:'Singer',
          component:()=>import('@/views/singer/singer'),
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/sheet',
          name:'Sheet',
          component:()=>import('@/views/sheet/sheet'),
          meta:{
            requireAuth:true
          }
        },
        {
          path:'/user',
          name:'User',
          component:()=>import('@/views/user/index'),
          meta:{
            requireAuth:true
          }
        }
      ]
    }
  ]
})
