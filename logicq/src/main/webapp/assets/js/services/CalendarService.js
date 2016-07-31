
(function () {
	'use strict';
	angular.module('crmlogicq').factory('CalendarService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {
			saveEventDetails:function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveEventDetailsURL;
				return  $http.post(url,request.eventd)
			},
			searchAllEventList: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllEventDetailsURL+"/"+$scope.eventd.pageSize+"/"+$scope.eventd.currentPage,
					dataType :'json',
					data : ''
				})
			},
			deleteEventDetails: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteEventDetailsURL;
				return  $http.post(url,request.eventd)
			},
		
			saveEventCalendarDetails :function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveCalendarDetailsURL;
				return  $http.post(url,request.calendar)
			},
		    searchAllEventCalendarList: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllCalendarDetailsURL+"/"+$scope.calendar.pageSize+"/"+$scope.calendar.currentPage,
					dataType :'json',
					data : ''
				})
			},
			deleteEventCalendarDetails: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteCalendarDetailsURL;
				return  $http.post(url,request.calendar)
			},
		}
}]);

}());