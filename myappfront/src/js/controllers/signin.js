'use strict';

/* Controllers */
// signin controller
app.controller('SigninFormController' ,  function ($cookies, $http, $location, $q, $resource, $scope, Cookies, RestEntry ,Login,$state,$window,userInfo) {
    $scope.boxSignIn=true;
    $scope.boxSignUp=true;
$(window).scroll(function(){
    if($(window).scrollTop()>512) {
        $('.header-login-signup').css('background-color', 'white');
        $('.js-scrollTo').css('color', '#292c2f');
        $('.sama').css('color', '#292c2f');
    }
    else {
        $('.header-login-signup').css('background-color', 'transparent');
        $('.js-scrollTo').css('color', 'white');
        $('.sama').css('color', 'white');
    }
});
    //slider comfiguration
    $('.slider').fractionSlider({
        'controls': 			true,
        'pager': 				true,
        'responsive': 			true,
        'dimensions': 			"1450,770",
        'increase': 			false
    });
    //wow configuration
    var wow = new WOW(
        {
            animateClass: 'animated',
            offset:       100
        }
    );
    wow.init();
    //carousel configuration
    var carousel = $("#carousel").waterwheelCarousel({
        edgeFadeEnabled:true,
        autoPlay:3000,
        flankingItems: 6,
        forcedImageWidth:300,
        forcedImageHeight:400,
        movingToCenter: function ($item) {
            $('#callback-output').prepend('movingToCenter: ' + $item.attr('id') + '<br/>');
        },
        movedToCenter: function ($item) {
            $('#callback-output').prepend('movedToCenter: ' + $item.attr('id') + '<br/>');
        },
        movingFromCenter: function ($item) {
            $('#callback-output').prepend('movingFromCenter: ' + $item.attr('id') + '<br/>');
        },
        movedFromCenter: function ($item) {
            $('#callback-output').prepend('movedFromCenter: ' + $item.attr('id') + '<br/>');
        },
        clickedCenter: function ($item) {
            $('#callback-output').prepend('clickedCenter: ' + $item.attr('id') + '<br/>');
        }
    });
    $scope.signIn=function(){
        $scope.boxSignIn=false;
    }
    $scope.signUp=function(){
        $scope.boxSignUp=false;
    }
   $scope.close=function(nature){
       if(nature=='box-signIn')
       $scope.boxSignIn=true;
       if(nature=='box-signUp')
       $scope.boxSignUp=true;
   }

    var back
    $('#back').mouseenter(function(){
         back=setInterval(function(){carousel.prev();
        return false},1000)})
    $('#back').mouseleave(function(){clearInterval(back);})
    var next
    $('#next').mouseenter(function(){
        back=setInterval(function(){carousel.next();
            return false},1000)})
    $('#next').mouseleave(function(){clearInterval(back)})

    /*===================================*/
    $scope.user = {};
    $scope.authError = null ;

    $scope.login = function() {
        Login.login($scope.user.email, $scope.user.password, function (data, status, headers, config) {

            userInfo.authentified = true;

            // Success handle

            //------------------------- Getting the user info here --------------------------------------

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



   //------------------------------------------------------------------------------------------





        }, function(data, status, headers, config) {
            // Failure handler
            if ( status=="401" ) {
                $scope.authError = 'Email or Password not right';
            }
            if(status=="0")
                $scope.authError = 'Server Error';
        });




    }
    //signup configuration
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
                    var  userInfo = {

                        userName: "",
                        roles   : '',
                        id      : ''
                    };
                    userInfo.userName = response.userName ;
                    userInfo.roles = response.role ;
                    userInfo.id=response.idMembre;
                    $window.sessionStorage["userInfo"] = JSON.stringify(userInfo);
                    $state.go('app.resume');



            },
            function (x) {
                $scope.authError = 'Server Error';
            });
    }
    $('.js-scrollTo').on('click', function() { // Au clic sur un élément
        var page = $(this).attr('href'); // Page cible
        var speed = 750; // Durée de l'animation (en ms)
        $('html, body').animate( { scrollTop: $(page).offset().top }, speed ); // Go
        return false;
    });
})
;