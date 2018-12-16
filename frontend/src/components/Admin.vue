<template>
    <div class="wrapperForFooter">
        <app-header :greeting="greeting" :backPage="backPage" :action="pathTo" @adminName="adminName = $event"></app-header>

        <button class="menuButton" @click="show = !show">
            <ion-icon class="ion-navicon" name="menu"></ion-icon>
        </button>

        <hr/>

        <transition name="slide">
            <aside v-show="show" >
                <ul class="buttons">
                    <li><input type="button" class="btn" value="Add banner" @click="showOperation('app-addBanner')"/></li>
                    <li><input type="button" class="btn" value="Edit banner" @click="showOperation('app-editBanner')"/></li>
                    <li><input type="button" class="btn" value="Delete banner" @click="showOperation('app-deleteBanner')"/></li>
                    <li><input type="button" class="btn" value="See banner change history" @click="showOperation('app-log')"/></li>
                    <li><input type="button" class="btn" value="Open test page to view banners" @click="showOperation('app-banners')"/></li>
                </ul>
            </aside>
        </transition>

        <div class="content">
            <app-add-banner :adminName="adminName"></app-add-banner>
            <app-edit-banner :adminName="adminName"></app-edit-banner>
            <app-delete-banner :adminName="adminName"></app-delete-banner>
            <app-banners :adminName="adminName" :bannerDetailsName="pathToBannerDetails" :allowScale="allowScale"></app-banners>
            <app-log></app-log>

        </div>
        <app-footer></app-footer>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                pathToBannerDetails: 'banner-details-admin',
                show: false,
                adminName: '',
                backPage: 'Main page',
                pathTo: '/',
                greeting: 'Welcome to the Admin Page!',
                allowScale: false
            }
        },
        name: "admin",
        methods: {
            showOperation(operation){
                this.show = false;

                switch (operation) {
                    case "app-addBanner":        $('.addBanner').show(); $('.editBanner').hide(); $('.deleteBanner').hide(); $('.log').hide(); $('.testPage').hide(); break;
                    case "app-editBanner":       $('.addBanner').hide(); $('.editBanner').show(); $('.deleteBanner').hide(); $('.log').hide(); $('.testPage').hide(); break;
                    case "app-deleteBanner":     $('.addBanner').hide(); $('.editBanner').hide(); $('.deleteBanner').show(); $('.log').hide(); $('.testPage').hide(); break;
                    case "app-log":              $('.addBanner').hide(); $('.editBanner').hide(); $('.deleteBanner').hide(); $('.log').show(); $('.testPage').hide(); break;
                    case "app-banners":          $('.addBanner').hide(); $('.editBanner').hide(); $('.deleteBanner').hide(); $('.log').hide(); $('.testPage').show(); break;
                }
            }
        }
    };

</script>

<style scoped>
    aside {
        background-color: #fff;
        width: 250px;
        position: fixed;
        top: 167px;
        height: 600px;
        left: 0;
        bottom: 0;
        z-index: 1;
        display: flex;
        justify-content: center;
        align-items: center;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
    }
    aside h2{
        font-weight: 300;
        color: #afafaf;
        transition: 1s;
    }
    button {
        background: transparent;
        border: 0;
        width: 40px;
        height: 40px;
        font-size: 30px;
        outline: none;
        color: #9f9f9f;
        cursor: pointer;
        border-radius: 50%;
        transition: all .3s ease-in-out;
    }
    button:active {
        background-color: rgba(0,0,0,0.1);
    }
    .buttons{
        position: fixed;
        top: 167px;
        margin-left: -40px;
    }
    .buttons input{
        font-size: 13px;
        margin: 14px auto;
    }
    .menuButton{
        margin-top: 10px;
    }
    .addBanner, .editBanner, .deleteBanner, .log{
        display: none;
    }
    li{
        list-style-type: none;
    }
</style>