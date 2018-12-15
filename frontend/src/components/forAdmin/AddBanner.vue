<template>
    <div class="addBanner">
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
                    <label for="id">Id</label>
                    <input type="number" class="form-control" id="id" required v-model="banner.id" name="id">
                </div>

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
                    <input type="text" class="form-control" id="targetUrl" required v-model="banner.targetUrl" name="targetUrl">
                </div>

                <div class="form-group">
                    <label for="langId">LangId</label>
                    <input type="text" class="form-control" id="langId" required v-model="banner.langId" name="langId">
                </div>

                <button v-on:click="saveBanner" class="btn btn-success">Submit</button>
            </div>

            <div v-else-if="success">
                <h4>Banner with id:{{banner.id}} has added successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Add</button>
            </div>

            <div v-else>
                <h4>Something wrong :( Show the console log</h4>
                <button v-on:click="newBanner" class="btn btn-danger">Add</button>
            </div>
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
                    id: 0,
                    imgSrc: null,
                    width: 0,
                    height: 0,
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
                if (!this.banner.id)
                    this.errors.push('id is required');
                if(!this.banner.imgSrc)
                    this.errors.push('imgSrc is required');
                if(!this.banner.width){
                    this.errors.push('width is required');
                    this.banner.width = null
                }
                if(!this.banner.height)
                    this.errors.push('height is required');
                if(!this.banner.targetUrl)
                    this.errors.push('targetUrl is required');
                if(!this.banner.langId)
                    this.errors.push('langId is required');

                if (this.errors.length !== 0)
                    e.preventDefault();

                var data = {
                    id:        this.banner.id,
                    imgSrc:    this.banner.imgSrc,
                    width:     this.banner.width,
                    height:    this.banner.height,
                    targetUrl: this.banner.targetUrl,
                    langId:    this.banner.langId,
                };

                http
                    .post("/admin/saveBanner", data)
                    .then(response => {

                        if (response.status = 'OK'){
                            this.banner.id = response.data;
                            this.success = true;
                        }
                    })
                    .catch(e => {
                        console.log(e);
                    });

                this.submitted = true;
            },
            newBanner() {
                this.submitted = false;
                if (this.success = true){
                    this.success = false;
                    this.banner = {};
                    this.errors = [];
                }
            }

        }
    };
</script>

<style>
    .nameOperation{
        font-size: 20px;
    }
    .submitform {
        width: 500px;
        margin-left: calc((100% - 500px)/2);
        max-width: 500px;
    }
    .error{
        color: red;
    }
</style>