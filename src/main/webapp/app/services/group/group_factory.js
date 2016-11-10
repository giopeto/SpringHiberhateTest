'use strict';

/* GroupFactory Services */

ngApp.lazy.factory('GroupFactory', function($resource, $q, $log) {
    var resource = $resource('groups/:id', {id : '@id'}, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }
    });


    return resource;
});
