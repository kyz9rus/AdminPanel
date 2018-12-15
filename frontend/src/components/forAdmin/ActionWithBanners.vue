<template>
    <div class="actionPanel">
        <label for="answer">Choose action</label>
        <select class="custom-select sources" id="answer" name="answer" autofocus v-model="answer" v-on:change="sendData">
            <option>Select action:</option>
            <option>Group</option>
            <option>Sort</option>
        </select>
        <br/><br/>

        <app-group-banners v-if="answer === 'Group'" :languages="languages" v-on:actionValue="getActionValue"></app-group-banners>
        <app-sort-banners v-else-if="answer === 'Sort'" v-on:actionValue="getActionValue"></app-sort-banners>
    </div>
</template>

<script>
    export default {
        name: "ActionWithBanners",
        props: ["languages"],
        data(){
            return{
                answer: '',
                actionValue: ''
            }
        },
        methods:{
            sendData(){
                this.$emit('action', this.answer);
            },
            getActionValue : function(actionValue){
                this.$emit('actionValue', actionValue);
            }
        },
    }
</script>

<style scoped>
    .actionPanel{
        margin-left: 15px;
    }
</style>