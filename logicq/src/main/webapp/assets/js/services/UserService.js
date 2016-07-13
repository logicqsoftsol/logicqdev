
(function () {
	'use strict';
	angular.module('crmlogicq').factory('UserService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			/*Employee Details*/
			searchAllEmployeeList: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchAllEmployeeListURL,
					dataType :'json',
					data : ''
				})
			},	
			saveEmployeeDetails: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveEmployeeDetailsURL;
				return  $http.post(url,request.employee)
			},
			
			searchEmployeeDetails: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchEmployeeDetailsURL+'/'+$scope.selectedemployee,
					dataType :'json',
					data : ''
				})
			},
			
			/*Student Details*/
			
			searchAllStudentList: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchAllStudentListURL,
					dataType :'json',
					data : ''
				})
			},	
			saveStudentDetails: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveStudentDetailsURL;
				return  $http.post(url,request.student)
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