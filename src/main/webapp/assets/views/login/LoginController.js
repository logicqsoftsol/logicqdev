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
			 '$exceptionHandler',
			 'AuthenticationService',
			 function($scope,$rootScope,$http,$location,$localStorage,$exceptionHandler,AuthenticationService) {
		$scope.approval={};
		$scope.login = function () {
			AuthenticationService.Login($scope).success(function(response, status, headers, config){
				if(headers('AUTH-TOKEN') != '' && response.authorities != '' )
				{
                 $scope.logedinusername=response.userprofile.logindetails.username;
				AuthenticationService.setAuthenticationToken(headers('AUTH-TOKEN'),$scope.logedinusername);
			    $localStorage.profile=response;
				$scope.usertype=response.userprofile.logindetails.authorities[0].name;
			    if($scope.usertype=='ADMIN'){
					$location.path('/dashboard/overview');
				}
				//else if(!response.adminVerified || !response.emailVerified || !response.mobilenoVerified){
			    else if(!response.adminVerified ){	
			    $location.path('/dashboard/approvalpending');
				}else{
					$location.path('/dashboard/overview');
				}
			     var errormsg='Sucess fully able to login';
				 $rootScope.$emit("callAddAlert", {type:'info',msg:errormsg});
				}
			}).error(function(response, status) {
				var errormsg='Unable to Login Check setting or Loging Details '+' Status Code : '+status;
				 $rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
				$exceptionHandler(errormsg);
				$location.path('/login');
			});
    };
			 } ]);
}());