/**
 * 
 */

(function () {
    'use strict';
    
 angular.module('crmlogicq').config(['$httpProvider', function ($httpProvider) {
            
            $httpProvider.interceptors.push('APIInterceptor');
           
        }]);

  angular.module('crmlogicq').service('APIInterceptor', ['$sessionStorage', function ($sessionStorage) {
            var service = this;
            service.request = function (config) {
                config.headers = config.headers || {};
                if ($sessionStorage.authToken) {
                    config.headers['AUTH-TOKEN'] = $sessionStorage.authToken;
                }
                return config;
            };

        }]);
  
}());