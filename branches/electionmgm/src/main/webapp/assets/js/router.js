(function () {
   
    angular.module('electionmgm').config(function ($stateProvider, $urlRouterProvider) {
    
        // setting up the states
        
        $urlRouterProvider.otherwise("/");
             $stateProvider
                .state('login', {
                    url: "/login",
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
                .state('booth', {
                    url: "/booth",
                    templateUrl:"assets/views/booth/boothadmin.html",
                    controller:'BoothAdminController'
                    
                }),
                $stateProvider
                .state('panchyat', {
                    url: "/panchyat",
                    templateUrl:"assets/views/panchyat/panchyatadmin.html",
                    controller:'PanchyatAdminController'
                    
                }),
                $stateProvider
                .state('village', {
                    url: "/village",
                    templateUrl:"assets/views/village/villageadmin.html",
                    controller:'VillageAdminController'
                    
                }),
                $stateProvider
                .state('ward', {
                    url: "/ward",
                    templateUrl:"assets/views/ward/wardadmin.html",
                    controller:'WardAdminController'
                    
                }),
                $stateProvider
                .state('emgm', {
                    url: "/emgm",
                    templateUrl:"assets/views/electionmgm/emgm.html",
                    controller:'EmgmController'
                    
                }),
                $stateProvider
                .state('zonal', {
                    url: "/zonal",
                    templateUrl:"assets/views/zonal/zonaladmin.html",
                    controller:'ZonalAdminController'
                    
                }),
                $stateProvider
                .state('authusers', {
                    url: "/",
                    controller:'AuthController'
                    
                })
    });
})();