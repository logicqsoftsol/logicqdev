
(function () {
	'use strict';
	angular.module('crmlogicq').factory('AttendanceService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			getAttendanceDetails : function($scope) {
				return $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchattendanceURL,
					headers: {'Content-Type': 'application/json','AUTH-TOKEN':AuthenticationService.getAuthenticationToken} ,
					dataType : 'json',
					data : $scope.searchcriteria
				});
			}
		}
		
}]);

}());