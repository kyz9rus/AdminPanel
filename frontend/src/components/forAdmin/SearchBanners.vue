<template>
    <div class="searchform">
        <h4>Find by Id</h4>
        <div class="form-group">
            <input type="number" class="form-control" id="id" required v-model="id" name="id">
        </div>

        <div class="btn-group">
            <button v-on:click="searchBanners" class="btn btn-success">Search</button>
        </div>

        <ul class="search-result">
            <li v-for="(banner, index) in banners" :key="index">
                <h6>{{banner.id}} {{banner.imgsrc}}</h6>
            </li>
        </ul>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "search-banner",
        data() {
            return {
                id: 0,
                banners: []
            };
        },
        methods: {
            /* eslint-disable no-console */
            searchBanners() {
                http
                    .get("/banners/id/" + this.id)
                    .then(response => {
                        this.banners = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            }
            /* eslint-enable no-console */
        }
    };
</script>

<style scoped>
    .searchform {
        max-width: 300px;
        margin: auto;
    }
    .search-result {
        margin-top: 20px;
        text-align: left;
    }
</style>