var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http, $location) {
	// 分割图片地址函数
	var splitPicture = function(prcturesStr){
		if (prcturesStr != null) {
			var array = prcturesStr.split(",");
			return array[0];
		}
	};
	var absurl = $location.absUrl(); 
	console.log(absurl);
	var catID = absurl.split("/");
	console.log(catID[4])
	// 获得goodsInfo,绑定goodsInfo
	$http({
		url: "/cat/" + catID[4] + "/products" + "?sort=sort_sales&offset=0&number=15",
		method: "get"
	}).success(function(result){
		$scope.goodsInfo = result['data'];
		for (var i = 0; i < $scope.goodsInfo.length; i++) {
			$scope.goodsInfo[i].goods[0].picture = splitPicture($scope.goodsInfo[i].goods[0].picture);
		}
		console.log($scope.goodsInfo);
	});
	
	// 获得prosInfo,绑定prosInfo
	$http({
		url: "/cat/" + catID[4] + "/properties",
		method: "get"
	}).success(function(result){
		$scope.prosInfo = result['data'];
		console.log($scope.prosInfo);
	});
});

