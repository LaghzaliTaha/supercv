'use strict';

/* Controllers */

  // linkedinCtrl
  app.controller('linkedinCtrl', ['$scope', '$location', '$rootScope','$http',function($scope,$location,$rootScope,$http) {
  
  $scope.getLinkedInData = function() {
    if(!$scope.hasOwnProperty("userprofile")){
      IN.API.Profile("me").fields(
          [ "id", "firstName", "lastName","email-address", "pictureUrl",
              "publicProfileUrl","associations","certifications","educations","competences","languages","courses","date-of-birth"]).result(function(result) {
        // set the model
        //  var insertUser=result.values[0] ;
        $rootScope.$apply(function() {
          var userprofile =result.values[0]
          $rootScope.userprofile = userprofile;
          $rootScope.loggedUser = true;
            //go to main
          $location.path("/main");
        });
      }).error(function(err) {
        $scope.error = err;
      });
    }
  };
  //logout and go to login screen
  $scope.logoutLinkedIn = function() {
    //retrieve values from LinkedIn
    IN.User.logout();
    delete $rootScope.userprofile;
    $rootScope.loggedUser = false;
    $location.path("/login");
  };
  }]);