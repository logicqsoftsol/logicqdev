(function () {
	'use strict';
	angular.module('mlmlogicq').factory('UserHelper', ['$http' ,function ($http){

		return {

				prepareUserProfileRequest: function ($scope) {
					return $scope.request.user={
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
								memberlevel:$scope.userprofile.networkinfo.memberlevel,
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
		}
}]);

}());