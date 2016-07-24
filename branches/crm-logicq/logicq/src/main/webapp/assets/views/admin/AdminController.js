(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AttendanceService','UserService','GraphHelper','UserHelper','CalendarService','NotificationService','AppConstants',function ($scope, $http,  $location, AdminService,AttendanceService,UserService,GraphHelper,UserHelper,CalendarService,NotificationService,AppConstants) {
		 $scope.display=6;
		 $scope.graphattendance=[];
		 $scope.request = {};
		 $scope.selectedemployee='';
		 $scope.emp={};
		 $scope.empdel={};
		 $scope.selectedstudent='';
		 $scope.student={};
		 $scope.studentdel={};
		 $scope.emp.country='INDIA';
		 $scope.eventtyplist=[
          {id:1, name:'EXAM'},
          {id:2, name:'DAILY'},
		  {id:3, name:'WEEK DAYS ONLY'},
		  {id:4, name:'WEEK ENDS ONLY'},
          {id:5, name:'FUNCTION'},
          {id:6, name:'VACATION'},
		  {id:7, name:'REGIONAL FUNCTION'},
		  {id:8, name:'NATIONAL HOLIDAY'},
		  {id:9, name:'EMERGENCY'},
		  {id:10, name:'OTHER'}
        ];
		$scope.entitylist=[
		  {id:1, name:'ALL'},
		  {id:2, name:'STUDENT'},
          {id:3, name:'TEACHER(permanent)'},
		  {id:4, name:'TEACHER(contract)'},
          {id:5, name:'CONTRACTOR'},
          {id:6, name:'VENDOR'},
		  {id:7, name:'EMPLOYEE(permanent)'},
		  {id:8, name:'EMPLOYEE(contract)'},
		  {id:9, name:'GUARDIAN'}];
		  
		
		
		
								/* DashBoard   Display**/				
								 $scope.displayDashBoard = function() {
									 AttendanceService.getAttendanceCount($scope).success(function(data, status) {
									 GraphHelper.populateAttendanceForGraphStudent($scope,data);
										});
								     AttendanceService.getAttendanceCount($scope).success(function(data, status) {
										 GraphHelper.populateAttendanceForEmployee($scope,data);
										 });
									 
									 GraphHelper.populateExpenseandCollection($scope);
								 };							
			
		
		
		
		$scope.searchAttendanceTable= function() {
			 AttendanceService.getAttendanceDetails($scope).success(function(data, status) {
				 $scope.attendancedetails =data;
			});
			};

			$scope.searchAttendanceDefault= function() {
			 AttendanceService.getAttendanceDetailsdefault($scope).success(function(data, status) {
				 $scope.attendancedetails =data;
			});
			};	
			
			$scope.searchAttendanceGraph= function() {
				AttendanceService.getAttendanceCount($scope).success(function(data, status) {
				GraphHelper.populateAttendanceForGraphStudent($scope,data);
				});
			};
			
		
		   
																						
								/* Employee operation**/
												
								   $scope.emp.basicdetailid='';
								   $scope.emp.contactdetailid='';
								   $scope.emp.addressdetailid='';
								   $scope.emp.communicationdetailid='';												
								/* Search Employee**/
								$scope.searchAllEmployeeList = function() {
									UserService.searchAllEmployeeList($scope)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};	
								
								/*Save Employee**/
            				   $scope.saveEmployeeDetails = function() {
								
					                UserHelper.populateEmployeeForSave($scope);
									UserService.saveEmployeeDetails($scope.request)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};
								
								
								/*New Employee**/
								 $scope.newEmployee =  function() {
									// $scope.emp.userid=null;
									 $scope.emp={};
									 $scope.selectedemployee=null;
								 }
								
								/*Edit Employee**/
								 $scope.editForEmployee =  function(emp) {
									 $scope.selectedemployee=emp.id;
									UserService.searchEmployeeDetails($scope).success(function(data, status) {
										 UserHelper.populateEmployeeForEdit($scope,data);
									});
								};
								
								
								
								/*Set selected row for delete employee**/
								 $scope.pouplateEmployeeForDelete =  function(emp) {
									 UserHelper.pouplateEmployeeForDelete($scope,emp);
									 $scope.request.emp=emp;
								};
								
								/*Delete Employee**/
								 $scope.deleteEmployee= function() {
									 UserService.deleteEmployee($scope.request).success(function(data, status) {
										 $scope.request.student={};
											$scope.employelist=data;
										});
									};
								
								
								/* Student operation* */
								   $scope.student.basicdetailid='';
								   $scope.student.contactdetailid='';
								   $scope.student.addressdetailid='';
								   $scope.student.communicationdetailid='';
								/* Search Student**/
								$scope.searchAllStudentList = function() {
									UserService.searchAllStudentList($scope)
											.success(function(data, status) {
												$scope.studentdlist=data;
											});
								};	
								
								/*Save Student**/
								  $scope.saveStudentDetails = function() {
								
									   UserHelper.populateStudentForSave($scope);
									   UserService.saveStudentDetails($scope.request)
															.success(function(data, status) {
																$scope.studentdlist=data;
															});
												};					
												
												/*New Student**/
												 $scope.newStudent =  function() {
													 $scope.student={};
													 $scope.selectedstudent=null;
												 }		
												
												 /*Edit Student**/
												 $scope.editForStudent =  function(student) {
													 $scope.selectedstudent=student.id;
													UserService.searchStudentDetails($scope).success(function(data, status) {
														 UserHelper.populateStudentForEdit($scope,data);
													});
												};			 
				 
												/*Set selected row for delete student**/
												 $scope.pouplateStudentForDelete =  function(student) {
													 UserHelper.pouplateStudentForDelete($scope,student);
													 $scope.request.student=student;
												};
												
												/*Delete student**/
												 $scope.deleteStudent= function() {
													 UserService.deleteStudent($scope.request).success(function(data, status) {
														 $scope.request.student={};
															$scope.studentdlist=data;
														});
													};
													
													
										 /*Event Details**/	
												$scope.eventd={};
												$scope.eventd.eventid='';
												$scope.eventoperation='';
												$scope.operationtype='';
												$scope.eventid='';
											$scope.searchAllEventList=	function() {
														CalendarService.searchAllEventList($scope)
																.success(function(data, status) {
																	$scope.eventdetails=data;
																});
													};
												
												/*Add Event Details**/
											 $scope.addEventDetails= function() {
													 $scope.eventoperation='Create New';
                                                     $scope.operationtype='+';
													$scope.eventd={};
													$scope.eventd.eventid='';
													};
													
													/*Edit Event Details**/
											$scope.editEventDetails= function(eventd) {
													 $scope.eventoperation='Edit Existing';
													 $scope.operationtype='*';
													  UserHelper.populateEventDetailsForRowClick($scope,eventd);
													};
													
													/*Search Event Details**/
											$scope.searchEventDetails= function() {
													 $scope.eventoperation='Looking for Existing';
													  $scope.operationtype='';
													
													};
													
													/*Delete Event Details**/
                                               $scope.deleteEventDetails=function(eventd) {
													 $scope.eventoperation='Are you sure want to delete this  ';
													 $scope.operationtype='-';
													 UserHelper.populateEventDetailsForRowClick($scope,eventd);
													 $scope.request.eventd=eventd;
													};
													
													
													
													/*Operation Event Details**/
													$scope.operationEventDetail=function(){
														var operation=$scope.operationtype;
														$scope.request.eventd={};
														UserHelper.populateEventDetailsForOperation($scope);
														if ('+'==operation) {
															
															CalendarService.saveEventDetails($scope.request)
																.success(function(data, status) {
																	$scope.eventdetails=data;
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventDetails($scope.request)
																.success(function(data, status) {
																	$scope.eventdetails=data;
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventDetails($scope.request)
															.success(function(data, status) {
																	$scope.eventdetails=data;
																});
														}else{
															
														}
													};
													
													
											/*Calendar  Details**/
												$scope.calendar={};
												$scope.calendar.calendarid='';
												$scope.eventcalendarid='';
												$scope.eventdetailslist=[];
												$scope.calendar.eventid='';
												$scope.calendar.deletec=false;
													/*Search all calnder details*/
													$scope.getAllCalendarDetails=function() {
															CalendarService.searchAllEventCalendarList($scope)
																.success(function(data, status) {
																	$scope.calendardetailslist=data;
																	//UserHelper.formatEventCalendarDateType($scope);
																});
													};
												/*select event details**/
												$scope.$watch('calendar.eventname', function(newVal, oldVal){
												angular.forEach($scope.eventdetailslist, function(value, key) {
													if(value.eventname==newVal){
												    $scope.calendar.eventid=value.eventid;
													$scope.calendar.eventtype=value.eventtype;
													$scope.calendar.applicablefor=value.applicablefor;
													}	
													});
													
													});
													
												 /*Add Event calender details**/
												$scope.addEventCalendarDetails=function() {
													$scope.eventoperation='Setup new ';
                                                     $scope.operationtype='+';
													 $scope.calendar={};
													 $scope.calendar.calendarid='';
													 $scope.eventdetailslist=$scope.eventdetails;
														
													};
												
												/*Edit Event calender details**/	
                                                 $scope.editEventCalendarDetails=function(calendar) {
														$scope.eventoperation='Modify Existing';
													    $scope.operationtype='*';
														$scope.calendar.disabledc=false;
														UserHelper.setClickedRowForEventCalendarDetails($scope,calendar);
														$scope.eventdetailslist=$scope.eventdetails;
													};
													
													/*Search Event calender details**/
                                                  $scope.searchEventCalendarDetails=	function() {
													  $scope.eventoperation='Looking for Existing';
													  $scope.operationtype='';
													  $scope.calendar.disabledc=false;
													
													};		
													
													/*Delete Event calender details**/
                                                $scope.deleteEventCalendarDetails=	function(calendar) {
													 $scope.eventoperation='Are you sure want to delete this ';
													 $scope.operationtype='-';
													UserHelper.setClickedRowForEventCalendarDetails($scope,calendar);
													$scope.calendar.disabledc=true;
													
													};	

													
											/*Set Event calender details operation**/
										  $scope.operationCalendarDetailForEvent=function(){
													var operation=$scope.operationtype;
														$scope.request.calander={};
														UserHelper.populateEventCalendarDetailsForOperation($scope);
														if ('+'==operation) {
															
															CalendarService.saveEventCalendarDetails($scope.request)
																.success(function(data, status) {
																	$scope.calendardetailslist=data;
																	//UserHelper.formatEventCalendarDateType($scope);
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventCalendarDetails($scope.request)
																.success(function(data, status) {
																	$scope.calendardetailslist=data;
																	//UserHelper.formatEventCalendarDateType($scope);
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventCalendarDetails($scope.request)
															.success(function(data, status) {
																	$scope.calendardetailslist=data;
																});
														}else{
															
														}
											  
										  };
										  
											/*Set Template Configuration operation**/
											$scope.eventfortemplatelist=null;
											$scope.notificationtemplate={};
											$scope.notificationtemplate.eventid='';
											$scope.notitemplatetypelist=[{id:1, value:'SMS'},
																		{id:2, value:'E-MAIL'},
																		{id:3, value:'NOTIFICATION'},
																		{id:4, value:'ALL'}];
											$scope.notificationtemplatelist={};
											$scope.IsNotiTempVisible=true;
											if($scope.eventfortemplatelist==null){
											CalendarService.searchAllEventList($scope)
																	.success(function(data, status) {
																		$scope.eventfortemplatelist=data;
														});
												};
									
												
											/*select event details**/
										$scope.$watch('notificationtemplate.eventname', function(newVal, oldVal){
												angular.forEach($scope.eventfortemplatelist, function(value, key) {
													if(value.eventname==newVal){
												    $scope.notificationtemplate.eventid=value.eventid;
													$scope.notificationtemplate.eventtype=value.eventtype;
													$scope.notificationtemplate.applicablefor=value.applicablefor;
													}	
													});
													
													});
										
										  $scope.addNotificationTemplate=function(){
												$scope.eventoperation='Setup new ';
                                                $scope.operationtype='+';
												$scope.IsNotiTempVisible=true;
												$scope.notificationtemplate={};
											
												
										  };
										  $scope.editNotificationTemplate =function(notificationtemplate){
											  $scope.eventoperation='Modify Existing';
											    $scope.operationtype='*';
												$scope.IsNotiTempVisible=true;
												UserHelper.setRowForNotificationTemplate($scope,notificationtemplate);
										  };
										  $scope.searchNotificationTemplate =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
										  };
										  
										  $scope.deleteTemplateForNotification=function(notificationtemplate){
											  $scope.eventoperation='Are you sure want to delete this ';
											  $scope.operationtype='-';
											  $scope.IsNotiTempVisible=false;
											  UserHelper.setRowForNotificationTemplate($scope,notificationtemplate);
										  };
										  
											  
											  /* Get All Notification**/
											$scope.getAllNotificationTemplateList=function(){
												NotificationService.getAllNotificationTemplateList($scope)
												.success(function(data, status) {
													$scope.notificationtemplatelist=data;
								                	});
											  };
										  
											/*Set Notification Template  details operation**/
										  $scope.setupTemplateForNotification=function(){
											   
													var operation=$scope.operationtype;
														if ('+'==operation) {
															UserHelper.populateNotificationDetailsForOperation($scope);
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data;
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationDetailsForOperation($scope);
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data;
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplate($scope.request).success(function(data, status) {
																$scope.notificationtemplatelist=data;
															});
														
														}else{
															
														}
											  
										  };
										  
										  
										 /*Set Notification Template Setup Configuration operation**/
											$scope.notisendsetup={};
											$scope.notisendingdetails={};
											$scope.notitemplatetypelist=[{id:1, value:'SMS'},
																		{id:2, value:'E-MAIL'},
																		{id:3, value:'NOTIFICATION'},
																		{id:4, value:'ALL'}];
											$scope.notificationtemplatelist={};
											$scope.entitytype='';
											$scope.templatelistforentity={};
											$scope.notisendsetup.templateid='';
											$scope.notisendsetup.setupid='';
											$scope.notificationtemplate={};
											$scope.notisendsetup.isdisabled=false;
											/*select msg applicable for **/
											$scope.$watch('notisendsetup.msgapplicablefor', function(newVal, oldVal){
													angular.forEach($scope.entitylist, function(value, key) {
														if(value.name==newVal){
															$scope.entitytype=newVal;
															NotificationService.getNotificationDetailsForEntity($scope)
															.success(function(data, status) {
																$scope.templatelistforentity=data;
											                	});
														}	
														});
														
														});
											
											$scope.$watch('notisendsetup.templatename', function(newVal, oldVal){
												angular.forEach($scope.templatelistforentity, function(value, key) {
													if(value.templatename==newVal){
														$scope.notisendsetup.templatetext=value.templatetext;
														$scope.notisendsetup.templateid=value.templateid;
														$scope.notificationtemplate=value;
													}	
													});
													
													});
											
												  
										 $scope.getNotificationSendingConfigurationDetails =function(){
										  NotificationService.getNotificationSetupDetails($scope).success(function(data, status) {
																$scope.notisendingdetails=data;
															});
										}
											
										   $scope.addnotificationSendingSetup =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='+';
											  $scope.notisendsetup={};
											  $scope.notisendsetup.isdisabled=false;
											
										  };
										  
										  $scope.updatenotificationSendingSetup =function(notisendsetup){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='*';
											  UserHelper.setRowForNotificationTemplateSetUP($scope,notisendsetup);
											   $scope.notisendsetup.isdisabled=false;
										  };
										  
										  $scope.deletenotificationSendingSetup=function(notisendsetup){
											  $scope.eventoperation='Are you sure want to delete this ';
											  $scope.operationtype='-';
											  $scope.notisendsetup.isdisabled=true;
											  UserHelper.setRowForNotificationTemplateSetUP($scope,notisendsetup);
											   
										  };
										  $scope.searchNotificationSendingSetup =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
										  };
									
										
										  
											/*Set Notification Template Setup details operation**/
										  $scope.setupNotificationSendingForTemplate=function(){
											 
													var operation=$scope.operationtype;
														if ('+'==operation) {
															  UserHelper.populateNotificationSetupDetailsForOperation($scope);
															NotificationService.saveNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data;
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationSetupDetailsForOperation($scope);
															NotificationService.saveNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data;
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationSetupDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data;
															});
														}else{
															
														}
											  
										  };
	}]);
}());