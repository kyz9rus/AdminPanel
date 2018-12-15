<template>
    <div class="wrapperForFooter">
        <app-header :msg="greeting" :msg2="backPage" :msg3="pathToAdmin"></app-header>

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
                pathToAdmin:   '/admin',
                authority: '',
                pathToBannerDetails: 'banner-details-index'
            };
        },
        methods: {}
    };
</script>