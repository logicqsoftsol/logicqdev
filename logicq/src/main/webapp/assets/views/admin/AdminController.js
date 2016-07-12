(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AttendanceService','UserService','GraphHelper','UserHelper','AppConstants',function ($scope, $http,  $location, AdminService,AttendanceService,UserService,GraphHelper,UserHelper,AppConstants) {
		 $scope.display=6;
   $scope.selectedRow = null;
		 $scope.graphattendance=[];
		 $scope.request = {};
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
														

																						
								/* Employee operation* */
								$scope.searchAllEmployeeList = function() {
									UserService.searchAllEmployeeList($scope)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};	

				   $scope.saveEmployeeDetails = function() {
					                UserHelper.populateEmployee($scope);
									UserService.saveEmployeeDetails($scope.request)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};
								
								/* Student operation* */
								  $scope.saveStudentDetails = function() {
									   UserHelper.populateStudent($scope);
									   UserService.saveStudentDetails($scope.request)
															.success(function(data, status) {
																$scope.studentdlist=data;
															});
												};					
								
									/* Student operation* */
								$scope.searchAllStudentList = function() {
									UserService.searchAllStudentList($scope)
											.success(function(data, status) {
												$scope.studentdlist=data;
											});
								};	

				 

								
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