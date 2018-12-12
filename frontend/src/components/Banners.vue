<template>
    <div class="list row">
        <div class="col-md-6">

            <h4>Banners List</h4>
            <ul>
                <li v-for="(banner, id) in banners" :key="id" @click="showBanner">
                    <router-link :to="{
                                        name: 'banner-details',
                                        params: { banner: banner, id: banner.id}
                                    }">
                        <div align="center" class="banner">
                            <a :href="banner.targeturl">
                                <img :width="banner.width" :height="banner.height" :src="banner.imgsrc"/>
                            </a>
                        </div>
                    </router-link>
                    <!--// для сортировки исп-ся фильтр ( | orderBy 'параметр')-->
                </li>
            </ul>

        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "banners-list",
        data() {
            return {
                banners: [{id: 1, width: 400, height: 200, imgsrc: '/static/img/acura.jpg', langid: 'Russion', targeturl: 'http://www.yandex.ru'}],
                show: true
            };
        },
        methods: {
            retrieveBanners() {
                http
                    .get("/showAllBanners")
                    .then(response => {
                        this.banners = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            refreshList() {
                this.retrieveBanners();
            },
            showBanner(){
                $('.descBanner').show();
            }
        },
        mounted() {
            this.retrieveBanners();
        }
    }
</script>

<style scoped>
    li{
        list-style-type: none;
    }
    .banner{
        margin: 10px auto;
    }
</style>