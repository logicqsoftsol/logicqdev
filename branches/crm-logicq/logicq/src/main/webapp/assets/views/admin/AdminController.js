(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AppConstants',function ($scope, $http,  $location, AdminService,AppConstants) {
		 $scope.selectedRow = null;
		 $scope.graphattendance=[];
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
			
	}]);
}());