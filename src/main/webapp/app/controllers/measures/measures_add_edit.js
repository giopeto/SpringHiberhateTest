'use strict';

/* Measures Add Edit Controller */

ngApp.lazy.controller('measuresAddEditCtrl', function($scope, $log, MeasureFactory) {

    var vm = this;
    vm.measures = new MeasureFactory();
    vm.isLoading = false;
    vm.allMeasures = [];

    vm.set = function (args) {
        vm.isLoading = true;
        $log.log(vm.items);


            MeasureFactory.save(vm.measure, function (data) {
                $log.log("Success: ", data);
                vm.allMeasures.push(data);
                vm.isLoading = false;
            }, function (error) {
                $log.log("Error: ", error);
                vm.isLoading = false;
            });



    };

    vm.get = function () {
        vm.isLoading = true;
        vm.allMeasures = MeasureFactory.query({}, function() {
            vm.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            vm.isLoading = false;
        });
    };

    vm.update = function (args) {
        vm.isLoading = true;
        MeasureFactory.update(args, function (data) {
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
        MeasureFactory.delete(args, function (data) {
            $log.log("Success: ", data);
            vm.get();
            vm.isLoading = false;
        }, function (error) {
            $log.log ("Error: ", error);
            vm.isLoading = false;
        });
    };


    vm.get();

});
