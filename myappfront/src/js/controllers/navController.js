app.controller('navController'  , function($scope,$state,userInfo,RestEntry,$window) {
    var currentUser=JSON.parse(userInfo.getUserInfo());
    RestEntry.getService("http://localhost:8089/membre/find/cvs/"+currentUser.id).then(function(data){
       $scope.cvs=data;

    })
    $scope.theme=function(key){
        $window.sessionStorage["ID-CV"]=key;
        $state.transitionTo('app.dashboard-v1', null, {'reload':true});
    }
})
