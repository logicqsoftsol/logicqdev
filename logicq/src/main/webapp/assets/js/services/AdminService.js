
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
			
			searchSMSTemplate: function (request) {
				return $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.searchSMSTemplate,
					headers: {'Content-Type': 'application/json','AUTH-TOKEN':AuthenticationService.getAuthenticationToken} ,
					dataType : 'json',
					data : ''
				})
			}, 
		}
}]);

}());