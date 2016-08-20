/**
 * 
 */

(function () {
    'use strict';
    
 angular.module('crmlogicq').config(['$httpProvider','$provide', function ($httpProvider,$provide) {  
    $httpProvider.interceptors.push('APIInterceptor');
    $provide.decorator("$exceptionHandler", function ($delegate, $injector) {
        return function (exception, cause) {
			   var rootScope = $injector.get("$rootScope");
			  $('#processing').hide();
		      $('#displaydata').show();             
		      $delegate(exception, cause);
			//Not requird as added error message
		     //  alert(cause+'\n'+exception);
        };
    });
	
        }]);
	
 
  angular.module('crmlogicq').service('APIInterceptor', ['$sessionStorage', function ($sessionStorage) {
//            var service = this;
//            service.request = function (config) {
//                config.headers = config.headers || {};
//                if ($sessionStorage.authToken) {
//                    config.headers['AUTH-TOKEN'] = $sessionStorage.authToken;
//                }
//                return config;
//            };
//			
	return {
     'request': function(config) {
    	  if ($sessionStorage.authToken) {
              config.headers['AUTH-TOKEN'] = $sessionStorage.authToken;
          }
         $('#processing').show();
		  $('#displaydata').hide();
         return config;
      },

      'response': function(response) {
         $('#processing').hide();
		  $('#displaydata').show();
         return response;
      }
    };   

        }]);
  
  angular.module('crmlogicq').directive('loading', function () {
      return {
        restrict: 'E',
        replace:true,
        template: '<div class="loading"><i class="fa fa-spinner fa-pulse fa-4x fa-fw"></i><span>Please Wait...</span></div>',
        link: function (scope, element, attr) {
              scope.$watch('loading', function (val) {
                  if (val)
                      $(element).show();
                  else
                      $(element).hide();
              });
        }
      }
  });
		
angular.module('crmlogicq').directive('showErrors', function ($timeout, showErrorsConfig) {
      var getShowSuccess, linkFn;
      getShowSuccess = function (options) {
        var showSuccess;
        showSuccess = showErrorsConfig.showSuccess;
        if (options && options.showSuccess != null) {
          showSuccess = options.showSuccess;
        }
        return showSuccess;
      };
      linkFn = function (scope, el, attrs, formCtrl) {
        var blurred, inputEl, inputName, inputNgEl, options, showSuccess, toggleClasses;
        blurred = false;
        options = scope.$eval(attrs.showErrors);
        showSuccess = getShowSuccess(options);
        inputEl = el[0].querySelector('[name]');
        inputNgEl = angular.element(inputEl);
        inputName = inputNgEl.attr('name');
        if (!inputName) {
          throw 'show-errors element has no child input elements with a \'name\' attribute';
        }
        inputNgEl.bind('blur', function () {
          blurred = true;
          return toggleClasses(formCtrl[inputName].$invalid);
        });
        scope.$watch(function () {
          return formCtrl[inputName] && formCtrl[inputName].$invalid;
        }, function (invalid) {
          if (!blurred) {
            return;
          }
          return toggleClasses(invalid);
        });
        scope.$on('show-errors-check-validity', function () {
          return toggleClasses(formCtrl[inputName].$invalid);
        });
        scope.$on('show-errors-reset', function () {
          return $timeout(function () {
            el.removeClass('has-error');
            el.removeClass('has-success');
            return blurred = false;
          }, 0, false);
        });
        return toggleClasses = function (invalid) {
          el.toggleClass('has-error', invalid);
          if (showSuccess) {
            return el.toggleClass('has-success', !invalid);
          }
        };
      };
      return {
        restrict: 'A',
        require: '^form',
        compile: function (elem, attrs) {
          if (!elem.hasClass('form-group')) {
            throw 'show-errors element does not have the \'form-group\' class';
          }
          return linkFn;
        }
      };
    }
  );
  
  angular.module('crmlogicq').provider('showErrorsConfig', function () {
    var _showSuccess;
    _showSuccess = false;
    this.showSuccess = function (showSuccess) {
      return _showSuccess = showSuccess;
    };
    this.$get = function () {
      return { showSuccess: _showSuccess };
    };
  });	
  
 angular.module('crmlogicq').directive('paging', function() {
      return {
          restrict: 'E',
          template: '',
          replace: true,
          link: function(scope, element, attrs) {
              scope.$watch('numPages', function(value) {
                  scope.pages = [];
                  for (var i = 1; i <= value; i++) {
                      scope.pages.push(i);
                  }
                  if (scope.currentPage > value) {
                      scope.selectPage(value);
                  }
              });
              scope.isActive = function(page) {
                  return scope.currentPage === page;
              };
              scope.selectPage = function(page) {
                  if (!scope.isActive(page)) {
                      scope.currentPage = page;
                  }
              };
              scope.selectPrevious = function() {
                   if (!scope.noNext()) {
                      scope.selectPage(scope.currentPage + 1);
                  }
              };
              scope.selectNext = function() {
                 
				  if (!scope.noPrevious()) {
                      scope.selectPage(scope.currentPage - 1);
                  }
              };
              scope.noPrevious = function() {
                  return scope.currentPage == 1;
              };
              scope.noNext = function() {
                  return scope.currentPage == scope.numPages;
              };

          }
      };
  });   
 
 
 
}());