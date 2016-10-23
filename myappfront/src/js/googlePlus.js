/**
 * Created by aymane on 4/11/16.
 */
var app = angular.module('app', ['googleplus']);

app.config(['GooglePlusProvider', function(GooglePlusProvider) {
    GooglePlusProvider.init({
        clientId: '935253580367-p12ed3rbfdsfc4dcbah7iuv5itsrco54.apps.googleusercontent.com',
        apiKey: 'derp'
    });
}]);