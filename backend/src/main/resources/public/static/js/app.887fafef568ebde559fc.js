webpackJsonp([1],{"/WBq":function(t,e){},"0n9M":function(t,e){},"3SFQ":function(t,e){},JMwU:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),r={data:()=>({greeting:"Welcome to the Banner Page!"}),name:"App"},s={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapper",attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var i=n("VU/8")(r,s,!1,function(t){n("/WBq")},null,null).exports,o=n("/ocq"),l={name:"index",data:()=>({greeting:"Welcome to the Banner Page!",authority:""}),methods:{}},c={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapperForFooter"},[e("app-header",{attrs:{msg:this.greeting}}),this._v(" "),e("div",{staticClass:"content"},[e("app-banners"),this._v(" "),e("br")],1),this._v(" "),e("app-footer")],1)},staticRenderFns:[]};var d=n("VU/8")(l,c,!1,function(t){n("Pz5e")},"data-v-481bc9bf",null).exports,u=n("mtWM"),p=n.n(u),h=p.a.create({baseURL:"http://localhost:8080/api",headers:{"Content-type":"application/json"}}),v={name:"banner",props:["banner"],data:()=>({show:!0}),methods:{deleteBanner(){h.delete("/banner/"+this.banner.id).then(t=>{console.log(t.data),this.$emit("refreshData"),this.$router.push("/")}).catch(t=>{console.log(t)})},hideBanner(){this.show=!this.show}}},m={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return this.banner?a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}],staticClass:"descBanner",attrs:{align:"center"}},[a("h4",[t._v("Banner "+t._s(this.banner.id))]),t._v(" "),a("img",{attrs:{src:n("kgbk"),alt:"X"},on:{click:t.hideBanner}}),t._v(" "),a("div",[a("label",[t._v("Site: "),a("a",{attrs:{href:this.banner.targeturl}},[t._v(t._s(this.banner.targeturl))])]),t._v(" "),a("br"),t._v(" "),a("label",[t._v("Language: ")]),t._v(" "+t._s(this.banner.langid)+"\n        ")])])]):a("div")},staticRenderFns:[]};var g=n("VU/8")(v,m,!1,function(t){n("V8te")},"data-v-2bdb2e0c",null).exports,b={data:()=>({greeting:"Welcome to the Admin Page!",show:!1}),name:"admin",props:["admin"],methods:{showOperation(t){switch(t){case"app-addBanner":$(".addBanner").show(),$(".editBanner").hide();break;case"app-editBanner":$(".addBanner").hide(),$(".editBanner").show()}},doSmth(){}}},f={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"wrapperForFooter"},[n("app-header",{attrs:{msg:t.greeting}}),t._v(" "),n("button",{staticClass:"menuButton",on:{click:function(e){t.show=!t.show}}},[n("ion-icon",{staticClass:"ion-navicon",attrs:{name:"menu"}})],1),t._v(" "),n("hr"),t._v(" "),n("transition",{attrs:{name:"slide"}},[n("aside",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}]},[n("ul",{staticClass:"buttons"},[n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Добавить баннер"},on:{click:function(e){t.showOperation("app-addBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Редактировать баннер"},on:{click:function(e){t.showOperation("app-editBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Удалить баннер"},on:{click:function(e){t.showOperation("app-deleteBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Отсортировать баннеры по языку"}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Посмотреть историю изменения баннеров"},on:{click:function(e){t.showOperation("app-log")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Открыть тестовую страницу для просмотра баннеров"}})])])])]),t._v(" "),n("div",{staticClass:"content"},[n("app-addBanner"),t._v(" "),n("app-editBanner")],1),t._v(" "),n("app-footer")],1)},staticRenderFns:[]};var _=n("VU/8")(b,f,!1,function(t){n("NOU4")},"data-v-dea546d8",null).exports;a.a.use(o.a);var w=new o.a({routes:[{path:"/",name:"index",component:d,children:[{path:"/banner/:id",name:"banner-details",component:g,props:!0}]},{path:"/admin",name:"admin",component:_}]}),C=n("Rf8U"),B=n.n(C),x={props:["msg"],data:()=>({})},U={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"header featurebox col-md-12 col-sm-12 col-xs-12"},[e("div",{staticClass:"row",attrs:{align:"center"}},[e("div",{staticClass:"name col-md-10 col-sm-10 col-xs-10"},[e("p",{staticClass:"mainText"},[this._v(this._s(this.msg))])]),this._v(" "),this._m(0)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"loginBlock col-md-2 col-sm-2 col-xs-2"},[e("form",{attrs:{method:"POST",action:"/login"}},[e("button",{staticClass:"login",attrs:{type:"submit"}},[e("img",{attrs:{src:n("hreQ"),alt:"Login"}})])])])}]};var y=n("VU/8")(x,U,!1,function(t){n("UW5i")},null,null).exports,k={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"footer"},[this._v("\n    © 2018 Все права защищены.\n")])},staticRenderFns:[]};var F=n("VU/8")(null,k,!1,function(t){n("JMwU")},"data-v-7df093c0",null).exports,I={name:"banners-list",data:()=>({banners:[{id:1,width:400,height:200,imgsrc:"/static/img/acura.jpg",langid:"Russion",targeturl:"http://www.yandex.ru"}],show:!0}),methods:{retrieveBanners(){h.get("/showAllBanners").then(t=>{this.banners=t.data,console.log(t.data)}).catch(t=>{console.log(t)})},refreshList(){this.retrieveBanners()},showBanner(){$(".descBanner").show()}},mounted(){this.retrieveBanners()}},P={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"list row"},[n("div",{staticClass:"col-md-6"},[n("h4",[t._v("Banners List")]),t._v(" "),n("ul",t._l(t.banners,function(e,a){return n("li",{key:a,on:{click:t.showBanner}},[n("router-link",{attrs:{to:{name:"banner-details",params:{banner:e,id:e.id}}}},[n("div",{staticClass:"banner",attrs:{align:"center"}},[n("a",{attrs:{href:e.targeturl}},[n("img",{attrs:{width:e.width,height:e.height,src:e.imgsrc}})])])])],1)}))]),t._v(" "),n("div",{staticClass:"col-md-6"},[n("router-view",{on:{refreshData:t.refreshList}})],1)])},staticRenderFns:[]};var N=n("VU/8")(I,P,!1,function(t){n("0n9M")},"data-v-6980fb3a",null).exports,R={name:"add-banner",data:()=>({banner:{id:0,imgsrc:"",width:0,height:0,targetUrl:"",langId:0,active:!1},submitted:!1}),methods:{saveBanner(){var t={id:this.banner.id,imgsrc:this.banner.imgsrc,width:this.banner.width,height:this.banner.height,tarteUrl:this.banner.tarteUrl,langId:this.banner.langId};h.post("/api/admin/saveBanner",t).then(t=>{this.banner.id=t.banner.id,console.log(t.data)}).catch(t=>{console.log(t)}),this.submitted=!0},newBanner(){this.submitted=!1,this.banner={}}}},E={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"addBanner"},[n("div",{staticClass:"submitform"},[n("h1",{staticClass:"nameOperation"},[t._v("Add Banner")]),t._v(" "),t.submitted?n("div",[n("h4",[t._v("You submitted successfully!")]),t._v(" "),n("button",{staticClass:"btn btn-success",on:{click:t.newBanner}},[t._v("Add")])]):n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"id"}},[t._v("Id")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.id,expression:"banner.id"}],staticClass:"form-control",attrs:{type:"number",id:"id",required:"",name:"id"},domProps:{value:t.banner.id},on:{input:function(e){e.target.composing||t.$set(t.banner,"id",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"imgsrc"}},[t._v("ImgSrc")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.imgsrc,expression:"banner.imgsrc"}],staticClass:"form-control",attrs:{type:"text",id:"imgsrc",required:"",name:"imgsrc"},domProps:{value:t.banner.imgsrc},on:{input:function(e){e.target.composing||t.$set(t.banner,"imgsrc",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"width"}},[t._v("Width")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.width,expression:"banner.width"}],staticClass:"form-control",attrs:{type:"number",id:"width",required:"",name:"width"},domProps:{value:t.banner.width},on:{input:function(e){e.target.composing||t.$set(t.banner,"width",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"height"}},[t._v("Height")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.height,expression:"banner.height"}],staticClass:"form-control",attrs:{type:"number",id:"height",required:"",name:"height"},domProps:{value:t.banner.height},on:{input:function(e){e.target.composing||t.$set(t.banner,"height",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"targetUrl"}},[t._v("TargetUrl")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.targetUrl,expression:"banner.targetUrl"}],staticClass:"form-control",attrs:{type:"text",id:"targetUrl",required:"",name:"targetUrl"},domProps:{value:t.banner.targetUrl},on:{input:function(e){e.target.composing||t.$set(t.banner,"targetUrl",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"langId"}},[t._v("LangId")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.langId,expression:"banner.langId"}],staticClass:"form-control",attrs:{type:"number",id:"langId",required:"",name:"langId"},domProps:{value:t.banner.langId},on:{input:function(e){e.target.composing||t.$set(t.banner,"langId",e.target.value)}}})]),t._v(" "),n("button",{staticClass:"btn btn-success",on:{click:t.saveBanner}},[t._v("Submit")])])])])},staticRenderFns:[]};var V=n("VU/8")(R,E,!1,function(t){n("3SFQ")},"data-v-5bfe20e3",null).exports,O={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"editBanner"},[this._v("\n    Hello\n")])},staticRenderFns:[]};var W=n("VU/8")({name:"EditBanner"},O,!1,function(t){n("YtHC")},"data-v-494f7215",null).exports;a.a.use(B.a,p.a),a.a.config.productionTip=!1,a.a.component("app-header",y),a.a.component("app-footer",F),a.a.component("app-banners",N),a.a.component("app-addBanner",V),a.a.component("app-editBanner",W),new a.a({el:"#app",router:w,components:{App:i},template:"<App/>"})},NOU4:function(t,e){},Pz5e:function(t,e){},UW5i:function(t,e){},V8te:function(t,e){},YtHC:function(t,e){},hreQ:function(t,e,n){t.exports=n.p+"static/img/login.jpg"},kgbk:function(t,e,n){t.exports=n.p+"static/img/cross.png"}},["NHnr"]);
//# sourceMappingURL=app.887fafef568ebde559fc.js.map