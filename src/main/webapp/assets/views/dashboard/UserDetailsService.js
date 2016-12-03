
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
			return  $http.post(url,request.user)
		},
		sendOTP: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.sendOTPURL+"/"+$scope.approval.verificationtypelabel;
			return  $http.post(url," ")
		},
		validateOTP: function ($scope) {
			var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.validateOTPURL+"/"+$scope.approval.verificationtypelabel+"/"+$scope.approval.otpcode;
			return  $http.post(url," ")
		},
		}
}]);

}());