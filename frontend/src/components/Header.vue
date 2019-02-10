<template>
    <div class="header featurebox col-md-12 col-sm-12 col-xs-12">
        <div class="row" align="center">
            <div class="name col-md-10 col-sm-10 col-xs-10">
                <p class="mainText">{{ greeting }}</p>
            </div>

            <div class="loginBlock col-md-2 col-sm-2 col-xs-2">
                <form :action="authPath">
                    <button type="submit" class="login">{{ buttonName }}</button>
                </form>

                <form :action="action">
                    <button type="submit">
                        {{ backPage }}
                    </button>
                </form>
            </div>
        </div>
    </div>
</template>

<style>
    .header {
        height: 100px;
        border: 1px solid black;
    }

    .name {
        margin: 32px auto;
        text-align: center;
    }

    .loginBlock img {
        width: 100%;
    }

    .loginBlock button {
        background: linear-gradient(180deg, grey, black);
        width: 120px;
        height: 45px;
        border-radius: 8px;
        margin-top: 2px;
        font-size: 14px;
        color: white;
    }

    .mainText {
        font-size: 23px;
    }
</style>

<script>
    import http from "../http-common";

    export default {
        data() {
            return {
                adminName: '',
                buttonName: '',
                authPath: ''
            }
        },
        props: ['greeting', 'backPage', 'action'],
        created: function () {
            http
                .get('/getAuthority')
                .then((response) => {
                    // console.log(response.data);

                    console.log(response.data.login + " !!!");

                    if (response.data === 'anonymousUser') {
                        console.log("anonymousUser");

                        this.buttonName = 'Login';
                        this.authPath = this.action;
                    } else {
                        console.log(response.data.login);

                        this.adminName = response.data.login;
                        this.buttonName = 'Logout';
                        this.authPath = '/logout';
                    }

                    this.$emit("adminName", this.adminName)

                });
        }
    }
</script>