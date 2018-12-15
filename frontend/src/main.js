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

// For Admin
import AddBanner from '@/components/forAdmin/AddBanner.vue'
import EditBanner from '@/components/forAdmin/EditBanner.vue'
import DeleteBanner from '@/components/forAdmin/DeleteBanner.vue'
import Log from '@/components/forAdmin/Log.vue'
import ActionWithBanners from '@/components/forAdmin/ActionWithBanners.vue'
import GroupBanners from '@/components/forAdmin/actionWithBanners/GroupBanners.vue'
import SortBanners from '@/components/forAdmin/actionWithBanners/SortBanners.vue'


Vue.use(VueAxios, axios)
Vue.config.productionTip = false

Vue.component('app-header', Header)
Vue.component('app-footer', Footer)
Vue.component('app-banners', Banners)

Vue.component('app-add-banner', AddBanner)
Vue.component('app-edit-banner', EditBanner)
Vue.component('app-delete-banner', DeleteBanner)
Vue.component('app-log', Log)
Vue.component('app-action-with-banners', ActionWithBanners)
Vue.component('app-group-banners', GroupBanners)
Vue.component('app-sort-banners', SortBanners)

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
