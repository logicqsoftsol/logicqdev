/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('mlmlogicq', ['ui.router','snap','ngStorage']).constant('AppConstants', {
    'hostName':'http://127.0.0.1:', 
	// 'hostName':'http://45.113.136.152:',
	  'hostPort': '8090' ,
	 // 'hostPort': '8059' ,
	   'applicationName' : '/mlmlogicq' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loadDefaultUserURL':'/load/users',
	   'loginURL' : '/api/login',
	   'getUserProfileURL' : '/api/user/fetchUserProfileDetails',
	   'sendOTPURL' : '/api/service/otpSend',
	   'validateOTPURL' : '/api/service/otpValidate',
	   'saveUserProfileDetailsURL' :'/api/user/saveUser',
	   'updateAdminTaskURL':'/api/admin/updateAdminTask'

	}).directive('ngConfirmClick', [
	                                   function(){
	                                       return {
	                                           link: function (scope, element, attr) {
	                                               var msg = attr.ngConfirmClick || "Are you sure?";
	                                               var clickAction = attr.confirmedClick;
	                                               element.bind('click',function (event) {
	                                                   if ( window.confirm(msg) ) {
	                                                       scope.$eval(clickAction)
	                                                   }
	                                                   else{
	                                                	   
	                                                   }
	                                               });
	                                           }
	                                       };
	                               }]);
}());