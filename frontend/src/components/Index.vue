<template>
    <div class="wrapperForFooter">
        <app-header :greeting="greeting" :backPage="backPage" :action="pathTo"></app-header>

        <div class="content">
            <app-banners :bannerDetailsName="pathToBannerDetails" :simplifiedMode="simplifiedMode"></app-banners>
        </div>

        <app-footer></app-footer>
    </div>
</template>

<script>
    export default {
        name: "index",
        data() {
            return {
                pathToBannerDetails: 'banner-details-index',
                backPage: 'Admin page',
                pathTo: '/admin',
                greeting: 'Welcome to the Main Page!',
                simplifiedMode: true,
            }
        }
    };
</script>