<template>
    <div v-if="this.banner">
        <div class="descBanner" align="center">
            <h4>Banner {{ this.banner.id }}</h4>
            <img v-on:click="hideWindow()" src="../assets/img/cross.png" alt="X"/>
            <div>
                <label>Site: <a :href="this.banner.targeturl">{{this.banner.targeturl}}</a></label>  <br/>
                <label>Language: </label> {{this.banner.langid}}
            </div>

            <!--<span v-if="this.banner.active"-->
                  <!--v-on:click="updateActive(false)"-->
                  <!--class="button is-small btn-primary">Inactive</span>-->
            <!--<span v-else-->
                  <!--v-on:click="updateActive(true)"-->
                  <!--class="button is-small btn-primary">Active</span>-->

            <!--<span class="button is-small btn-danger" v-on:click="deleteBanner()">Delete</span>-->
        </div>
    </div>
    <div v-else>
        <br/>
        <p>Please click on a Banner...</p>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "banner",
        props: ["banner"],
        methods: {
            /* eslint-disable no-console */
            updateActive(status) {
                var data = {
                    id:         this.banner.id,
                    imgsrc:     this.banner.imgsrc,
                    width:      this.banner.width,
                    height:     this.banner.height,
                    targeturl:  this.banner.targeturl,
                    langid:     this.banner.langid,
                    active:     status
                };

                http
                    .put("/banner/" + this.banner.id, data)
                    .then(response => {
                        this.banner.active = response.data.active;
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            deleteBanner() {
                http
                    .delete("/banner/" + this.banner.id)
                    .then(response => {
                        console.log(response.data);
                        this.$emit("refreshData");
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            hideWindow() {
                $('.descBanner').hide();
            }
            /* eslint-enable no-console */
        }
    };
</script>

<style scoped>
    .descBanner{
        position: fixed;
        left: 65%;
        border: 1px solid black;
        border-radius: 18px;
        width: 300px;
    }

    .descBanner h4{
        float: left;
        margin-left: 100px;
    }

    .descBanner img {
        float: right;
        width: 8%;
        margin-top: 2px;
        margin-right: 10px;
    }
</style>