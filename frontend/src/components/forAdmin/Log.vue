<template>
    <div class="log">
        <div>
            <button v-on:click="showLog" class="btn btn-success">{{ show }}</button>
        </div>

        <div v-if="submitted && success">
            <table>
                <tr>
                    <td>Action id</td>
                    <td>Banner id</td>
                    <td>Admin name</td>
                    <td>Action name</td>
                    <td>Action time</td>
                </tr>

                <tr v-for="(action, index) in actions" :key="index">
                    <td>{{ action.id }}</td>
                    <td>{{ action.banner.id }}</td>
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
                success: false
            }
        },
        methods: {
            showLog(){
                this.$emit('isClicked', this.submitted);


                this.submitted ? this.show = 'Hide' : this.show = 'Show';

                http
                    .get("/admin/getAllActions")
                    .then(response => {
                        if (response.status = 'OK') {
                            this.actions = response.data;
                            console.log(response.data);
                            this.success = true;
                        }
                        else
                            this.success = false;
                    })
                    .catch(e => {
                        console.log(e);
                    });

                this.submitted = true;
            }
        }
    }
</script>

<style scoped>

</style>