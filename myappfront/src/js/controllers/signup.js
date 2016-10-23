'use strict';

 // signup controller
 app.controller('SignupFormController', ['$scope', '$http', '$state', 'Login','RestEntry' , function($scope, $http, $state , Login,RestEntry) {




     $scope.fakeUsernames = "http://localhost:8089/membre/ifUseNameExiste/";
     $scope.fakeEmails = "http://localhost:8089/membre/ifEmailExiste/";
     $scope.affiche=false;
     $scope.sexe=function(){

         if($scope.data.sexe ==null)
         {
             $scope.affiche=true;
         }
     }
     $scope.submitted = false;

     $scope.interacted = function(field) {
         return $scope.submitted || field.$dirty;
     };

    $scope.authError = null;
    $scope.signup = function() {
        $scope.submitted = true;
        var userJson = {
            userName: $scope.data.username,
            nomMembre: $scope.data.first_name,
            prenomMembre:$scope.data.last_name,
            password:$scope.data.password,
            email:$scope.data.email_address,
            actived:true,
            sexe:$scope.data.sexe }



        Login.Signup(userJson, function (response)  {





                RestEntry.getService("http://localhost:8089/membre/getLogedUser").then(function (data) {
                    var  userInfo = {

                        userName: "",
                        roles   : '',
                        id      : ''
                    };

                    userInfo.userName = data.userName ;
                    userInfo.roles = data.roles ;
                    userInfo.id=data.id;
                    $window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
                    $state.go('app.resume');


                });
            },
            function (x) {
                $scope.authError = 'Server Error';
            });
    }

}]);







