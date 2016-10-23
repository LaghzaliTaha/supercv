/**
 * Created by alibousenna on 17/03/2016.
 */
angular.module('app').factory('userInfo' , function ($window ){
    
    
    var authentified ;


    var UserLoged ;
    
    return {


       isAuthentified : function isAuthentified() {


           if( $window.sessionStorage["userInfo"]) {

               authentified = true;
               return authentified
           }
           else
               authentified=false;
            return authentified;
        },
        getUserInfo : function getUserInfo(){
            UserLoged= $window.sessionStorage["userInfo"]
            return UserLoged ;
        }

}}

);