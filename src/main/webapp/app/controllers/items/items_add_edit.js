'use strict';

/* Items Add Edit Controller */

ngApp.lazy.controller('itemsAddEditCtrl', function($scope, $log, ItemFactory, GroupFactory, MeasureFactory) {

    var vm = this;
    vm.items = new ItemFactory();
    vm.isLoading = false;
    vm.items.measures = [];
    /*vm.items = {
     name: '',
     };*/
    vm.allItems = [];
    vm.measures = [];
    vm.allGroups = GroupFactory.query({}, function() {

    }, function (error) {
        $log.log ("Error: ", error);
    });
    vm.allMeasures = MeasureFactory.query({}, function() {
    }, function (error) {
        $log.log ("Error: ", error);
    });

    vm.set = function (args) {
        vm.isLoading = true;
        $log.log(vm.items);
        vm.items.group = JSON.parse(vm.items.group);

        var start = performance.now();
        //for(var i = 0; i <10000; i++) {
            ItemFactory.save(vm.items, function (data) {
               /* $log.log("Success: ", data);*/
                vm.allItems.push(data);
                vm.isLoading = false;

                var end = performance.now(),
                min = (end/1000/60) << 0,
                sec = (end/1000) % 60;
                console.log('Insert ' + i + ' records took ' + min + ' min and ' + sec + "sec.");
            }, function (error) {
                $log.log("Error: ", error);
                vm.isLoading = false;
            });
       //}


    };

    vm.get = function () {
        vm.isLoading = true;
        vm.allItems = ItemFactory.query({}, function() {
            vm.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            vm.isLoading = false;
        });
    };

    vm.update = function (args) {
        vm.isLoading = true;
        ItemFactory.update(args, function (data) {
            $log.log("Success: ", data)
            vm.isLoading = false;
            args.edit = 0;
        }, function (error) {
            $log.log ("Error: ", error);
            vm.isLoading = false;
        });
    };

    vm.delete = function (args) {
        vm.isLoading = true;
        ItemFactory.delete(args, function (data) {
            $log.log("Success: ", data);
            vm.get();
            vm.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            vm.isLoading = false;
        });
    };

    vm.addMeasure = function (args) {
        $log.log (args);
        //vm.items.measures = JSON.parse(vm.items.measures);
        vm.items.measures.push(JSON.parse(args));
    };

    vm.get();

});
