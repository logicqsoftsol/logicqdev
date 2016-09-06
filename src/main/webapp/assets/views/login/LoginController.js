(function () {
	'use strict';
	angular.module('electionmgm').controller('LoginController',['$scope','$rootScope','$http', '$exceptionHandler','$location','AuthenticationService','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler,$location,AuthenticationService,AppConstants) {
		$scope.login = function () {
			if($scope.username=='admin'){
				$location.path('/admin');
			} else
			if($scope.username=='boothadmin'){
				$location.path('/booth');
			} else
			if($scope.username=='panchyatadmin'){
				$location.path('/panchyat');
			} else
			if($scope.username=='villageadmin'){
				$location.path('/village');
			} else
			if($scope.username=='wardadmin'){
					$location.path('/ward');
				} else
			if($scope.username=='zonaladmin'){
				$location.path('/zonal');
			}
		
			if($scope.username=='emgm'){
				$location.path('/emgm');
			}
			else{
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