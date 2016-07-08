/**
 * 
 */

(function () {
    'use strict';
    
 angular.module('crmlogicq').config(['$httpProvider', function ($httpProvider) {
            
            $httpProvider.interceptors.push('APIInterceptor');
           
        }]);

 (function (ChartJsProvider) {
	  ChartJsProvider.setOptions({ colors : [ '#803690', '#00ADF9', '#DCDCDC', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360'] });
	}); 
 
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