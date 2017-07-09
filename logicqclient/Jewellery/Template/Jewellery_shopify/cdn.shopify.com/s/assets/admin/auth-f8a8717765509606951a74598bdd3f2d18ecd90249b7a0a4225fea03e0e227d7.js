!function(t,e,n){function r(t){var e={},r=/^jQuery\d+$/;return n.each(t.attributes,function(t,n){n.specified&&!r.test(n.name)&&(e[n.name]=n.value)}),e}function i(t,r){var i=this,o=n(i);if(i.value==o.attr("placeholder")&&o.hasClass("placeholder"))if(o.data("placeholder-password")){if(o=o.hide().next().show().attr("id",o.removeAttr("id").data("placeholder-id")),t===!0)return o[0].value=r;o.focus()}else i.value="",o.removeClass("placeholder"),i==e.activeElement&&i.select()}function o(){var t,e=this,o=n(e),a=this.id;if(""==e.value){if("password"==e.type){if(!o.data("placeholder-textinput")){try{t=o.clone().attr({type:"text"})}catch(s){t=n("<input>").attr(n.extend(r(this),{type:"text"}))}t.removeAttr("name").data({"placeholder-password":!0,"placeholder-id":a}).bind("focus.placeholder",i),o.data({"placeholder-textinput":t,"placeholder-id":a}).before(t)}o=o.removeAttr("id").hide().prev().attr("id",a).show()}o.addClass("placeholder"),o[0].value=o.attr("placeholder")}else o.removeClass("placeholder")}var a,s,u="placeholder"in e.createElement("input"),l="placeholder"in e.createElement("textarea"),c=n.fn,d=n.valHooks;u&&l?(s=c.placeholder=function(){return this},s.input=s.textarea=!0):(s=c.placeholder=function(){var t=this;return t.filter((u?"textarea":":input")+"[placeholder]").not(".placeholder").bind({"focus.placeholder":i,"blur.placeholder":o}).data("placeholder-enabled",!0).trigger("blur.placeholder"),t},s.input=u,s.textarea=l,a={get:function(t){var e=n(t);return e.data("placeholder-enabled")&&e.hasClass("placeholder")?"":t.value},set:function(t,r){var a=n(t);return a.data("placeholder-enabled")?(""==r?(t.value=r,t!=e.activeElement&&o.call(t)):a.hasClass("placeholder")?i.call(t,!0,r)||(t.value=r):t.value=r,a):t.value=r}},u||(d.input=a),l||(d.textarea=a),n(function(){n(e).delegate("form","submit.placeholder",function(){var t=n(".placeholder",this).each(i);setTimeout(function(){t.each(o)},10)})}),n(t).bind("beforeunload.placeholder",function(){n(".placeholder").each(function(){this.value=""})}))}(this,document,jQuery),function(){var t;t=["rememberMe","home_date_range","homeSidebarDate","homeSidebarChannel"],window.SafeLocalStorage={get:function(t,e){var n,r,i,o,a;if(2!==arguments.length)throw"SafeLocalStorage developer error: You must supply a 2nd argument, a fallback/default value, to SafeLocalStorage.get()";try{a=localStorage.getItem(t);try{return a=JSON.parse(a),"undefined"===a?e:null!=a?a:e}catch(i){return n=i,"undefined"===a?e:null!=a?a:e}}catch(o){return r=o,e}},set:function(t,e){try{return localStorage.setItem(t,JSON.stringify(e))}catch(n){}},"delete":function(t){try{return localStorage.removeItem(t)}catch(e){}},clear:function(){try{return localStorage.clear()}catch(t){}},clearUnsafeItems:function(){var e,n,r,i,o,a,s,u;try{for(u={},e=0,i=t.length;i>e;e++)r=t[e],s=this.get(r,null),s&&(u[r]=s);for(a=this.clear(),n=0,o=t.length;o>n;n++)r=t[n],s=u[r],s&&this.set(r,s);return a}catch(l){}}}}.call(this),function(){var t;t=function(t){return t.attr({role:"alert",tabindex:-1}),setTimeout(function(){return t.focus()},1e3)},$(document).on("ready",function(){var e,n;return SafeLocalStorage.clearUnsafeItems(),$("input, textarea").placeholder(),$(".login-form #forgot-password").on("click",function(t){var e,n;return t.preventDefault(),t.stopPropagation(),n=$("input[type=email]").val(),e=t.currentTarget.getAttribute("href"),e+="?login="+encodeURIComponent(n),window.location=e}),$("#remember_checkbox").on("change",function(t){return SafeLocalStorage.set("rememberMe",!!t.target.checked)}),SafeLocalStorage.get("rememberMe",!1)&&$("#remember_checkbox").attr("checked",!0),$("body").on("mouseenter",".tooltip",function(t){return $(this).hasClass("disabled")?void 0:$(this).addClass("is-active")}),$("body").on("mouseleave",".tooltip",function(t){return $(this).removeClass("is-active")}),$("input").each(function(t){return t.autocapitalize=!1,t.autocorrect=!1}),e=$("#login-input"),e&&(""===e.val()?e.focus():$("#password").focus()),$("#passwordLoginToggle").on("click",function(t){return t.preventDefault(),t.stopPropagation(),$("#auth_style").val("normal-password"),$("#user_identity_url").removeAttr("required"),$("#user_identity_url").prop("disabled",!0),$("#user_password, #user_password_confirmation").prop("required","required"),$("#user_password, #user_password_confirmation").prop("disabled",!1),$("#passwordLogin, #passwordLoginConfirmation").slideToggle(400)}),$("#decline-invitation, #cancel-decline").on("click",function(t){return t.preventDefault(),t.stopPropagation(),$("#create-account-form, #decline-form").slideToggle(400)}),n=$("#system_error"),n.length?t(n):void 0})}.call(this);