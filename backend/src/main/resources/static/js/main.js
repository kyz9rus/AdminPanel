Vue.component('app-header', {
    template: '<div class="header featurebox col-md-12 col-sm-12 col-xs-12"><div class="row" align="center"><div class="name col-md-10 col-sm-10 col-xs-10"><p class="mainText">Welcome to the Admin Page!</p></div><div class="loginBlock col-md-2 col-sm-2 col-xs-2"><form method="POST" action="/login"><button type="submit" class="login"><img src="img/login.jpg" alt="Login"/></button></form></div></div></div>'
});

Vue.component('app-footer',{
    template: '<div class="footer">2018</div>'
});

Vue.component('app-admin', {
    template: '<div><input type="text" v-model="admin.login"></div>',
    script: 'export default{ name:"admin", data () {return {response: [],errors: [],user: {login: "", firstName: ""}}}'
});

new Vue({
   el: '#app'
});