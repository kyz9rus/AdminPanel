<template>
    <div class="form-group">
        <label for="sortBy">Sort by:</label>
        <select id="sortBy" class="custom-select" name="sortBy" autofocus v-model="sortValue" v-on:change="sendData">
            <option></option>
            <option>bannerId</option>
            <option>width</option>
            <option>height</option>
            <option>targetUrl</option>
            <option>langId</option>
        </select>
    </div>
</template>

<script>
    export default {
        name: "ActionWithBanners",
        data() {
            return {
                sortValue: ''
            }
        },
        methods: {
            sendData() {
                this.$emit('actionValue', this.sortValue);
            }
        }
    }
</script>