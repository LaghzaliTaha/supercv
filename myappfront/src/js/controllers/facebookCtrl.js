/**
 * Created by aymane on 4/6/16.
 */
'use strict';
app.controller('facebookCtrl' , ['$scope', '$http', '$state', 'Login' , function($scope, $http, $state , Login) {
    $scope.name = 'Login please' ;
    $scope.authError = null;
    $scope.FBLogin = function(){
        FB.login(function(response){
            if(response.authResponse){
                console.log('welcome! fetching your info ...');
                FB.api('/me?fields=name,email,gender,birthday,bio,hometown,education,last_name,first_name',function(response){


                    var userJson = {
                        userName: response.name,
                        nomMembre: response.first_name,
                        prenomMembre: response.last_name,
                        password: '000000',
                        email: response.email ,
                        civilite: 'marocaine',
                        actived:true,
                        sexe:false }


                   

               // Sending date to the server with the same service of a normal signup
                    console.log('Sending the date to the server');
                    Login.Signup(userJson, function (myresponse)  {





                            if (myresponse.data != null) {
                                $scope.authError = myresponse;
                            } else {
                                $state.go('app.dashboard-v1');
                            }
                        },
                        function (x) {
                            $scope.authError = 'Server Error';
                        });





                });

            }else{
                console.log('login cancelled');
            }
        } ,

            {
                //scope: 'email,user_likes'
                scope :'public_profile,email, user_birthday, user_hometown, user_location, user_likes, user_activities, user_education_history, user_work_history, user_about_me'


        });
    };

}]) ;

