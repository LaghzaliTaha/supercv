angular.module("restServices",[])
.factory('RestEntry', ['$http', '$q','Cookies', function($http, $q,Cookies){
    var isCSRFTokenInvalidOrMissing = function (data, status) {
        return (status === 403 && data.message && data.message.toLowerCase().indexOf('csrf') > -1)
            || (status === 0 && data === null);
    };

    var getService=function(url){



            return $http.get(url
                    )
                .then(
                    function(response){
                        return response.data;

                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                    }
                );



    };
    var postService=function(url,object){


            // Extract the CSRF token
            var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
            console.log('Extracted the CSRF token from the cookie', csrfToken);
            // Prepare the headers
            //l' en- tête doit contenir le jeton CSRF avec le nom d' en- tête à droite, et doit déclarer un type de x-www-form-urlencoded contenu
            // (pour se conformer à ce que Spring Security attend par défaut: une soumission de formulaire standard).
            var headers = {
                'Content-Type': 'application/json'
            };
            headers[$http.defaults.xsrfHeaderName] = csrfToken;
            return $http.post(url, object,{
                    headers: headers
                })
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        return $q.reject(errResponse);

                    }
                );


    };
    var updateService =function(url,object, id){

            // Extract the CSRF token
            var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
            console.log('Extracted the CSRF token from the cookie', csrfToken);
            // Prepare the headers
            //l' en- tête doit contenir le jeton CSRF avec le nom d' en- tête à droite, et doit déclarer un type de x-www-form-urlencoded contenu
            // (pour se conformer à ce que Spring Security attend par défaut: une soumission de formulaire standard).
            var headers = {
                'Content-Type': 'application/json'
            };
            headers[$http.defaults.xsrfHeaderName] = csrfToken;
            return $http.put(url+id, object,{
                    headers: headers
                })
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        return $q.reject(errResponse);
                    }
                );



    };
    var deleteService= function(url,id){

            // Extract the CSRF token
            var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
            console.log('Extracted the CSRF token from the cookie', csrfToken);
            // Prepare the headers
            //l' en- tête doit contenir le jeton CSRF avec le nom d' en- tête à droite, et doit déclarer un type de x-www-form-urlencoded contenu
            // (pour se conformer à ce que Spring Security attend par défaut: une soumission de formulaire standard).
            var headers = {
                'Content-Type':  'application/json'
            };
            headers[$http.defaults.xsrfHeaderName] = csrfToken;
            return $http.delete(url+id,{
                    headers: headers
                })
                .then(
                    function(response){
                        return response.data;
                    },

                    function(errResponse){
                        console.error('Error while deleting user');
                    }
                );



    };

    return {

        getService: getService,

        postService: postService,

        updateService: updateService,

        deleteService:deleteService

    };

}]);
