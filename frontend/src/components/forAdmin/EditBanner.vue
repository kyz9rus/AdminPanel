<template>
    <div class="editBanner">
        <div class="submitform">
            <h1 class="nameOperation">Edit Banner</h1>

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
                    <input type="text" class="form-control" id="imgsrc" v-model="banner.imgsrc" name="imgsrc">
                </div>

                <div class="form-group">
                    <label for="width">Width</label>
                    <input type="number" class="form-control" id="width" v-model="banner.width" name="width">
                </div>

                <div class="form-group">
                    <label for="height">Height</label>
                    <input type="number" class="form-control" id="height" v-model="banner.height" name="height">
                </div>

                <div class="form-group">
                    <label for="targetUrl">TargetUrl</label>
                    <input type="text" class="form-control" id="targetUrl" v-model="banner.targetUrl" name="targetUrl">
                </div>

                <div class="form-group">
                    <label for="langId">LangId</label>
                    <input type="text" class="form-control" id="langId" v-model="banner.langId" name="langId">
                </div>

                <button v-on:click="editBanner" class="btn btn-success">Submit</button>
            </div>

            <div v-else-if="successAdded">
                <h4>Banner with id:{{banner.id}} has added successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Add</button>
            </div>

            <div v-else>
                <h4>You submitted successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Add</button>
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "EditBanner",
        data (){
            return{
                banner: {
                    id: 0,
                    imgsrc: '',
                    width: 0,
                    height: 0,
                    targeturl: '',
                    langid: '',
                },
                submitted: false,
                errors: [],
                successAdded: false
            }
        },
        methods: {
            editBanner(){
                if (!this.banner.id)
                    this.errors.push('id is required');

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
                    .put("/admin/editBanner", data)
                    .then(response => {
                        if (response.status = 'OK'){
                            this.banner.id = response.data.id;
                            this.successAdded = true;
                        }
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });

            },
            newBanner() {
                this.submitted = false;
                this.banner = {};
                this.successAdded = false
                this.errors = []
            }

        }
    }
</script>

<style scoped>

</style>