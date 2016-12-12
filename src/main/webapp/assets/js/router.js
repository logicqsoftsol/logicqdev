(function () {
   
    angular.module('mlmlogicq').config(function ($stateProvider, $urlRouterProvider) {
    
        // setting up the states
        
         $urlRouterProvider.otherwise("/");
		 $urlRouterProvider.when("/dashboard","/dashboard/overview");
		  $stateProvider.state('base',{'abstract':!0,url:"",templateUrl:"assets/views/base.html"}),
             $stateProvider
                .state('login', {
					parent:'base',
                    url: "/login",
                    templateUrl:"assets/views/login/login.html",
                    controller:'LoginController'
                }),
               $stateProvider
                .state('logout', {
					parent:'base',
                    url: "/logout",
                    templateUrl:"assets/views/login/login.html",
                    controller:'LoginController'
                }),
                $stateProvider
                .state('dashboard', {
					parent:'base',
                    url: "/dashboard",
                    templateUrl:"assets/views/dashboard/dashboard.html",
                    controller:'DashboardCtrl'
                    
                }),
				 $stateProvider
                .state('overview', {
					parent: 'dashboard',
                    url: "/overview",
                    templateUrl:"assets/views/overview/overview.html",
                    controller:'DashboardCtrl'
                    
                })
                ,
				 $stateProvider
                .state('approvalpending', {
					parent: 'dashboard',
                    url: "/approvalpending",
                    templateUrl:"assets/views/overview/approval.html",
                    controller:'DashboardCtrl'
                    
                })
				 ,
				 $stateProvider
                .state('reports', {
					parent: 'dashboard',
                    url: "/reports",
                    templateUrl:"assets/views/reports/reports.html",
                    controller:'ReportCtrl'
                    
                }),
				 $stateProvider
                .state('adminoverview', {
					parent: 'dashboard',
                    url: "/adminoverview",
                    templateUrl:"assets/views/admin/adminoverview.html",
                    controller:'AdminCtrl'
                    
                })
             $stateProvider
                .state('authusers', {
                    url: "/",
					templateUrl:"assets/views/login/login.html",
                    controller:'LoginController'
                    
                })
    });
})();