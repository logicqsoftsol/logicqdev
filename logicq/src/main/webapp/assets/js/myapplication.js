/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('crmlogicq', ['ui.bootstrap','zingchart-angularjs',
        'ui.router','checklist-model','ngStorage'
  ]).constant('AppConstants', {
	   'hostName':'http://127.0.0.1:', 
	   'hostPort': '8090' ,
	   'applicationName' : '/crmlogicq' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' , 
	   'loadDefaultUserURL' : '/admin/login/loadDefaultUser',
	   'addSMSTemplate' : '/api/admin/smstemplate/add',
	   'updateSMSTemplate' : '/api/admin/smstemplate/update',
	   'deleteSMSTemplate' : '/api/admin/smstemplate/delete',
	   'searchSMSTemplate' : '/api/admin/smstemplate/search',
	   'loginURL' :'/api/login',
	   
	
	   'getAttendanceAsTabularURL':'/api/admin/attendance/getAttendanceAsTabular',
	   'getAttendanceAsGraphURL':'/api/admin/attendance/getAttendanceAsGraph',
	   
	   'saveEventDetailsURL':'/api/admin/calendar/event/saveEventDetails',
	   'deleteEventDetailsURL':'/api/admin/calendar/event/deleteEventDetails',
	   'getAllEventDetailsURL':'/api/admin/calendar/event/getAllEventDetails',
	   
	   
	   'getAllCalendarDetailsURL':'/api/admin/calendar/getAllCalendarDetails',
	   'getCalendarDetailsforCriteriaURL':'/api/admin/calendar/getCalendarDetailsforCriteria',
	   'saveCalendarDetailsURL':'/api/admin/calendar/saveCalendarDetails',
	   'deleteCalendarDetailsURL':'/api/admin/calendar/deleteCalendarDetails',
	   
	   'searchAllEmployeeListURL':'/api/user/searchAllEmployeeList',
	   'saveEmployeeDetailsURL':'/api/user/saveEmployeeDetails',
	   'searchEmployeeDetailsURL':'/api/user/searchEmployeeDetails',
	   'deleteEmployeeDetailsURL':'/api/user/deleteEmployeeDetails',
	   
	   'searchAllStudentListURL':'/api/user/searchAllStudentList',
	   'saveStudentDetailsURL':'/api/user/saveStudentDetails',
	   'searchStudentDetailsURL':'/api/user/searchStudentDetails',
	   'deleteStudentDetailsURL':'/api/user/deleteStudentDetails',
	   
	   
	   'saveNotificationTemplateURL':'/api/admin/notification/saveNotificationTemplate',
	   'deleteNotificationTemplateURL':'/api/admin/notification/deleteNotificationTemplate',
	   'getNotificationTemplatesURL':'/api/admin/notification/getNotificationTemplates',
	  
	   'saveNotificationTemplateSetupURL':'/api/admin/notification/saveNotificationTemplateSetup',
	   'deleteNotificationTemplateSetupURL':'/api/admin/notification/deleteNotificationTemplateSetup',
	   'getNotificationSetupDetailsURL':'/api/admin/notification/getNotificationSetupDetails',
	   'getNotificationDetailsForEntityURL':'/api/admin/notification/getNotificationDetailsForEntity',
	   
	   

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