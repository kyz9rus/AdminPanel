webpackJsonp([1],{"32ho":function(t,e){},"44lG":function(t,e){},JMwU:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),s={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"wrapper"},[n("div",{staticClass:"wrapperForFooter",attrs:{id:"app"}},[n("app-header"),t._v(" "),n("div",{staticClass:"content"},[n("nav",[n("router-link",{staticClass:"btn btn-primary",attrs:{to:"/"}},[t._v("Banners")]),t._v(" "),n("router-link",{staticClass:"btn btn-primary",attrs:{to:"/search"}},[t._v("Search")])],1),t._v(" "),n("br"),t._v(" "),n("router-view"),t._v("\n\n      HELLO\n    ")],1),t._v(" "),n("app-footer")],1)])},staticRenderFns:[]};var r=n("VU/8")({name:"App"},s,!1,function(t){n("32ho")},null,null).exports,i=n("/ocq"),o=n("mtWM"),c=n.n(o).a.create({baseURL:"http://localhost:8080/api",headers:{"Content-type":"application/json"}}),l={name:"banners-list",data:()=>({banners:[]}),methods:{retrieveBanners(){c.get("/getAllBanners").then(t=>{this.banners=t.data,console.log(t.data)}).catch(t=>{console.log(t)})},refreshList(){this.retrieveBanners()}},mounted(){this.retrieveBanners()}},d={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"list row"},[n("div",{staticClass:"col-md-6"},[n("h4",[t._v("Banners List")]),t._v(" "),n("ul",t._l(t.banners,function(e,a){return n("li",{key:a},[n("router-link",{attrs:{to:{name:"banner-details",params:{banner:e,id:e.id}}}},[t._v("\n                    "+t._s(e.imgsrc)+"\n                ")])],1)}))]),t._v(" "),n("div",{staticClass:"col-md-6"},[n("router-view",{on:{refreshData:t.refreshList}})],1)])},staticRenderFns:[]};var v=n("VU/8")(l,d,!1,function(t){n("XRR9")},"data-v-fd981e84",null).exports,h={name:"banner",props:["banner"],methods:{updateActive(t){var e={id:this.banner.id,imgsrc:this.banner.imgsrc,width:this.banner.width,height:this.banner.height,targetUrl:this.banner.targetUrl,langId:this.banner.langId,active:t};c.put("/banner/"+this.banner.id,e).then(t=>{this.banner.active=t.data.active,console.log(t.data)}).catch(t=>{console.log(t)})},deleteBanner(){c.delete("/banner/"+this.banner.id).then(t=>{console.log(t.data),this.$emit("refreshData"),this.$router.push("/")}).catch(t=>{console.log(t)})}}},p={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return this.banner?n("div",[n("h4",[t._v("Banner")]),t._v(" "),n("div",[n("label",[t._v("Width: ")]),t._v(" "+t._s(this.banner.width)+"\n    ")]),t._v(" "),this.banner.active?n("span",{staticClass:"button is-small btn-primary",on:{click:function(e){t.updateActive(!1)}}},[t._v("Inactive")]):n("span",{staticClass:"button is-small btn-primary",on:{click:function(e){t.updateActive(!0)}}},[t._v("Active")]),t._v(" "),n("span",{staticClass:"button is-small btn-danger",on:{click:function(e){t.deleteBanner()}}},[t._v("Delete")])]):n("div",[n("br"),t._v(" "),n("p",[t._v("Please click on a Banner...")])])},staticRenderFns:[]};var u=n("VU/8")(h,p,!1,function(t){n("u3eR")},"data-v-5dafffc7",null).exports;a.a.use(i.a);var m=new i.a({routes:[{path:"/",name:"banners",alias:"/banner",component:v,children:[{path:"/banner/:id",name:"banner-details",component:u,props:!0}]}]}),b={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"footer"},[this._v("\n    © 2018 Все права защищены.\n")])},staticRenderFns:[]};var f=n("VU/8")(null,b,!1,function(t){n("JMwU")},"data-v-7df093c0",null).exports,_={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"header featurebox col-md-12 col-sm-12 col-xs-12"},[e("div",{staticClass:"row",attrs:{align:"center"}},[e("div",{staticClass:"name col-md-10 col-sm-10 col-xs-10"},[e("p",{staticClass:"mainText"},[this._v("Welcome to the Banner Page!")])]),this._v(" "),e("div",{staticClass:"loginBlock col-md-2 col-sm-2 col-xs-2"},[e("form",{attrs:{method:"POST",action:"/login"}},[e("button",{staticClass:"login",attrs:{type:"submit"}},[e("img",{attrs:{src:n("hreQ"),alt:"Login"}})])])])])])}]};var g=n("VU/8")(null,_,!1,function(t){n("44lG")},"data-v-65446b8a",null).exports;a.a.config.productionTip=!1,a.a.component("app-header",g),a.a.component("app-footer",f),new a.a({el:"#app",router:m,components:{App:r},template:"<App/>"})},XRR9:function(t,e){},hreQ:function(t,e,n){t.exports=n.p+"static/img/login.bbb93f2.jpg"},u3eR:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.cf8c5d9b2b4eb09a5ee9.js.map