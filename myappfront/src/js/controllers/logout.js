'use strict';

/* Controllers */
// logout controller
app.controller('logoutController',  function ($cookies, $http, $location, $q, $resource, $scope, Cookies,  Login,$state,userInfo,$window) {

    $scope.user = {};
    $scope.authError = null;

    $scope.logout = function() {

        Login.logout( function (data, status, headers, config) {
            userInfo.userInfo = null;

           delete $window.sessionStorage["userInfo"] ;
            $state.go('access.signin');
			//retrieve values from LinkedIn
		IN.User.logout();
		delete $rootScope.userprofile;
		$rootScope.loggedUser = false;
		$location.path("/login");

        }, function(data, status, headers, config) {

        });




    }
})
;