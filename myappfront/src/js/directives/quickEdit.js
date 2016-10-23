/**
 * Created by alibousenna on 03/05/2016.
 */
angular.module('app').directive("quickEdit", function() {
    return {
        restrict: 'A',
        require: "?ngModel", // require ngModel on the same HTML element as quickEdit
        link: function(scope, element, attrs, ngModel) {
            ngModel.$render = function() {
                element.text(ngModel.$viewValue || '');
            };


            // add HTML5 "contentEditable" attribute with value "true" on double click
            // this will make field editable
            element.click(function() {
                $(this).attr("contentEditable", "true");
                $(this).focus();
                event.stopPropagation();
                var elementEdit=$(this)
                $(document).click(function() {
                    elementEdit.attr("contentEditable", "false");
                    elementEdit.blur();
                    event.preventDefault();
                    read();
                    $(document).off();

                });
            });

            // handling "return/enter" and "escape" key press
            element.bind('keydown', function(event) {
                var keycode = (event.keyCode ? event.keyCode : event.which);
                // on "enter" set "contentEditable" to "false" to make field not-editable again
                // and call "read" method which is responsible for setting new value to the object in ngModel
                if (keycode === 13) { // ENTER
                    $(this).attr("contentEditable", "false");
                    $(this).blur();
                    event.preventDefault();
                    read();
                }
                // on "escape"and set the text in the element back to the original value
                // and set "contentEditable" to "false" to make field not-editable again
                if (keycode === 27) { // ESCAPE
                    element.text(ngModel.$viewValue);
                    $(this).attr("contentEditable", "false");
                    $(this).blur();
                }
            });

            // this is called to update the value in the object after edit
            function read() {
                var text = element.text();
                ngModel.$setViewValue(text);
            }
        }
    }});