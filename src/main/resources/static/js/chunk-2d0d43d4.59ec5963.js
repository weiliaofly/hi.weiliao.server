(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d43d4"],{"5fd1":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("Card",[a("tables",{ref:"tables",attrs:{searchable:"",searchInputAble:"",columns:e.columns,showAddBtn:!0},on:{"on-add":e.handleAdd,"on-edit":e.handleEdit,"on-delete":e.handleDelete},model:{value:e.tableData,callback:function(t){e.tableData=t},expression:"tableData"}})],1),a("Modal",{attrs:{title:e.classificationModalTitle,"class-name":"vertical-center-modal","footer-hide":"","mask-closable":!1},on:{"on-cancel":e.cancelFormModal},model:{value:e.classificationModal,callback:function(t){e.classificationModal=t},expression:"classificationModal"}},[a("Form",{ref:"formValidate",attrs:{model:e.formValidate,rules:e.ruleValidate,"label-width":80}},[a("div",{staticClass:"flex-center mgb10"},[a("div",[a("div",{staticClass:"flex-center mgb10"},[a("Avatar",{attrs:{src:e.formValidate.img,shape:"square",size:"large"}})],1),a("Button",{attrs:{type:"primary",size:"small"},on:{click:function(t){e.cropperModal=!0}}},[e._v("上传图片")])],1)]),a("FormItem",{attrs:{label:"广告说明",prop:"desc"}},[a("Input",{attrs:{placeholder:"Enter your desc",clearable:""},model:{value:e.formValidate.desc,callback:function(t){e.$set(e.formValidate,"desc",t)},expression:"formValidate.desc"}})],1),a("FormItem",{attrs:{label:"广告类型",prop:"type"}},[a("Select",{attrs:{placeholder:"Select your type"},model:{value:e.formValidate.type,callback:function(t){e.$set(e.formValidate,"type",t)},expression:"formValidate.type"}},[a("Option",{attrs:{value:"0"}},[e._v("启动广告页面")]),a("Option",{attrs:{value:"1"}},[e._v("H5启动页")]),a("Option",{attrs:{value:"2"}},[e._v("首页轮播")]),a("Option",{attrs:{value:"3"}},[e._v("赞数广告页")]),a("Option",{attrs:{value:"4"}},[e._v("文章列表推荐广告页")])],1)],1),a("FormItem",{attrs:{label:"跳转地址",prop:"linkHref"}},[a("Input",{attrs:{placeholder:"Enter your linkHref",clearable:""},model:{value:e.formValidate.linkHref,callback:function(t){e.$set(e.formValidate,"linkHref",t)},expression:"formValidate.linkHref"}})],1),a("FormItem",{attrs:{label:"跳转方向",prop:"direction"}},[a("RadioGroup",{model:{value:e.formValidate.direction,callback:function(t){e.$set(e.formValidate,"direction",t)},expression:"formValidate.direction"}},[a("Radio",{attrs:{label:"0"}},[e._v("内部跳转")]),a("Radio",{attrs:{label:"1"}},[e._v("外部跳转")])],1)],1),a("FormItem",{attrs:{label:"起止时间",prop:"startAndEndTime"}},[a("DatePicker",{staticStyle:{width:"200px"},attrs:{value:e.formValidate.startAndEndTime,confirm:"",format:"yyyy/MM/dd",type:"daterange",placement:"bottom-end",placeholder:"Select date"}})],1),a("FormItem",{attrs:{label:"状态",prop:"state"}},[a("RadioGroup",{model:{value:e.formValidate.state,callback:function(t){e.$set(e.formValidate,"state",t)},expression:"formValidate.state"}},[a("Radio",{attrs:{label:"0"}},[e._v("正常")]),a("Radio",{attrs:{label:"1"}},[e._v("禁用")])],1)],1),a("div",{staticClass:"flex-center"},[a("Button",{attrs:{type:"primary"},on:{click:function(t){return e.handleSubmit("formValidate")}}},[e._v("提交")]),a("Button",{staticClass:"mgl10",on:{click:function(t){return e.handleReset("formValidate")}}},[e._v("重置")])],1)],1)],1),a("Modal",{attrs:{title:"上传图片","class-name":"vertical-center-modal",width:"620","mask-closable":!1},model:{value:e.cropperModal,callback:function(t){e.cropperModal=t},expression:"cropperModal"}},[a("Cropper")],1)],1)},r=[],l=(a("7f7f"),a("fa69")),o=a("9ffe"),n=a("7e1e"),s={name:"advertising_management",components:{Tables:l["a"],Cropper:o["a"]},data:function(){return{columns:[{title:"选项",type:"selection",width:45,key:"selection"},{title:"序号",type:"index",key:"index",width:80,align:"center"},{title:"广告Id",key:"advertisementId"},{title:"广告名称类型",key:"typeName"},{title:"广告图片",key:"img",render:function(e,t){return e("div",[e("img",{attrs:{src:t.row.img},class:"table-img"})])}},{title:"广告说明",key:"desc"},{title:"跳转地址",key:"linkHref",render:function(e,t){var a=t.row.linkHref?t.row.linkHref:"-";return e("span",a)}},{title:"跳转方向",key:"direction",render:function(e,t){var a="0"===t.row.direction?"内部跳转":"外部跳转";return e("span",a)}},{title:"开始时间",key:"startTime"},{title:"结束时间",key:"endTime"},{title:"状态",key:"state",render:function(e,t){var a="0"===t.row.state?"success":"error",i="0"===t.row.state?"启用":"禁用";return e("Tag",{props:{color:a}},i)}},{title:"操作",key:"handle",options:["delete","edit"]}],formValidate:{type:"0",img:"",desc:"",linkHref:"",direction:"0",startAndEndTime:[],state:"0"},ruleValidate:{type:[{required:!0,message:"广告类型不能为空",trigger:"change"}],img:[{required:!0,message:"广告图片不能为空",trigger:"change"}],desc:[{required:!0,message:"广告说明文本不能为空",trigger:"blur"}],linkHref:[{required:!0,message:"跳转地址不能为空",trigger:"blur"}],direction:[{required:!0,message:"跳转方向不能为空",trigger:"change"}],startAndEndTime:[{required:!0,type:"array",message:"起止时间不能为空",trigger:"change"}],state:[{required:!0,message:"状态不能为空",trigger:"change"}]},classificationModal:!1,cropperModal:!1,classificationModalTitle:"",tableData:[]}},methods:{handleAdd:function(e){this.classificationModalTitle="新增广告",this.classificationModal=e},handleEdit:function(e){this.classificationModalTitle="修改广告",this.formValidate.type=e.row.type,this.formValidate.img=e.row.img,this.formValidate.linkHref=e.row.linkHref,this.formValidate.direction=e.row.direction,this.formValidate.desc=e.row.desc,this.formValidate.startAndEndTime=e.row.startAndEndTime,this.formValidate.state=e.row.state,this.classificationModal=!0},handleDelete:function(e){this.tableData=this.tableData.filter(function(t,a){return a!==e.row.initRowIndex})},cancelFormModal:function(){this.handleReset("formValidate")},handleSubmit:function(e){var t=this,a=this;a.$refs[e].validate(function(i){i&&(a.classificationModal=!1,t.$refs[e].resetFields(),a.$Message.success("提交成功!"))})},handleReset:function(e){this.$refs[e].resetFields()}},mounted:function(){var e=this;Object(n["b"])().then(function(t){e.tableData=t.data})}},d=s,c=a("2877"),m=Object(c["a"])(d,i,r,!1,null,"c863bfc8",null);t["default"]=m.exports}}]);