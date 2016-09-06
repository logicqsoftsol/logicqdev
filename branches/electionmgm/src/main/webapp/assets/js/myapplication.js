/**
 * 
 */

(function () {
    'use strict';
    
   angular.module('electionmgm', ['ui.bootstrap','zingchart-angularjs','ngMap',
                                   'ui.router','checklist-model','ngStorage'
  ]).constant('AppConstants', {
	   'hostName':'http://127.0.0.1:', 
	   'hostPort': '8090' ,
	   'applicationName' : '/electionmgm' ,
	   'get' : 'GET' ,  
	   'post' : 'POST' ,
	   'loginURL' :'/api/login',
       'loadDefaultUserURL':'/prelogin/loadDefaultUsers'
	}).directive('ngConfirmClick', [
	                                   function(){
	                                       return {
	                                           link: function (scope, element, attr) {
	                                               var msg = attr.ngConfirmClick || "Are you sure?";
	                                               var clickAction = attr.confirmedClick;
	                                               element.bind('click',function (event) {
	                                                   if ( window.confirm(msg) ) {
	                                                       scope.$eval(clickAction)
	                                                   }
	                                                   else{
	                                                	   
	                                                   }
	                                               });
	                                           }
	                                       };
	                               }]);
  
}());