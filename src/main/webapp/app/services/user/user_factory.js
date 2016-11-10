'use strict';

/* UserFactory Services */

ngApp.lazy.factory('UserFactory', function($resource, $q, $log) {
	 var resource = $resource('createAccount/:id', {id : '@id'});
	 return resource;
});