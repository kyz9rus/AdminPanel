import Vue from 'vue'
import Router from 'vue-router'
// import SearchBanners from '@/components/SearchBanners '
import BannersList from "@/components/BannersList.vue";
// import AddBanner from "./components/AddBanner.vue";
// import SearchBanners from "./components/SearchBanners.vue";
import Banner from "@/components/Banner.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
        path: "/",
        name: "banners",
        alias: "/banner",
        component: BannersList,
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
    // }
  ]
})
