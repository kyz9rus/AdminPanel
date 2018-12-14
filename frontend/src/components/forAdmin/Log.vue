<template>
    <div class="log">
        <div>
            <button id="submitLogBut" v-on:click="showLog" class="btn btn-success">{{ show }}</button>
        </div>

        <div v-if="submitted && success">
            <table class="logTable">
                <tr>
                    <td>Action id</td>
                    <td>Banner id</td>
                    <td>Admin name</td>
                    <td>Action name</td>
                    <td>Action time</td>
                </tr>

                <tr v-for="(action, index) in actions" :key="index">
                    <td>{{ action.id }}</td>
                    <td>{{ action.banner_id }}</td>
                    <td>{{ action.user.login }}</td>
                    <td>{{ action.actionname }}</td>
                    <td>{{ action.actiontime }}</td>
                </tr>
            </table>
        </div>

        <div v-else-if="submitted">
            <h4>Something wrong :( Show the console log</h4>
        </div>
    </div>
</template>

<script>
    import http from "../../http-common";

    export default {
        name: "Log",
        data (){
            return{
                actions: [],
                show: 'Show',
                submitted: false,
                success: true
            }
        },
        methods: {
            showLog(){
                // this.$emit('isClicked', this.submitted);
                if (this.show === 'Show') {
                    http
                        .get("/admin/getAllActions")
                        .then(response => {
                            if (response.status = 'OK') {
                                this.actions = response.data;

                                console.log(response.data);
                                console.log(response.data[0].user);
                                console.log(response.data[0].user.login);


                                this.success = true;
                            }
                            else
                                this.success = false;
                        })
                        .catch(e => {
                            console.log(e);
                        });

                    this.submitted = true;
                    this.show = 'Hide';
                    $('.logTable').show();
                }
                else{
                    $('.logTable').hide();
                    this.show = 'Show';
                }

            }
        }
    }
</script>

<style scoped>
    #submitLogBut{
        margin-left: 30%;
    }
    .logTable{
        border: 1px solid black;
        margin-top: 50px;
        width: 90%;
        margin-left: 5%;
        text-align: center;
    }

    tr:first-child{
        font-weight: bold;
        font-size: 18px;
    }

    tr:nth-child(even) {
        background-color: whitesmoke;
    }
</style>