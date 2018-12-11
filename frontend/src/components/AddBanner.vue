<template>
    <!--<div class="submitform">-->
        <!--<div v-if="!submitted">-->
            <!--<div class="form-group">-->
                <!--<label for="id">Id</label>-->
                <!--<input type="number" class="form-control" id="id" required v-model="banner.id" name="id">-->
            <!--</div>-->

            <!--<div class="form-group">-->
                <!--<label for="imgsrc">ImgSrc</label>-->
                <!--<input type="text" class="form-control" id="imgsrc" required v-model="banner.imgsrc" name="imgsrc">-->
            <!--</div>-->

            <!--<div class="form-group">-->
                <!--<label for="width">Width</label>-->
                <!--<input type="number" class="form-control" id="width" required v-model="banner.width" name="width">-->
            <!--</div>-->

            <!--<div class="form-group">-->
                <!--<label for="height">Height</label>-->
                <!--<input type="number" class="form-control" id="height" required v-model="banner.height" name="height">-->
            <!--</div>-->

            <!--<div class="form-group">-->
                <!--<label for="targetUrl">TargetUrl</label>-->
                <!--<input type="text" class="form-control" id="targetUrl" required v-model="banner.targetUrl" name="targetUrl">-->
            <!--</div>-->

            <!--<div class="form-group">-->
                <!--<label for="langId">LangId</label>-->
                <!--<input type="number" class="form-control" id="langId" required v-model="banner.langId" name="langId">-->
            <!--</div>-->

            <!--<button v-on:click="saveBanner" class="btn btn-success">Submit</button>-->
        <!--</div>-->

        <!--<div v-else>-->
            <!--<h4>You submitted successfully!</h4>-->
            <!--<button class="btn btn-success" v-on:click="newBanner">Add</button>-->
        <!--</div>-->
    <!--</div>-->
</template>

<script>
    // import http from "../http-common";
    //
    // export default {
    //     name: "add-banner",
    //     data() {
    //         return {
    //             banner: {
    //                 id: 0,
    //                 imgsrc: "",
    //                 width: 0,
    //                 height: 0,
    //                 targetUrl: "",
    //                 langId: 0,
    //                 active: false
    //             },
    //             submitted: false
    //         };
    //     },
    //     methods: {
    //         /* eslint-disable no-console */
    //         saveCustomer() {
    //             var data = {
    //                 id: this.banner.id,
    //                 imgsrc: this.banner.imgsrc,
    //                 width: this.banner.width,
    //                 height: this.banner.height,
    //                 tarteUrl: this.banner.tarteUrl,
    //                 langId: this.banner.langId,
    //             };
    //
    //             http
    //                 .post("/banner", data)
    //                 .then(response => {
    //                     this.banner.id = response.banner.id;
    //                     console.log(response.data);
    //                 })
    //                 .catch(e => {
    //                     console.log(e);
    //                 });
    //
    //             this.submitted = true;
    //         },
    //         newBanner() {
    //             this.submitted = false;
    //             this.banner = {};
    //         }
    //         /* eslint-enable no-console */
    //     }
    // };
</script>

<style scoped>
    .submitform {
        max-width: 300px;
        margin: auto;
    }
</style>