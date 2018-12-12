<template>
    <div class="wrapperForFooter">
        <app-header :msg="greeting"></app-header>
            <div class="content">
                <app-banners></app-banners>


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
                authority: ''
            };
        },
        methods: {}
    };
</script>

<style scoped>

</style>