<template>
    <div class="testPage">
        <div class="list row col-md-12">
            <div v-if="this.adminName">
                <label for="answer">Choose action</label>
                <select class="custom-select sources" id="answer" name="answer" autofocus v-model="answer">
                    <option>Select action:</option>
                    <option>Group</option>
                    <option>Sort</option>
                </select>
                <br/><br/>

                <div v-if="answer === 'Group'" class="form-group">
                    <label for="groupWord">Group by:</label>
                    <select id="groupWord" class="custom-select" name="groupWord" autofocus v-model="groupValue">
                        <option v-for="language in languages">{{ language }}</option>
                    </select>
                </div>

                <div v-else-if="answer === 'Sort'" class="form-group">
                    <label for="sortBy">Sort by:</label>
                    <select id="sortBy" class="custom-select" name="sortBy" autofocus v-model="sortValue">
                        <option></option>
                        <option>bannerId</option>
                        <option>width</option>
                        <option>height</option>
                        <option>targetUrl</option>
                        <option>langId</option>
                    </select>
                </div>

            </div>

            <!--<h4>Banners List</h4>-->
            <div v-if="answer === 'Group'" class="col-md-12">
                <ul>
                    <li v-for="banner in groupedBanners" @click="showBanner">
                        <router-link :to="{
                                    name: bannerDetailsName,
                                    params: { banner: banner, id: banner.id}
                                }">
                            <div align="center" class="banner">
                                <a :href="banner.targeturl">
                                    <img :width="banner.width" :height="banner.height" :src="banner.imgsrc"/>
                                </a>
                            </div>
                        </router-link>
                    </li>
                </ul>
            </div>
            <div v-else-if="answer === 'Sort'" class="col-md-12">
                <ul>
                    <li v-for="banner in sortedBanners" @click="showBanner">
                        <router-link :to="{
                                    name: bannerDetailsName,
                                    params: { banner: banner, id: banner.id}
                                }">
                            <div align="center" class="banner">
                                <a :href="banner.targeturl">
                                    <img :width="banner.width" :height="banner.height" :src="banner.imgsrc"/>
                                </a>
                            </div>
                        </router-link>
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
        props: ["adminName", "bannerDetailsName"],
        data() {
            return {
                banners: [
                    {id: 1, width: 400, height: 200, imgsrc: '/static/img/acura.jpg', langid: '1', targeturl: 'https://www.lada.ru'},
                    {id: 2, width: 800, height: 100, imgsrc: '/static/img/acura.jpg', langid: '3', targeturl: 'https://www.alada.ru'},
                    {id: 3, width: 200, height: 300, imgsrc: '/static/img/acura.jpg', langid: '2', targeturl: 'https://www.blada.ru'}
                ],
                languages: ['', 'Russian', 'English'],
                show: true,
                answer: '',
                sortValue: '',
                groupValue: '',
                scale: 2       // to correctly display banners on the site
            };
        },
        methods: {
            retrieveBanners() {
                http
                    .get("/showAllBanners")
                    .then(response => {
                        this.banners = response.data; // JSON are parsed automatically.
                        // console.log(response.data);
                        this.languages = [''];
                        for (var i = 0; i < this.banners.length; i++){
                            this.banners[i].width = this.banners[i].width / this.scale;
                            this.banners[i].height = this.banners[i].height / this.scale;

                            var check = true;
                            for (var j = 0; j < this.languages.length; j++)
                                if (this.banners[i].langid === this.languages[j]){
                                    check = false;
                                    break;
                                }
                            if (check)
                                this.languages.push(this.banners[i].langid);


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
            },
        },
        mounted() {
            this.retrieveBanners();
        },
        computed: {
            sortedBanners() {
                switch (this.sortValue) {
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

                            if (a.targeturl > b.targeturl) {
                                return 1;
                            }
                            if (a.targeturl  < b.targeturl) {
                                return -1;
                            }
                            return 0;
                        });
                    case 'langId' :
                        return this.banners.sort(function (a, b) {
                            // return a.langid.localeCompare(b.langId)
                            if (a.langid > b.langid) {
                                return 1;
                            }
                            if (a.langid  < b.langid) {
                                return -1;
                            }
                            return 0;
                        });
                }
            },
            groupedBanners: function () {
                return this.banners.filter(function (banner) {
                    return banner.langid.indexOf(this.groupValue) !== -1
                }.bind(this))
            },
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
</style>