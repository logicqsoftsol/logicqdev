
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
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllEventDetailsURL,
					dataType :'json',
					data : ''
				})
			},
			
		}
}]);

}());