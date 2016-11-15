'use strict';

/* MeasureFactory Services */

ngApp.lazy.factory('MeasureFactory', function($resource) {
    var resource = $resource('measures/:id', {id : '@id'}, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }
    });

    return resource;
});