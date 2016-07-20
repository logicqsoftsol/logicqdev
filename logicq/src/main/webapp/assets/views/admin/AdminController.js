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
		 $scope.eventtyplist=[
          {id:1, name:'ANNUAL EXAM'},
          {id:2, name:'MID-SEM EXAM'},
          {id:3, name:'DURGA PUJA/DUSSEHRA'},
          {id:4, name:'SUMMER VACATION'},
		  {id:5, name:'GANESH PUJA'},
		  {id:6, name:'ANNUAL FUNCTION'},
        ];
		$scope.entitylist=[
		  {id:1, name:'ALL'},
		  {id:1, name:'STUDENT'},
          {id:2, name:'TEACHER'},
          {id:3, name:'CONTRACTOR'},
          {id:4, name:'VENDOR'},
		  {id:5, name:'EMPLOYEE(permanent)'},
		  {id:6, name:'EMPLOYEE(contract)'}];
		  
		
		
		
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
								
								/*Set selected row for Employee**/
								 $scope.setClickedRowForEmp =  function(emp) {
									$scope.selectedemployee=emp.id;
								};
								
								
								/*New Employee**/
								 $scope.newEmployee =  function() {
									// $scope.emp.userid=null;
									 $scope.emp={};
									 $scope.selectedemployee=null;
								 }
								
								/*Edit Employee**/
								 $scope.editForEmployee =  function() {
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
								
								
												/*Set selected row for student**/
												 $scope.setClickedRowForStudent =  function(student) {
													$scope.selectedstudent=student.id;
												};
												
											
												
												/*New Student**/
												 $scope.newStudent =  function() {
													 $scope.student={};
													 $scope.selectedstudent=null;
												 }		
												
												 /*Edit Student**/
												 $scope.editForStudent =  function() {
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
													
													};
													
													/*Edit Event Details**/
											$scope.editEventDetails= function() {
													 $scope.eventoperation='Edit Existing';
													 $scope.operationtype='*';
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
													// UserHelper.populateEventDetailsForRowClick($scope,eventd);
													 $scope.request.eventd=eventd;
													};
													
													/*Populate Event Details for row clicked**/
													 $scope.setClickedEventDetails=function(eventd) {
														 UserHelper.populateEventDetailsForRowClick($scope,eventd);
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
												$scope.addEventCalendarDetails=	function() {
													$scope.eventoperation='Setup new ';
                                                     $scope.operationtype='+';
													 $scope.eventdetailslist=$scope.eventdetails;
														
													};
												
												/*Edit Event calender details**/	
                                                 $scope.editEventCalendarDetails=	function() {
														$scope.eventoperation='Modify Existing';
													    $scope.operationtype='*';
														$scope.eventdetailslist=$scope.eventdetails;
													};
													
													/*Search Event calender details**/
                                                  $scope.searchEventCalendarDetails=	function() {
													  $scope.eventoperation='Looking for Existing';
													  $scope.operationtype='';
													
													};		
													
													/*Delete Event calender details**/
                                                $scope.deleteEventCalendarDetails=	function(calander) {
													 $scope.eventoperation='Are you sure want to delete this ';
													 $scope.operationtype='-';
													$scope.readonlyprop='readonly';
													
													};	

													/*Set Event calender details row**/
                                                $scope.setClickedRowForEventCalendarDetails=function(calander) {
														UserHelper.setClickedRowForEventCalendarDetails($scope,calander);
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
															CalendarService.deleteEventCalendar($scope.request)
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
											
													/* Fetch all event list*/
												if(null==$scope.eventfortemplatelist){
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
									
												
										  };
										  $scope.editNotificationTemplate =function(){
											  $scope.eventoperation='Modify Existing';
											    $scope.operationtype='*';
											
													
											
										  };
										  $scope.searchNotificationTemplate =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
										  };
										  
										  $scope.deleteTemplateForNotification=function(notificationtemplate){
											  $scope.eventoperation='Are you sure want to delete this ';
											  $scope.operationtype='-';
										  };
										  
										  $scope.setRowForNotificationTemplate=function(notificationtemplate){
											  UserHelper.setRowForNotificationTemplate($scope,notificationtemplate);
											  };	
											  
											  /* Get All Notification**/
											$scope.getAllNotificationTemplateList=function(){
												NotificationService.getAllNotificationTemplateList($scope)
												.success(function(data, status) {
													$scope.notificationtemplatelist=data;
								                	});
											  };
										  
											/*Set Event calender details operation**/
										
										  $scope.setupTemplateForNotification=function(){
											   UserHelper.populateNotificationDetailsForOperation($scope);
													var operation=$scope.operationtype;
														if ('+'==operation) {
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data;
															});
															
														}
														else if('*'===operation){
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																//UserHelper.populateUINotificationTemplate(,data);
																$scope.notificationtemplatelist=data;
															});
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
														
														}else{
															
														}
											  
										  };
										  
										  
										 /*Set Notification Template Setup Configuration operation**/
											$scope.notisendsetup={};
											$scope.notificationsendingsetupdetails={};
											$scope.notificationtemplate.eventid='';
											$scope.notitemplatetypelist=[{id:1, value:'SMS'},
																		{id:2, value:'E-MAIL'},
																		{id:3, value:'NOTIFICATION'},
																		{id:4, value:'ALL'}];
											$scope.notificationtemplatelist={};
											
										   $scope.addnotificationSendingSetup =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
											
										  };
										  
										  $scope.updatenotificationSendingSetup =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
										  };
										  $scope.searchNotificationSendingSetup =function(){
											  $scope.eventoperation='Looking for Existing';
											  $scope.operationtype='';
										  };
							$scope.setRowForNotificationSendingSetup =function(notisendsetup){
											 
										  };
	}]);
}());