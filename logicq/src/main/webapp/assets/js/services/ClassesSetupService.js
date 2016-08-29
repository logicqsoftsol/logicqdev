
(function () {
	'use strict';
	angular.module('crmlogicq').factory('ClassesSetupService', ['$http' ,'AuthenticationService','AppConstants' ,function ($http ,AuthenticationService,AppConstants){

		return {

			saveSubjectDetails:function ($scope){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveSubjectDetailsURL;
				return  $http.post(url,request)
			},
			deleteExistingSubject: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteExistingSubjectURL;
				return  $http.post(url,request)

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