/**
* Module
*
* Description
*/
angular.module('productApp')
	.factory('ProductService', ['$http', function($http){
		return {
			getProducts: function(){
				return $http.get('http://localhost:8081/RESTService/api/product');
			},

			getProduct: function(id){
				return $http.get('http://localhost:8081/RESTService/api/product/'+id);
			}
		};
	}]).factory('UserService', ['', function(){
		return function name(){
			
		};
	}])