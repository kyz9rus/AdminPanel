import Vue from 'vue'
import Router from 'vue-router'
// import SearchBanners from '@/components/SearchBanners '
import Index from "@/components/Index.vue";
// import AddBanner from "./components/AddBanner.vue";
// import SearchBanners from "./components/SearchBanners.vue";
import Banner from "@/components/Banner.vue";
import Admin from "@/components/Admin.vue";

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
        path: "/",
        // name: "index",
        // components: Index
        name: "index",
        component: Index,
        children: [
            {
                path: "/banner/:id",
                name: "banner-details",
                component: Banner,
                props: true
            }
        ]
    },
    // {
    //     path: "/add",
    //     name: "add",
    //     component: AddBanner
    // },
    // {
    //   path: "/search",
    //   name: "search",
    //   component: SearchBanners
    // },
      {
          path: "/admin",
          name: "admin",
          component: Admin
      }
  ]
})
