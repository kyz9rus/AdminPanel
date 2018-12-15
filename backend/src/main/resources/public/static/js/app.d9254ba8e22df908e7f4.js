webpackJsonp([1],{"1Y76":function(t,e){},"45bu":function(t,e){},Dgtu:function(t,e){},JMwU:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),r={data:()=>({greeting:"Welcome to the Banner Page!"}),name:"App"},s={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapper",attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var i=n("VU/8")(r,s,!1,function(t){n("45bu")},null,null).exports,o=n("/ocq"),c=n("mtWM"),l=n.n(c),d=l.a.create({baseURL:"http://localhost:8080/api",headers:{"Content-type":"application/json"}}),h={name:"banners-list",data:()=>({banners:[{id:1,width:400,height:200,imgsrc:"/static/img/acura.jpg",langid:"Russion",targeturl:"http://www.yandex.ru"}]}),methods:{retrieveBanners(){d.get("/showAllBanners").then(t=>{this.banners=t.data,console.log(t.data)}).catch(t=>{console.log(t)})},refreshList(){this.retrieveBanners()},showWindow(){$(".descBanner").show()}},mounted(){this.retrieveBanners()}},u={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"list row"},[n("div",{staticClass:"col-md-6"},[n("h4",[t._v("Banners List")]),t._v(" "),n("ul",t._l(t.banners,function(e,a){return n("li",{key:a},[n("router-link",{attrs:{to:{name:"banner-details",params:{banner:e,id:e.id}}}},[n("div",{staticClass:"banner",attrs:{align:"center"},on:{click:function(e){t.showWindow()}}},[n("a",{attrs:{href:e.targeturl}},[n("img",{attrs:{width:e.width,height:e.height,src:e.imgsrc}})])])])],1)}))]),t._v(" "),n("div",{staticClass:"col-md-6"},[n("router-view",{on:{refreshData:t.refreshList}})],1)])},staticRenderFns:[]};n("VU/8")(h,u,!1,function(t){n("Dgtu")},"data-v-61805fe8",null).exports;var p={name:"banner",props:["banner"],methods:{updateActive(t){var e={id:this.banner.id,imgsrc:this.banner.imgsrc,width:this.banner.width,height:this.banner.height,targeturl:this.banner.targeturl,langid:this.banner.langid,active:t};d.put("/banner/"+this.banner.id,e).then(t=>{this.banner.active=t.data.active,console.log(t.data)}).catch(t=>{console.log(t)})},deleteBanner(){d.delete("/banner/"+this.banner.id).then(t=>{console.log(t.data),this.$emit("refreshData"),this.$router.push("/")}).catch(t=>{console.log(t)})},hideWindow(){$(".descBanner").hide()}}},v={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return this.banner?a("div",[a("div",{staticClass:"descBanner",attrs:{align:"center"}},[a("h4",[t._v("Banner "+t._s(this.banner.id))]),t._v(" "),a("img",{attrs:{src:n("kgbk"),alt:"X"},on:{click:function(e){t.hideWindow()}}}),t._v(" "),a("div",[a("label",[t._v("Site: "),a("a",{attrs:{href:this.banner.targeturl}},[t._v(t._s(this.banner.targeturl))])]),t._v(" "),a("br"),t._v(" "),a("label",[t._v("Language: ")]),t._v(" "+t._s(this.banner.langid)+"\n        ")])])]):a("div",[t._m(0)])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"descBanner",attrs:{align:"center"}},[e("br"),this._v(" "),e("p",[this._v("Please click on a Banner...")])])}]};n("VU/8")(p,v,!1,function(t){n("1Y76")},"data-v-2c06bc76",null).exports;var g={data:()=>({greeting:"Welcome to the Admin Page!"}),name:"admin",props:["admin"],methods:{doSmth(){}}},m={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapperForFooter"},[e("app-header",{attrs:{msg:this.greeting}}),this._v(" "),this._m(0),this._v(" "),e("app-footer")],1)},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"content"},[e("br")])}]};var f=n("VU/8")(g,m,!1,function(t){n("OZUd")},"data-v-21350cbe",null).exports,_={name:"index",data:()=>({greeting:"Welcome to the Banner Page!",authority:"",profile:frontendData.profile}),methods:{getAuthority(){console.log("RESPONSE: "),http.get("/getAuthority").then(t=>{console.log(t.data)}).catch(t=>{console.log(t)})}}},b={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"wrapperForFooter"},[n("app-header",{attrs:{msg:t.greeting}}),t._v(" "),n("div",{staticClass:"content"},[t.profile?t._e():n("h1",[t._v("Необходимо авторизоваться")]),t._v(" "),"admin"===t.authority?n("router-link",{attrs:{to:"/admin"}}):t._e(),t._v(" "),"user"===t.authority?n("router-link",{attrs:{to:"/"}}):t._e(),t._v(" "),n("router-link",{staticClass:"btn btn-primary",attrs:{to:"/admin"}},[t._v("Search")]),t._v(" "),n("br")],1),t._v(" "),n("app-footer")],1)},staticRenderFns:[]};var w=n("VU/8")(_,b,!1,function(t){n("YlGT")},"data-v-276c7d89",null).exports;a.a.use(o.a);var C=new o.a({mode:"history",routes:[{path:"/",name:"index",component:w},{path:"/admin",name:"admin",component:f}]}),x={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"footer"},[this._v("\n    © 2018 Все права защищены.\n")])},staticRenderFns:[]};var B=n("VU/8")(null,x,!1,function(t){n("JMwU")},"data-v-7df093c0",null).exports,k={props:["msg"],data:()=>({})},E={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"header featurebox col-md-12 col-sm-12 col-xs-12"},[e("div",{staticClass:"row",attrs:{align:"center"}},[e("div",{staticClass:"name col-md-10 col-sm-10 col-xs-10"},[e("p",{staticClass:"mainText"},[this._v(this._s(this.msg))])]),this._v(" "),this._m(0)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"loginBlock col-md-2 col-sm-2 col-xs-2"},[e("form",{attrs:{method:"POST",action:"/login"}},[e("button",{staticClass:"login",attrs:{type:"submit"}},[e("img",{attrs:{src:n("hreQ"),alt:"Login"}})])])])}]};var y=n("VU/8")(k,E,!1,function(t){n("aJtV")},"data-v-16cf32d2",null).exports,U=n("Rf8U"),R=n.n(U);a.a.use(R.a,l.a),a.a.config.productionTip=!1,a.a.component("app-header",y),a.a.component("app-footer",B),new a.a({el:"#app",router:C,components:{App:i},template:"<App/>"}),l.a.get("http://localhost:8080/api/getAuthority").then(t=>{console.log("RESPONSE"),console.log(t.data),"admin"===t.data&&$(location).attr("href","http://localhost:8080/admin")})},OZUd:function(t,e){},YlGT:function(t,e){},aJtV:function(t,e){},hreQ:function(t,e,n){t.exports=n.p+"static/img/login.jpg"},kgbk:function(t,e,n){t.exports=n.p+"static/img/cross.png"}},["NHnr"]);
//# sourceMappingURL=app.d9254ba8e22df908e7f4.js.map