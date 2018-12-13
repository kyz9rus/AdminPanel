<template>
    <div class="deleteBanner">
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

            <button v-on:click="saveBanner" class="btn btn-success">Submit</button>
        </div>

        <div v-else>
            <h4>You submitted successfully!</h4>
            <button class="btn btn-success" v-on:click="newBanner">Add</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "DeleteBanner",
        data(){
            return{
                submitted: false
            }
        },
        methods: {
            deleteBanner() {
                http
                    .delete("/admin/deleteBanner/" + this.banner.id)
                    .then(response => {
                        console.log(response.data);
                        this.$emit("refreshData");
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            newBanner() {
                this.submitted = false;
                this.banner = {};
            }
        }
    };
</script>

<style scoped>

</style>