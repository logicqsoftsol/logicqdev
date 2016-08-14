(function() {
	'use strict';
	angular.module('issuetracker').controller(
			'AuthController',
			[
			 '$scope',
			 '$http',
			 '$location',
			 function($scope, $http, $location) {
							 $location.path('/login');
				
			 } ]);
}());
