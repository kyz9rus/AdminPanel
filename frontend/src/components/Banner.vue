<template>
    <div v-if="this.banner">

        <div v-if="extendedMode" class="descBanner" align="center" v-show="show">
            <h4>Banner id: {{ this.banner.id }}</h4>
            <img @click="hideBanner" src="../assets/img/cross.png" alt="X"/><br/>
            <div>
                <label>Width: {{ this.banner.width }}px</label><br/>
                <label>Height: {{ this.banner.height }}px</label><br/>
                <label>Target url: <a :href="this.banner.targetUrl">{{this.banner.targetUrl}}</a></label><br/>
                <label>Language id: {{ this.banner.langId }}</label>
            </div>
        </div>

        <div v-else class="descBanner" align="center" v-show="show">
            <h4>Banner {{ this.banner.id }}</h4>
            <img @click="hideBanner" src="../assets/img/cross.png" alt="X"/><br/>
            <div>
                <label>Site: <a :href="this.banner.targetUrl">{{this.banner.targetUrl}}</a></label><br/>
                <label>Language: {{ this.banner.langId }}</label>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        name: "banner",
        props: ["banner", "extendedMode"],
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
        top: 12%;
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