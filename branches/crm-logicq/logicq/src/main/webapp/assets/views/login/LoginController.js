(function () {
	'use strict';
	angular.module('crmlogicq').controller('LoginController',['$scope','$http', '$exceptionHandler','$location', 'AuthenticationService','AppConstants',function ($scope, $http, $exceptionHandler, $location, AuthenticationService,AppConstants) {

		$scope.login = function () {
			$scope.error =false;
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				//console.log(headers('AUTH-TOKEN'));
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
				//	AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'));
				
				//	AuthenticationService.saveMetadata().success(function(metadataResponse, metadataStatus, metadataHeaders, metadataConfig){
				//							AuthenticationService.setMetaData(metadataResponse);
				//						}).error(function(metadataResponse, metadataStatus) {  
				//					console.log("The request failed with response " + metadataResponse + " and status code " + metadataStatus);
				//						});

						$location.path('/admin');
						
				}
			}).error(function(response, status) {  
				$exceptionHandler('Unable to Login Check setting or Loging Details ',' Status Code : '+status);
			});

		};
	}]);
}());