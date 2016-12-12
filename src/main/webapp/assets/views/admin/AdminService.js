
(function () {
	'use strict';
	angular.module('mlmlogicq').factory('AdminService', ['$http','AppConstants' ,function ($http ,AppConstants){

		return {
			
		updateAdminTask: function (request) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.updateAdminTaskURL;
			return  $http.post(url,request.task)
		}
		
		}
}]);

}());