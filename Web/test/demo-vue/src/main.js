// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import axios from 'axios'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

//设置反向代理,前端请求默认发送到下面的url
axios.defaults.baseURL = 'http://localhost:6060/yohane/api'

//全局注册,可在其他组件中通过this.$axios发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)

//钩子函数,访问路由前
router.beforeEach((to,from,next)=>{
  if(to.meta.requireAuth == true){
    if(store.state.token){
      next()
    }else{
      next({
        path:'/login',
        query: {redirect:to.fullPath}
      })
    }
  }else{
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

