angular.module('productApp')
	.controller('HomeCtrl', ['categoryList', function(categoryList){
		var self = this;

		self.categories = categoryList.data.categories;


	}])
	.controller('ProductListCtrl', ['productList', function(productList){

		var self = this;

		self.products = productList.data.products;

		self.fieldName = 'id';

		self.reverseSort = false;

	

	}])
	.controller('ProductUpdateCtrl', ['ProductService','$location','$routeParams', function(ProductService, $location, $routeParams){
		var self = this;

		self.product = {};

		ProductService.getProduct($routeParams.id).then(function(response){
			self.product = response.data;
			self.id = self.product.id;
		});

		self.updateProduct = function(){
			ProductService.updateProduct(self.product, self.product.id).then(function(response){
				$location.path('/products');
				$location.replace();
			})
		};
	}])
	.controller('ProductAddCtrl', ['ProductService','$location', function(ProductService, $location){
		var self = this;

		self.product = {};

		self.addProduct = function(){
			console.log(self.product);
			ProductService.addProduct(self.product).then(function(response){
				$location.path('/products');
				$location.replace();
			});
		}


	}]);