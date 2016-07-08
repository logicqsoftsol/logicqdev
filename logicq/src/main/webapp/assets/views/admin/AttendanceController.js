(function () {
	'use strict';
	angular.module('crmlogicq').controller('AttendanceController',['$scope','$http', '$location', 'AttendanceService','AppConstants',function ($scope, $http,  $location, AttendanceService,AppConstants) {
		 
		 $scope.searchAttendance= function() {
			 AttendanceService.getAttendanceDetails($scope).success(function(data, status) {
				 $scope.attendancedetails = data;
			});
			};
		 
		 
		$scope.attendancedetails = {
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
			            text: "%v students"
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
			            values: [870],
			            backgroundColor: "#FA6E6E #FA9494",
			        }, {
			            text: "Absent",
			            values: [130],
			            backgroundColor: "#F1C795 #feebd2"
			        }]
			    };	 	
		
	}]);
}());