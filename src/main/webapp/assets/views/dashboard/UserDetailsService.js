
(function () {
	'use strict';
	angular.module('mlmlogicq').factory('UserDetailsService', ['$http','AppConstants' ,function ($http ,AppConstants){

		return {
			getUserProfileForNetwork: function ($scope) {
				return  $http({
					method: 'GET',
					url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getUserProfileURL+"/"+$scope.networkid,
					dataType :'json',
					data : ''
				})
		},
		saveUserProfileDetails: function (request) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.saveUserProfileDetailsURL;
			return  $http.post(url,request)
		},
		sendOTP: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.sendOTPURL;
			return  $http.post(url,$scope.request.otpdetails)
		},
		validateOTPForEmail: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.validateOTPForEmailURL;
			return  $http.post(url,$scope.request.otpdetails)
		},
		validateOTPForMobile: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.validateOTPForMobileURL;
			return  $http.post(url,$scope.request.otpdetails)
		},
		}
}]);

}());