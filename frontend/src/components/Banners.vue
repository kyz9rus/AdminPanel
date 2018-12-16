<template>
    <div class="testPage">
        <div class="list row col-md-12">

            <div v-if="this.adminName">
                <app-action-with-banners @action="answer = $event" :languages="languages" v-on:actionValue="getActionValue"></app-action-with-banners>
            </div>

            <div class="col-md-12 banners" align="center">
                <h4>Banners List:</h4>

                <ul v-if="answer === 'Sort'">
                    <li v-for="banner in sortedBanners">
                        <div v-bind:style="{width: banner.width + 'px' }">
                            <router-link :to="{
                                        name: bannerDetailsName,
                                        params: { banner: banner, id: banner.id, extendedMode: allowScale}
                                    }">
                                <div align="center" class="banner">
                                    <a :href="banner.targetUrl">
                                        <img :width="banner.width" :height="banner.height" :src="banner.imgSrc" @click="showBanner"/>
                                    </a>
                                </div>
                            </router-link>
                        </div>
                    </li>
                </ul>

                <ul v-else-if="answer === 'Group'">
                    <li v-for="banner in groupedBanners">
                        <div v-bind:style="{width: banner.width + 'px' }">
                            <router-link :to="{
                                        name: bannerDetailsName,
                                        params: { banner: banner, id: banner.id, extendedMode: allowScale}
                                    }">
                                <div align="center" class="banner">
                                    <a :href="banner.targetUrl">
                                        <img :width="banner.width" :height="banner.height" :src="banner.imgSrc" @click="showBanner"/>
                                    </a>
                                </div>
                            </router-link>
                        </div>
                    </li>
                </ul>

                <ul v-else>
                    <li v-for="banner in banners">
                        <div v-if="allowScale" v-bind:style="{width: 100 + '%' }">
                            <router-link :to="{
                                        name: bannerDetailsName,
                                        params: { banner: banner, id: banner.id, extendedMode: allowScale}}">
                                <div align="center" class="banner">
                                    <a :href="banner.targetUrl"  >
                                        <img :width="'100%'" :height="banner.height" :src="banner.imgSrc" @click="showBanner"/>
                                    </a>
                                </div>
                            </router-link>
                        </div>

                        <div v-else v-bind:style="{width: banner.width + 'px' }">
                            <router-link :to="{
                                        name: bannerDetailsName,
                                        params: { banner: banner, id: banner.id, extendedMode: allowScale}}">
                                <div align="center" class="banner">
                                    <a :href="banner.targetUrl"  >
                                        <img :width="'100%'" :height="banner.height" :src="banner.imgSrc" @click="showBanner"/>
                                    </a>
                                </div>
                            </router-link>
                        </div>
                    </li>
                </ul>
            </div>
            <div>
                <router-view @refreshData="refreshList"></router-view>
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "banners-list",
        props: ["adminName", 'bannerDetailsName', 'allowScale'],
        data() {
            return {
                banners: [
                    {id: 1, width: 400, height: 100, imgSrc: '/static/img/acura.jpg', langId: 'Russian', targetUrl: 'https://www.lada.ru'},
                    {id: 2, width: 200, height: 20, imgSrc: '/static/img/acura.jpg', langId: 'English', targetUrl: 'https://www.alada.ru'},
                    {id: 3, width: 200, height: 200, imgSrc: '/static/img/acura.jpg', langId: 'Russian', targetUrl: 'https://www.blada.ru'},
                    {id: 4, width: 230, height: 300, imgSrc: '/static/img/acura.jpg', langId: 'Russian', targetUrl: 'https://www.blada.ru'}
                ],
                languages: ['', 'Russian', 'English'],
                show: true,
                answer: '',
                actionValue: '',
                windowWidth: window.innerWidth
            };
        },
        methods: {
            retrieveBanners() {
                this.languages = [''];

                http
                    .get("/showAllBanners")
                    .then(response => {
                        this.banners = response.data; // JSON are parsed automatically.
                        this.languages = [''];

                        let uniqueLanguages = new Set();
                        this.banners.map(banner => {
                            uniqueLanguages.add(banner.langId);
                        });
                        this.languages = Array.from(uniqueLanguages);

                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            getActionValue : function(actionValue){
                this.actionValue = actionValue;
            },
            refreshList() {
                this.retrieveBanners();
            },
            showBanner(){
                $('.descBanner').show();
            },
            handleResize (event) {
                this.windowWidth = event.currentTarget.innerWidth;
                this.banners.map(banner => {
                    banner.height = this.windowWidth * banner.height / banner.width;
                    banner.width = this.windowWidth
                });
            },},
        beforeDestroy: function () {
            window.removeEventListener('resize', this.handleResize)
        },
        mounted() {
            this.retrieveBanners();

            if (typeof this.allowScale !== "undefined")
                window.addEventListener('resize', this.handleResize)
        },
        computed: {
            sortedBanners(){
                switch (this.actionValue) {
                    case 'bannerId' :
                        return this.banners.sort(function (a, b) {
                            if (a.id > b.id) {
                                return 1;
                            }
                            if (a.id  < b.id) {
                                return -1;
                            }
                            return 0;
                        });

                    case 'width' :
                        return this.banners.sort(function (a, b) {
                            if (a.width > b.width) {
                                return 1;
                            }
                            if (a.width  < b.width) {
                                return -1;
                            }
                            return 0;
                        });

                    case 'height' :
                        return this.banners.sort(function (a, b) {
                            if (a.height > b.height) {
                                return 1;
                            }
                            if (a.height  < b.height) {
                                return -1;
                            }
                            return 0;
                        });

                    case 'targetUrl' :
                        return this.banners.sort(function (a, b) {

                            if (a.targetUrl > b.targetUrl) {
                                return 1;
                            }
                            if (a.targetUrl  < b.targetUrl) {
                                return -1;
                            }
                            return 0;
                        });

                    case 'langId' :
                        return this.banners.sort(function (a, b) {
                            if (a.langId > b.langId) {
                                return 1;
                            }
                            if (a.langId  < b.langId) {
                                return -1;
                            }
                            return 0;
                        });
                }
            },
            groupedBanners(){
                return this.banners.filter(function (banner) {
                    return banner.langId.indexOf(this.actionValue) !== -1
                }.bind(this))
            }
        },
    }

</script>

<style scoped>
    li{
        list-style-type: none;
    }
    .banner{
        margin: 10px auto;
    }
    .banners{
        margin-top: 20px;
    }
</style>