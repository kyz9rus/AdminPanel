import Vue from 'vue'
import Router from 'vue-router'
import Index from "@/components/Index.vue";
import Banner from "@/components/Banner.vue";
import Admin from "@/components/Admin.vue";

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
      {
          path: "/",
          name: "index",
          component: Index,
          children: [
              {
                  path: "/banner/:id",
                  name: "banner-details-index",
                  component: Banner,
                  props: true
              }
          ]
      },
      {
          path: "/admin",
          name: "admin",
          component: Admin,
          children: [
              {
                  path: "/admin/banner/:id",
                  name: "banner-details-admin",
                  component: Banner,
                  props: true
              }
          ]
      }
  ]
})
