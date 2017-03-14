
(function () {
	'use strict';
	angular.module('mlmlogicq').factory('AdminService', ['$http','AppConstants' ,function ($http ,AppConstants){

		return {
			
		updateAdminTask: function (request) {
			var url = AppConstants.hostName+AppConstants.updateAdminTaskURL;
			//var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.updateAdminTaskURL;
			return  $http.post(url,request.task)
		},
		pay: function (request) {
			var url = AppConstants.hostName+AppConstants.senMoneyURL;
			//var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.updateAdminTaskURL;
			return  $http.post(url,request.paymentdetails)
		},
		addMoneyToWallet: function (request) {
			var url = AppConstants.hostName+AppConstants.addMoneyToWalletURL;
			//var url = AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.updateAdminTaskURL;
			return  $http.post(url,request.addMoney)
		},
		getTxnDetails: function ($scope) {
			return  $http({
				method: 'GET',
				url: AppConstants.hostName+AppConstants.getTransactionDetailsURL,
				//url: AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.getUserProfileURL+"/"+$scope.networkid,
				dataType :'json',
				data : ''
			})
		},
		
		}
}]);

}());