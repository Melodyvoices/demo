"use strict";(self["webpackChunkaimailbos_frontend"]=self["webpackChunkaimailbos_frontend"]||[]).push([[706],{4325:function(e,t,i){i.r(t),i.d(t,{default:function(){return N}});var l=i(6768),a=i(4232),n=i(5586),s=i(5698);const o={class:"mailDetail"},c={class:"flex-3 mail-left mail-card"},d={class:"flex-1 mail-item"},r={class:"item-content back-icon"},v={class:"flex-1 mail-item"},m={class:"item-content"},u={class:"flex-1 mail-item"},f={class:"item-content"},k={style:{color:"rgba(22,130,252,1)"}},b={class:"flex-1 mail-item"},g={class:"item-content"},h={class:"flex-1 mail-item"},L={class:"item-content"},p={style:{color:"rgba(22,130,252,1)"}},y={class:"flex-3 mail-item mail-body"},x={class:"item-content",style:{"white-space":"pre-wrap",border:"0.05vw solid #0076b5",padding:"1vw","max-height":"10vw",overflow:"auto"}},w={class:"flex-5 mail-right mail-card"},F={class:"dialogue-content",ref:"scrollContainer"},O={key:0,class:"flex-left"},C={class:"chat-content"},_={key:0},D=["innerHTML"],I={key:2,class:"referList"},T=["id"],E={class:"chat-content flex-center",style:{"white-space":"pre-wrap"}},X={class:"flex-center icon-box"};function Q(e,t,i,Q,S,j){const q=(0,l.g2)("RollbackOutlined"),B=(0,l.g2)("LoadingOutlined"),A=(0,l.g2)("a-textarea"),H=(0,l.g2)("a-col"),R=(0,l.g2)("SendOutlined"),$=(0,l.g2)("a-row");return(0,l.uX)(),(0,l.CE)("div",o,[(0,l.Lk)("div",c,[(0,l.Lk)("div",d,[t[2]||(t[2]=(0,l.Lk)("div",{class:"item-title",style:{background:"rgb(138, 17, 17)"}},"钓鱼邮件",-1)),(0,l.Lk)("div",r,[(0,l.bF)(q,{onClick:j.goBack},null,8,["onClick"])])]),(0,l.Lk)("div",v,[t[3]||(t[3]=(0,l.Lk)("div",{class:"item-title"},"邮件标题",-1)),(0,l.Lk)("div",m,(0,a.v_)(S.mailInfo.title),1)]),(0,l.Lk)("div",u,[t[4]||(t[4]=(0,l.Lk)("div",{class:"item-title"},"发件人",-1)),(0,l.Lk)("div",f,[(0,l.Lk)("a",k,(0,a.v_)(S.mailInfo.senders),1)])]),(0,l.Lk)("div",b,[t[5]||(t[5]=(0,l.Lk)("div",{class:"item-title"},"发件时间",-1)),(0,l.Lk)("div",g,(0,a.v_)(S.mailInfo.sendDate),1)]),(0,l.Lk)("div",h,[t[6]||(t[6]=(0,l.Lk)("div",{class:"item-title"},"收件人",-1)),(0,l.Lk)("div",L,[(0,l.Lk)("a",p,(0,a.v_)(S.mailInfo.recipients),1)])]),t[8]||(t[8]=(0,l.Fv)('<div class="flex-1 mail-item" data-v-7b2231a5><div class="item-title" data-v-7b2231a5>邮件主题</div><div class="item-content" style="color:rgba(183, 183, 183,1);" data-v-7b2231a5>测试版暂未开放</div></div><div class="flex-1 mail-item" data-v-7b2231a5><div class="item-title" data-v-7b2231a5>邮件意图</div><div class="item-content" style="color:rgba(183, 183, 183,1);" data-v-7b2231a5>测试版暂未开放</div></div>',2)),(0,l.Lk)("div",y,[t[7]||(t[7]=(0,l.Lk)("div",{style:{display:"flex",width:"100%",gap:"1vw"}},[(0,l.Lk)("div",{class:"item-title flex-1"},"邮件正文"),(0,l.Lk)("div",{style:{flex:"6"}})],-1)),(0,l.Lk)("div",x,(0,a.v_)(S.mailInfo.content),1)]),t[9]||(t[9]=(0,l.Lk)("div",{class:"flex-1 mail-item"},[(0,l.Lk)("div",{class:"item-title"},"附件"),(0,l.Lk)("div",{class:"item-content",style:{color:"rgba(183, 183, 183,1)"}},(0,a.v_)("测试版暂未开放"))],-1))]),(0,l.Lk)("div",w,[(0,l.Lk)("div",F,[((0,l.uX)(!0),(0,l.CE)(l.FK,null,(0,l.pI)(S.contentData,((e,i)=>((0,l.uX)(),(0,l.CE)("div",{key:i},[1===e.type?((0,l.uX)(),(0,l.CE)("div",O,[t[10]||(t[10]=(0,l.Lk)("div",null,[(0,l.Lk)("div",{class:"img-box",style:{"margin-right":"1vw"}},[(0,l.Lk)("img",{src:n,alt:"",class:"img"})])],-1)),(0,l.Lk)("div",C,["#loading#"===e.content?((0,l.uX)(),(0,l.CE)("div",_,[(0,l.bF)(B)])):((0,l.uX)(),(0,l.CE)("div",{key:1,innerHTML:j.markdownTohtml(e.content)},null,8,D)),e.referList?.length>0&&"为什么告警？"===e.referList[0]?((0,l.uX)(),(0,l.CE)("div",I,[(0,l.Lk)("div",{style:{"font-weight":"bold",cursor:"pointer"},onClick:t[0]||(t[0]=(...e)=>j.dialogueSend&&j.dialogueSend(...e))},"为什么告警？")])):(0,l.Q3)("",!0)])])):((0,l.uX)(),(0,l.CE)("div",{key:1,class:"flex-right",id:e.id},[(0,l.Lk)("div",E,(0,a.v_)(e.content),1),t[11]||(t[11]=(0,l.Lk)("div",null,[(0,l.Lk)("div",{class:"img-box",style:{"margin-left":"1vw"}},[(0,l.Lk)("img",{src:s,alt:"",class:"img"})])],-1))],8,T))])))),128))],512),(0,l.bF)($,{class:"dialogue-send"},{default:(0,l.k6)((()=>[(0,l.bF)(H,{span:23},{default:(0,l.k6)((()=>[(0,l.bF)(A,{value:S.sendText,"onUpdate:value":t[1]||(t[1]=e=>S.sendText=e),"auto-size":{minRows:1,maxRows:5},bordered:!1,class:"a-textarea-hide-scrollbar",disabled:!0},null,8,["value"])])),_:1}),(0,l.bF)(H,{span:1,class:"dialogue-send-icon"},{default:(0,l.k6)((()=>[(0,l.Lk)("div",X,[(0,l.bF)(R)])])),_:1})])),_:1})])])}i(4114);var S=i(8696),j=i(9480),q=i(6678),B={icon:{tag:"svg",attrs:{viewBox:"64 64 896 896",focusable:"false"},children:[{tag:"path",attrs:{d:"M793 242H366v-74c0-6.7-7.7-10.4-12.9-6.3l-142 112a8 8 0 000 12.6l142 112c5.2 4.1 12.9.4 12.9-6.3v-74h415v470H175c-4.4 0-8 3.6-8 8v60c0 4.4 3.6 8 8 8h618c35.3 0 64-28.7 64-64V306c0-35.3-28.7-64-64-64z"}}]},name:"rollback",theme:"outlined"},A=B,H=i(4827);function R(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?Object(arguments[t]):{},l=Object.keys(i);"function"===typeof Object.getOwnPropertySymbols&&(l=l.concat(Object.getOwnPropertySymbols(i).filter((function(e){return Object.getOwnPropertyDescriptor(i,e).enumerable})))),l.forEach((function(t){$(e,t,i[t])}))}return e}function $(e,t,i){return t in e?Object.defineProperty(e,t,{value:i,enumerable:!0,configurable:!0,writable:!0}):e[t]=i,e}var P=function(e,t){var i=R({},e,t.attrs);return(0,l.bF)(H.A,R({},i,{icon:A}),null)};P.displayName="RollbackOutlined",P.inheritAttrs=!1;var M=P,U=i(6824),z={name:"mailDetail",components:{SendOutlined:j.A,LoadingOutlined:q.A,RollbackOutlined:M},data(){return{contentData:[],sendText:"测试版暂未开放自由问答",faqQueryForm:{id:"",text:"为什么告警？"},mailInfo:{title:"",senders:"",sendDate:"",recipients:"",content:""}}},mounted(){this.faqQueryForm.id=this.$route.params.id,""!==this.faqQueryForm.id&&((0,S.uU)({id:this.faqQueryForm.id}).then((e=>{this.mailInfo={title:e.title,senders:e.senders,sendDate:e.sendDate,recipients:e.recipients,content:e.content}})),this.contentData=[{id:"0",dialogueId:"0",content:"尊敬的用户，您好！\n\n我是您的智能小帮手，全天候24小时待命，致力于为您提供高效、便捷的邮件安全运营支持。\n\n您可以就本邮件向我发起提问哦！\n\n期待您的每一次互动，让我们共同打造更安全、高效的电子邮件环境。",type:1,referList:["为什么告警？"]}])},methods:{markdownTohtml(e){return(0,U.xI)(e)},scrollToBottom(){const e=this.$refs.scrollContainer;e&&(e.scrollTop=e.scrollHeight)},dialogueSend(){this.contentData.push({id:"0",dialogueId:"0",content:"为什么告警？",type:0,referList:null}),this.contentData.push({id:"1",dialogueId:"1",content:"#loading#",type:1,referList:null}),this.$nextTick((()=>{this.scrollToBottom()})),(0,S.JL)(this.faqQueryForm).then((()=>{(0,S.uU)({id:this.faqQueryForm.id}).then((e=>{this.contentData=e.records,this.$nextTick((()=>{this.scrollToBottom()}))}))}))},goBack(){this.$router.push("/mail/index")}}},J=i(1241);const K=(0,J.A)(z,[["render",Q],["__scopeId","data-v-7b2231a5"]]);var N=K}}]);
//# sourceMappingURL=706.146ef3c4.js.map