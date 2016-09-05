
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
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllSubjectDetailsURL+'/'+$scope.subject.pageSize+'/'+$scope.subject.currentPage,
				dataType :'json',
				data : ''
			})
		},
		getAllSubjectList: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getAllSubjectListURL,
				dataType :'json',
				data : ''
			})
		},
	
	
	
			saveClassSetupDetails:function (request){
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveClassSetupDetailsURL;
				return  $http.post(url,request.classsetup)
			},
			deleteClassSetupDetails: function (request) {
				var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.deleteClassSetupDetailsURL;
				return  $http.post(url,request.classsetup)

			}, 
		getClassesSetupDetails: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getClassesSetupDetailsURL+'/'+$scope.classsetup.pageSize+'/'+$scope.classsetup.currentPage,
				dataType :'json',
				data : ''
			})
		},
		
		}
}]);

}());