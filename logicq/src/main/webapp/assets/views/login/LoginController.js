(function () {
	'use strict';
	angular.module('crmlogicq').controller('LoginController',['$scope','$rootScope','$http', '$exceptionHandler','$location','AuthenticationService','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler,$location,AuthenticationService,AppConstants) {
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
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				 $exceptionHandler(errormsg);
			});

		};
	}]);
}());