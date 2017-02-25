(function() {
	'use strict';
	angular.module('mlmlogicq').controller(
			'DashboardCtrl',
			[
			 '$scope',
			 '$rootScope',
			 '$http',
			 '$timeout',
			 '$location',
			 '$localStorage',
			 '$sessionStorage',
			 '$exceptionHandler',
			 '$state',
			 'UserDetailsService',
			 'UserHelper',
			 'AdminService',
			 function($scope,$rootScope,$http,$timeout,$location,$localStorage,$sessionStorage,$exceptionHandler,$state,UserDetailsService,UserHelper,AdminService) {
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
					$scope.encashdetails={};
					$scope.documentid={};
					$scope.user.image="assets/images/dummyuser.jpg";
					$scope.taskPoller=[];
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
				
					$scope.viewSupportHands=function(){
						$scope.displayNetworkProfie($localStorage.profile.networkjson);
					}
					if($localStorage.profile.document.documentPath!=null){
						$scope.user.image=$localStorage.profile.document.documentPath;
					}
				
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
							$scope.approvalpendinglist=[];
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
				}).error(function(data, status) {
									  var errormsg='Unable to validate OTP  '+status;
										$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
										$exceptionHandler(errormsg);
									});
					
				}	
				
				$scope.poller = function() {
				if($scope.taskPoller.length>0){
					UserDetailsService.pollTaskDetails().success(function(data, status) {
				   	$scope.tasklist=data.tasklist;
					$scope.tasklist.count=data.tasklist.length;
					if(data.tasklist.length==0){
						$scope.taskPoller=[];
					}else{
						$scope.taskPoller=data.tasklist;
					}
				  }).error(function(data, status) {
					  var errormsg='Unable to Update Your Task  '+status;
						$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
						$exceptionHandler(errormsg);
					});     
				}
				$timeout($scope.poller, 4000); 
				};
				$scope.poller();
				  
				  $scope.clearRequestForm= function(){
					  $scope.approval.verificationvalue='';
					  $scope.approval.otpcode='';
				  }
				  
		     $scope.displayProfile = function () {
					 $scope.userdetails=$localStorage.profile;
					 $scope.usertype=$scope.userdetails.userprofile.logindetails.authorities[0].name;
					 $scope.tasklist=$scope.userdetails.tasklist;
                    if(null!=$scope.tasklist){
					$scope.tasklist.count=$scope.tasklist.length;	
					}				
					
					 if($scope.usertype=='ADMIN'){
			    	$scope.taskreadonly='false';
				}else{
					$scope.taskreadonly='true';
				}
					 $scope.user.image=$scope.userdetails.document.documentPath;
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
					};
					
				
					
					$scope.setupNetwork=function(){
						$scope.userprofile={};
						$scope.userprofile.networkinfo={};
						$scope.userprofile.networkinfo.parentmemberid=$scope.userdetails.userprofile.logindetails.username;
						$scope.userprofile.networkinfo.memberlevel='LEVEL1';
					}
					
					$scope.setupNetworkForEdit=function(){
						$scope.userprofile.conatctDetails={};
						$scope.userprofile.networkinfo={};
						UserHelper.prepareUserProfileForEdit($scope);
					}
					
					$scope.poulateEncashDetails=function(){
						$scope.encashdetails={};
						$scope.encashdetails.walletnumber=$scope.userdetails.userprofile.walletdetails.walletnumber;
						$scope.encashdetails.encashamount=$scope.userdetails.walletStatement.maxencashable;
					}
					$scope.createEncashRequest=function(){
						$scope.request.encashdetails={};
						$scope.request.encashdetails.walletnumber=$scope.encashdetails.walletnumber;
						$scope.request.encashdetails.encashamount=$scope.encashdetails.encashamount;
						UserDetailsService.createEncashRequest($scope.request).success(function(data, status) {
                      $scope.taskPoller.push("createEncashRequest");
					}).error(function(data, status) {
						   var errormsg='Unable to Create Encash Request : '+status;
							$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
							$exceptionHandler(errormsg);
						});
					}
					
					$scope.populateEncashDetailsForApprover=function(){
						UserHelper.populateEncashRequestDetails($scope);
					}
					
					$scope.addUserDetails=function(){
						UserHelper.prepareUserProfileRequest($scope);
						UserDetailsService.saveUserProfileDetails( $scope.request).success(function(data, status) {
                       $scope.taskPoller.push("userSave");
							if(!data.mobilenoVerified){
								$scope.otp.mobilenumber=data.userprofile.conatctDetails.mobilenumber;
								angular.element('#otppopup').modal('show');
						     	}
							if(!data.emailVerified){
								$scope.otp.email=data.userprofile.conatctDetails.email;
								angular.element('#otppopup').modal('show');
						     	}
								}).error(function(data, status) {
								   var errormsg='Unable to save User Profile  details : '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					
					$scope.updateAdminTask=function(task){
				     $scope.request.task=task;
                     $scope.taskPoller.push("updateAdminTask");
					  if(task.tasktype=='ENCASH_REQUEST' && task.taskstatus=='Approved'){
						  angular.element('#notificationdetails').modal('hide');
						  angular.element('#encashdetailmodal').modal('show');
						  $scope.encashdetails.encashamount=task.encashvo.encashamount;
						  $scope.encashdetails.walletnumber=task.encashvo.walletnumber;
						  $scope.encashdetails.username=task.encashvo.username;
						  $scope.encashdetails.approver=$localStorage.profile.userprofile.logindetails.username;
					 }else{
				       angular.element('#encashdetailmodal').modal('hide');
				      AdminService.updateAdminTask($scope.request).success(function(data, status) {
					 angular.element('#notificationdetails').modal('hide');
					 }).error(function(data, status) {
								   var errormsg='Unable to Update Task Details: '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					 }
				    $scope.saveEncashDetails=function(){
					//UserHelper.populateTaskWithEncashRequestDetails($scope.request.task);
					$scope.request.task.encashvo.encashtype=$scope.encashdetails.encashmethod;
                    $scope.request.task.encashvo.refrencenumber=$scope.encashdetails.refrence;					
					AdminService.updateAdminTask($scope.request).success(function(data, status) {
					 $scope.taskPoller.push("saveEncashDetails");
					 angular.element('#encashdetailmodal').modal('hide');
					 }).error(function(data, status) {
								   var errormsg='Unable to Update Task Details: '+status;
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
					
			$scope.uploadFile = function(files) {
               $scope.request.fd = new FormData();
              //Take the first selected file
              $scope.request.fd.append("file", files[0]);
			  UserDetailsService.uploadImages($scope.request).success(function(data, status) {
				  $scope.documentid=data.documentID;
			  }).error(function(data, status) {
								   var errormsg='Unable to upload Image';
									$rootScope.$emit("callAddAlert", {type:'danger',msg:errormsg});
									$exceptionHandler(errormsg);
								});
					}
	
					
			 } ]);
}());