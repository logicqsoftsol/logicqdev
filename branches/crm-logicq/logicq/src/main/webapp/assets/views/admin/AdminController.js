(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AttendanceService','UserService','GraphHelper','UserHelper','AppConstants',function ($scope, $http,  $location, AdminService,AttendanceService,UserService,GraphHelper,UserHelper,AppConstants) {
		 $scope.display=6;
		 $scope.graphattendance=[];
		 $scope.request = {};
		 $scope.selectedemployee='';
		 $scope.emp={};
		 $scope.selectedstudent='';
		 $scope.student={};
		
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
								 $scope.setClickedRowForEmp =  function(empreg) {
									$scope.selectedemployee=empreg.id;
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
								
								/* Student operation* */
								
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
			
	}]);
}());