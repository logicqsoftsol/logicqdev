(function() {
	'use strict';
	angular.module('mlmlogicq').controller(
			'DashboardCtrl',
			[
			 '$scope',
			 '$rootScope',
			 '$http',
			 '$location',
			 '$localStorage',
			 '$sessionStorage',
			 '$exceptionHandler',
			 '$state',
			 'UserDetailsService',
			 'UserHelper',
			 function($scope,$rootScope,$http,$location,$localStorage,$sessionStorage,$exceptionHandler,$state,UserDetailsService,UserHelper) {
				   //Variable declare
				    $scope.$state = $state;
				    $scope.menuItems = [];
					//User profile Details 
					$scope.userdetails={};
					$scope.userprofile={};
					$scope.userprofile.logindetails={};
				    $scope.userprofile.conatctDetails={};
					$scope.userprofile.networkinfo={};
					$scope.userprofile.walletdetails={};
					$scope.userprofile.walletdetails.walletStatement={};
					$scope.userprofile.userperformance={};
				    $scope.networkjson={};
					$scope.networkid='';
					$scope.networkcreated='false';	
					$scope.approval={};
				    $scope.otp={};
					$scope.approvalpendinglist=[];
					$scope.request={};
				    angular.forEach($state.get(), function (item) {
				        if (item.data && item.data.visible) {
				            $scope.menuItems.push({name: item.name, text: item.data.text});
				        }
						
				    });
					
					$('#networkmember-chart').on('click', function(event) {
							var networkid = $('#networkmembernodeid').val();
							$scope.networkid=networkid;
							UserDetailsService.getUserProfileForNetwork( $scope).success(function(data, status) {
								$localStorage.profile=data;
								$scope.networkcreated='true';
								$scope.displayProfile();
									}).error(function(data, status) {
									   var errormsg='Unable to Populate for Calnder event details : '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					 });
					 
				$scope.displayNetworkProfie= function(networkjson){
					$('#networkmember-chart').orgchart({
				      'data' : $scope.networkjson,
				      'depth': 2,
				      'nodeContent': 'title',
				      'exportButton': false,
				      'exportFilename': 'MyOrgChart'
				    });
					
				};
				if(!$localStorage.profile.mobilenoVerified){
			    $scope.approval.mobilenoVerified='Pending';	
				$scope.approvalpendinglist.push({id:1, name:'Mobile Number'});
				}else{
					$scope.approval.mobilenoVerified='Approved';
				}
				if(!$localStorage.profile.emailVerified){
			    $scope.approval.emailVerified='Pending';
                $scope.approvalpendinglist.push({id:2, name:'Email'});				
				}else{
					$scope.approval.emailVerified='Approved';
				}
					
					if(!$localStorage.profile.adminVerified){
			       $scope.approval.adminVerified='Pending';
				   $scope.approvalpendinglist.push({id:3, name:'Admin'});	
				}else{
					$scope.approval.adminVerified='Approved';
				}
				
				 $scope.$watch('approval.verificationfor', function(newVal, oldVal){
												angular.forEach($scope.approvalpendinglist, function(value, key) {
													if(value.name==newVal){
														 $scope.approval.verificationtypelabel=value.name;
                                                        $scope.request.otpdetails={};                                                         
														 if(value.name=='Email'){
															  $scope.approval.verificationvalue=$localStorage.profile.userprofile.conatctDetails.email;
															   UserHelper.populateOTPDetailsForEmail($scope);
															   UserDetailsService.sendOTP($scope).success(function(data, status) {
								
								             	}).error(function(data, status) {
									   var errormsg='Unable to Send OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
														  }	
                                                          if(value.name=='Mobile Number'){
															 $scope.approval.verificationvalue=$localStorage.profile.userprofile.conatctDetails.mobilenumber;
            												   UserHelper.populateOTPDetailsForMobile($scope);		   
															   UserDetailsService.sendOTP($scope).success(function(data, status) {
							
									}).error(function(data, status) {
									  var errormsg='Unable to Send OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});

														}	
                                                          if(value.name=='Admin'){
															   $scope.approval.otpfor='ADMIN';
															    $scope.approval.otpsendto=$scope.approval.verificationvalue;
															 $scope.approval.verificationvalue='Admin Notify';
														  }															  
														 
													}	
													});
												});
												
				$scope.validateOTP=	function (){
					if($scope.approval.verificationtypelabel=='Email'){
						 UserHelper.populateOTPDetailsForEmail($scope);
						 UserDetailsService.validateOTPForEmail($scope).success(function(data, status) {
							angular.element('#approvalmodal').modal('hide');
							$scope.approval.mobilenoVerified='Approved';
									}).error(function(data, status) {
									  var errormsg='Unable to validate OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					}
					if($scope.approval.verificationtypelabel=='Mobile Number'){
						UserHelper.populateOTPDetailsForMobile($scope);
						UserDetailsService.validateOTPForMobile($scope).success(function(data, status) {
							          angular.element('#approvalmodal').modal('hide');
									$scope.approval.emailVerified='Approved';
									}).error(function(data, status) {
									  var errormsg='Unable to validate OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					}
					
				}							
				
		     $scope.displayProfile = function () {
					 $scope.userdetails=$localStorage.profile;
				     $scope.userprofile.firstname=$scope.userdetails.userprofile.firstname;
					 $scope.userprofile.lastname=$scope.userdetails.userprofile.lastname;
					 $scope.userprofile.dateofbirth=new Date($scope.userdetails.userprofile.dateofbirth);
					 $scope.userprofile.gender=$scope.userdetails.userprofile.gender;
					$scope.userprofile.conatctDetails.addressText=$scope.userdetails.userprofile.conatctDetails.addressText;
					$scope.userprofile.conatctDetails.district=$scope.userdetails.userprofile.conatctDetails.district;
					$scope.userprofile.conatctDetails.email=$scope.userdetails.userprofile.conatctDetails.email;
					$scope.userprofile.conatctDetails.mobilenumber=$scope.userdetails.userprofile.conatctDetails.mobilenumber;
					$scope.userprofile.networkinfo.memberlevel=$scope.userdetails.userprofile.networkinfo.memberlevel;
					$scope.userprofile.walletdetails.walletnumber=$scope.userdetails.userprofile.walletdetails.walletnumber;
					$scope.userprofile.walletdetails.walletStatement.payout=$scope.userdetails.walletStatement.payout;
					$scope.userprofile.walletdetails.walletStatement.maxencashable=$scope.userdetails.walletStatement.maxencashable;
					$scope.userprofile.walletdetails.walletStatement.currentbalance=$scope.userdetails.walletStatement.currentbalance;
					$scope.userprofile.walletdetails.walletStatement.walletlastupdate=new Date($scope.userdetails.walletStatement.walletlastupdate);
					$scope.userprofile.userperformance.totalnetwork=$scope.userdetails.userperformance.network;
					$scope.userprofile.userperformance.totalmetting=$scope.userdetails.userperformance.metting;
					$scope.userprofile.userperformance.totaltask=$scope.userdetails.userperformance.task;
					$scope.userprofile.userperformance.totalincome=$scope.userdetails.userperformance.income;
					$scope.userprofile.userperformance.totalperformance=$scope.userdetails.userperformance.performancetype;
					$scope.userprofile.userperformance.totalrating=$scope.userdetails.userperformance.ratting;
					$scope.networkjson=$scope.userdetails.networkjson;
					if($scope.networkcreated=='false'){
						$scope.displayNetworkProfie($scope.networkjson);
						$scope.networkcreated='true';
					}
					};
					
					$scope.saveUser=function(){
						UserDetailsService.saveUserProfileDetails( $scope).success(function(data, status) {
							if(!data.isOTPVerfied){
								$scope.otp.mobilenumber=data.userprofile.conatctDetails.mobilenumber;
								$('#otppopup').modal('show');
						     	}
								}).error(function(data, status) {
								   var errormsg='Unable to Populate for Calnder event details : '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					
			 } ]);
}());
