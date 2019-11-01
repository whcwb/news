// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import apis from './axios/api';
import http from './axios/index';

import '../src/assets/css/font.css'
import $ from 'jquery' ;
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap-vue/dist/bootstrap-vue.css'

import 'iview/dist/styles/iview.css';


import VueI18n from 'vue-i18n'
import BootstrapVue from 'bootstrap-vue'
Vue.use(VueI18n)
Vue.use(BootstrapVue)

Vue.prototype.apis = apis;


Vue.prototype.$http = http;

import {Card,Modal} from 'iview';
Vue.component('Card', Card);
Vue.component('Modal', Modal);

import 'fullpage.js/vendors/scrolloverflow' // Optional. When using scrollOverflow:true
import VueFullPage from 'vue-fullpage.js'

Vue.use(VueFullPage);



const i18n = new VueI18n({
  locale: 'zh-CN',    // 语言标识
  //this.$i18n.locale // 通过切换locale的值来实现语言切换
  messages: {
    'zh-CN': require('./common/lang/zh'),   // 中文语言包
    'en-US': require('./common/lang/en')    // 英文语言包
  }
})

Vue.config.productionTip = false




/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  i18n
})
