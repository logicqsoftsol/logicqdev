(function () {
	'use strict';
	angular.module('crmlogicq').factory('UserHelper', ['$http' ,function ($http){

		return {
			populateEmployeeForSave: function ($scope) {
				return $scope.request.employee={
						idetificationid : $scope.emp.idetificationid,
						userid:$scope.emp.userid,
						id:$scope.selectedemployee,
						basicdetails : {
							title : $scope.emp.title,
							firstname : $scope.emp.firstname,
							middlename : $scope.emp.middlename,
							lastname : $scope.emp.lastname,
							gender : $scope.emp.gender,
							dateofbirth : new Date(
									$scope.emp.dateofbirth),
						},
						contactdetails : {
							addressdetails : {
								addresstext : $scope.emp.address,
								landmark : $scope.emp.landmark,
								city : $scope.emp.city,
								pincode : $scope.emp.pincode,
								state : $scope.emp.state,
								country : $scope.emp.country,
							},
							communicationdetails : {
								mobilenumber : $scope.emp.mobilenumber,
								emailid : $scope.emp.emailid,
								emergencycontactnumber : $scope.emp.emergencycontactnumber,
								communicationtype : $scope.emp.communicationtype
							}
						}

					};
				},
				populateEmployeeForEdit: function ($scope,data) {
					$scope.emp.idetificationid=data.idetificationid;
					$scope.emp.id=data.id;
					$scope.emp.userid=data.userid;
					$scope.emp.title=data.basicdetails.title;
					$scope.emp.firstname=data.basicdetails.firstname;
					$scope.emp.middlename=data.basicdetails.middlename;
					$scope.emp.lastname=data.basicdetails.lastname;
					$scope.emp.gender=data.basicdetails.gender;
					$scope.emp.dateofbirth=new Date(data.basicdetails.dateofbirth);
					$scope.emp.address=data.contactdetails.addressdetails.addresstext;
					$scope.emp.landmark=data.contactdetails.addressdetails.landmark;
					$scope.emp.city=data.contactdetails.addressdetails.city;
					$scope.emp.pincode=data.contactdetails.addressdetails.pincode;
					$scope.emp.state=data.contactdetails.addressdetails.state;
					$scope.emp.country=data.contactdetails.addressdetails.country;
					$scope.emp.mobilenumber=data.contactdetails.communicationdetails.mobilenumber;
					$scope.emp.emailid=data.contactdetails.communicationdetails.emailid;
					$scope.emp.emergencycontactnumber=data.contactdetails.communicationdetails.emergencycontactnumber;
					$scope.emp.communicationtype=data.contactdetails.communicationdetails.communicationtype;
					},
				
				populateStudentForSave: function ($scope) {
					return $scope.request.student={
							idetificationid : $scope.student.idetificationid,
							userid:$scope.student.userid,
							id:$scope.selectedstudent,
							basicdetails : {
								title : $scope.student.title,
								firstname : $scope.student.firstname,
								middlename : $scope.student.middlename,
								lastname : $scope.student.lastname,
								gender : $scope.student.gender,
								dateofbirth : new Date($scope.student.dateofbirth),
							},
							contactdetails : {
								addressdetails : {
									addresstext : $scope.student.address,
									landmark : $scope.student.landmark,
									city : $scope.student.city,
									pincode : $scope.student.pincode,
									state : $scope.student.state,
									country : $scope.student.country,
								},
								communicationdetails : {
									mobilenumber : $scope.student.mobilenumber,
									emailid : $scope.student.emailid,
									emergencycontactnumber : $scope.student.emergencycontactnumber,
									communicationtype : $scope.student.communicationtype
								}
							}

						};
				},
				populateStudentForEdit: function ($scope,data) {
					$scope.student.idetificationid=data.idetificationid;
					$scope.student.id=data.id;
					$scope.student.userid=data.userid;
					$scope.student.title=data.basicdetails.title;
					$scope.student.firstname=data.basicdetails.firstname;
					$scope.student.middlename=data.basicdetails.middlename;
					$scope.student.lastname=data.basicdetails.lastname;
					$scope.student.gender=data.basicdetails.gender;
					$scope.student.dateofbirth=new Date(data.basicdetails.dateofbirth);
					$scope.student.address=data.contactdetails.addressdetails.addresstext;
					$scope.student.landmark=data.contactdetails.addressdetails.landmark;
					$scope.student.city=data.contactdetails.addressdetails.city;
					$scope.student.pincode=data.contactdetails.addressdetails.pincode;
					$scope.student.state=data.contactdetails.addressdetails.state;
					$scope.student.country=data.contactdetails.addressdetails.country;
					$scope.student.mobilenumber=data.contactdetails.communicationdetails.mobilenumber;
					$scope.student.emailid=data.contactdetails.communicationdetails.emailid;
					$scope.student.emergencycontactnumber=data.contactdetails.communicationdetails.emergencycontactnumber;
					$scope.student.communicationtype=data.contactdetails.communicationdetails.communicationtype;
					},
		}
		
		
		
	
		
}]);

}());