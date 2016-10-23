/**
 * Created by alibousenna on 21/04/2016.
 */
angular.module('app').directive('fakeRemoteRecordValidator', ['$timeout', 'fakeQueryService','RestEntry', function($timeout, fakeQueryService,RestEntry,$scope) {
    return {
        require: 'ngModel',
        link : function(scope, element, attrs, ngModel) {
            var nature=scope.$eval(attrs.fakeRemoteRecordValidator);

            ngModel.$parsers.push(function(value) {
                var seedData;
                RestEntry.getService(nature+value).then(function(d){
                    seedData= d.value;
                    valid(false);
                    loading(true);
                    fakeQueryService(value, seedData).then(
                        function() {
                            valid(true);
                            loading(false);
                        },
                        function() {
                            valid(false);
                            loading(false);
                        }
                    );

                });

                return value;



            });

            function valid(bool) {
                ngModel.$setValidity('record-taken', bool);
            }

            function loading(bool) {
                ngModel.$setValidity('record-loading', !bool);
            }
        }
    }
}]);
