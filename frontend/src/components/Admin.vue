<template>
    <div class="wrapperForFooter">
        <app-header :msg="greeting" :msg2="backPage" :msg3="pathTo"></app-header>

        <button class="menuButton" @click="show = !show">
            <ion-icon class="ion-navicon" name="menu"></ion-icon>
        </button>

        <hr/>

        <transition name="slide">
            <aside v-show="show" >
                <ul class="buttons">
                    <li><input type="button" class="btn" value="Добавить баннер" @click="showOperation('app-addBanner')"/></li>
                    <li><input type="button" class="btn" value="Редактировать баннер" @click="showOperation('app-editBanner')"/></li>
                    <li><input type="button" class="btn" value="Удалить баннер" @click="showOperation('app-deleteBanner')"/></li>
                    <li><input type="button" class="btn" value="Отсортировать баннеры по языку"/></li>
                    <li><input type="button" class="btn" value="Посмотреть историю изменения баннеров" @click="showOperation('app-log')"/></li>
                    <li><input type="button" class="btn" value="Открыть тестовую страницу для просмотра баннеров" @click="goToIndex"/></li>
                </ul>
            </aside>
        </transition>

        <div class="content">
            <app-addBanner :adminName="adminName"></app-addBanner>
            <app-editBanner :adminName="adminName"></app-editBanner>
            <app-deleteBanner :adminName="adminName"></app-deleteBanner>
            <!--<app-log @isClicked="show = $event"></app-log>-->
            <app-log></app-log>


        </div>
        <app-footer></app-footer>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        data(){
            return {
                greeting: 'Welcome to the Admin Page!',
                backPage: 'Main page',
                pathTo:   '/',
                adminName: '',
                show: false
            }
        },
        name: "admin",
        methods: {
            showOperation(operation){
                this.show = false;
                http
                    .get('admin/getAdminName')
                    .then((response) => {
                       this.adminName = response.data
                    });

                switch (operation) {
                    case "app-addBanner":        $('.addBanner').show(); $('.editBanner').hide(); $('.deleteBanner').hide(); $('.log').hide(); break;
                    case "app-editBanner":       $('.addBanner').hide(); $('.editBanner').show(); $('.deleteBanner').hide(); $('.log').hide(); break;
                    case "app-deleteBanner":     $('.addBanner').hide(); $('.editBanner').hide(); $('.deleteBanner').show(); $('.log').hide(); break;
                    case "app-log":              $('.addBanner').hide(); $('.editBanner').hide(); $('.deleteBanner').hide(); $('.log').show(); break;
                }
            },
            goToIndex(){
                $(location).attr('href', '/');
            },
        }
    };

</script>

<style scoped>
    aside {
        background-color: #fff;
        width: 400px;
        position: fixed;
        top: 167px;
        margin-top: -4px;
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

    .content{
        height: 800px;
    }
    .buttons{
        margin-top: -200px;
        margin-left: -20px;

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