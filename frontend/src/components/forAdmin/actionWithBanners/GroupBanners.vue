<template>
    <div class="form-group">
        <label for="groupWord">Group by:</label>
        <select id="groupWord" class="custom-select" name="groupWord" autofocus v-model="groupValue"
                v-on:change="sendData">
            <option v-for="language in languages">{{ language }}</option>
        </select>
    </div>

</template>

<script>
    export default {
        name: "ActionWithBanners",
        props: ["languages"],
        data() {
            return {
                groupValue: '',
            }
        },
        methods: {
            sendData() {
                this.$emit('actionValue', this.groupValue);
            }
        }
    }
</script>