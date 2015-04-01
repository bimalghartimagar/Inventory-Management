angular.module('filtersApp',[])
.controller('FilterCtrl', [function(){
	var self = this;

	self.amount = 1024;
	self.totalCost = 4906;
	self.name = 'Bimal Gharti Magar';
	self.startTime = new Date().getTime();

	self.notes = [
	{label: 'FC Todo', type: 'chore', done: false},
	{label: 'FT Todo', type: 'task', done: false},
	{label: 'FF Todo', type: 'fun', done: true},
	{label: 'SC Todo', type: 'chore', done: false},
	{label: 'ST Todo', type: 'task', done: true},
	{label: 'SF Todo', type: 'fun', done: true},
	{label: 'TC Todo', type: 'chore', done: false},
	{label: 'TT Todo', type: 'task', done: false},
	{label: 'TF Todo', type: 'fun', done: false}
	];
	self.sortOrder = ['+type', '-label'];
	self.filterOptions = {
		"string": '',
		"object": {done: false, label: 'C'},
		"function": function(note) {
			return note.type === 'task' && note.done === false;
		}
	};
	self.currentFilter = 'string';
}]);
