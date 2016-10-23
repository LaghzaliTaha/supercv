'use strict';

angular.module('app').factory('Login', function ($http, $resource, Cookies) {




	/**
	 * Tries to detect whether the response elements returned indicate an invalid or missing CSRF token...
	 */
	var isCSRFTokenInvalidOrMissing = function (data, status) {
		return (status === 403 && data.message && data.message.toLowerCase().indexOf('csrf') > -1)
			|| (status === 0 && data === null);
	};

	return {

		login: function(username, password, successHandler, errorHandler) {
			var loginResources = $resource('http://localhost:8089/login', {}, {
				options: {method: 'OPTIONS', cache: false}
			});

			// Obtain a CSRF token
			loginResources.options().$promise.then(function (response) {
				console.log('Obtained a CSRF token in a cookie', response);

				// Extract the CSRF token
				var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
				console.log('Extracted the CSRF token from the cookie', csrfToken);
				// Prepare the headers
				//l' en- tête doit contenir le jeton CSRF avec le nom d' en- tête à droite, et doit déclarer un type de x-www-form-urlencoded contenu
				// (pour se conformer à ce que Spring Security attend par défaut: une soumission de formulaire standard).
				var headers = {
					'Content-Type': 'application/x-www-form-urlencoded'

				};
				headers[$http.defaults.xsrfHeaderName] = csrfToken;

				// Post the credentials for logging in
				$http.post('http://localhost:8089/login', 'username=' + username + '&password=' + password, {
					headers: headers
				})
					.success(successHandler)

					.error(function (data, status, headers, config) {

						if (isCSRFTokenInvalidOrMissing(data, status)) {
							console.error('The obtained CSRF token was either missing or invalid. Have you turned on your cookies?');

						} else {
							// Nope, the error is due to something else. Run the error handler...
							errorHandler(data, status, headers, config);
						}
					});

			}).catch(function(response) {
				console.error('Could not contact the server... is it online? Are we?', response);
			});
		},

		logout: function(successHandler, errorHandler) {
			var logoutResources = $resource('http://localhost:8089/logout', {}, {
				options: {method: 'OPTIONS', cache: false}
			});

			// Obtain a CSRF token
			logoutResources.options().$promise.then(function (response) {
				console.log('Obtained a CSRF token in a cookie', response);

				// Extract the CSRF token
				var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
				console.log('Extracted the CSRF token from the cookie', csrfToken);

				// Prepare the headers
				var headers = {
					'Content-Type': 'application/x-www-form-urlencoded'
				};
				headers[$http.defaults.xsrfHeaderName] = csrfToken;

				// Post the credentials for logging out
				$http.post('http://localhost:8089/logout', '', {
					headers: headers
				})
					.success(successHandler)
					.error(function(data, status, headers, config) {

						if (isCSRFTokenInvalidOrMissing(data, status)) {
							console.error('The obtained CSRF token was either missing or invalid. Have you turned on your cookies?');

						} else {
							// Nope, the error is due to something else. Run the error handler...
							errorHandler(data, status, headers, config);
						}
					});

			}).catch(function(response) {
				console.error('Could not contact the server... is it online? Are we?', response);
			});
		},
		forgotpwd: function(email, successHandler, errorHandler) {

				// Post the credentials for logging in
				$http.get('http://localhost:8089/send-mail/'+email)
						.success(successHandler)

						.error(function (data, status, headers, config) {

								errorHandler(data, status, headers, config);

						});


		},
 //------------------------------------------My task-------------------------------------------------
		//Sign up Service
	    Signup: function (user ,  successHandler, errorHandler) {




			    var SignupResources = $resource('http://localhost:8089/login', {}, {
					options: {method: 'OPTIONS', cache: false}
				});
			    // Obtain a CSRF token
			    SignupResources.options().$promise.then(function (response) {
				console.log('Obtained a CSRF token in a cookie', response);

				// Extract the CSRF token
				var csrfToken = Cookies.getFromDocument($http.defaults.xsrfCookieName);
				console.log('Extracted the CSRF token from the cookie', csrfToken);
				 //Prepare the headers
				//l' en- tête doit contenir le jeton CSRF avec le nom d' en- tête à droite, et doit déclarer un type de x-www-form-urlencoded contenu
				// (pour se conformer à ce que Spring Security attend par défaut: une soumission de formulaire standard).
				var headers = {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				};
				headers[$http.defaults.xsrfHeaderName] = csrfToken;


					$http.post('http://localhost:8089/membre', user , {
						headers: headers

					})


				     	.success(successHandler)
						.error(function(data, status, headers, config) {
			             if (isCSRFTokenInvalidOrMissing(data, status)) {
							   console.error('The obtained CSRF token was either missing or invalid. Have you turned on your cookies?');
						   }else {
							   // Nope, the error is due to something else. Run the error handler...
							   errorHandler(data, status, headers, config);
						   }
						});

				}).catch(function(response) {
					console.error('Could not contact the server... is it online? Are we?', response);
				});



		},


 //------------------------------------------The end-------------------------------------------------


	};
});