(function() {
	'use strict';
	angular.module('electionmgm').controller(
			'AuthController',
			[
			 '$scope',
			 '$http',
			 '$location',
			 function($scope, $http, $location) {
							 $location.path('/login');
				
			 } ]);
}());
