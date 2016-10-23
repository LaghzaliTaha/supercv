/**
 * Created by alibousenna on 21/03/2016.
 */
app.controller('resetpwd',  function($stateParams,$http,$scope,$state){
    $scope.show=true;
    var token;


    $http.get("http://localhost:8089/resetpassword/"+$stateParams.token)
        .then(function(response) {
            token=$stateParams.token;
        });

    $scope.resetPwd=function(){
        if($scope.pwd1==$scope.pwd2){
        $http.get('http://localhost:8089/changepassword/'+$stateParams.token+'/'+$scope.pwd1)
            .then(function(response) {
                $state.go('access.signin');

            })
            .then(function(){
                $scope.show=false;
            })
        ;}
        else {
            $scope.authError="les mots de passes ne sont pas identique";
        }
    }
});
