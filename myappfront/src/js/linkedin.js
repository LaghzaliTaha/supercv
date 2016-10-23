//LinkedIn functions
//Execute on load profile 
function onLinkedInLoad() {
	IN.Event.on(IN, "auth", function() {
		onLinkedInLogin();
	});
	IN.Event.on(IN, "logout", function() {
		onLinkedInLogout();
	});
}

//execute on logout event
function onLinkedInLogout() {
	location.reload(true);
}

	//$scope.getLinkedInData();
//execute on login event
function onLinkedInLogin() {
	// pass user info to angular
	angular.element(document).ready(function(){

			angular.element(document.getElementById("linkedinlogin")).scope().$apply(
		function($scope) {
			$scope.getLinkedInData();
		}
	);
			
	});
}