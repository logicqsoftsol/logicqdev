(function() {
	'use strict';
	angular.module('crmlogicq').controller(
			'AuthController',
			[
			 '$scope',
			 '$http',
			 '$location',
			 'AuthenticationService',
			 function($scope, $http, $location, AuthenticationService) {
				 AuthenticationService.loadDefaultUsers().success(
						 function(response) {
							 $location.path('/login');
						 });
			 } ]);
}());
