// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import AppAdmin from './AppAdmin'
import router from './router'

import axios from 'axios'
import VueAxios from 'vue-axios'

import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'

import Banners from '@/components/Banners.vue'

import AddBanner from '@/components/forAdmin/AddBanner.vue'
import EditBanner from '@/components/forAdmin/EditBanner.vue'
import DeleteBanner from '@/components/forAdmin/DeleteBanner.vue'
import Log from '@/components/forAdmin/LogBanner.vue'


Vue.use(VueAxios, axios)
Vue.config.productionTip = false

Vue.component('app-header', Header)
Vue.component('app-footer', Footer)
Vue.component('app-banners', Banners)
Vue.component('app-addBanner', AddBanner)
Vue.component('app-editBanner', EditBanner)
Vue.component('app-deleteBanner', DeleteBanner)
Vue.component('app-log', Log)

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
})

new Vue({
    el: '#admin',
    router,
    components: { AppAdmin },
    template: '<AppAdmin/>',
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