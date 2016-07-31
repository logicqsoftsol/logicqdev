
(function () {
	'use strict';
	angular.module('crmlogicq').factory('AttendanceService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			getAttendanceAsGraph: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAttendanceAsGraphURL
															    +'/'+$scope.attendancecriteria.criteriadate+'/'+$scope.attendancecriteria.attedancefor
															    +'/'+$scope.attendancecriteria.mobileno+'/'+$scope.attendancecriteria.cardno,
				dataType :'json',
				data : ''
			})
		},
		getAttendanceAsTabular: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAttendanceAsTabularURL
																	+'/'+$scope.attendancecriteria.criteriadate+'/'+$scope.attendancecriteria.attedancefor
																	+'/'+$scope.attendancecriteria.mobileno+'/'+$scope.attendancecriteria.cardno+'/'+$scope.attendancecriteria.pageSize+'/'+$scope.attendancecriteria.currentPage,
				dataType :'json',
				data : ''
			})
		},
		
		}
		
}]);

}());