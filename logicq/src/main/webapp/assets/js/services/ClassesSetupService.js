
(function () {
	'use strict';
	angular.module('crmlogicq').factory('ClassesSetupService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			saveSubjectDetails:function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveSubjectDetailsURL;
				return  $http.post(url,request.subject)
			},
			deleteExistingSubject: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteExistingSubjectURL;
				return  $http.post(url,request.subject)

			}, 
		getAllSubjectDetails: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllSubjectDetailsURL,
				dataType :'json',
				data : ''
			})
		},
	
		
		}
}]);

}());