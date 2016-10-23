/**
 * Created by alibousenna on 21/04/2016.
 */
angular.module('app').factory('fakeQueryService', function($timeout, $q) {
    var FAKE_TIMEOUT = 2000;
    return function(username, fakeInvalidData) {
        var defer = $q.defer();
        $timeout(function() {
            fakeInvalidData!=username
                ? defer.resolve()
                : defer.reject();
        }, FAKE_TIMEOUT);
        return defer.promise;
    }
});