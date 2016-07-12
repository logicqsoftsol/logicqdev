
(function () {
	'use strict';
	angular.module('crmlogicq').factory('AttendanceService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			
			getAttendanceDetails: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchattendanceURL+'/'+$scope.attendancecriteria.id+'/'+$scope.attendancecriteria.mobileno+'/'+$scope.attendancecriteria.cardno+'/'+$scope.attendancecriteria.fromdate+'/'+$scope.attendancecriteria.todate,
					dataType :'json',
					data : ''
				})
			},
			getAttendanceDetailsdefault: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchcurrentAttedanceURL,
					dataType :'json',
					data : ''
				})
			},

			getAttendanceCount: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getattendanceCountURL+'/'+$scope.graphattendance.attedancefor+'/'+$scope.graphattendance.fromdate+'/'+$scope.graphattendance.todate,
				dataType :'json',
				data : ''
			})
		},
		}
		
}]);

}());