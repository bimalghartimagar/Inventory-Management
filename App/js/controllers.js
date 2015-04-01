angular.module('productApp', [])
.controller('MainCtrl',[function(){
	console.log('MainCtrl has been created');

	var self = this;

	self.change = function(){
		self.username = 'changed';
		self.password = 'password';
	};

	self.submit = function(){
		console.log('User clicked submit with ', self.username, self.password);
	};
	
	self.notes = [
	{id: 1, label: 'First Note', done: false},
	{id: 2, label: 'Second Note', done: false},
	{id: 3, label: 'Finished Third Note', done: true}
	];
}]);