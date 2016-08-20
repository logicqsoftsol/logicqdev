(function () {
	'use strict';
	angular.module('crmlogicq').controller('LoginController',['$scope','$rootScope','$http', '$exceptionHandler','$location','AuthenticationService','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler,$location,AuthenticationService,AppConstants) {
		$scope.login = function () {
			$scope.logedinusername ='';
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
                 $scope.logedinusername=response.username;
				 AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'));
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