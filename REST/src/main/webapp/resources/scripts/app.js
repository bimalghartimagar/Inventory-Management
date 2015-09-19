
angular.module('productApp', ['ngRoute'])
.config(['$routeProvider',function($routeProvider){
	$routeProvider
	.when('/products', {
		templateUrl: 'resources/views/products.html',
		controller: 'ProductListCtrl as productListCtrl',
		resolve: {
			productList: ['ProductService', function(ProductService){
				return ProductService.getProducts();
			}]

		}
	})
	.when('/product/edit/:id',{
		templateUrl: 'resources/views/product.html',
		controller: 'ProductUpdateCtrl as productUpdateCtrl'
	})
	.when('/product/add',{
		templateUrl: 'resources/views/new_product.html',
		controller: 'ProductAddCtrl as productAddCtrl'
	})
	.when('/', {
			templateUrl: 'resources/views/main.html',
			controller: 'HomeCtrl as homeCtrl',
			resolve: {
				categoryList: ['ProductService', function(ProductService){
					return ProductService.getCategories();
				}]
				
			}
		})
	.otherwise({
		redirectTo: '/'
	})
}])