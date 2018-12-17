<template>
    <div class="wrapperForFooter">
        <app-header :greeting="greeting" :backPage="backPage" :action="pathTo"
                    @adminName="adminName = $event"></app-header>

        <button class="menuButton" @click="showPanel = !showPanel">
            <ion-icon class="ion-navicon" name="menu"></ion-icon>
        </button>

        <br/>

        <transition name="slide">
            <aside v-show="showPanel">
                <ul class="buttons">
                    <router-link :to="{name: 'add-banner', params: { adminName: adminName }}">
                        <input type="button" class="btn" value="Add banner" @click="showPanel = false"/>
                    </router-link>
                    <br/>

                    <router-link :to="{name: 'edit-banner', params: { adminName: adminName }}">
                        <input type="button" class="btn" value="Edit banner" @click="showPanel = false"/>
                    </router-link>
                    <br/>

                    <router-link :to="{name: 'delete-banner', params: { adminName: adminName }}">
                        <input type="button" class="btn" value="Delete banner" @click="showPanel = false"/>
                    </router-link>
                    <br/>

                    <router-link :to="{name: 'banner-changes'}">
                        <input type="button" class="btn" value="See banner change history" @click="showPanel = false"/>
                    </router-link>
                    <br/>

                    <router-link
                            :to="{name: 'test-page', params: { adminName: adminName, bannerDetailsName: pathToBannerDetails}}">
                        <input type="button" class="btn" value="Open test page to view banners"
                               @click="showPanel = false"/>
                    </router-link>
                </ul>
            </aside>
        </transition>

        <div class="content">
            <router-view></router-view>
        </div>

        <app-footer></app-footer>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                pathToBannerDetails: 'banner-details-admin',
                showPanel: false,
                adminName: '',
                backPage: 'Main page',
                pathTo: '/',
                greeting: 'Welcome to the Admin Page!',
                allowScale: false
            }
        },
        name: "admin",
        methods: {}
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
        box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
    }

    aside h2 {
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
        background-color: rgba(0, 0, 0, 0.1);
    }

    .buttons {
        position: fixed;
        top: 167px;
        margin-left: -40px;
    }

    .buttons input {
        font-size: 13px;
        margin: 14px auto;
    }

    .menuButton {
        margin-top: 10px;
    }
</style>