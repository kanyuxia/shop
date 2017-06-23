var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http) {
	// 获得categoryInfo,绑定categoryInfo
	$http({
		url: "/index/cats",
		method: "get"
	}).success(function(result){
		$scope.categoryInfo = result['data'];
		var count;
		if ($scope.categoryInfo.length >= 3) {
			count = 3;
		} else {
			count = $scope.categoryInfo.length;
		}
		var catIDs = new Array(count);
		for (var i = 0; i < count; i++) {
			catIDs[i] = $scope.categoryInfo[i].categoryID;
		}
		$http.post("/index/info",catIDs).success(function(result){
			$scope.info = result['data'];
		});
	});
	
	// 获得highsellInfo,绑定highsellInfo
	$http({
		url: "/index/highsell/6",
		method: "get"
	}).success(function(result){
		$scope.highsellInfo = result['data'];
//		console.log($scope.highsellInfo);
	});
	
	// 获得userInfo,绑定userInfo
	$http({
		url: "/pass/getUser",
		method: "get"
	}).success(function(result){
		$scope.userInfo = result['data'];
		console.log($scope.userInfo);
		if ($scope.userInfo == null) {
			$scope.userName = "你好，请登录!";
		} else {
			$scope.userName = "你好，" + $scope.userInfo.nickname;
		}
	});
});