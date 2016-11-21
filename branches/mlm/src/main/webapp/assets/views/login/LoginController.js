(function() {
	'use strict';
	angular.module('mlmlogicq').controller(
			'LoginController',
			[
			 '$scope',
			 '$rootScope',
			 '$http',
			 '$location',
			 '$localStorage',
			 'AuthenticationService',
			 function($scope,$rootScope,$http,$location,$localStorage,AuthenticationService) {
		
		$scope.login = function () {
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
                // $scope.logedinusername=response.username;
				 //AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'),$scope.logedinusername);
			    $localStorage.profile=response;
				$location.path('/dashboard/overview');
				}
			}).error(function(response, status) {
				$location.path('/login');
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				// $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				 //$exceptionHandler(errormsg);
			});

    };
			 } ]);
}());
