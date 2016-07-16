(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AttendanceService','UserService','GraphHelper','UserHelper','CalendarService','AppConstants',function ($scope, $http,  $location, AdminService,AttendanceService,UserService,GraphHelper,UserHelper,CalendarService,AppConstants) {
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
			
			/*calendar and event details**/
		     $scope.editEventDetails= function(event) {
				 $scope.event.eventname=event.name;
				 $scope.event.eventtype=event.type;
				 $scope.event.applicablefor=event.applicablefor;
				};	
			
			$scope.saveEventDetails= function() {
				AdminService.saveEventDetails($scope).success(function(data, status) {
					alert('Save  Sucess Fully');
				        });
					};		
					
		   $scope.deleteEventDetails= function(event) {
			   AdminService.deleteEventDetails($scope).success(function(data, status) {
					alert('Delete  Sucess Fully');
						        });
							};		
					
							$scope.getAllEventDetails= function() {
								AdminService.getAllEventDetails($scope).success(function(data, status) {
								  $scope.eventdetails =data;
								 });
							};					
			
							
							$scope.getCalendarDetailsforCriteria= function() {
								AdminService.getCalendarDetailsforCriteria($scope).success(function(data, status) {
								  $scope.eventdetails =data;
								 });
							};	
							
							$scope.saveCalendarDetails= function(calendar) {
								AdminService.saveCalendarDetails($scope).success(function(data, status) {
								 alert('save sucess fully');       
								});
									};	
									
									$scope.editCalendarDetails= function(calendar) {
										 $scope.calendar.eventname=calendar.eventname;
										 $scope.calendar.eventtype=calendar.eventtype;
										 $scope.calendar.applicablefor=calendar.applicablefor;
										 $scope.calendar.eventstartdate=calendar.eventstartdate;
										 $scope.calendar.eventenddate=calendar.eventenddate;
										 $scope.calendar.comments=calendar.comments;
									 };	
									   $scope.deleteCalendarDetails= function(event) {
										   AdminService.deleteCalendarDetails($scope).success(function(data, status) {
								         alert('delete sucess fully');
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
													
													
										/*Event Details and Calendar Details**/	
												$scope.eventd={};
												$scope.eventd.eventid='';
												$scope.eventoperation='';
												$scope.eventoperationtype='';
												
											$scope.searchAllEventList=	function() {
														CalendarService.searchAllEventList($scope)
																.success(function(data, status) {
																	$scope.eventdetails=data;
																});
													};
												
												/*Add Event Details**/
											 $scope.addEventDetails= function() {
													 $scope.eventoperation='Create New';
                                                     $scope.eventoperationtype='+';
													};
													
													/*Edit Event Details**/
											$scope.editEventDetails= function() {
													 $scope.eventoperation='Edit Existing';
													 $scope.eventoperationtype='*';
													};
													
													/*Search Event Details**/
											$scope.searchEventDetails= function() {
													 $scope.eventoperation='Looking for Existing';
													  $scope.eventoperationtype='';
													
													};
													
													/*Delete Event Details**/
                                               $scope.deleteEventDetails=function(eventd) {
													 $scope.eventoperation='Are you sure want to delete this  ';
													 $scope.eventoperationtype='-';
													};
													
													/*Populate Event Details for row clicked**/
													 $scope.setClickedEventDetails=function(eventd) {
														 UserHelper.populateEventDetailsForRowClick($scope,eventd);
													 };
													
													/*Operation Event Details**/
													$scope.operationEventDetail=function(){
														var operation=$scope.eventoperationtype;
														$scope.request.eventd={};
														UserHelper.populateEventDetailsForOperation($scope);
														if ('+'==operation) {
															$scope.eventid='';
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
														}else{
															
														}
													};
													
							
	}]);
}());