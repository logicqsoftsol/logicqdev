
(function () {
	'use strict';
	angular.module('crmlogicq').factory('GraphHelper', ['$http' ,function ($http){

		return {
		populateAttendanceForGraphStudent: function ($scope,data) {
			return  $scope.studentattendace = {
			        globals: {
			            shadow: false,
			            fontFamily: "Verdana",
			            fontWeight: "100"
			        },
			        type: "pie",
			        backgroundColor: "#fff",

			        legend: {
			            layout: "x5",
			            position: "50%",
			            borderColor: "transparent",
			            marker: {
			                borderRadius: 10,
			                borderColor: "transparent"
			            }
			        },
			        tooltip: {
			            text: "%v "+"Students"//data.attendanceFor
			        },
			        plot: {
			            refAngle: "-90",
			            borderWidth: "0px",
			            valueBox: {
			                placement: "in",
			                text: "%npv %",
			                fontSize: "15px",
			                textAlpha: 1,
			            }
			        },
			        series: [{
			            text: "Present",
			            values:[100],//data.presentcount
			            backgroundColor: "#FA6E6E #FA9494",
			        }, {
			            text: "Absent",
			            values:[30],//data.absentcount
			            backgroundColor: "#F1C795 #feebd2"
			        }]
			    };
			    
		},
		populateAttendanceForEmployee: function ($scope,data) {
			return $scope.employeattendace = {
				        globals: {
				            shadow: false,
				            fontFamily: "Verdana",
				            fontWeight: "100"
				        },
				        type: "pie",
				        backgroundColor: "#fff",

				        legend: {
				            layout: "x5",
				            position: "50%",
				            borderColor: "transparent",
				            marker: {
				                borderRadius: 10,
				                borderColor: "transparent"
				            }
				        },
				        tooltip: {
				            text: "%v Employee"
				        },
				        plot: {
				            refAngle: "-90",
				            borderWidth: "0px",
				            valueBox: {
				                placement: "in",
				                text: "%npv %",
				                fontSize: "15px",
				                textAlpha: 1,
				            }
				        },
				        series: [{
				            text: "present",
				            values: [100],
				            backgroundColor: "#FA6E6E #FA9494",
				        }, {
				            text: "Absent",
				            values: [10],
				            backgroundColor: "#F1C795 #feebd2"
				        }]
				    };
		},
		populateExpenseandCollection: function ($scope) {
			return $scope.businessdata = {
				    type: "line", 
				    title: {
				      textAlign:'left',
				    },
				    crosshairX : {
				      lineColor : "#b6b6b6",
				      trigger : "move",
				      lineStyle : 'dashed',
				      marker : {
				        visible : true,
				      size : 4
				      },
				      scaleLabel : {
				        bold : true,
				        backgroundColor : "#fff",
				        fontColor : "#474747",
				        fontSize : "16px",
				        callout : false,
				        paddingTop : 2,
				        
				      },
				      plotLabel : {
				        backgroundColor : "white",
				        borderColor : "#bababa",
				        borderRadius : "5px",
				        bold : true,
				        fontSize : "12px",
				        fontColor : "#2f2f2f",
				        textAlign : 'right',
				        padding : '10px',
				        shadow : true,
				        shadowAlpha : 0.2,
				        shadowBlur : 5,
				        shadowDistance : 4,
				        shadowColor : "#a1a1a1",
				        
				      }
				    },
				    plot : {
				      tooltip : {
				        visible : false
				      },
				      aspect : 'spline',
				      marker : {
				        backgroundColor : "white",
				        borderWidth : "2px",
				      },
				      hoverMarker : {
				        backgroundColor : 'none',
				        size : 10
				      }
				    },
				    scaleX : {
				      lineColor : "#E3E8E9",
				      fontColor : "#879CAB",
				      guide :{
				        visible : true,
				        lineWidth : "1px",
				        lineColor : "#E3E8E9",
				        lineStyle : "solid"
				      },
				      tick : {
				        visible : false
				      },
				      labels : ['Mon', 'Tues', 'Weds', 'Thurs', 'Fri', 'Sat', 'Sun']
				    },
				    scaleY : {
				      lineColor : "#E3E8E9",
				      fontColor : "#879CAB",
				      guide :{
				        visible : true,
				        lineWidth : "1px",
				        lineColor : "#E3E8E9",
				        lineStyle : "solid"
				      },
				       tick : {
				        visible : false
				      },
					  labels : ['10000', '20000', '30000', '40000', '50000', '60000', '70000']
				    },
				    series : [
				        {
				            values : [3,2,4,5,4,1,0],
				            text : "Expenses",
				            lineColor : "#00ACF2",
				            marker : {
				        borderColor : "#00ACF2"
				      }
				        },
				        {
				            values : [0,0,3,4,3,1,1],
				            text : "Collection",
				      lineColor : "#86CA00",
				      marker : {
				        borderColor: "#86CA00"
				      }
				        },
				        {
				            values : [0,1,1,4,2,0,1],
				            text : "Dues",
				      lineColor : "#FF4B47",
				      marker : {
				        borderColor: "#FF4B47"
				      }
				        }
				    ]
				};
			
		},
		}
		
		
		
	
		
}]);

}());