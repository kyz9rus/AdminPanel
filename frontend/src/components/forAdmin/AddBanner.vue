<template>
    <div class="submitform">
        <h1 class="nameOperation">Add Banner</h1>

        <div v-if="errors.length">
            <label class="error">Please correct the following error(s):</label>
            <ul>
                <li v-for="error in errors" class="error">{{ error }}</li>
            </ul>
        </div>

        <div v-if="!submitted">
            <div class="form-group">
                <label for="imgSrc">ImgSrc</label>
                <input type="text" class="form-control" id="imgSrc" required v-model="banner.imgSrc" name="imgSrc">
            </div>

            <div class="form-group">
                <label for="width">Width</label>
                <input type="number" class="form-control" id="width" required v-model="banner.width" name="width">
            </div>

            <div class="form-group">
                <label for="height">Height</label>
                <input type="number" class="form-control" id="height" required v-model="banner.height" name="height">
            </div>

            <div class="form-group">
                <label for="targetUrl">TargetUrl</label>
                <input type="text" class="form-control" id="targetUrl" required v-model="banner.targetUrl"
                       name="targetUrl">
            </div>

            <div class="form-group">
                <label for="langId">LangId</label>
                <input type="text" class="form-control" id="langId" required v-model="banner.langId" name="langId">
            </div>

            <button v-on:click="saveBanner" class="btn btn-success">Add</button>
        </div>

        <div v-else-if="success">
            <h4>Banner with id:{{banner.id}} has added successfully!</h4>
            <button class="btn btn-success" v-on:click="newBannerSuccess">Back</button>
        </div>

        <div v-else>
            <h4>Something wrong :( Show the console log</h4>
            <button v-on:click="newBannerError" class="btn btn-danger">Back</button>
        </div>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "add-banner",
        props: ['adminName'],
        data() {
            return {
                banner: {
                    id: null,
                    imgSrc: null,
                    width: null,
                    height: null,
                    targetUrl: null,
                    langId: null,
                },
                submitted: false,
                errors: [],
                success: false
            };
        },
        methods: {
            saveBanner() {
                this.errors = [];

                if (!this.banner.imgSrc)
                    this.errors.push('imgSrc is required');

                if (!this.banner.width || (this.banner.width < 50 || this.banner.width > 900))
                    this.errors.push('width is required and must be a number (50 < width < 900)');

                if (!this.banner.height || (this.banner.height < 50 || this.banner.height > 500))
                    this.errors.push('height is required and must be a number (50 < height < 500)');

                if (!this.banner.targetUrl)
                    this.errors.push('targetUrl is required');

                if (!this.banner.langId)
                    this.errors.push('langId is required');


                if (this.errors.length !== 0)
                    return;


                var data = {
                    id: this.banner.id,
                    imgSrc: this.banner.imgSrc,
                    width: this.banner.width,
                    height: this.banner.height,
                    targetUrl: this.banner.targetUrl,
                    langId: this.banner.langId,
                };

                http
                    .post("/admin/saveBanner", data)
                    .then(response => {

                        if (response.status = 'OK') {
                            this.banner.id = response.data.id;
                            this.success = true;
                        }
                    })
                    .catch(e => {
                        console.log(e);
                    });

                this.submitted = true;
            },
            newBannerSuccess() {
                this.submitted = false;
                if (this.success = true) {
                    this.success = false;
                    this.banner = {};
                    this.errors = [];
                }
            },
            newBannerError() {
                this.submitted = false;
                this.errors = [];
            }

        }
    };
</script>

<style>
    .nameOperation {
        font-size: 20px;
    }

    .submitform {
        width: 500px;
        margin-left: calc((100% - 500px) / 2);
        max-width: 500px;
    }

    .error {
        color: red;
    }
</style>