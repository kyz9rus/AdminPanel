<template>
    <div class="wrapperForFooter">
        <app-header :greeting="greeting" :page="backPage" :action="pathToAdmin" :authAction="'/login'"></app-header>

            <div class="content">
                <app-banners :bannerDetailsName="pathToBannerDetails"></app-banners>

                <br/>

                </div>

        <app-footer></app-footer>
    </div>
</template>

<script>
export default {
        name: "index",
        data() {
            return {
                greeting: 'Welcome to the Banner Page!',
                backPage: 'Admin page',
                pathToAdmin: '/admin',
                authority: '',
                pathToBannerDetails: 'banner-details-index'
            };
        },
        methods: {}
    };
</script>