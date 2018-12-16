<template>
    <div>
        <div>
            <button id="submitLogBut" v-on:click="showLog" class="btn btn-success">{{ textButton }}</button>
        </div>

        <div v-if="submitted && success">
            <table v-show="showTable" class="logTable">
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
                    <td>{{ action.actionName }}</td>
                    <td>{{ action.actionTime }}</td>
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
                textButton: 'Show',
                submitted: false,
                success: true,
                showTable: false
            }
        },
        methods: {
            showLog(){
                if (this.textButton === 'Show') {
                    http
                        .get("/admin/getAllActions")
                        .then(response => {
                            if (response.status = 'OK') {
                                this.actions = response.data;

                                response.data.map(user => {
                                    this.actions.user = user.login;
                                });

                                this.success = true;
                                this.textButton = 'Hide';
                                this.showTable = true;
                            }
                            else
                                this.success = false;
                        })
                        .catch(e => {
                            console.log(e);
                        });

                    this.submitted = true;
                }
                else{
                    this.showTable = false;
                    this.textButton = 'Show';
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