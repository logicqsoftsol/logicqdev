(function () {
	'use strict';
	angular.module('issuetracker').controller('LoginController',['$scope','$rootScope','$http', '$exceptionHandler','$location','AuthenticationService','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler,$location,AuthenticationService,AppConstants) {
		$scope.login = function () {
			if($scope.username=='admin'){
				$location.path('/admin');
			} else
			if($scope.username=='client'){
				$location.path('/client');
			} else
			if($scope.username=='account'){
				$location.path('/account');
			} else
			if($scope.username=='serviceengg'){
				$location.path('/serviceengg');
			} else
			if($scope.username=='inventory'){
				$location.path('/inventory');
			}else{
				var errormsg='Unable to Login Check setting or Loging Details ';
				 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				 $exceptionHandler(errormsg);
			}
			
	/*		$scope.error =false;
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				//console.log(headers('AUTH-TOKEN'));
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
						$location.path('/admin');		
				}
			}).error(function(response, status) {
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				 $exceptionHandler(errormsg);
			});*/

		};
	}]);
}());