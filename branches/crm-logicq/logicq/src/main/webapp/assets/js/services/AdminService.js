
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
		saveEventDetails:function ($scope){
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveEventDetailsURL;
			return  $http.post(url,request)
		},
		
		deleteEventDetails: function (request) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteEventDetailsURL;
			return  $http.post(url,request)

		},
		getAllEventDetails: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllEventDetailsURL,
				dataType :'json',
				data : ''
			})
		},
	
		
		getAllCalendarDetails: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllCalendarDetailsURL,
				dataType :'json',
				data : ''
			})
		},
		getCalendarDetailsforCriteria: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getCalendarDetailsforCriteriaURL,
				dataType :'json',
				data : ''
			})
		},
		saveCalendarDetails: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveCalendarDetailsURL;
			return  $http.post(url,request)
		},
		deleteCalendarDetails: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteCalendarDetailsURL;
			return  $http.post(url,request)
		},		
		}
}]);

}());