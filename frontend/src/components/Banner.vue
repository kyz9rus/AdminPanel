<template>
    <div v-if="this.banner">
        <div class="descBanner" align="center">
            <h4>Banner {{ this.banner.id }}</h4>
            <img v-on:click="hideWindow()" src="../assets/img/cross.png" alt="X"/>
            <div>
                <label>Site: <a :href="this.banner.targeturl">{{this.banner.targeturl}}</a></label>  <br/>
                <label>Language: </label> {{this.banner.langid}}
            </div>
        </div>
    </div>
    <div v-else>
        <!--<div class="descBanner" align="center" v-on:click="hideWindow">-->
            <!--<br/>-->
            <!--<p>Please click on a Banner...</p>-->
        <!--</div>-->
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "banner",
        props: ["banner"],
        methods: {

            // updateActive(status) {
            //     var data = {
            //         id:         this.banner.id,
            //         imgsrc:     this.banner.imgsrc,
            //         width:      this.banner.width,
            //         height:     this.banner.height,
            //         targeturl:  this.banner.targeturl,
            //         langid:     this.banner.langid,
            //         active:     status
            //     };
            //
            //     http
            //         .put("/banner/" + this.banner.id, data)
            //         .then(response => {
            //             this.banner.active = response.data.active;
            //             console.log(response.data);
            //         })
            //         .catch(e => {
            //             console.log(e);
            //         });
            // },
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
        }
    };
</script>

<style scoped>
    .descBanner{
        position: fixed;
        left: 40%;
        border: 1px solid black;
        border-radius: 18px;
        width: 300px;
        background: rgba(255,255,255,0.8);
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