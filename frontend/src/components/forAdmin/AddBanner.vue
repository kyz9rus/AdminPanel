<template>
    <div class="addBanner">
        <div class="submitform">
            <h1 class="nameOperation">Add Banner</h1>
            {{adminName}}
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
                    <label for="imgsrc">ImgSrc</label>
                    <input type="text" class="form-control" id="imgsrc" required v-model="banner.imgsrc" name="imgsrc">
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
                    <label for="targeturl">TargetUrl</label>
                    <input type="text" class="form-control" id="targeturl" required v-model="banner.targeturl" name="targeturl">
                </div>

                <div class="form-group">
                    <label for="langid">LangId</label>
                    <input type="text" class="form-control" id="langid" required v-model="banner.langid" name="langid">
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
                    imgsrc: null,
                    width: 0,
                    height: 0,
                    targeturl: null,
                    langid: null,
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
                if(!this.banner.imgsrc)
                    this.errors.push('imgSrc is required');
                if(!this.banner.width)
                    this.errors.push('width is required');
                if(!this.banner.height)
                    this.errors.push('height is required');
                if(!this.banner.targeturl)
                    this.errors.push('targeturl is required');
                if(!this.banner.langid)
                    this.errors.push('langid is required');

                if (this.errors.length !== 0)
                    e.preventDefault();

                var data = {
                    id:        this.banner.id,
                    imgsrc:    this.banner.imgsrc,
                    width:     this.banner.width,
                    height:    this.banner.height,
                    targeturl: this.banner.targeturl,
                    langid:    this.banner.langid,
                };

                http
                    .post("/admin/saveBanner/" + this.adminName, data)
                    .then(response => {
                        console.log(response.data);
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