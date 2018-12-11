<template>
  <div class="wrapper">
    <div id="app" class="wrapperForFooter">
      <app-header></app-header>
      <div class="content">

        <!--List of banners-->
        <!--<app-listOfBanners></app-listOfBanners>-->
        <nav>
          <router-link class="btn btn-primary" to="/">Banners</router-link>
          <!--<router-link class="btn btn-primary" to="/add">Add</router-link>-->
          <router-link class="btn btn-primary" to="/search">Search</router-link>
        </nav>

        <br/>
        <router-view/>

      </div>

      <app-footer></app-footer>
    </div>
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
    margin: 50px auto !important;
    padding: 10px;
  }

  .wrapperForFooter{
    height: 100%;
    flex: 1 0 auto;
  }
</style>
