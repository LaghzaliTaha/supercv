/**
 * Created by alibousenna on 20/03/2016.
 */
app.controller('forgotpwd',  function ($cookies, $http, $location, $q, $resource, $scope, Cookies,  Login,$state,userInfo,$window) {
$scope.forgotpwd=function() {

    Login.forgotpwd($scope.email,  function (data, status, headers, config) {



        $scope.isCollapsed = !$scope.isCollapsed;


    }, function(data, status, headers, config) {
        // Failure handler
        if ( status=="500" ) {
            $scope.authError = 'Email  not right';
        }
        if(status=="0")
            $scope.authError = 'Server Error';
    });




}
})
;
