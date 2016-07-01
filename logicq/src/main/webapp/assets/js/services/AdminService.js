
(function () {
	'use strict';
	angular.module('crmlogicq').factory('AdminService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

	return {

		showReport: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.showReportURL;
			return  $http.post(url,$scope.request)
		}
	}
}]);

}());