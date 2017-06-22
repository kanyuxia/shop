var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http) {
	// 获得categoryInfo,绑定categoryInfo
	$http({
		url: "/index/cats",
		method: "get"
	}).success(function(result){
		$scope.categoryInfo = result['data'];
		console.log($scope.categoryInfo);
		var count;
		if ($scope.categoryInfo.length >= 3) {
			count = 3;
		} else {
			count = $scope.categoryInfo.length;
		}
		var catIDs = new Array(count);
		for (var i = 0; i < count; i++) {
			catIDs[i] = $scope.categoryInfo[i].categoryID;
			console.log(catIDs);
		}
		$http.post("/index/info",catIDs).success(function(result){
			$scope.info = result['data'];
			console.log($scope.info);
		});
	});
	
	// 获得highsellInfo,绑定highsellInfo
	$http({
		url: "/index/highsell/6",
		method: "get"
	}).success(function(result){
		$scope.highsellInfo = result['data'];
		console.log($scope.highsellInfo);
	});
	
	
});