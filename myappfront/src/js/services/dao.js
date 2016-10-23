/**
 * Created by alibousenna on 08/03/2016.
 */
angular.module("RestServices").factory('RestEntry', ['$http', '$q', function($http, $q){

    return {

        getAll: function(url) {
            return $http.get(url)
                .then(
                    function(response){

                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },

        add: function(url,object){
            return $http.post(url, object)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating object');
                        return $q.reject(errResponse);
                    }
                );
        },

        updateUser: function(url,object, id){
            return $http.put(url+id, object)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while updating object');
                        return $q.reject(errResponse);
                    }
                );
        },

        delete: function(url,id){
            return $http.delete(url+id)
                .then(
                    function(response){
                        return response.data;
                    },

                    function(errResponse){
                        console.error('Error while deleting user');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);

