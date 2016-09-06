(function () {
	'use strict';
	angular.module('electionmgm').controller('EmgmController',['$scope','$rootScope','$http', '$exceptionHandler', '$timeout','$location','AdminService','GraphHelper','NgMap','AppConstants',function ($scope,$rootScope,$http,$exceptionHandler, $timeout,$location,AdminService,GraphHelper,NgMap,AppConstants) {
		
		$scope.populateTaskDetailsForGraph = function() {
			$scope.taskgraphdetails=GraphHelper.populateTaskDetails($scope);
		}
		$scope.populateComplainDetailsForGraph = function() {
			$scope.complaingraphdetails=GraphHelper.populateComplainDetails($scope);
		}
		$scope.populateBusinessPerformanceForGraph = function() {
		 $scope.businessdata=GraphHelper.populateProductSellDetails($scope);
		}
		$scope.populateDeptPerformanceForGraph = function() {
			 $scope.deptperfgraphdata=GraphHelper.deptPerfData($scope);
		}
		$scope.populateExpenseCollectionDetails= function() {
			 $scope.expcoldatagraph=GraphHelper.populateExpenseCollectionDetails($scope);
		}
		
		$scope.loadHotZoneMap= function() {
		    NgMap.getMap().then(function(map) {
		      $scope.map = map;
		    });
		    $scope.neighborhoods = [
		                        new google.maps.LatLng(52.511467, 13.447179),
		                        new google.maps.LatLng(52.549061, 13.422975),
		                        new google.maps.LatLng(52.497622, 13.396110),
		                        new google.maps.LatLng(52.517683, 13.394393)
		                      ];

		                      $scope.toggleBounce = function() {
		                        if (this.getAnimation() != null) {
		                          this.setAnimation(null);
		                        } else {
		                          this.setAnimation(google.maps.Animation.BOUNCE);
		                        }
		                      };
		                      var iterator=0;
		                      $scope.addMarker = function() {
		                        for (var i=0; i<$scope.neighborhoods.length; i++) {
		                          $timeout(function() {
		                            // add a marker this way does not sync. marker with <marker> tag
		                            new google.maps.Marker({
		                              position: $scope.neighborhoods[iterator++],
		                              map: $scope.map,
		                              draggable: false,
		                              animation: google.maps.Animation.DROP
		                            });
		                          }, i * 200);
		                        }
		                      } 
		               }							  
	
	}]);
}());