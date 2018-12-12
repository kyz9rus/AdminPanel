// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios'
import VueAxios from 'vue-axios'

import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'

import Banners from '@/components/Banners.vue'
import AddBanner from '@/components/AddBanner.vue'
import EditBanner from '@/components/EditBanner.vue'

Vue.use(VueAxios, axios)
Vue.config.productionTip = false

Vue.component('app-header', Header)
Vue.component('app-footer', Footer)
Vue.component('app-banners', Banners)
Vue.component('app-addBanner', AddBanner)
Vue.component('app-editBanner', EditBanner)

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
})

// axios.get('http://localhost:8080/api/getAuthority').then((response) => {
//     console.log('RESPONSE')
//     console.log(response.data)
//
//     if (response.data === 'admin') {
//         alert('admin');
//         $(location).attr('href', 'http://localhost:8080/admin');
//     }
// });