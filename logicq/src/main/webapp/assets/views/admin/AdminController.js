(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$sessionStorage','$rootScope','$http', '$exceptionHandler','$location','AdminService','AttendanceService','UserService','GraphHelper','UserHelper','CalendarService','NotificationService','ClassesSetupService','AppConstants',function ($scope,$sessionStorage,$rootScope,$http,$exceptionHandler,$location,AdminService,AttendanceService,UserService,GraphHelper,UserHelper,CalendarService,NotificationService,ClassesSetupService,AppConstants) {
		 $scope.logedinusername=$sessionStorage.username;
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
		  {id:3, name:'WEEK-DAYS-ONLY'},
		  {id:4, name:'WEEK-ENDS-ONLY'},
          {id:5, name:'FUNCTION'},
          {id:6, name:'VACATION'},
		  {id:7, name:'REGIONAL-FUNCTION'},
		  {id:8, name:'NATIONAL-HOLIDAY'},
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
		$scope.classlist=[
		         		  {id:1, name:'STD 1'},
		         		  {id:2, name:'STD 2'},
		                   {id:3, name:'STD 3'},
		         		  {id:4, name:'STD 4'},
		                   {id:5, name:'STD 5'},
		                   {id:6, name:'STD 6'},
		         		  {id:7, name:'STD 7'},
		         		  {id:8, name:'STD 8'},
		         		  {id:9, name:'STD 9'},
		         		 {id:9, name:'STD 10'},
		         		 { id:9, name:'STD 11'},
		         		 { id:9, name:'STD 12'}];
		$scope.sectionlist=[
		         		  {id:1, value:'A'},
		         		  {id:2, value:'B'},
		                   {id:3, value:'C'},
		         		  {id:4, value:'D'}];
		
		$scope.subjecttypelist=[
		         		  {id:1, name:'ALL'},
		         		  {id:2, name:'COMPULSORY'},
		                   {id:3, name:'OPTIONAL'}];

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
		$scope.sucessmsg='Save Successfully';
		$scope.createmsg='Create Successfully';
		$scope.editmsg='Edit Successfully';
		$scope.deletemsg='Delete Successfully';
		
		//testing
	    	$scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"];
		  $scope.data = [300, 500, 100, 40, 120];
		
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
											 var errormsg='Unable to Populate for Graph  Status Code : '+status;
											 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
											$exceptionHandler(errormsg);
										});
									 GraphHelper.populateExpenseandCollection($scope);
								 };							
				
								 /* DashBoard   Display for calendar**/	
								 $scope.calendardashboard={};
								 $scope.calendardashboardlist={};
								 $scope.getAllCalendarDetailsForDashBoard=function() {
									 $scope.calendardashboard.criteriadate="Next 1months";
									 CalendarService.getAllCalendarListForDashBoard( $scope).success(function(data, status) {
										 $scope.calendardashboardlist=data;
									 }).error(function(data, status) {
										 var errormsg='Unable to Populate for Calnder event details : '+status;
										 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
								 };
					
					/*Attendance details According to page**/	
			$scope.getAttendaceAccordingToPage=function(page) {
				$scope.attendancecriteria.currentPage=page;
				 AttendanceService.getAttendanceAsTabular($scope).success(function(data, status){
					 $scope.attendancedetails=data.attendacedetails;
					 if(null==$scope.attendancecriteria.totalrecordcount){
						 $scope.attendancecriteria.totalrecordcount=data.attendanceCriteria.totalrecordcount;
						 
					}
					$scope.attendancecriteria.numPages= Math.ceil($scope.attendancecriteria.totalrecordcount/$scope.attendancecriteria.pageSize);
					 $scope.numPages=$scope.attendancecriteria.numPages;
				 }).error(function(data, status) {
					 var errormsg='Unable to Find Last 1 day attendance Status Code : '+status;
					 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
					 $exceptionHandler(errormsg);
					});
				};
				
				/*Attendance details As Graph**/
			$scope.getAttendanceAsGraph = function() {
				   $scope.studentattendace={};
				    AttendanceService.getAttendanceAsGraph($scope).success(function(data, status){
					$scope.studentattendace = GraphHelper.populateAttendanceGraph($scope,data);
					}).error(function(data, status) {
						 var errormsg='Unable to Find Last 1 Day attendance  Status Code : '+status;
						 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						$exceptionHandler(errormsg);
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
													 				
												}
												$scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
												$scope.numPages=$scope.emp.numPages;
											}).error(function(data, status) {
												var errormsg='Unable to Search Employee Status Code : '+status;
												 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
												$exceptionHandler(errormsg);
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
													 		
												}
												$scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
												$scope.numPages=$scope.emp.numPages;	
												$rootScope.$emit("callAddAlert", {type:'success',msg:'Employee '+$scope.sucessmsg});
											}).error(function(data, status) {
												var errormsg='Unable to Save Employee Status Code : '+status;
												 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
												$exceptionHandler(errormsg);
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
										 var errormsg='Unable to Find employee details for edit  Status Code : '+status;
										 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										 $exceptionHandler(errormsg);
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
												 
											 }
											 $scope.emp.numPages= Math.ceil($scope.emp.totalrecordcount/$scope.emp.pageSize);
											 $scope.numPages=$scope.emp.numPages;
											 $rootScope.$emit("callAddAlert", {type:'success',msg:'Employee '+$scope.deletemsg});
										}).error(function(data, status) {
											var errormsg='Unable to Delete Employee Status Code : '+status;
											 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
											$exceptionHandler(errormsg);
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
													
												 }
												 $scope.student.numPages= Math.ceil($scope.student.totalrecordcount/$scope.student.pageSize);
												 $scope.numPages=$scope.student.numPages;
											}).error(function(data, status) {
												var errormsg='Unable to Search All Student  Status Code : '+status;
												 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
												$exceptionHandler(errormsg);
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
																	
																 }
																 $scope.student.numPages= Math.ceil($scope.student.totalrecordcount/$scope.student.pageSize);
																  $scope.numPages=$scope.student.numPages;
																  $rootScope.$emit("callAddAlert", {type:'success',msg:'Student '+$scope.sucessmsg});
															}).error(function(data, status) {
																 var errormsg='Unable to Save Student  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																 $exceptionHandler(errormsg);
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
														 var errormsg='Unable to Search Student Details Status Code : '+status;
														 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
														$exceptionHandler(errormsg);
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
															$rootScope.$emit("callAddAlert", {type:'success',msg:'Student '+$scope.deletemsg});
														}).error(function(data, status) {
															 var errormsg='Unable to Delete Student  Status Code : '+status;
															 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
															$exceptionHandler(errormsg);
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
																	 
																 }
																 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																 $scope.numPages=$scope.eventd.numPages;
															 }).error(function(data, status) {
																 var errormsg='Unable to Find Event Details  Status Code : '+status;
																  $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
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
																		 
																	 }
																	 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 $scope.numPages=$scope.eventd.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'EventDetails '+$scope.createmsg});
																}).error(function(data, status) {
																	 var errormsg='Unable to Save Event Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventDetails($scope.request)
																.success(function(data, status) {
																	$scope.eventdetails=data.eventdetails;
																	 if(null==$scope.eventd.totalrecordcount){
																		 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																		 
																	 }
																	 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 $scope.numPages=$scope.eventd.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'EventDetails '+$scope.editmsg});
																}).error(function(data, status) {
																	 var errormsg='Unable to Modifyt Event Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventDetails($scope.request)
															.success(function(data, status) {
																	$scope.eventdetails=data.eventdetails;
																	 if(null==$scope.eventd.totalrecordcount){
																		 $scope.eventd.totalrecordcount=data.eventcriteria.totalrecordcount;
																		 
																	 }
																	 $scope.eventd.numPages= Math.ceil($scope.eventd.totalrecordcount/$scope.eventd.pageSize);
																	 $scope.numPages=$scope.eventd.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'EventDetails '+$scope.deletemsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Delet Event Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
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
																		 
																	 }
																	 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 $scope.numPages=$scope.calendar.numPages;
																}).error(function(data, status) {
																	var errormsg='Unable to search Event Calendar List  Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
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
															$scope.eventcalendarid=null;
															CalendarService.saveEventCalendarDetails($scope.request)
																.success(function(data, status) {
																	$scope.calendardetailslist=data.calendardetailslist;
																	 if(null==$scope.calendar.totalrecordcount){
																		 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																		 
																	 }
																	 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 $scope.numPages=$scope.calendar.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'EventCalendar Details '+$scope.createmsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Add Event Calendar Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
																});
															
															
														}
														else if('*'===operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.saveEventCalendarDetails($scope.request)
																.success(function(data, status) {
																	$scope.calendardetailslist=data.calendardetailslist;
																	 if(null==$scope.calendar.totalrecordcount){
																		 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																		 
																	 }
																	 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																	 $scope.numPages=$scope.calendar.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'Event Calendar Details '+$scope.editmsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Modify Event Calendar Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	$exceptionHandler(errormsg);
																});
															
														}
														else if('-'==operation){
															$scope.eventid=$scope.eventd.eventid;
															CalendarService.deleteEventCalendarDetails($scope.request)
															.success(function(data, status) {
																$scope.calendardetailslist=data.calendardetailslist;
																 if(null==$scope.calendar.totalrecordcount){
																	 $scope.calendar.totalrecordcount=data.calendarcriteria.totalrecordcount;
																	 
																 }
																 $scope.calendar.numPages= Math.ceil($scope.calendar.totalrecordcount/$scope.calendar.pageSize);
																 $scope.numPages=$scope.calendar.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Event Calendar Details '+$scope.deletemsg});
																})
															.error(function(data, status) {
																var errormsg='Unable to delete Event Calendar Details  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
															   $exceptionHandler(errormsg);
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
											$scope.notificationtemplate.numPages='1';
											$scope.notificationtemplate.pagesize='15';
											$scope.notificationtemplate.currentPage=$scope.currentPage;
											
											
											  /* Get All Notification**/
											$scope.getNotificationTemplateListAccordingToPage=function(page){
												$scope.notificationtemplate.currentPage=page;
												NotificationService.getAllNotificationTemplateList($scope)
												.success(function(data, status) {
													$scope.notificationtemplatelist=data.notificationtemplatelist;
													 if(null==$scope.notificationtemplate.totalrecordcount){
														 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
														 
													 }
													 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
													 $scope.numPages=$scope.notificationtemplate.numPages;
								                	}).error(function(data, status) {
								                		var errormsg='Unable to Search Notification Template List  Status Code : '+status;
														 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
														   $exceptionHandler(errormsg);
													});
											  };
										  
											
											if($scope.eventfortemplatelist==null){
											CalendarService.searchAllEventList($scope)
																	.success(function(data, status) {
																		$scope.eventfortemplatelist=data.eventdetails;
														}).error(function(data, status) {
															var errormsg='Unable to Search EventList Status Code : '+status;
															 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
															   $exceptionHandler(errormsg);
														});
												};
									
												
											/*select Notification Template  details**/
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
																	 
																 }
																 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 $scope.numPages=$scope.notificationtemplate.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Details '+$scope.createmsg});
															}).error(function(data, status) {
																var errormsg='Unable to Save Notification Template List  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationDetailsForOperation($scope);
															NotificationService.saveNotificationTemplate($scope.request)
															.success(function(data, status) {
																$scope.notificationtemplatelist=data.notificationtemplatelist;
																 if(null==$scope.notificationtemplate.totalrecordcount){
																	 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
																	 
																 }
																 $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 $scope.numPages=$scope.notificationtemplate.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Details '+$scope.editmsg});
															}).error(function(data, status) {
																var errormsg='Unable to Modify Notification Template List  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplate($scope.request).success(function(data, status) {
																$scope.notificationtemplatelist=data.notificationtemplatelist;
																 if(null==$scope.notificationtemplate.totalrecordcount){
																	 $scope.notificationtemplate.totalrecordcount=data.notificationtemplatecriteria.totalrecordcount;
																	
																 }
																  $scope.notificationtemplate.numPages= Math.ceil($scope.notificationtemplate.totalrecordcount/$scope.notificationtemplate.pageSize);
																 $scope.numPages=$scope.notificationtemplate.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Details '+$scope.deletemsg});
															}).error(function(data, status) {
																var errormsg='Unable to Delete Notification Template List  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
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
											$scope.entitytype='';
											$scope.templatelistforentity={};
											$scope.notisendsetup.templateid='';
											$scope.notisendsetup.setupid='';
											$scope.notisendsetup.isdisabled=false;
											$scope.notisendsetup.totalrecordcount=null;
											$scope.notisendsetup.numPages=null;
											$scope.notisendsetup.pageSize=$scope.pageSize;
											$scope.notisendsetup.currentPage=$scope.currentPage;
											
											
											
											/*Search Notification Template*/			  
										 $scope.getNotificationTemplateSetupDetailsAccordingToPage=function(page){
											 $scope.notisendsetup.currentPage=page;
										     NotificationService.getNotificationSetupDetails($scope).success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																 if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 
																 }
																 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 $scope.numPages=$scope.notisendsetup.numPages;
																 
															}).error(function(data, status) {
																var errormsg='Unable to get Notification Setup Details  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
										};
											
											/*select msg applicable for **/
											$scope.$watch('notisendsetup.msgapplicablefor', function(newVal, oldVal){
													angular.forEach($scope.entitylist, function(value, key) {
														if(value.name==newVal){
															$scope.entitytype=newVal;
															NotificationService.getNotificationDetailsForEntity($scope)
															.success(function(data, status) {
																$scope.templatelistforentity=data;
											                	}).error(function(data, status) {
											                		var errormsg='Unable to get Notification Template List For Entity Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	   $exceptionHandler(errormsg);
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
																	 }
																 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 $scope.numPages=$scope.notisendsetup.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.createmsg});
															}).error(function(data, status) {
																var errormsg='Unable to Add Notification Setup Details Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
															
														}
														else if('*'===operation){
															UserHelper.populateNotificationSetupDetailsForOperation($scope);
															NotificationService.saveNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																 }
																 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 $scope.numPages=$scope.notisendsetup.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.editmsg});
															}).error(function(data, status) {
																var errormsg='Unable to Modify Notification Setup Details  Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
														}
														else if('-'==operation){
															UserHelper.populateNotificationSetupDetailsForDelete($scope);
															NotificationService.deleteNotificationTemplateSetup($scope.request)
															.success(function(data, status) {
																$scope.notisendingdetails=data.notisendingdetails;
																if(null==$scope.notisendsetup.totalrecordcount){
																	 $scope.notisendsetup.totalrecordcount=data.notisendingdetailscriteria.totalrecordcount;
																	 
																 }
																 $scope.notisendsetup.numPages= Math.ceil($scope.notisendsetup.totalrecordcount/$scope.notisendsetup.pageSize);
																 $scope.numPages=$scope.notisendsetup.numPages;
																 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.deletemsg});
															}).error(function(data, status) {
																var errormsg='Unable to Delete Notification Setup Details Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																   $exceptionHandler(errormsg);
															});
														}else{
															
														}
											  
										  };
										  
										  /*Subject Details **/	
										  $scope.subject={};
										  $scope.subject.currentPage='';
										  
										  $scope.subjectlist=[];
								
											 $scope.getSubjectListAccordingToPage=function(page){
												 $scope.notisendsetup.currentPage=page;
											    
											};
											
											$scope.searchSubject =function(){
												  $scope.subjectoperation='Looking for Existing';
												  $scope.operationtype='';
											  };
											  
											$scope.addNewSubject=function(){
													$scope.subjectoperation='Add new ';
	                                                $scope.operationtype='+';
													$scope.subject={};
													$scope.subject.subjectid='';
											  };
											  
											  $scope.editExistingSubject =function(subrow){
												  $scope.subjectoperation='Modify Existing';
												    $scope.operationtype='*';
													UserHelper.setRowForSubjectSetup($scope,subrow);
											  };
											 
											  $scope.pouplateSubjectForDelete =function(subrow){
												  $scope.subjectoperation='Are you sure want to delete this ';
												  $scope.operationtype='-';
												  UserHelper.setRowForSubjectSetup($scope,subrow);
											  };
											
											  
											  /*Set Subject  details operation**/
											  $scope.operationSubjectDetail=function(){
												 
														var operation=$scope.operationtype;
															if ('+'==operation) {
																  UserHelper.setSubjectDetails($scope);
																ClassesSetupService.saveSubjectDetails($scope.request)
																.success(function(data, status) {
																	$scope.subjectlist=data.subjectlist;
																	if(null==$scope.subject.totalrecordcount){
																		 $scope.subject.totalrecordcount=data.subjectcriteria.totalrecordcount;
																		 }
																	 $scope.subject.numPages= Math.ceil($scope.subject.totalrecordcount/$scope.subject.pageSize);
																	 $scope.numPages=$scope.subject.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.createmsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Save Subject Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	   $exceptionHandler(errormsg);
																});
																
															}
															else if('*'===operation){
																UserHelper.setSubjectDetails($scope);
																ClassesSetupService.saveSubjectDetails($scope.request)
																.success(function(data, status) {
																	$scope.subjectlist=data.subjectlist;
																	if(null==$scope.subject.totalrecordcount){
																		 $scope.subject.totalrecordcount=data.subjectcriteria.totalrecordcount;
																	 }
																	 $scope.subject.numPages= Math.ceil($scope.subject.totalrecordcount/$scope.subject.pageSize);
																	 $scope.numPages=$scope.subject.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.editmsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Modify Subject Details  Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	   $exceptionHandler(errormsg);
																});
															}
															else if('-'==operation){
																UserHelper.setSubjectDetails($scope);
																ClassesSetupService.deleteExistingSubject($scope.request)
																.success(function(data, status) {
																	$scope.subjectlist=data.subjectlist;
																	if(null==$scope.subject.totalrecordcount){
																		 $scope.subject.totalrecordcount=data.subjectcriteria.totalrecordcount;
																		 
																	 }
																	 $scope.subject.numPages= Math.ceil($scope.subject.totalrecordcount/$scope.subject.pageSize);
																	 $scope.numPages=$scope.subject.numPages;
																	 $rootScope.$emit("callAddAlert", {type:'success',msg:'Notification Sending Setup Details '+$scope.deletemsg});
																}).error(function(data, status) {
																	var errormsg='Unable to Delete Subject Details Status Code : '+status;
																	 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																	   $exceptionHandler(errormsg);
																});
															}
												  
											  };
											  
											
											 /*Classes  Details **/		
											$scope.classes={};
											$scope.classes.currentPage='';
											$scope.classeslist={};
											 $scope.getClassesDetailsAccordingToPage=function(page){
												 $scope.notisendsetup.currentPage=page;
											    
											};	
											
											 /*Classes-Subject Details **/		
											  $scope.applicableyearlist=[
													                      {id: 1,  year : "Current"},
													                      {id: 2,  name : "All"},
													                      {id: 3,  name : "Next 2 years"},
													                      {id: 4,  name : "Next 5 years"}
													                    ];
											$scope.classessubject={};
											$scope.classessubject.currentPage='';
											$scope.classsubdetails={};
										    $scope.compsubjectlist = [];
										    $scope.optionalsubjectlist = [];
										    $scope.classessubjectoperation='';
										    $scope.classessubject.selectedcompsubject = [];
										    $scope.classessubject.selectedoptionalsubject = [];
										    $scope.selectedoptionalsubject='';
											$scope.selectedcompsubject=null;
											$scope.selectedcompsub='';
											$scope.selectedoptsub='';
											 $scope.getClassesDetailsAccordingToPage=function(page){
												 $scope.classessubject.currentPage=page;
											    
											};	
											
											 $scope.getAllSubjectList=function($scope){
												 ClassesSetupService.getAllSubjectList($scope).success(function(data, status) {	
													$scope.compsubjectlist=data.complsorysubjectlist;
													$scope.optionalsubjectlist=data.optionalsubjectlist;													
														 }).error(function(data, status) {
																var errormsg='Unable to Search Subject Details Status Code : '+status;
																 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
																 $exceptionHandler(errormsg);
															});
											    
											};	
											 $scope.$watch('selectedcompsubject',function(){
												 $scope.selectedcompsub='';
												 angular.forEach($scope.selectedcompsubject, function(value, key) {
												   $scope.selectedcompsub=$scope.selectedcompsub+"|"+value.name;
												 });
											});
											 $scope.$watch('selectedoptionalsubject',function(){
												 $scope.selectedoptsub='';
												 angular.forEach($scope.selectedoptionalsubject, function(value, key) {
												  $scope.selectedoptsub=$scope.selectedoptsub+"|"+value.name;
												});
											});
											
											$scope.searchClassSubject =function(){
												  $scope.classessubjectoperation='Looking for Existing';
												  $scope.operationtype='';
											  };
											  
											$scope.setupClassSubject=function(){
													$scope.classessubjectoperation='Setup new ';
	                                                $scope.operationtype='+';
													$scope.classessubject={};
													$scope.getAllSubjectList($scope);
													//$scope.subject.subjectid='';
											  };
											  
											  $scope.editClassSubjectSetup =function(classssub){
												  $scope.classessubjectoperation='Modify Existing';
												    $scope.operationtype='*';
													$scope.getAllSubjectList($scope);
												//	UserHelper.setRowForSubjectSetup($scope,classssub);
											  };
											 
											  $scope.pouplateClassSubjectForDelete =function(classssub){
												  $scope.classessubjectoperation='Are you sure want to delete this ';
												  $scope.operationtype='-';
												 
												 // UserHelper.setRowForSubjectSetup($scope,classssub);
											  };
											
											/* export report details---*/
											$scope.exportdata={};
											$scope.exportdata.applicableto='';
											 $scope.isReportExportApplicable = function(reportapplicableto) {
											 return reportapplicableto === $scope.exportdata.applicableto;
											    };
											
											$scope.downloadAttendaceReport=function(){			
												switch($scope.exportdata.exporttype){
												case 'XLS':
												{
													AdminService.downloadReport($scope).success(function(response) {
														var xlsinput = new Blob([response]); 
														window.navigator.msSaveOrOpenBlob(xlsinput, 'attendancereport.xlsx'); 
													});
												};
												break;
												case 'CSV':
												{
													AdminService.downloadReport($scope).success(function(response) {
														var csvData = new Blob([response]); 
														const url = URL.createObjectURL(csvData);
														const link = document.createElement('a');
														link.href = url;
														link.style = 'visibility:hidden';
														link.download = $scope.exportdata.exportfor+'.csv';
														document.body.appendChild(link);
														link.click();
														document.body.removeChild(link);
													});
												};
												break;
												case 'PDF':
												{
													AdminService.downloadReport($scope).success(function(response) {
														var file = new Blob([response]);
														window.navigator.msSaveOrOpenBlob(file, 'attendancereport.pdf');        


													});
												};
												break;
												default:
													break;
												}
											    
											};
											 /*download file  Details **/	
											 
									
											
											
	
	}]);
}());