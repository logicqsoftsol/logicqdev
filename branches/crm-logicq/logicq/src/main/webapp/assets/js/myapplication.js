/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('crmlogicq', ['zingchart-angularjs',
        'ui.router','checklist-model','ngStorage'
  ]).constant('AppConstants', {
	   'hostName':'http://127.0.0.1:', 
	   'hostPort': '8090' ,
	   'applicationName' : '/crmlogicq' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loadDefaultUserURL' : '/admin/loadDefaultUser',
	   'addSMSTemplate' : '/admin/smstemplate/add',
	   'updateSMSTemplate' : '/admin/smstemplate/update',
	   'deleteSMSTemplate' : '/admin/smstemplate/delete',
	   'searchSMSTemplate' : '/admin/smstemplate/search',
	   'loginURL' :'/api/login',
	   'searchcurrentAttedanceURL':'/admin/attendance/searchCurrentAttendance',
	   'searchattendanceURL':'/admin/attendance/searchAttendance',
	   'getattendanceCountURL':'/admin/attendance/getAttendanceCount',

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