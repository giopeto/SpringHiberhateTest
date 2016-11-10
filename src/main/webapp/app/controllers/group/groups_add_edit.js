'use strict';

/* Group Add Edit Controller */

ngApp.lazy.controller('groupsAddEditCtrl', function($scope, $log, GroupFactory) {

    var groupScope = this;
    groupScope.group = new GroupFactory();
    groupScope.isLoading = false;
    /*groupScope.group = {
       name: '',
    };*/
    groupScope.allGroups = [];

    groupScope.set = function (args) {
        groupScope.isLoading = true;
        $log.log(groupScope.group);

        GroupFactory.save(groupScope.group, function (data) {
            $log.log("Success: ", data);
            groupScope.allGroups.push(data);
            groupScope.isLoading = false;
        }, function (error) {
            $log.log("Error: ", error);
            groupScope.isLoading = false;
        });
    };

    groupScope.get = function () {
        groupScope.isLoading = true;
        groupScope.allGroups = GroupFactory.query({}, function() {
            groupScope.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            groupScope.isLoading = false;
        });
    };

    groupScope.update = function (args) {
        groupScope.isLoading = true;
        GroupFactory.update(args, function (data) {
            $log.log("Success: ", data)
            groupScope.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            groupScope.isLoading = false;
        });
    };

    groupScope.delete = function (args) {
        groupScope.isLoading = true;
        GroupFactory.delete(args, function (data) {
            $log.log("Success: ", data);
            groupScope.get();
            groupScope.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            groupScope.isLoading = false;
        });
    };


    groupScope.get();

});
