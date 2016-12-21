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
			 'AdminService',
			 function($scope,$rootScope,$http,$location,$localStorage,$sessionStorage,$exceptionHandler,$state,UserDetailsService,UserHelper,AdminService) {
				   //Variable declare
				    $scope.$state = $state;
				    $scope.menuItems = [];
					//User profile Details 
					$scope.userdetails={};
					$scope.userprofile={};
					$scope.user={};
					$scope.user.logindetails={};
				    $scope.user.conatctDetails={};
					$scope.user.networkinfo={};
					$scope.user.walletdetails={};
					$scope.user.walletdetails.walletStatement={};
					$scope.user.userperformance={};
				    $scope.networkjson={};
					$scope.networkid='';
					$scope.networkcreated='false';	
					$scope.approval={};
				    $scope.otp={};
					$scope.approvalpendinglist=[];
					$scope.request={};
					$scope.tasklist={};
					$scope.tasklist.count={};
					$scope.request.task={};
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
								$scope.displayProfile();
									}).error(function(data, status) {
									   var errormsg='Unable to Populate for Calnder event details : '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					 });
					 
				$scope.displayNetworkProfie= function(networkjson){
					$('#networkmember-chart').orgchart({
				      'data' : networkjson,
				      'depth': 2,
				      'nodeContent': 'title',
				      'exportButton': false,
				      'exportFilename': 'MyOrgChart'
				    });
					
				};
				
				if(!$localStorage.profile.mobilenoVerified){
			    $scope.approval.mobilenoVerified='Pending';	
				$scope.approvalpendinglist.push({id:1, name:'MobileNumber'});
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
                                                        }
                                                        if(value.name=='MobileNumber'){
                                                        	$scope.approval.verificationvalue=$localStorage.profile.userprofile.conatctDetails.mobilenumber;
                                                        }
														 if(value.name=='Email'||value.name=='MobileNumber'){
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
						 UserDetailsService.validateOTP($scope).success(function(data, status) {
							 $localStorage.profile.mobilenoVerified=data.mobilenoVerified;
							 $localStorage.profile.emailVerified=data.emailVerified;
							 $localStorage.profile.adminVerified=data.adminVerified;
							angular.element('#approvalmodal').modal('hide');
							if(!$localStorage.profile.mobilenoVerified){
			    $scope.approval.mobilenoVerified='Pending';	
				$scope.approvalpendinglist.push({id:1, name:'MobileNumber'});
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
									}).error(function(data, status) {
									  var errormsg='Unable to validate OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					
				}							
				
		     $scope.displayProfile = function () {
					 $scope.userdetails=$localStorage.profile;
					 $scope.usertype=$scope.userdetails.userprofile.logindetails.authorities[0].name;
			    if($scope.usertype=='ADMIN'){
					 $scope.tasklist=$scope.userdetails.tasklist;
					 $scope.tasklist.count=$scope.tasklist.length;
				}else{
					 $scope.tasklist={};
					 $scope.tasklist.count=0;
				}
				     $scope.user.firstname=$scope.userdetails.userprofile.firstname;
					 $scope.user.lastname=$scope.userdetails.userprofile.lastname;
					 $scope.user.dateofbirth=new Date($scope.userdetails.userprofile.dateofbirth);
					 $scope.user.gender=$scope.userdetails.userprofile.gender;
					$scope.user.conatctDetails.addressText=$scope.userdetails.userprofile.conatctDetails.addressText;
					$scope.user.conatctDetails.district=$scope.userdetails.userprofile.conatctDetails.district;
					$scope.user.conatctDetails.email=$scope.userdetails.userprofile.conatctDetails.email;
					$scope.user.conatctDetails.mobilenumber=$scope.userdetails.userprofile.conatctDetails.mobilenumber;
					$scope.user.networkinfo.memberlevel=$scope.userdetails.userprofile.networkinfo.memberlevel;
					$scope.user.walletdetails.walletnumber=$scope.userdetails.userprofile.walletdetails.walletnumber;
					$scope.user.walletdetails.walletStatement.payout=$scope.userdetails.walletStatement.payout;
					$scope.user.walletdetails.walletStatement.maxencashable=$scope.userdetails.walletStatement.maxencashable;
					$scope.user.walletdetails.walletStatement.currentbalance=$scope.userdetails.walletStatement.currentbalance;
					$scope.user.walletdetails.walletStatement.walletlastupdate=new Date($scope.userdetails.walletStatement.walletlastupdate);
					$scope.user.userperformance.totalnetwork=$scope.userdetails.userperformance.network;
					$scope.user.userperformance.totalmetting=$scope.userdetails.userperformance.metting;
					$scope.user.userperformance.totaltask=$scope.userdetails.userperformance.task;
					$scope.user.userperformance.totalincome=$scope.userdetails.userperformance.income;
					$scope.user.userperformance.totalperformance=$scope.userdetails.userperformance.performancetype;
					$scope.user.userperformance.totalrating=$scope.userdetails.userperformance.ratting;
					$scope.networkjson= $scope.networkjson.concat($scope.userdetails.networkjson);
					$scope.displayNetworkProfie($scope.networkjson);
					};
					
					$scope.setupNetwork=function(){
						$scope.userprofile={};
						$scope.userprofile.networkinfo={};
						$scope.userprofile.networkinfo.parentmemberid=$scope.userdetails.userprofile.logindetails.username;
						$scope.userprofile.networkinfo.memberlevel='LEVEL1';
					}
					$scope.poulateEncashDetails=function(){
						$scope.encashdetails={};
						$scope.encashdetails.walletnumber=$scope.userdetails.userprofile.walletdetails.walletnumber;
						$scope.encashdetails.encashamount=$scope.userdetails.walletStatement.maxencashable;
					}
					$scope.createEncashRequest=function(){
						UserDetailsService.createEncashRequest($scope.request).sucess(function(data, status) {
					}).error(function(data, status) {
						   var errormsg='Unable to Populate for Calnder event details : '+status;
							$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
							$exceptionHandler(errormsg);
						});
					
					$scope.populateEncashDetailsForApprover=function(){
						UserHelper.populateEncashRequestDetails($scope);
						 UserDetailsService.validateOTP($scope).success(function(data, status) {
							 
							 
						 }).error(function(data, status) {
							   var errormsg='Unable to Populate for Calnder event details : '+status;
								$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
								$exceptionHandler(errormsg);
							});
					}
					
					$scope.addUserDetails=function(){
						UserHelper.prepareUserProfileRequest($scope);
						UserDetailsService.saveUserProfileDetails( $scope.request).success(function(data, status) {
							if(!data.mobilenoVerified){
								$scope.otp.mobilenumber=data.userprofile.conatctDetails.mobilenumber;
								angular.element('#otppopup').modal('show');
						     	}
							if(!data.emailVerified){
								$scope.otp.email=data.userprofile.conatctDetails.email;
								angular.element('#otppopup').modal('show');
						     	}
								}).error(function(data, status) {
								   var errormsg='Unable to Populate for Calnder event details : '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					
					$scope.updateAdminTask=function(task){
				     $scope.request.task=task;
				     AdminService.updateAdminTask($scope.request).success(function(data, status) {
					 $scope.tasklist.count=$scope.tasklist.count-1;
					 angular.element('#notificationdetails').modal('hide');
					 if(task.tasktype=='ENCASH_REQUEST'){
						  angular.element('#encashdetailmodal').modal('show');
					 }
					 }).error(function(data, status) {
								   var errormsg='Unable to Update Task Details: '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					
			 } ]);
}());
