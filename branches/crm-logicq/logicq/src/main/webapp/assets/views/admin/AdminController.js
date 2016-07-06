(function () {
	'use strict';
	angular.module('crmlogicq').controller('AdminController',['$scope','$http', '$location', 'AdminService','AppConstants',function ($scope, $http,  $location, AdminService,AppConstants) {
		 $scope.selectedRow = null;
		 $scope.attendanceDetails=
			 [{"userid":1,"name":"Ann Frazier","mobileno":"420-(702)766-5509","intime":"8:30 AM","outtime":"1:45 AM","date":"3/23/2016"},
			 {"userid":2,"name":"Jonathan Bishop","mobileno":"62-(812)604-3014","intime":"12:17 AM","outtime":"5:32 AM","date":"2/2/2016"},
			 {"userid":3,"name":"Karen Grant","mobileno":"48-(832)745-7966","intime":"9:40 PM","outtime":"7:21 PM","date":"6/29/2016"},
			 {"userid":4,"name":"Chris Franklin","mobileno":"970-(702)858-1838","intime":"10:13 PM","outtime":"1:45 AM","date":"5/16/2016"},
			 {"userid":5,"name":"Julia Adams","mobileno":"381-(125)122-2856","intime":"12:34 AM","outtime":"7:40 PM","date":"8/15/2015"},
			 {"userid":6,"name":"Anna Ferguson","mobileno":"63-(210)352-0807","intime":"6:20 AM","outtime":"12:34 AM","date":"1/31/2016"},
			 {"userid":7,"name":"Louis Jordan","mobileno":"86-(961)980-0805","intime":"12:48 PM","outtime":"9:41 PM","date":"5/4/2016"},
			 {"userid":8,"name":"Paul Weaver","mobileno":"63-(910)935-2220","intime":"4:41 AM","outtime":"11:40 PM","date":"6/30/2016"},
			 {"userid":9,"name":"Karen Mcdonald","mobileno":"86-(635)277-0859","intime":"3:32 PM","outtime":"5:09 AM","date":"5/3/2016"},
			 {"userid":10,"name":"Roger Stanley","mobileno":"86-(992)238-1846","intime":"7:13 AM","outtime":"7:01 PM","date":"10/7/2015"}];
		 
		 
		 $scope.setClickedRow = function(attendance){
			 $scope.id=attendance.userid;
			 $scope.name=attendance.name;
			 $scope.mobileno=attendance.mobileno;
			 $scope.intime=attendance.intime;
			 $scope.outtime=(attendance.outtime); 
			 $scope.date=new Date(attendance.date); 
			 	};
			 	
		
	}]);
}());