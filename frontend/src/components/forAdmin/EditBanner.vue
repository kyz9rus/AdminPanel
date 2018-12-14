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
                <h6>Choose only those fields, which you wanted to change (id is required)</h6>
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
                    <label for="targeturl">TargetUrl</label>
                    <input type="text" class="form-control" id="targeturl" v-model="banner.targeturl" name="targeturl">
                </div>

                <div class="form-group">
                    <label for="langid">LangId</label>
                    <input type="text" class="form-control" id="langid" v-model="banner.langid" name="langid">
                </div>

                <button v-on:click="editBanner" class="btn btn-success">Submit</button>
            </div>

            <div v-else-if="success">
                <h4>Banner with id:{{banner.id}} has changed successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Edit</button>
            </div>

            <div v-else>
                <h4>Something wrong :( Show the console log</h4>
                <button class="btn btn-danger">Edit</button>
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
                success: false
            }
        },
        methods: {
            editBanner(){
                if (!this.banner.id) {
                    this.errors.push('id is required');
                    e.preventDefault();
                }

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
                this.success = false;
                this.banner = {};
                this.errors = [];
            }

        }
    }
</script>

<style scoped>

</style>