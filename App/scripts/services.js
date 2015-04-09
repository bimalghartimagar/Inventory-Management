
angular.module('productApp')
	.factory('ProductService', ['$http', function($http){
		return {
			getProducts: function(){
				return $http.get('http://192.168.79.149:8081/RESTService/api/product');
			},

			getProduct: function(id){
				return $http.get('http://192.168.79.149:8081/RESTService/api/product/'+id);
			},

			addProduct: function(product){
				return $http.put('http://192.168.79.149:8081/RESTService/api/product', product);
			},

			updateProduct: function(product, id){
				return $http.put('http://192.168.79.149:8081/RESTService/api/product/'+id, product);
			}
		};
	}]);