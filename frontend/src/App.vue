<template>
  <div id="app" class="wrapper">

    <router-view/>
  </div>
</template>

<script>
export default {
    name: 'App'
}

</script>

<style>
  @import 'assets/css/bootstrap.min.css';

  .wrapper{
    display: flex;
    flex-direction: column;
    height: 100%;
  }

  .content{
    flex: 1 0 auto;
    margin: 50px auto;
    min-height: 700px;
    padding: 10px;
  }

  .wrapperForFooter{
    height: 100%;
    flex: 1 0 auto;
  }
</style>
