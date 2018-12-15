<template>
    <div class="deleteBanner">
        <div class="submitform">
            <h1 class="nameOperation">Delete Banner</h1>

            <div v-if="error">
                <label class="error">Please correct the following error(s):</label>
                <p  class="error">{{ error }}</p>
            </div>

            <div v-if="!submitted">
                <div class="form-group">
                    <label for="id">Enter banner id</label>
                    <input type="number" class="form-control" id="id" required v-model="banner.id" name="id">
                </div>

                <button v-on:click="deleteBanner" class="btn btn-success">Submit</button>
            </div>

            <div v-else-if="success">
                <h4>Banner with id:{{banner.id}} has deleted successfully!</h4>
                <button class="btn btn-success" v-on:click="newBanner">Delete</button>
            </div>

            <div v-else>
                <h4>Something wrong :( Show the console log</h4>
                <button v-on:click="newBanner" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "DeleteBanner",
        props: ["adminName"],
        data(){
            return{
                banner: {
                    id: 0,
                    imgSrc: null,
                    width: 0,
                    height: 0,
                    targetUrl: null,
                    langId: null,
                },
                submitted: false,
                error: '',
                success: false
            }
        },
        methods: {
            deleteBanner(){
                if (!this.banner.id) {
                    this.error = 'id is required';
                    e.preventDefault();
                }

                http
                    .delete("/admin/deleteBanner/" + this.banner.id)
                    .then(response => {
                        if (response.status = 'OK')
                            this.success = true;
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
    };
</script>