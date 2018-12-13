<template>
    <div class="editBanner">
        <div class="submitform">
            <h1 class="nameOperation">Edit Banner</h1>

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
                    <label for="targetUrl">TargetUrl</label>
                    <input type="text" class="form-control" id="targetUrl" required v-model="banner.targetUrl" name="targetUrl">
                </div>

                <div class="form-group">
                    <label for="langId">LangId</label>
                    <input type="text" class="form-control" id="langId" required v-model="banner.langId" name="langId">
                </div>

                <button v-on:click="editBanner" class="btn btn-success">Submit</button>
            </div>

            <div v-else>
                <h4>You submitted successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Add</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "EditBanner",
        data (){
            return{
                banner: {
                    id: 0,
                    imgsrc: "",
                    width: 0,
                    height: 0,
                    targeturl: "",
                    langid: "",
                },
                submitted: false
            }
        },
        methods: {
            searchBanner(){
                http
                    .get("/admin/getBanner/" + this.banner.id)
                    .then(response => {
                        banner = response.data; // JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });

            },
            editBanner() {
                var data = {
                    id:       this.banner.id,
                    imgsrc:   this.banner.imgsrc,
                    width:    this.banner.width,
                    height:   this.banner.height,
                    tarteUrl: this.banner.tarteUrl,
                    langId:   this.banner.langId,
                };

                http
                    .get("/admin/editBanner", data)
                    .then(response => {
                        this.banner.id = response.banner.id;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });

                this.submitted = true;
            },
            newBanner() {
                this.submitted = false;
                this.banner = {};
            }

        }
    }
</script>

<style scoped>

</style>