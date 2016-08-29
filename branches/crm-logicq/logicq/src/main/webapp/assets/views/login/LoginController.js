(function () {
	'use strict';
	angular.module('crmlogicq').controller('LoginController',['$scope','$rootScope','$http', '$exceptionHandler','$location','AuthenticationService','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler,$location,AuthenticationService,AppConstants) {
		$scope.login = function () {
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
                 $scope.logedinusername=response.username;
				 AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'),$scope.logedinusername);
				  $location.path('/admin');	
				}else{
					$location.path('/login');
					var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
					 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
					 $exceptionHandler(errormsg);
				}
			}).error(function(response, status) {
				$location.path('/login');
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				 $exceptionHandler(errormsg);
			});

		};
	}]);
}());