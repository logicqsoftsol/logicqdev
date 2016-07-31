(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$exceptionHandler','$location', 'AdminService','AttendanceService','UserService','GraphHelper','UserHelper','CalendarService','NotificationService','AppConstants',function ($scope, $http,$exceptionHandler,$location, AdminService,AttendanceService,UserService,GraphHelper,UserHelper,CalendarService,NotificationService,AppConstants) {
		$scope.display=6;
		 $scope.totalrecordcount=null;
		 $scope.currentPage = 1;
	     $scope.numPages = 1;
	     $scope.pageSize = 15;
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
		  {id:10, name:'ATTENDANCE'},
		  {id:11, name:'OTHER'}
        ];
		 
		 $scope.criteriadatelist=[ {id:1, value:'Last 1days'},
		                           {id:1, value:'Last 2days'},
		                           {id:1, value:'Last 3days'},
		                           {id:1, value:'Last 4days'},
		                 		  {id:2, name:'Last 1weeks'},
		                          {id:3, name:'Last 2weeks'},
		                          {id:3, name:'Last 3weeks'},
		                		  {id:4, name:'Last 1months'},
		                          {id:5, name:'Last 2months'},
		                          {id:6, name:'Last 4months'},
		                		  {id:7, name:'Last 6months'},
		                		  {id:8, name:'Last 1years'},
		                		  {id:9, name:'Last 2years'}];
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

		$scope.attendancecriteria={};
		$scope.studentattendace={};
		$scope.employeattendace={};
		$scope.attendancedetails={};
		$scope.attendancecriteria.criteriadate ='Last1days';
		$scope.attendancecriteria.attedancefor ='EMPSTD';
		$scope.attendancecriteria.mobileno='ISEMPTY';
		$scope.attendancecriteria.cardno='ISEMPTY';
		$scope.attendancecriteria.totalrecordcount=null;
		$scope.attendancecriteria.numPages=$scope.numPages;
		$scope.attendancecriteria.pageSize=$scope.pageSize;
		$scope.attendancecriteria.currentPage=$scope.currentPage;
		
		
		
								/* DashBoard   Display**/				
								 $scope.displayDashBoard = function() {
									 AttendanceService.getAttendanceAsGraph($scope).success(function(data, status) {
										 $scope.studentattendace={};
										 $scope.employeattendace={};
										angular.forEach(data,function(value,index){
												if(value.applicablefor=="STUDENT"){
													$scope.studentattendace=GraphHelper.populateAttendanceGraph($scope,value);
												}
                                                if(value.applicablefor=="EMPLOYEE"){
													$scope.employeattendace=GraphHelper.populateAttendanceGraph($scope,value);
											    }
											});
									
										}).error(function(data, status) {
											$exceptionHandler('Unable to Populate for Graph ',' Status Code : '+status);
										});
									 GraphHelper.populateExpenseandCollection($scope);
								 };							
				
					
					/*Attendance details According to page**/	
			$scope.getAttendaceAccordingToPage=function(page) {
				$scope.attendancecriteria.currentPage=page;
				 AttendanceService.getAttendanceAsTabular($scope).success(function(data, status){
					 $scope.attendancedetails=data.attendacedetails;
					 if(null==$scope.attendancecriteria.totalrecordcount){
						 $scope.attendancecriteria.totalrecordcount=data.attendanceCriteria.totalrecordcount;
						 $scope.attendancecriteria.numPages= Math.ceil($scope.attendancecriteria.totalrecordcount/$scope.attendancecriteria.pageSize);
					 }
				 }).error(function(data, status) {
						$exceptionHandler('Unable to Find Last 1 day attendance ',' Status Code : '+status);
					});
				};
				
				/*Attendance details As Graph**/
			$scope.getAttendanceAsGraph = function() {
				   $scope.studentattendace={};
				    AttendanceService.getAttendanceAsGraph($scope).success(function(data, status){
					$scope.studentattendace = GraphHelper.populateAttendanceGraph($scope,data);
					}).error(function(data, status) {
						$exceptionHandler('Unable to Find Last 1 Day attendance ',' Status Code : '+status);
					});
				};
																						
								/* Employee operation**/		
								   $scope.emp.basicdetailid='';
								   $scope.emp.contactdetailid='';
								   $scope.emp.addressdetailid='';
								   $scope.emp.communicationdetailid='';	
								   $scope.emp.totalrecordcount=null;
								   $scope.emp.numPages=$scope.numPages;
								   $scope.emp.pageSize=$scope.pageSize;
								   $scope.emp.currentPage=$scope.currentPage;
								/* Search Employee**/
								$scope.searchAllEmployeeListAccordingToPage=function(page) {
									$scope.emp.currentPage=page;
									UserService.searchAllEmployeeList($scope)
											.success(function(data, status) {
												$scope.employelist=data.employeelist;
												 if(null==$scope.emp.totalrecordcount){
													 $scope.emp.totalrecordcount=data.employeecriteria.totalrecordcount;
													 $scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
												 }
											}).error(function(data, status) {
												$exceptionHandler('Unable to Search Employee ',' Status Code : '+status);
											});
								};	
								
								/*Save Employee**/
            				   $scope.saveEmployeeDetails = function() {
					                UserHelper.populateEmployeeForSave($scope);
									UserService.saveEmployeeDetails($scope.request)
											.success(function(data, status) {
												$scope.employelist=data.employeelist;
												 if(null==$scope.emp.totalrecordcount){
													 $scope.emp.totalrecordcount=data.employeecriteria.totalrecordcount;
													 $scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
												 }
											}).error(function(data, status) {
												$exceptionHandler('Unable to Save Employee ',' Status Code : '+status);
											});
								};
								
								
								/*New Employee**/
								 $scope.newEmployee =  function() {
									// $scope.emp.userid=null;
									 $scope.emp={};
									 $scope.selectedemployee=null;
								 };
								
								/*Edit Employee**/
								 $scope.editForEmployee =  function(emp) {
									 $scope.selectedemployee=emp.id;
									UserService.searchEmployeeDetails($scope).success(function(data, status) {
										 UserHelper.populateEmployeeForEdit($scope,data);
									}).error(function(data, status) {
										$exceptionHandler('Unable to Find employee details for edit ',' Status Code : '+status);
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
											$scope.employelist=data.employeelist;
											 if(null==$scope.emp.totalrecordcount){
												 $scope.emp.totalrecordcount=data.employeecriteria.totalrecordcount;
												 $scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
											 }
										}).error(function(data, status) {
											$exceptionHandler('Unable to Delete Employee ',' Status Code : '+status);
										});
								 };
								
								/* Student operation* */
								   $scope.student.basicdetailid='';
								   $scope.student.contactdetailid='';
								   $scope.student.addressdetailid='';
								   $scope.student.communicationdetailid='';
								   $scope.student.totalrecordcount=null;
								   $scope.student.numPages=$scope.numPages;
								   $scope.student.pageSize=$scope.pageSize;
								   $scope.student.currentPage=$scope.currentPage;
								/* Search Student**/
								$scope.searchAllStudentListAccordingToPage = function(page) {
									 $scope.student.currentPage=page;
									UserService.searchAllStudentList($scope)
											.success(function(data, status) {
												$scope.studentdlist=data.studentlist;
												if(null==$scope.student.totalrecordcount){
													$scope.student.totalrecordcount=data.studentcriteria.totalrecordcount;
													$scope.student.numPages= Math.ceil($scope.student.totalrecordcount/$scope.student.pageSize);
												 }
											}).error(function(data, status) {
												$exceptionHandler('Unable to Search All Student ',' Status Code : '+status);
											});
								};	
								
								/*Save Student**/
								  $scope.saveStudentDetails = function() {
								
									   UserHelper.populateStudentForSave($scope);
									   UserService.saveStudentDetails($scope.request)
															.success(function(data, status) {
																$scope.studentdlist=data.studentlist;
																if(null==$scope.student.totalrecordcount){
																	$scope.student.totalrecordcount=data.studentcriteria.totalrecordcount;
																	$scope.student.numPages= Math.ceil($scope.student.totalrecordcount/$scope.student.pageSize);
																 }
															}).error(function(data, status) {
																$exceptionHandler('Unable to Save Student ',' Status Code : '+status);
															});
												};					
												
												/*New Student**/
												 $scope.newStudent =  function() {
													 $scope.student={};
													 $scope.selectedstudent=null;
												 };	
												
												 /*Edit Student**/
												 $scope.editForStudent =  function(student) {
													 $scope.selectedstudent=student.id;
													UserService.searchStudentDetails($scope).success(function(data, status) {
														 UserHelper.populateStudentForEdit($scope,data);
													}).error(function(data, status) {
														$exceptionHandler('Unable to Search Student Details ',' Status Code : '+status);
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
															$scope.studentdlist=data.studentlist;
														}).error(function(data, status) {
															$exceptionHandler('Unable to Delete Student ',' Status Code : '+status);
														});
													};
													
													
										 /*Event Details**/	
												$scope.eventd={};
												$scope.eventd.eventid='';
												$scope.eventoperation='';
												$scope.operationtype='';
												$scope.eventid='';
												$scope.eventd.totalrecordcount=null;
												$scope.eventd.numPages=$scope.numPages;
												$scope.eventd.pageSize=$scope.pageSize;
												$scope.eventd.currentPage=$scope.currentPage;
										
											         	
													/* Search All Event List According to Page*/
													  $scope.getAllEventDetailsAccordingToPage=function(page) {
														  $scope.eventd.currentPage=page;
															CalendarService.searchAllEventList($scope).success(function(data, status){
																$scope.eventdetails=data.eventdetails;
																 if(null==$scope.eventd.totalrecordcount){
																	 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																	 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																 }
															 }).error(function(data, status) {
																	$exceptionHandler('Unable to Find Event Details ',' Status Code : '+status);
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
																	$scope.eventdetails=data.eventdetails;
																	 if(null==$scope.eventd.totalrecordcount){
																		 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																		 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to Save Event Details',' Status Code : '+status);
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventDetails($scope.request)
																.success(function(data, status) {
																	$scope.eventdetails=data.eventdetails;
																	 if(null==$scope.eventd.totalrecordcount){
																		 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																		 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to Modifyt Event Details',' Status Code : '+status);
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventDetails($scope.request)
															.success(function(data, status) {
																	$scope.eventdetails=data.eventdetails;
																	 if(null==$scope.eventd.totalrecordcount){
																		 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																		 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to Delet Event Details',' Status Code : '+status);
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
												$scope.calendar.totalrecordcount=null;
												$scope.calendar.numPages=$scope.numPages;
												$scope.calendar.pageSize=$scope.pageSize;
												$scope.calendar.currentPage=$scope.currentPage;
													/*Search all calnder details*/
													$scope.getAllCalendarDetailsAccordingToPage=function(page) {
														 $scope.calendar.currentPage=page;
															CalendarService.searchAllEventCalendarList($scope)
																.success(function(data, status) {
																	$scope.calendardetailslist=data.calendardetailslist;
																	 if(null==$scope.calendar.totalrecordcount){
																		 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																		 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to search Event Calendar List',' Status Code : '+status);
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
																	$scope.calendardetailslist=data.calendardetailslist;
																	 if(null==$scope.calendar.totalrecordcount){
																		 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																		 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to Add Event Calendar Details',' Status Code : '+status);
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventCalendarDetails($scope.request)
																.success(function(data, status) {
																	$scope.calendardetailslist=data.calendardetailslist;
																	 if(null==$scope.calendar.totalrecordcount){
																		 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																		 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 }
																}).error(function(data, status) {
																	$exceptionHandler('Unable to Modify Event Calendar Details',' Status Code : '+status);
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventCalendarDetails($scope.request)
															.success(function(data, status) {
																$scope.calendardetailslist=data.calendardetailslist;
																 if(null==$scope.calendar.totalrecordcount){
																	 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																	 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																 }
																})
															.error(function(data, status) {
															   $exceptionHandler('Unable to delete Event Calendar Details ',' Status Code : '+status);
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
											$scope.notificationtemplate.totalrecordcount=null;
											$scope.notificationtemplate.numPages=$scope.numPages;
											$scope.notificationtemplate.pageSize=$scope.pageSize;
											$scope.notificationtemplate.currentPage=$scope.currentPage;
											
											
											  /* Get All Notification**/
											$scope.getNotificationTemplateListAccordingToPage=function(page){
												$scope.notificationtemplate.currentPage=page;
												NotificationService.getAllNotificationTemplateList($scope)
												.success(function(data, status) {
													$scope.notificationtemplatelist=data.notificationtemplatelist;
													 if(null==$scope.notificationtemplate.totalrecordcount){
														 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
														 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
													 }
								                	}).error(function(data, status) {
														   $exceptionHandler('Unable to Search Notification Template List ',' Status Code : '+status);
													});
											  };
										  
											
											if($scope.eventfortemplatelist==null){
											CalendarService.searchAllEventList($scope)
																	.success(function(data, status) {
																		$scope.eventfortemplatelist=data;
														}).error(function(data, status) {
															   $exceptionHandler('Unable to Search EventList ',' Status Code : '+status);
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
										  
											  
											
											/*Set Notification Template  details operation**/
										  $scope.setupTemplateForNotification=function(){
											   
													var operation=$scope.operationtype;
														if ('+'==operation) {
															UserHelper.populateNotificationDetailsForOperation($scope);
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data.notificationtemplatelist;
																 if(null==$scope.notificationtemplate.totalrecordcount){
																	 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
																	 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Save Notification Template List ',' Status Code : '+status);
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationDetailsForOperation($scope);
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data.notificationtemplatelist;
																 if(null==$scope.notificationtemplate.totalrecordcount){
																	 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
																	 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Modify Notification Template List ',' Status Code : '+status);
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplate($scope.request).success(function(data, status) {
																$scope.notificationtemplatelist=data.notificationtemplatelist;
																 if(null==$scope.notificationtemplate.totalrecordcount){
																	 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
																	 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Delete Notification Template List ',' Status Code : '+status);
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
											$scope.notisendsetup.totalrecordcount=null;
											$scope.notisendsetup.numPages=$scope.numPages;
											$scope.notisendsetup.pageSize=$scope.pageSize;
											$scope.notisendsetup.currentPage=$scope.currentPage;
											/*select msg applicable for **/
											$scope.$watch('notisendsetup.msgapplicablefor', function(newVal, oldVal){
													angular.forEach($scope.entitylist, function(value, key) {
														if(value.name==newVal){
															$scope.entitytype=newVal;
															NotificationService.getNotificationDetailsForEntity($scope)
															.success(function(data, status) {
																$scope.templatelistforentity=data;
											                	}).error(function(data, status) {
																	   $exceptionHandler('Unable to get Notification Template List For Entity',' Status Code : '+status);
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
											
												  
										 $scope.getNotificationTemplateSetupDetailsAccordingToPage=function(page){
											 $scope.notisendsetup.currentPage=page;
										  NotificationService.getNotificationSetupDetails($scope).success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																 if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to get Notification Setup Details ',' Status Code : '+status);
															});
										};
											
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
																$scope.notisendingdetails=data.notisendingdetails;
																if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Add Notification Setup Details ',' Status Code : '+status);
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationSetupDetailsForOperation($scope);
															NotificationService.saveNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Modify Notification Setup Details ',' Status Code : '+status);
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationSetupDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 }
															}).error(function(data, status) {
																   $exceptionHandler('Unable to Delete Notification Setup Details ',' Status Code : '+status);
															});
														}else{
															
														}
											  
										  };
	
	}]);
}());