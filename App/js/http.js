/**

* notesApp Module

* Description

*/

angular.module('notesApp', [])

.controller('MainCtrl', ['$http', '$log', function($http, $log){

        var self = this;

        self.products = [];

        self.newProduct ={};

        var getProductList = function(){

                var urlProducts = 'http://localhost:8081/RESTService/api/product';

                $http.get(urlProducts).then(function(response){

                        self.products = response.data;

                },function(data){

                        $log.log('error ' + data);
                });
        };

        getProductList();               

        self.getProduct = function(id){

                var urlProduct = 'http://localhost:8081/RESTService/api/product/'+id;

                $http.get(urlProduct).success(function(data){

                        self.editProduct = data;

                        $log.log(self.editProduct);

                }).error(function(data){

                        $log.log('error ' + data);

                });
        };

        self.addProduct = function(){

                $http.post('http://localhost:8081/RESTService/api/product', self.newProduct )
                .then(getProductList)
                .then(function(response){
                        self.newProduct ={};
                });
        };
}]);