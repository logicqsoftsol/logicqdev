
(function () {
	'use strict';
	angular.module('crmlogicq').factory('AdminService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			addSMSTemplate:function ($scope){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.addSMSTemplate;
				return  $http.post(url,request)
			},
			
			updateSMSTemplate: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.updateSMSTemplate;
				return  $http.post(url,request)

			},
			
			deleteSMSTemplate: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteSMSTemplate;
				return  $http.post(url,request)

			}, 
			
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