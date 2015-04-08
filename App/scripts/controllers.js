angular.module('productApp')
.controller('HomeCtrl', [function(){
var self = this;
var i = 0;
self.click = function(){
	alert(i++);
}

}])
.controller('ProductListCtrl', ['ProductService', function(ProductService){

	var self = this;

	self.products = [];

	self.fieldName = 'id';

	self.reverseSort = false;

	ProductService.getProducts().then(function(response){
		self.products = response.data;
	})

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