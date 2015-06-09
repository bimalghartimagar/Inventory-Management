
angular.module('productApp', ['ngRoute'])
	.config(['$routeProvider',function($routeProvider){
		$routeProvider
		.when('/products', {
			templateUrl: 'resources/views/products.html',
			controller: 'ProductListCtrl as productListCtrl'
		})
		.when('/product/edit/:id',{
			templateUrl: 'resources/views/product.html',
			controller: 'ProductUpdateCtrl as productUpdateCtrl'
		})
		.when('/product/add',{
			templateUrl: 'resources/views/new_product.html',
			controller: 'ProductAddCtrl as productAddCtrl'
		})
		.otherwise({
			redirectTo: '/'
		})
	}])