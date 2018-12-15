<template>
    <div class="list row">
        <div class="col-md-6">

            <h4>Banners List</h4>
            <ul>
                <!--<input type="text" v-model="input" autofocus>-->

                <li v-for="(banner, id) in banners" :key="id" @click="showBanner">
                <!--<li v-for="(banner, id) in banners | orderBy 'langid" | filterBy input :key="id" @click="showBanner">-->
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
                banners: [{id: 1, width: 400, height: 200, imgsrc: '/static/img/acura.jpg', langid: 'Russion', targeturl: 'https://www.lada.ru'}],
                show: true,
                scale: 2       // масштаб для корректного отображения баннеров на сайте
            };
        },
        methods: {
            retrieveBanners() {
                http
                    .get("/showAllBanners")
                    .then(response => {
                        this.banners = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                        for (var i = 0; i < this.banners.length; i++){
                            this.banners[i].width = this.banners[i].width / this.scale;
                            this.banners[i].height = this.banners[i].height / this.scale;
                        }
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