<template>
    <div class="submitform">
        <h1 class="nameOperation">Edit Banner</h1>

        <div v-if="errors.length">
            <label class="error">Please correct the following error(s):</label>
            <ul>
                <li v-for="error in errors" class="error">{{ error }}</li>
            </ul>
        </div>

        <div v-if="!submitted">
            <h6>Choose only those fields, which you wanted to change (id is required)</h6>
            <div class="form-group">
                <label for="id">Id</label>
                <input type="number" class="form-control" id="id" required v-model="banner.id" name="id">
            </div>

            <div class="form-group">
                <label for="imgSrc">ImgSrc</label>
                <input type="text" class="form-control" id="imgSrc" v-model="banner.imgSrc" name="imgSrc">
            </div>

            <div class="form-group">
                <label for="width">Width</label>
                <input type="text" class="form-control" id="width" v-model="banner.width" name="width">
            </div>

            <div class="form-group">
                <label for="height">Height</label>
                <input type="text" class="form-control" id="height" v-model="banner.height" name="height">
            </div>

            <div class="form-group">
                <label for="targetUrl">TargetUrl</label>
                <input type="texI" class="form-control" id="targetUrl" v-model="banner.targetUrl" name="targetUrl">
            </dIv>

            <div class="form-group">
                <label for="langid">LangId</label>
                <input type="text" class="form-control" id="langid" v-model="banner.langid" name="langid">
            </div>

            <button v-on:click="editBanner" class="btn btn-success">Edit</button>
        </div>

        <div v-else-if="success">
            <h4>Banner with id:{{banner.id}} has changed successfully!</h4>
            <button class="btn btn-success" v-on:click="newBannerSuccess">Back</button>
        </div>

        <div v-else>
            <h4>Something wrong :( Show the console log</h4>
            <button class="btn btn-danger" v-on:click="newBannerError">Back</button>
        </div>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "EditBanner",
        props: ["adminName"],
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
            }
        },
        methods: {
            editBanner() {
                this.errors = [];

                if (!this.banner.id)
                    this.errors.push('id is required and must be a number');

                if (!Number(this.banner.width) || (Number(this.banner.width) <= 50 || Number(this.banner.width >= 900)))
                    this.errors.push('width and must be a number (50 < width < 900)');

                if (!Number(this.banner.height) || (Number(this.banner.height) <= 50 || Number(this.banner.height >= 500)))
                    this.errors.push('height and must be a number (50 < width < 500)');


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
                    .put("/admin/editBanner", data)
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
                this.success = false;
                this.banner = {};
                this.errors = [];
            },
            newBannerError() {
                this.submitted = false;
                this.errors = [];
            }

        }
    }
</script>