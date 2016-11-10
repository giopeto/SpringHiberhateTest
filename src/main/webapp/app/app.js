//Define an angular module for our app
var ngApp = angular.module('gifts', ['ngRoute', 'ngResource']);

ngApp.config(function ($controllerProvider, $compileProvider, $filterProvider, $provide, $routeProvider, $httpProvider) {
	
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

	ngApp.lazy = {
        controller: $controllerProvider.register,
       	directive: $compileProvider.directive,
        filter: $filterProvider.register,
        factory: $provide.factory,
        service: $provide.service
    };
   
    $routeProvider.when('/users_add_edit', {
		templateUrl: 'app/templates/user/users_add_edit.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([
					'app/controllers/user/users_add_edit.js',
					'app/services/user/user_factory.js',
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function () {
						console.log ('ERROR');
					});
				});
				return deferred.promise;
			}]
		}
	}).when('/groups_add_edit', {
		templateUrl: 'app/templates/group/groups_add_edit.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([

					'app/controllers/group/groups_add_edit.js',
					'app/services/group/group_factory.js',
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function () {
						console.log ('ERROR');
					});
				});
				return deferred.promise;
			}]
		}
	}).when('/items_add_edit', {
		templateUrl: 'app/templates/items/items_add_edit.html',
		resolve: {
			load: ['$q', '$rootScope', function ($q, $rootScope) {
				var deferred = $q.defer();
				require([

					'app/controllers/items/items_add_edit.js',
					'app/services/items/item_factory.js',
					'app/services/group/group_factory.js',
				], function () {
					$rootScope.$apply(function () {
						deferred.resolve();
					}, function () {
						console.log ('ERROR');
					});
				});
				return deferred.promise;
			}]
		}
	}).otherwise({
		redirectTo: '/users_add_edit',
	});



});