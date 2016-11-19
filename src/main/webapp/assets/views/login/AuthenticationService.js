(function () {
	'use strict';
	angular.module('mlmlogicq').factory('AuthenticationService', ['$http','AppConstants',function ($http,AppConstants ){

		return {

			Login: function ($scope) {

				return  $http({
					method: 'POST',
					url:AppConstants.hostName+AppConstants.hostPort+AppConstants.applicationName+AppConstants.loginURL,
					headers: {'Content-Type': 'application/json','AUTH-TOKEN': '' ,'userName':$scope.username ,'password':$scope.password} ,
					dataType :'json',
					data : ''
				})
			},
			   
			setAuthenticationToken: function (token,username) {
				//$sessionStorage.authToken = token;
                //$sessionStorage.username=username;
			    },


		}
	}]);
}());