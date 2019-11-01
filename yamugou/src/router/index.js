import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}


export default new Router({

  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('@/pages/index3.0')
    },
    {
      path: 'Detail',
      name: 'Detail',
      component: () => import('@/pages/Detail')
    },
    {
      path: 'newsList',
      name: 'newsList',
      component: () => import('@/pages/newsList')
    },
    {
      path: 'ZWXW',
      name: 'ZWXW',
      component: () => import('@/pages/ZWXW')
    },
    {
      path: 'jqjs',
      name: 'jqjs',
      component: () => import('@/pages/jqjs')
    },
    {
      path: 'phoneLocalnewsDetail',
      name: 'phoneLocalnewsDetail',
      component: () => import('@/pages/phoneLocalnewsDetail')
    },
    {
      path: 'phoneJDDetail',
      name: 'phoneJDDetail',
      component: () => import('@/pages/phoneJDDetail')
    },
    {
      path: '/LYGL/:listName',                                     //旅游攻略
      name: 'LYGL',
      component: () => import('@/pages/LYGL')
    },
    {
      path: 'LYGL_Sec',                                     //旅游攻略二级页面
      name: 'LYGL_Sec',
      component: () => import('@/pages/LYGL_Sec')
    },
    {
      path: 'onlineBooking',                                      //在线预订
      name: 'onlineBooking',
      component: () => import('@/pages/onlineBooking')
    },
    {
      path: '/wzymg/:type',                                      //玩转亚木沟
      name: 'wzymg',
      component: () => import('@/pages/wzymg')
    },
    {
      path: 'wzymgOld',                                      //玩转亚木沟
      name: 'wzymgOld',
      component: () => import('@/pages/wzymgOld')
    },
    {
      path: 'wzymg_Sec',                                      //玩转亚木沟二级页面
      name: 'wzymg_Sec',
      component: () => import('@/pages/wzymg_Sec')
    },
    {
      path: '/wzymg_more/:listName',                                      //玩转亚木沟二级页面
      name: 'wzymg_more',
      component: () => import('@/pages/wzymg_more')
    },
    {
      path: 'yzymg',                                      //游在亚木沟
      name: 'yzymg',
      component: () => import('@/pages/yzymg')
    },
    {
      path: 'contactUS',                                      //联系我们
      name: 'contactUS',
      component: () => import('@/pages/contactUS')
    },
    {
      path: 'onlineBookingDetail',                                      //在线预订的二级页面-查看详情
      name: 'onlineBookingDetail',
      component: () => import('@/pages/onlineBookingDetail')
    },
    {
      path: 'aboutUS',                                      //关于我们
      name: 'aboutUS',
      component: () => import('@/pages/aboutUS')
    },
    {
      path: 'localNews',                                      //景区新闻
      name: 'localNews',
      component: () => import('@/pages/localNews')
    },
  ]
})
