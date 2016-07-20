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
							id:$scope.emp.basicdetailid,
							title : $scope.emp.title,
							firstname : $scope.emp.firstname,
							middlename : $scope.emp.middlename,
							lastname : $scope.emp.lastname,
							gender : $scope.emp.gender,
							dateofbirth : new Date(
									$scope.emp.dateofbirth),
						},
						contactdetails : {
							id:$scope.emp.contactdetailid,
							addressdetails : {
								id:$scope.emp.addressdetailid,
								addresstext : $scope.emp.address,
								landmark : $scope.emp.landmark,
								city : $scope.emp.city,
								pincode : $scope.emp.pincode,
								state : $scope.emp.state,
								country : $scope.emp.country,
							},
							communicationdetails : {
								id:$scope.emp.communicationdetailid,
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
					$scope.emp.basicdetailid=data.basicdetails.id;
					$scope.emp.title=data.basicdetails.title;
					$scope.emp.firstname=data.basicdetails.firstname;
					$scope.emp.middlename=data.basicdetails.middlename;
					$scope.emp.lastname=data.basicdetails.lastname;
					$scope.emp.gender=data.basicdetails.gender;
					$scope.emp.dateofbirth=new Date(data.basicdetails.dateofbirth);
					$scope.emp.contactdetailid=data.contactdetails.id;
					$scope.emp.addressdetailid=data.contactdetails.addressdetails.id;
					$scope.emp.address=data.contactdetails.addressdetails.addresstext;
					$scope.emp.landmark=data.contactdetails.addressdetails.landmark;
					$scope.emp.city=data.contactdetails.addressdetails.city;
					$scope.emp.pincode=data.contactdetails.addressdetails.pincode;
					$scope.emp.state=data.contactdetails.addressdetails.state;
					$scope.emp.country=data.contactdetails.addressdetails.country;
					$scope.emp.communicationdetailid=data.contactdetails.communicationdetails.id;
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
								id:$scope.student.basicdetailid,
								title : $scope.student.title,
								firstname : $scope.student.firstname,
								middlename : $scope.student.middlename,
								lastname : $scope.student.lastname,
								gender : $scope.student.gender,
								dateofbirth : new Date($scope.student.dateofbirth),
							},
							contactdetails : {
								id:$scope.student.contactdetailid,
								addressdetails : {
									id:$scope.student.addressdetailid,
									addresstext : $scope.student.address,
									landmark : $scope.student.landmark,
									city : $scope.student.city,
									pincode : $scope.student.pincode,
									state : $scope.student.state,
									country : $scope.student.country,
								},
								communicationdetails : {
									id:$scope.student.communicationdetailid,
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
					$scope.student.basicdetailid=data.basicdetails.id;
					$scope.student.contactdetailid=data.contactdetails.id;
					$scope.student.addressdetailid=data.contactdetails.addressdetails.id;
					$scope.student.addresstext=data.contactdetails.addressdetails.addresstext;
					$scope.student.landmark=data.contactdetails.addressdetails.landmark;
					$scope.student.city=data.contactdetails.addressdetails.city;
					$scope.student.pincode=data.contactdetails.addressdetails.pincode;
					$scope.student.state=data.contactdetails.addressdetails.state;
					$scope.student.country=data.contactdetails.addressdetails.country;
					$scope.student.communicationdetailid=data.contactdetails.communicationdetails.id;
					$scope.student.mobilenumber=data.contactdetails.communicationdetails.mobilenumber;
					$scope.student.emailid=data.contactdetails.communicationdetails.emailid;
					$scope.student.emergencycontactnumber=data.contactdetails.communicationdetails.emergencycontactnumber;
					$scope.student.communicationtype=data.contactdetails.communicationdetails.communicationtype;
					},
					
					
					pouplateStudentForDelete: function ($scope,data) {
						$scope.studentdel.id=data.id;
						$scope.studentdel.userid=data.userid;
						$scope.studentdel.name=data.name;
						},
						
						pouplateEmployeeForDelete: function ($scope,data) {
							$scope.empdel.id=data.id;
							$scope.empdel.userid=data.userid;
							$scope.empdel.name=data.name;
							},
		
		
		
		populateEventDetailsForOperation: function ($scope) {
		return $scope.request.eventd={
			eventid:$scope.eventd.eventid,
			eventname:$scope.eventd.name,
			eventtype:$scope.eventd.type,
			applicablefor:$scope.eventd.entity
		};
		},
		
		populateEventDetailsForRowClick: function ($scope,data) {
			$scope.eventd.eventid=data.eventid;
			$scope.eventd.name=data.eventname;
			$scope.eventd.type=data.eventtype;
			$scope.eventd.entity=data.applicablefor;
		},	
		
		
	populateEventCalendarDetailsForOperation: function ($scope) {
		return $scope.request.calendar={
			calendarid:$scope.eventcalendarid,
			eventstartdate:$scope.calendar.eventstartdate,
			eventenddate:$scope.calendar.eventenddate,	
			comments:$scope.calendar.comments,
			eventdetails : {
				eventid:$scope.calendar.eventid,
				eventname :$scope.calendar.eventname,
				eventtype : $scope.calendar.eventtype,
				applicablefor : $scope.calendar.applicablefor,
			}
		};
		},
	setClickedRowForEventCalendarDetails: function ($scope,data) {
			$scope.eventcalendarid=data.calendarid;
			$scope.calendar.eventstartdate=data.eventstartdate;
			$scope.calendar.eventenddate=data.eventenddate;
			$scope.calendar.comments=data.comments;
			$scope.calendar.eventid=data.eventdetails.eventid;
			$scope.calendar.eventname=data.eventdetails.eventname;
			$scope.calendar.eventtype=data.eventdetails.eventtype;
			$scope.calendar.applicablefor=data.eventdetails.applicablefor;
		},	
		formatEventCalendarDateType: function ($scope) {
			angular.forEach($scope.calendardetailslist, function(value, key) {
			$scope.calendar.eventstartdate=new Date(value.eventstartdate);
			$scope.calendar.eventenddate==new Date(value.eventenddate);
													});
		},	
		populateNotificationDetailsForOperation: function ($scope) {
			return $scope.request.notificationtemplate={
					templateid:$scope.notificationtemplate.templateid,
					templatetext:$scope.notificationtemplate.templatetext,
				eventdetails : {
					eventid:$scope.notificationtemplate.eventid,
					eventname :$scope.notificationtemplate.eventname,
					eventtype : $scope.notificationtemplate.eventtype,
					applicablefor : $scope.notificationtemplate.applicablefor,
				}
			};
			},
	
			setRowForNotificationTemplate: function ($scope,data) {
				$scope.notificationtemplate.templateid=data.templateid;
				$scope.notificationtemplate.templatetext=data.templatetext;
				$scope.notificationtemplate.eventid=data.eventdetails.eventid;
				$scope.notificationtemplate.eventname=data.eventdetails.eventname;
				$scope.notificationtemplate.applicablefor=data.eventdetails.applicablefor;
			},		
			
		}
		
}]);

}());