(function () {
	'use strict';
	angular.module('mlmlogicq').factory('UserHelper', ['$http' ,function ($http){

		return {
			prepareUserProfileForEdit:function ($scope){
				$scope.userprofile.firstname=$scope.userdetails.userprofile.firstname;
				$scope.userprofile.lastname=$scope.userdetails.userprofile.lastname;
				$scope.userprofile.gender=$scope.userdetails.userprofile.gender;
				$scope.userprofile.dateofbirth=new Date($scope.userdetails.userprofile.dateofbirth);
				$scope.userprofile.conatctDetails.mobilenumber=$scope.userdetails.userprofile.conatctDetails.mobilenumber;
				$scope.userprofile.conatctDetails.email=$scope.userdetails.userprofile.conatctDetails.email;
				$scope.userprofile.networkinfo.memberlevel=$scope.userdetails.userprofile.networkinfo.memberlevel;
				$scope.userprofile.conatctDetails.addressText=$scope.userdetails.userprofile.conatctDetails.addressText;
				$scope.userprofile.conatctDetails.landMark=$scope.userdetails.userprofile.conatctDetails.landMark;
				$scope.userprofile.conatctDetails.pincode=$scope.userdetails.userprofile.conatctDetails.pincode;
				$scope.userprofile.conatctDetails.district=$scope.userdetails.userprofile.conatctDetails.district;
				$scope.userprofile.conatctDetails.state=$scope.userdetails.userprofile.conatctDetails.state;
			},

				prepareUserProfileRequest: function ($scope) {
					return $scope.request.user={
							document:{
								documentID:$scope.documentid
							},
					  userprofile:{
							firstname:$scope.userprofile.firstname,
							lastname:$scope.userprofile.lastname,
							gender:$scope.userprofile.gender,
							dateofbirth:$scope.userprofile.dateofbirth,
							logindetails:{
								username:$scope.userprofile.logindetails.username,
								password:$scope.userprofile.logindetails.password,
								mobilenumber:$scope.userprofile.conatctDetails.mobilenumber,
								email:$scope.userprofile.conatctDetails.email,
								enabled:'false',
							},
							networkinfo:{
								memberid:$scope.userprofile.logindetails.username,
								parentmemberid:$scope.userprofile.networkinfo.parentmemberid,
								memberlevel:'LEVEL0',
								dateofjoin:new Date()
							},
							conatctDetails:{
								addressText:$scope.userprofile.conatctDetails.addressText,
								landMark:$scope.userprofile.conatctDetails.landMark,
								pincode:$scope.userprofile.conatctDetails.pincode,
								district:$scope.userprofile.conatctDetails.district,
								state:$scope.userprofile.conatctDetails.state,
								country:'INDIA',
								mobilenumber:$scope.userprofile.conatctDetails.mobilenumber,
								email:$scope.userprofile.conatctDetails.email,
								alternetmobilenumber:$scope.userprofile.conatctDetails.mobilenumber,
								isaddressvalid:'false'
							},
							bankAccountDetails:{
								bankName:$scope.userprofile.bankAccountDetails.bankName,
									accountNumber:$scope.userprofile.bankAccountDetails.accountNumber,
									ifsccode:$scope.userprofile.bankAccountDetails.ifsccode,
									pancardno:$scope.userprofile.bankAccountDetails.pancardno,
									accountHolderName:$scope.userprofile.bankAccountDetails.accountHolderName
							},
							socialdetails:{
								fblink:$scope.userprofile.socialdetails.fblink,
								youtubelink:$scope.userprofile.socialdetails.youtubelink,
								twiter:$scope.userprofile.socialdetails.twiter,
								linkedinlink:$scope.userprofile.socialdetails.linkedinlink,
								googlePlusLink:$scope.userprofile.socialdetails.googlePlusLink
							}
					  },
					  networkjson:{
						  name:$scope.userprofile.firstname,
						  title:$scope.userprofile.networkinfo.memberlevel,
						  category:$scope.userprofile.networkinfo.memberlevel,
						  parentid:$scope.userprofile.networkinfo.parentmemberid,
						  id:$scope.userprofile.logindetails.username,
						  children:[{}]
					  }
					};
				},
       populateOTPDetailsForEmail: function ($scope) {
		return $scope.request.otpdetails={
			reciveremailid:$scope.approval.verificationvalue,
			otpnumber:$scope.approval.otpcode,
		};				
		},
		  populateOTPDetailsForMobile: function ($scope) {
		return $scope.request.otpdetails={
			mobilenumber:$scope.approval.verificationvalue,
			otpnumber:$scope.approval.otpcode,
		};				
		},
		 populateEncashRequestDetails: function ($scope) {
				return $scope.request.encashdetails={
						encashamount:$scope.encashdetails.encashamount,
					wallentnumber:$scope.encashdetails.walletnumber,
					username:$scope.encashdetails.username,
					encashtype:$scope.encashdetails.encashmethod,
					refrencenumber:$scope.encashdetails.refrence
				};				
				},
				 populateTaskWithEncashRequestDetails: function ($scope) {
				return $scope.request.task={
					encashvo:{
						encashamount:$scope.encashdetails.encashamount,
					walletnumber:$scope.encashdetails.walletnumber,
					username:$scope.encashdetails.username,
					encashtype:$scope.encashdetails.encashmethod,
					refrencenumber:$scope.encashdetails.refrence
					}
						
				};				
				},
		}
}]);

}());