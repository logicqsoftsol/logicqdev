'use strict';

/**
 * @ngdoc function
 * @name mlmlogicq.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of mlmlogicq
 */
angular.module('mlmlogicq')
  .controller('DashboardCtrl', function($scope,$rootScope,$state) {
    $scope.$state = $state;

    $scope.menuItems = [];
    angular.forEach($state.get(), function (item) {
        if (item.data && item.data.visible) {
            $scope.menuItems.push({name: item.name, text: item.data.text});
        }
		
    });
	
	var netorkdatasource = {
      'name': 'SMART-MLM',
      'title': '600000.00',
	  'category':'Diamond',
          'children': [
            { 'name': 'Manoj', 'title': 'INR 10000.00','category':'Diamond' },
			{ 'name': 'Sangram', 'title': 'INR 20000.00', 'category':'Gold',
			'children': [
                { 'name': 'ZXC', 'title': 'INR 7400.00', 'category':'Silver' },
                { 'name': 'VBN', 'title': 'INR 6400.00', 'category':'White' , 
				'children':[
				{ 'name': 'ASD', 'title': 'INR 5600.00', 'category':'Silver' },
				{ 'name': 'FGH', 'title': 'INR 10000.00','category':'Diamond',
                 'children':[{ 'name': 'JKL', 'title': 'INR 4600.00', 'category':'Silver' },
				            { 'name': 'QWE', 'title': 'INR 4400.00', 'category':'Silver','children':[
							{ 'name': 'POI', 'title': 'INR 3600.00', 'category':'Silver' },
							{ 'name': 'UYT', 'title': 'INR 3600.00', 'category':'Silver' }
							] }
				 ]}
				]}
                 ]	}
          ]
       };
	   
	$('#networkmember-chart').orgchart({
      'data' : netorkdatasource,
      'depth': 2,
      'nodeContent': 'title',
      'exportButton': false,
      'exportFilename': 'MyOrgChart'
    });
	
	
	$scope.userdetails=$rootScope.data;
	//User profile Details 
	$scope.userprofile={};
	
	
	$scope.userprofile.firstname='';
	$scope.userprofile.lastname='';
	$scope.userprofile.dateofbirth='';
	$scope.userprofile.gender='';
	
	
	$scope.userprofile.conatctDetails={};
	$scope.userprofile.conatctDetails.addressText='';
	$scope.userprofile.conatctDetails.district='';
	$scope.userprofile.conatctDetails.email='';
	$scope.userprofile.conatctDetails.mobilenumber='';
	
	
	$scope.userprofile.networkinfo={};
	$scope.userprofile.networkinfo.memberlevel='';
	
	$scope.userprofile.walletdetails={};
	$scope.userprofile.walletdetails.walletnumber='';
	
	$scope.userprofile.walletdetails.walletStatement={};
	$scope.userprofile.walletdetails.walletStatement.payout='';
	$scope.userprofile.walletdetails.walletStatement.maxencashable='';
	$scope.userprofile.walletdetails.walletStatement.currentbalance='';
	$scope.userprofile.walletdetails.walletStatement.walletlastupdate='';
	
	$scope.displayProfile = function ($scope,data) {
		$scope.userprofile.firstname=data.userprofile.firstname;
		$scope.userprofile.lastname=data.userprofile.lastname;
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
	};
	
  });
