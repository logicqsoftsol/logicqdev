
(function () {
	'use strict';
	angular.module('crmlogicq').factory('NotificationService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {
			saveNotificationTemplate:function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveNotificationTemplateURL;
				return  $http.post(url,request.notificationtemplate)
			},
			getAllNotificationTemplateList: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getNotificationTemplatesURL+'/'+$scope.notitemp.pageSize+'/'+$scope.notitemp.currentPage,
					dataType :'json',
					data : ''
				})
			},
			deleteNotificationTemplate: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteNotificationTemplateURL;
				return  $http.post(url,request.notificationtemplate)
			},
			saveNotificationTemplateSetup: function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveNotificationTemplateSetupURL;
				return  $http.post(url,request.notisendsetup)
			},
			getNotificationSetupDetails: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getNotificationSetupDetailsURL+'/'+$scope.notisendsetup.pageSize+'/'+$scope.notisendsetup.currentPage,
					dataType :'json',
					data : ''
				})
			},
			deleteNotificationTemplateSetup: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteNotificationTemplateSetupURL;
				return  $http.post(url,request.notisendsetup)
			},
			getNotificationDetailsForEntity: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getNotificationDetailsForEntityURL+'/'+$scope.entitytype,
					dataType :'json',
					data : ''
				})
			},
			
		}
}]);

}());