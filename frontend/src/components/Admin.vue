<template>
    <div class="wrapperForFooter">
        <app-header :msg="greeting"></app-header>
        <div class="content">

            

        </div>
        <app-footer></app-footer>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        data(){
            return {
                greeting: 'Welcome to the Admin Page!'
            }
        },
        name: "admin",
        props: ["admin"],
        methods: {
            /* eslint-disable no-console */
            doSmth() {
                // http
                //     .put("/banner/" + this.banner.id, data)
                //     .then(response => {
                //         this.banner.active = response.data.active;
                //         console.log(response.data);
                //     })
                //     .catch(e => {
                //         console.log(e);
                //     });
            }
        },
    //         updateActive(status) {
    //             var data = {
    //                 id:         this.banner.id,
    //                 imgsrc:     this.banner.imgsrc,
    //                 width:      this.banner.width,
    //                 height:     this.banner.height,
    //                 targeturl:  this.banner.targeturl,
    //                 langid:     this.banner.langid,
    //                 active:     status
    //             };
    //
    //             http
    //                 .put("/banner/" + this.banner.id, data)
    //                 .then(response => {
    //                     this.banner.active = response.data.active;
    //                     console.log(response.data);
    //                 })
    //                 .catch(e => {
    //                     console.log(e);
    //                 });
    //         },
    //
    //     }
    };

</script>

<style scoped>

</style>