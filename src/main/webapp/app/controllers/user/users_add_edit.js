'use strict';

/* User Add Edit Controller */

ngApp.lazy.controller('usersAddEditCtrl', function($scope, $log, UserFactory) {
	
	var usersScope = this;
	usersScope.user = new UserFactory();
	/*usersScope.user = {
		firstName: '',
		lastName: '',
		email: '',
		userName: '',
		password: ''
	};*/
	usersScope.allUsers = [];
	
	usersScope.set = function () {
		UserFactory.save(usersScope.user, function (data) {
			$log.log("Success: ", data);
			usersScope.get();
		}, function (error) {
			$log.log ("Error: ", error);
		});
	};

	usersScope.get = function () {
		usersScope.allUsers = UserFactory.query({}, function() {
		}, function (error) {
			$log.log ("Error: ", error);
		});
	};

	usersScope.get();



});