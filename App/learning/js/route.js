angular.module('routeApp', ['ngRoute'])
	.config(['$routeProvider',function($routeProvider) {
		
		$routeProvider.when('/', {
			template: '<h3>This is default route</h3>'
		})
		.when('/second',{
			template: '<h3>This is second route</h3>'
		})
		.otherwise({redirectTo: '/'})
	}]);
