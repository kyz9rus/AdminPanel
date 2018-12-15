<template>
    <div v-if="this.banner">
        <div class="descBanner" align="center" v-show="show">
            <h4>Banner {{ this.banner.id }}</h4>
            <img @click="hideBanner" src="../assets/img/cross.png" alt="X"/><br/>
            <div>
                <label>Site: <a :href="this.banner.targeturl">{{this.banner.targeturl}}</a></label>  <br/>
                <label>Language: </label> {{this.banner.langid}}
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        name: "banner",
        props: ["banner"],
        data(){
            return{
                show: true
            }
        },
        methods: {
            hideBanner() {
                this.show = !(this.show);
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