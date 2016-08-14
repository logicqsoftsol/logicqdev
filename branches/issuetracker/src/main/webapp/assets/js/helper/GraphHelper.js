(function () {
		'use strict';
		angular.module('issuetracker').factory('GraphHelper', ['$http' ,function ($http){

		return {
			populateTaskDetails: function ($scope) {
								return  $scope.taskgraphdetails = {
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
								            text: "%v Tasks"
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
								            text: "Created",
								            values:[10],
								            backgroundColor: "#076696",
								        }, {
								            text: "Closed",
								            values:[7],
								            backgroundColor: "#008000"
								        },
								         {
								            text: "pending",
								            values:[2],
								            backgroundColor: "#B8240D"
								        }]
								    };
								    
							},
							populateComplainDetails: function ($scope) {
								return  $scope.complaingraphdetails = {
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
								            text: "%v Complain"
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
								            text: "Pending",
								            values:[5],
								            backgroundColor: "#B8240D",
								        }, {
								            text: "Closed",
								            values:[7],
								            backgroundColor: "#008000"
								        },
								         {
								            text: "Created",
								            values:[2],
								            backgroundColor: "#07968B"
								        }]
								    };
								    
							},
				populateProductSellDetails: function ($scope) {
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
									      labels : ['1st', '2nd', '3rd', '4th', '5th', '6th']
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
										  labels : ['2', '4', '6', '8', '10', '12']
									    },
									    series : [
									        {
									            values : [2,2,3,4,1,1],
									            text : "smartclass",
									            lineColor : "#00ACF2",
									            marker : {
									        borderColor : "#00ACF2"
									      }
									        },
									        {
									            values : [0,1,3,2,1,2],
									            text : "security",
									      lineColor : "#86CA00",
									      marker : {
									        borderColor: "#86CA00"
									      }
									        },
									        {
									            values : [0,1,2,1,2,0],
									            text : "computer&services",
									      lineColor : "#FF4B47",
									      marker : {
									        borderColor: "#FF4B47"
									      }
									        }
									    ]
									};
								
							},
							populateExpenseCollectionDetails: function ($scope) {
								return $scope.expcoldatagraph = {
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
									        visible : true
									      },
									      labels : ['1st', '2nd', '3rd', '4th', '5th', '6th', '7th']
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
										  labels : ['10', '20', '30', '40', '50', '60', '70']
									    },
									    series : [
									        {
									            values : [1,5,4,5,3,0,0],
									            text : "Expense",
									            lineColor : "#00ACF2",
									            marker : {
									        borderColor : "#00ACF2"
									      }
									        },
									        {
									            values : [2,3,6,2,5,1,5],
									            text : "Collection",
									      lineColor : "#86CA00",
									      marker : {
									        borderColor: "#86CA00"
									      }
									        },
									        {
									            values : [1,1,1,4,2,3,8],
									            text : "Dues",
									      lineColor : "#FF4B47",
									      marker : {
									        borderColor: "#FF4B47"
									      }
									        }
									    ]
									};
								
							},
							deptPerfData: function ($scope) {
								return $scope.deptperfgraphdata = {
										type : 'bar',
										"scale-x": {
										   "label":{ /* Scale Title */
											"text":"Here is a category scale",
											},
											"labels":["Month 1","Month 2","Month 3","Month 4","Month 5","Month 6","Month 7","Month 8"] /* Scale Labels */
											},
									  globals: {
								            shadow: false,
								            fontFamily: "Verdana",
								            fontWeight: "100"
								        },
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
								        series: [{
								            text: "Marketing",
								            values:[1,4,5,5,10],
								            backgroundColor: "#B8240D",
								        }, {
								            text: "Technical",
								            values:[9,3,4,5,6],
								            backgroundColor: "#0CA6AD"
								        }, {
								            text: "Accounts",
								            values:[3,8,2,5,6],
								            backgroundColor: "#7F38DF"
								        },
								         {
								            text: "Managing",
								            values:[5,5,4,7,6],
								            backgroundColor: "#B9DF38"
								        }]
								    };
							},
							}

							
					}]);

					}());