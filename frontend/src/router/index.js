import Vue from 'vue'
import Router from 'vue-router'
import Index from "@/components/Index.vue";
import Banner from "@/components/Banner.vue";
import Admin from "@/components/Admin.vue";

import AddBanner from "@/components/forAdmin/AddBanner.vue";
import EditBanner from "@/components/forAdmin/EditBanner.vue";
import DeleteBanner from "@/components/forAdmin/DeleteBanner.vue";
import BannerChanges from "@/components/forAdmin/Log.vue";
import TestPage from "@/components/Banners.vue";

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
                  path: "/admin/addBanner",
                  name: "add-banner",
                  component: AddBanner,
                  props: true
              },
              {
                  path: "/admin/editBanner",
                  name: "edit-banner",
                  component: EditBanner,
                  props: true
              },
              {
                  path: "/admin/deleteBanner",
                  name: "delete-banner",
                  component: DeleteBanner,
                  props: true
              },
              {
                  path: "/admin/bannerChanges",
                  name: "banner-changes",
                  component: BannerChanges,
                  props: true
              },
              {
                  path: "/admin/testPage",
                  name: "test-page",
                  component: TestPage,
                  props: true,
                  children: [
                      {
                          path: "/admin/testPage/banner/:id",
                          name: "banner-details-admin",
                          component: Banner,
                          props: true
                      },
                  ]
              },

          ]
      }
  ]
})
