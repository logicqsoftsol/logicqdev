(function () {
	'use strict';
	angular.module('crmlogicq').controller('LoginController',['$scope','$http', '$location', 'AuthenticationService','AppConstants',function ($scope, $http,  $location, AuthenticationService,AppConstants) {

		$scope.login = function () {
			$scope.error =false;
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				console.log(headers('AUTH-TOKEN'));
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
					AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'));
				
					AuthenticationService.saveMetadata().success(function(metadataResponse, metadataStatus, metadataHeaders, metadataConfig){
											AuthenticationService.setMetaData(metadataResponse);
										}).error(function(metadataResponse, metadataStatus) {  
									console.log("The request failed with response " + metadataResponse + " and status code " + metadataStatus);
										});

						$location.path('/admin');
						
				}


				$scope.loading = false;
			}).error(function(response, status) {  
				console.log("The request failed with response " + response + " and status code " + status);
				$scope.error = response;
			});

		};
	}]);
}());