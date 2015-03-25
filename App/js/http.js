/**

* notesApp Module

*

* Description

*/

angular.module('notesApp', [])

.controller('MainCtrl', ['$http', '$log', function($http, $log){



        var self = this;



        self.persons = [];



        self.newPerson={};







        var getPersonList = function(){



                var urlPersons = 'http://localhost:8081/RESTService/api/person';



                $http.get(urlPersons).then(function(response){



                        self.persons = response.data;



                },function(data){



                        $log.log('error ' + data);



                });

        };



        getPersonList();               



        self.getPerson = function(id){



                var urlPerson = 'http://localhost:8081/RESTService/api/person/'+id;



                $http.get(urlPerson).success(function(data){



                        self.person = data;



                        $log.log(self.person);



                }).error(function(data){



                        $log.log('error ' + data);



                });

        };



        self.addPerson = function(){



                $http.post('http://localhost:8081/RESTService/api/person', self.newPerson)

                .then(getPersonList)

                .then(function(response){

                        self.newPerson={};

                });



        };



}]);