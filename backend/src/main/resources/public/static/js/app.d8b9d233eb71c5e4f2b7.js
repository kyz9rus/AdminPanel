webpackJsonp([1],{"/WBq":function(t,e){},"67rC":function(t,e){},Bjxw:function(t,e){},Fq66:function(t,e){},GDn9:function(t,e){},JMwU:function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),r={data:()=>({greeting:"Welcome to the Banner Page!"}),name:"App"},s={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapper",attrs:{id:"app"}},[e("router-view")],1)},staticRenderFns:[]};var i=n("VU/8")(r,s,!1,function(t){n("/WBq")},null,null).exports,o={data:()=>({greeting:"Welcome to the Banner Page!"}),name:"AppAdmin"},l={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapper",attrs:{id:"admin"}},[e("router-view")],1)},staticRenderFns:[]};var d=n("VU/8")(o,l,!1,function(t){n("Qh2T")},null,null).exports,c=n("/ocq"),h={name:"index",data:()=>({greeting:"Welcome to the Banner Page!",authority:""}),methods:{}},u={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"wrapperForFooter"},[e("app-header",{attrs:{msg:this.greeting}}),this._v(" "),e("div",{staticClass:"content"},[this._m(0),this._v(" "),e("app-banners"),this._v(" "),e("br")],1),this._v(" "),e("app-footer")],1)},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("form",{attrs:{action:"/admin"}},[e("button",{attrs:{type:"submit"}},[this._v("\n                    АДМИНКА\n                ")])])}]};var p=n("VU/8")(h,u,!1,function(t){n("uIy0")},"data-v-e03f2a26",null).exports,m=n("mtWM"),v=n.n(m),g=v.a.create({baseURL:"http://localhost:8080/api",headers:{"Content-type":"application/json"}}),b={name:"banner",props:["banner"],data:()=>({show:!0}),methods:{hideBanner(){this.show=!this.show}}},f={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return this.banner?a("div",[a("div",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}],staticClass:"descBanner",attrs:{align:"center"}},[a("h4",[t._v("Banner "+t._s(this.banner.id))]),t._v(" "),a("img",{attrs:{src:n("kgbk"),alt:"X"},on:{click:t.hideBanner}}),t._v(" "),a("div",[a("label",[t._v("Site: "),a("a",{attrs:{href:this.banner.targeturl}},[t._v(t._s(this.banner.targeturl))])]),t._v(" "),a("br"),t._v(" "),a("label",[t._v("Language: ")]),t._v(" "+t._s(this.banner.langid)+"\n        ")])])]):a("div")},staticRenderFns:[]};var _=n("VU/8")(b,f,!1,function(t){n("anS1")},"data-v-144905b3",null).exports,w={data:()=>({greeting:"Welcome to the Admin Page!",show:!1}),name:"admin",props:["admin"],methods:{showOperation(t){switch(t){case"app-addBanner":$(".addBanner").show(),$(".editBanner").hide(),$(".deleteBanner").hide(),$(".log").hide();break;case"app-editBanner":$(".addBanner").hide(),$(".editBanner").show(),$(".deleteBanner").hide(),$(".log").hide();break;case"app-deleteBanner":$(".addBanner").hide(),$(".editBanner").hide(),$(".deleteBanner").show(),$(".log").hide();break;case"app-log":$(".addBanner").hide(),$(".editBanner").hide(),$(".deleteBanner").hide(),$(".log").show()}},doSmth(){}}},B={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"wrapperForFooter"},[n("app-header",{attrs:{msg:t.greeting}}),t._v(" "),n("button",{staticClass:"menuButton",on:{click:function(e){t.show=!t.show}}},[n("ion-icon",{staticClass:"ion-navicon",attrs:{name:"menu"}})],1),t._v(" "),n("hr"),t._v(" "),n("transition",{attrs:{name:"slide"}},[n("aside",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}]},[n("ul",{staticClass:"buttons"},[n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Добавить баннер"},on:{click:function(e){t.showOperation("app-addBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Редактировать баннер"},on:{click:function(e){t.showOperation("app-editBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Удалить баннер"},on:{click:function(e){t.showOperation("app-deleteBanner")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Отсортировать баннеры по языку"}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Посмотреть историю изменения баннеров"},on:{click:function(e){t.showOperation("app-log")}}})]),t._v(" "),n("li",[n("input",{staticClass:"btn",attrs:{type:"button",value:"Открыть тестовую страницу для просмотра баннеров"}})])])])]),t._v(" "),n("div",{staticClass:"content"},[n("app-addBanner"),t._v(" "),n("app-editBanner"),t._v(" "),n("app-deleteBanner"),t._v(" "),n("app-log")],1),t._v(" "),n("app-footer")],1)},staticRenderFns:[]};var C=n("VU/8")(w,B,!1,function(t){n("67rC")},"data-v-d928c9da",null).exports;a.a.use(c.a);var x=new c.a({mode:"history",routes:[{path:"/",name:"index",component:p,children:[{path:"/banner/:id",name:"banner-details",component:_,props:!0}]},{path:"/admin",name:"admin",component:C}]}),U=n("Rf8U"),y=n.n(U),k={props:["msg"],data:()=>({})},F={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"header featurebox col-md-12 col-sm-12 col-xs-12"},[e("div",{staticClass:"row",attrs:{align:"center"}},[e("div",{staticClass:"name col-md-10 col-sm-10 col-xs-10"},[e("p",{staticClass:"mainText"},[this._v(this._s(this.msg))])]),this._v(" "),this._m(0)])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"loginBlock col-md-2 col-sm-2 col-xs-2"},[e("form",{attrs:{method:"POST",action:"/login"}},[e("button",{staticClass:"login",attrs:{type:"submit"}},[e("img",{attrs:{src:n("hreQ"),alt:"Login"}})])])])}]};var I=n("VU/8")(k,F,!1,function(t){n("UW5i")},null,null).exports,A={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"footer"},[this._v("\n    © 2018 Все права защищены.\n")])},staticRenderFns:[]};var E=n("VU/8")(null,A,!1,function(t){n("JMwU")},"data-v-7df093c0",null).exports,R={name:"banners-list",data:()=>({banners:[{id:1,width:400,height:200,imgsrc:"/static/img/acura.jpg",langid:"Russion",targeturl:"http://www.yandex.ru"}],show:!0}),methods:{retrieveBanners(){g.get("/showAllBanners").then(t=>{this.banners=t.data,console.log(t.data);for(var e=0;e<this.banners.length;e++)this.banners[e].width=this.banners[e].width/2;console.log(this.banners)}).catch(t=>{console.log(t)})},refreshList(){this.retrieveBanners()},showBanner(){$(".descBanner").show()}},mounted(){this.retrieveBanners()}},P={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"list row"},[n("div",{staticClass:"col-md-6"},[n("h4",[t._v("Banners List")]),t._v(" "),n("ul",t._l(t.banners,function(e,a){return n("li",{key:a,on:{click:t.showBanner}},[n("router-link",{attrs:{to:{name:"banner-details",params:{banner:e,id:e.id}}}},[n("div",{staticClass:"banner",attrs:{align:"center"}},[n("a",{attrs:{href:e.targeturl}},[n("img",{attrs:{width:e.width,height:e.height,src:e.imgsrc}})])])])],1)}))]),t._v(" "),n("div",{staticClass:"col-md-6"},[n("router-view",{on:{refreshData:t.refreshList}})],1)])},staticRenderFns:[]};var V=n("VU/8")(R,P,!1,function(t){n("oSM+")},"data-v-48ad98a5",null).exports,q={name:"add-banner",data:()=>({banner:{id:0,imgsrc:"",width:0,height:0,targetUrl:"",langId:"",active:!1},submitted:!1}),methods:{saveBanner(){var t={id:this.banner.id,imgsrc:this.banner.imgsrc,width:this.banner.width,height:this.banner.height,tarteUrl:this.banner.tarteUrl,langId:this.banner.langId};g.get("/showAllBanners",t).then(t=>{console.log(t.data)}).catch(t=>{console.log(t)}),this.submitted=!0},newBanner(){this.submitted=!1,this.banner={}}}},W={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"addBanner"},[n("div",{staticClass:"submitform"},[n("h1",{staticClass:"nameOperation"},[t._v("Add Banner")]),t._v(" "),t.submitted?n("div",[n("h4",[t._v("You submitted successfully!")]),t._v(" "),n("button",{staticClass:"btn btn-success",on:{click:t.newBanner}},[t._v("Add")])]):n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"id"}},[t._v("Id")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.id,expression:"banner.id"}],staticClass:"form-control",attrs:{type:"number",id:"id",required:"",name:"id"},domProps:{value:t.banner.id},on:{input:function(e){e.target.composing||t.$set(t.banner,"id",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"imgsrc"}},[t._v("ImgSrc")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.imgsrc,expression:"banner.imgsrc"}],staticClass:"form-control",attrs:{type:"text",id:"imgsrc",required:"",name:"imgsrc"},domProps:{value:t.banner.imgsrc},on:{input:function(e){e.target.composing||t.$set(t.banner,"imgsrc",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"width"}},[t._v("Width")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.width,expression:"banner.width"}],staticClass:"form-control",attrs:{type:"number",id:"width",required:"",name:"width"},domProps:{value:t.banner.width},on:{input:function(e){e.target.composing||t.$set(t.banner,"width",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"height"}},[t._v("Height")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.height,expression:"banner.height"}],staticClass:"form-control",attrs:{type:"number",id:"height",required:"",name:"height"},domProps:{value:t.banner.height},on:{input:function(e){e.target.composing||t.$set(t.banner,"height",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"targetUrl"}},[t._v("TargetUrl")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.targetUrl,expression:"banner.targetUrl"}],staticClass:"form-control",attrs:{type:"text",id:"targetUrl",required:"",name:"targetUrl"},domProps:{value:t.banner.targetUrl},on:{input:function(e){e.target.composing||t.$set(t.banner,"targetUrl",e.target.value)}}})]),t._v(" "),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"langId"}},[t._v("LangId")]),t._v(" "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.banner.langId,expression:"banner.langId"}],staticClass:"form-control",attrs:{type:"text",id:"langId",required:"",name:"langId"},domProps:{value:t.banner.langId},on:{input:function(e){e.target.composing||t.$set(t.banner,"langId",e.target.value)}}})]),t._v(" "),n("button",{staticClass:"btn btn-success",on:{click:t.saveBanner}},[t._v("Submit")])])])])},staticRenderFns:[]};var N=n("VU/8")(q,W,!1,function(t){n("m+hA")},"data-v-dba6d17a",null).exports,L={name:"EditBanner",methods:{editBanner(){var t={id:this.banner.id,imgsrc:this.banner.imgsrc,width:this.banner.width,height:this.banner.height,tarteUrl:this.banner.tarteUrl,langId:this.banner.langId};http.get("/admin/editBanner",t).then(t=>{this.banner.id=t.banner.id,console.log(t.data)}).catch(t=>{console.log(t)}),this.submitted=!0}}},S={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"editBanner"},[this._v("\n    HelloEdit\n")])},staticRenderFns:[]};var O=n("VU/8")(L,S,!1,function(t){n("Fq66")},"data-v-fbc2eb30",null).exports,j={name:"DeleteBanner",methods:{deleteBanner(){http.delete("/banner/"+this.banner.id).then(t=>{console.log(t.data),this.$emit("refreshData"),this.$router.push("/")}).catch(t=>{console.log(t)})}}},D={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"deleteBanner"},[this._v("\n    HelloDelete\n")])},staticRenderFns:[]};var H=n("VU/8")(j,D,!1,function(t){n("Bjxw")},"data-v-6daa09b4",null).exports,M={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"log"},[this._v("\n    HelloLog\n")])},staticRenderFns:[]};var T=n("VU/8")({name:"Log"},M,!1,function(t){n("GDn9")},"data-v-7ad877cd",null).exports;a.a.use(y.a,v.a),a.a.config.productionTip=!1,a.a.component("app-header",I),a.a.component("app-footer",E),a.a.component("app-banners",V),a.a.component("app-addBanner",N),a.a.component("app-editBanner",O),a.a.component("app-deleteBanner",H),a.a.component("app-log",T),new a.a({el:"#app",router:x,components:{App:i},template:"<App/>"}),new a.a({el:"#admin",router:x,components:{AppAdmin:d},template:"<AppAdmin/>"})},Qh2T:function(t,e){},UW5i:function(t,e){},anS1:function(t,e){},hreQ:function(t,e,n){t.exports=n.p+"static/img/login.jpg"},kgbk:function(t,e,n){t.exports=n.p+"static/img/cross.png"},"m+hA":function(t,e){},"oSM+":function(t,e){},uIy0:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.d8b9d233eb71c5e4f2b7.js.map