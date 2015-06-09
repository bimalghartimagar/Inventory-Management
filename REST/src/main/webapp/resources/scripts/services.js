
angular.module('productApp')
	.factory('ProductService', ['$http', function($http){
		return {
			getProducts: function(){
				return $http.get('api/product');
			},

			getProduct: function(id){
				return $http.get('api/product/'+id);
			},

			addProduct: function(product){
				return $http.put('api/product', product);
			},

			updateProduct: function(product, id){
				return $http.put('api/product/'+id, product);
			}
		};
	}]);