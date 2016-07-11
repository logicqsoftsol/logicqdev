(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AppConstants',function ($scope, $http,  $location, AdminService,AppConstants) {
		
   $scope.selectedRow = null;
		 $scope.graphattendance=[];
		 $scope.request = {};
		 $scope.searchAttendanceTable= function() {
			 AdminService.getAttendanceDetails($scope).success(function(data, status) {
				 $scope.attendancedetails =data;
			});
			};
		 $scope.searchAttendanceDefault= function() {
			 AdminService.getAttendanceDetailsdefault($scope).success(function(data, status) {
				 $scope.attendancedetails =data;
			});
			};	
			
			$scope.searchAttendanceGraph= function() {
				$scope.graphattendance.attedancefor="Students";
				AdminService.getAttendanceCount($scope).success(function(data, status) {
					$scope.attendanceCountdetails = {
			        globals: {
			            shadow: false,
			            fontFamily: "Verdana",
			            fontWeight: "100"
			        },
			        type: "pie",
			        backgroundColor: "#fff",

			        legend: {
			            layout: "x5",
			            position: "50%",
			            borderColor: "transparent",
			            marker: {
			                borderRadius: 10,
			                borderColor: "transparent"
			            }
			        },
			        tooltip: {
			            text: "%v "+data.attendanceFor
			        },
			        plot: {
			            refAngle: "-90",
			            borderWidth: "0px",
			            valueBox: {
			                placement: "in",
			                text: "%npv %",
			                fontSize: "15px",
			                textAlpha: 1,
			            }
			        },
			        series: [{
			            text: "Present",
			            values:[data.presentcount],
			            backgroundColor: "#FA6E6E #FA9494",
			        }, {
			            text: "Absent",
			            values:[data.absentcount],
			            backgroundColor: "#F1C795 #feebd2"
			        }]
			    };	 	
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
									AdminService.searchAllEmployeeList($scope)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};	

				   $scope.saveEmployeeDetails = function() {
									$scope.request.employee={
										idetificationid : $scope.emp.idetificationid,
										basicdetails : {
											title : $scope.emp.title,
											firstName : $scope.emp.firstname,
											middlename : $scope.emp.middlename,
											lastname : $scope.emp.lastname,
											gender : $scope.emp.gender,
											dateofbirth : new Date(
													$scope.emp.dateofbirth),
										},
										contactdetails : {
											addressdetails : {
												addresstext : $scope.emp.address,
												landmark : $scope.emp.landmark,
												city : $scope.emp.city,
												pincode : $scope.emp.pincode,
												state : $scope.emp.state,
												country : $scope.emp.country,
											},
											communicationdetails : {
												mobilenumber : $scope.emp.mobilenumber,
												emailid : $scope.emp.emailid,
												emergencycontactnumber : $scope.emp.emergencycontactnumber,
												communicationtype : $scope.emp.communicationtype
											}
										}

									};
									AdminService.saveEmployeeDetails($scope.request)
											.success(function(data, status) {
												$scope.employelist=data;
											});
								};	
	}]);
}());