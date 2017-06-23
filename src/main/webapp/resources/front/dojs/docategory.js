var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http, $location) {
	// 完整URL地址
	var absurl = $location.absUrl(); 
	// URL中的分类ID
	var catID = absurl.split("/")[4];
	// 起始偏移量
	var offset = 0;
	// 商品数量
	var number = 15;
	// 最后一页以及第一页提示符
	$scope.hint = "";
	
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
	
	// 第一次加载获得goodsInfo,绑定goodsInfo
	$http({
		url: "/cat/" + catID + "/products" + "?sort=sort_sales&offset=" + offset + "&number=" + number,
		method: "get"
	}).success(function(result){
		$scope.goodsInfo = result['data'];
		for (var i = 0; i < $scope.goodsInfo.length; i++) {
			$scope.goodsInfo[i].goods[0].picture = splitPicture($scope.goodsInfo[i].goods[0].picture);
			
		}
		// 设置起始偏移量为放回的商品的数量
		offset = offset + $scope.goodsInfo.length;
	});
	// 加载prosInfo
	$http({
		url: "/cat/" + catID + "/properties",
		method: "get"
	}).success(function(result){
		$scope.prosInfo = result['data'];
		console.log($scope.prosInfo);
	});
	
	
	// 分割图片地址函数
	var splitPicture = function(prcturesStr){
		if (prcturesStr != null) {
			var array = prcturesStr.split(",");
			return array[0];
		}
	}
	
	// 上一页函数
	$scope.prePage = function() {
		offset = offset - number;
		console.log(offset);
		// 判断是否已经是第一页了
		if (offset <= 0) {
			$scope.hint="已经是第一页了";
		} else {
			offset = offset - number;
			if (offset <= 0) {
				offset = 0;
			}
			// 获得goodsInfo,绑定goodsInfo
			$http({
				url: "/cat/" + catID[4] + "/products" + "?sort=sort_sales&offset=" + offset + "&number=" + number,
				method: "get"
			}).success(function(result){
				$scope.goodsInfo = result['data'];
				for (var i = 0; i < $scope.goodsInfo.length; i++) {
					$scope.goodsInfo[i].goods[0].picture = splitPicture($scope.goodsInfo[i].goods[0].picture);
				}
				console.log($scope.goodsInfo);
			});
		}
	}
	
	// 下一页函数
	$scope.nextPage = function() {
		if (offset <= 0) {
			offset = 0;
		}
		// 获得goodsInfo,绑定goodsInfo
		$http({
			url: "/cat/" + catID[4] + "/products" + "?sort=sort_sales&offset=" + offset + "&number=" + number,
			method: "get"
		}).success(function(result){
			var resultInfo = result['data'];
			if (resultInfo.length == 0) {
				$scope.hint="已经没有商品了"
			} else {
				$scope.goodsInfo = resultInfo;
				for (var i = 0; i < $scope.goodsInfo.length; i++) {
					$scope.goodsInfo[i].goods[0].picture = splitPicture($scope.goodsInfo[i].goods[0].picture);
				}
				// 设置起始偏移量为放回的商品的数量
				offset = offset + $scope.goodsInfo.length;
			}
		});
	}
});

