(function () {
   
    angular.module('issuetracker').config(function ($stateProvider, $urlRouterProvider) {
    
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
                .state('client', {
                    url: "/client",
                    templateUrl:"assets/views/client/client.html",
                    controller:'ClientController'
                    
                }),
                $stateProvider
                .state('serviceengg', {
                    url: "/serviceengg",
                    templateUrl:"assets/views/serviceengg/serviceengg.html",
                    controller:'ServiceEnginerController'
                    
                }),
                $stateProvider
                .state('account', {
                    url: "/account",
                    templateUrl:"assets/views/account/account.html",
                    controller:'AccountController'
                    
                }),
                $stateProvider
                .state('inventory', {
                    url: "/inventory",
                    templateUrl:"assets/views/inventory/inventory.html",
                    controller:'InventoryController'
                    
                }),
                $stateProvider
                .state('fieldengg', {
                    url: "/fieldengg",
                    templateUrl:"assets/views/serviceengg/fieldengg/fieldengg.html",
                    controller:'FieldEnginerController'
                    
                }),
                $stateProvider
                .state('emgm', {
                    url: "/emgm",
                    templateUrl:"assets/views/electionmgm/emgm.html",
                    controller:'EmgmController'
                    
                }),
                $stateProvider
                .state('authusers', {
                    url: "/",
                    controller:'AuthController'
                    
                })
    });
})();