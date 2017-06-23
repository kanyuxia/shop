var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http) {
	// 获得shopcatInfo,绑定shopcatInfo
	$http({
		url: "/cart/current",
		method: "get"
	}).success(function(result){
		$scope.shopcatInfo = result['data'];
		console.log(shopcatInfo);
	});
});