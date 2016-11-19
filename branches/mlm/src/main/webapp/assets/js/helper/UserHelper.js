(function () {
	'use strict';
	angular.module('mlmlogicq').factory('UserHelper', ['$http' ,function ($http){

		return {

				populateUserProfile: function ($scope,data) {
					
					$scope.userprofile.firstname=data;
					$scope.userprofile.lastname=data;
					$scope.userprofile.dateofbirth='';
				    $scope.userprofile.gender='';
				    $scope.userprofile.conatctDetails.addressText='';
					$scope.userprofile.conatctDetails.district='';
					$scope.userprofile.conatctDetails.email='';
					$scope.userprofile.conatctDetails.mobilenumber='';
					$scope.userprofile.networkinfo.memberlevel='';
					$scope.userprofile.walletdetails.walletnumber='';
					$scope.userprofile.walletdetails.walletStatement.payout='';
					$scope.userprofile.walletdetails.walletStatement.maxencashable='';
					$scope.userprofile.walletdetails.walletStatement.currentbalance='';
					$scope.userprofile.walletdetails.walletStatement.walletlastupdate='';
				}			
		}
		
}]);

}());