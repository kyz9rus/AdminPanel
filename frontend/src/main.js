// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Footer from '@/components/Footer.vue'
import Header from '@/components/Header.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)
Vue.config.productionTip = false

Vue.component('app-header', Header)
Vue.component('app-footer', Footer)

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