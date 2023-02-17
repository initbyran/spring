import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import BoardDetail from '@/components/BoardDetail'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/board/:bnum',
      name: 'BoardDetail',
      component: BoardDetail
    }
  ]
})