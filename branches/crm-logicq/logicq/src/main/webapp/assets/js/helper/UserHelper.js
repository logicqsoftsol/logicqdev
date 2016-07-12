(function () {
	'use strict';
	angular.module('crmlogicq').factory('UserHelper', ['$http' ,function ($http){

		return {
			populateEmployee: function ($scope) {
				return $scope.request.employee={
						idetificationid : $scope.emp.idetificationid,
						basicdetails : {
							title : $scope.emp.title,
							firstName : $scope.emp.firstname,
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
				populateStudent: function ($scope) {
					return $scope.request.student={
							idetificationid : $scope.student.idetificationid,
							basicdetails : {
								title : $scope.student.title,
								firstName : $scope.student.firstname,
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
				}
		}
		
		
		
	
		
}]);

}());