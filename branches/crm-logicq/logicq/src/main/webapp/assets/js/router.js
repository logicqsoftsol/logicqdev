(function () {
   
    angular.module('crmlogicq').config(function ($stateProvider, $urlRouterProvider) {
    
        // setting up the states
        
        $urlRouterProvider.otherwise("/");
             $stateProvider
                .state('login', {
                    url: "/login",
                    templateUrl:"assets/views/login/login.html",
                    controller:'LoginController'
                }),
               $stateProvider
                .state('logout', {
                    url: "/logout",
                    templateUrl:"assets/views/login/login.html",
                    controller:'LoginController'
                }),
                $stateProvider
                .state('admin', {
                    url: "/admin",
                    templateUrl:"assets/views/admin/admin.html",
                    controller:'AdminController'
                    
                }),
                $stateProvider
                .state('authusers', {
                    url: "/",
                    controller:'AuthController'
                    
                })
    });
})();