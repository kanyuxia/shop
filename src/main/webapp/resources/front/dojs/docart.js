var app = angular.module('myApp', []);
app.controller('controller', function($scope, $http) {
	// 获得userInfo,绑定userInfo
	$http({
		url: "/pass/getUser",
		method: "get"
	}).then(function successCallback(result){
		console.log(result);
		$scope.userInfo = result['data']['data'];
		console.log($scope.userInfo);
		if ($scope.userInfo == null) {
			$scope.userName = "你好，请登录!";
		} else {
			$scope.userName = "你好，" + $scope.userInfo.nickname;
		}
	});
	
	// 总价格
	var total = 0;
	
	// 获得shopcatInfo,绑定shopcatInfo
	$http({
		method: 'GET',
		url: '/cart/current'
	}).then(function successCallback(result) {
		if (result['data']['success'] == false) {
			window.location = '/pass/login';
		} else {
			$scope.shopcatInfo = result['data']['data'];
			for (var i = 0; i < $scope.shopcatInfo.length; i++) {
				$scope.shopcatInfo[i].goods[0].picture = splitPicture($scope.shopcatInfo[i].goods[0].picture);
				total = total + $scope.shopcatInfo[i].goodsNumber * $scope.shopcatInfo[i].goods[0].sellPrice;
			}
			$scope.total = total;
			console.log($scope.total);
			console.log($scope.shopcatInfo);
		}
	});
	
	
	// 分割图片地址函数
	var splitPicture = function(prcturesStr){
		if (prcturesStr != null) {
			var array = prcturesStr.split(",");
			return array[0];
		}
	}
	
	// 删除函数
	$scope.deleteShopcart = function(shopCartID) {
		console.log(shopCartID);
		$http({
			method: 'get',
			url: '/cart/delete' + "?sid=" + shopCartID
		}).then(function successCallback(result) {
			var successed = result['data']['success'];
			console.log(successed);
			if (successed) {
				for (var i = 0; i < $scope.shopcatInfo.length; i++) {
					if ($scope.shopcatInfo[i].shopCartID == shopCartID) {
						$scope.shopcatInfo.splice(i,1);
						console.log($scope.shopcatInfo);
						break;
					}
				}
				$scope.total = 0;
				for (var i = 0; i < $scope.shopcatInfo.length; i++) {
					$scope.shopcatInfo[i].goods[0].picture = splitPicture($scope.shopcatInfo[i].goods[0].picture);
					$scope.total = $scope.tota + $scope.shopcatInfo[i].goodsNumber * $scope.shopcatInfo[i].goods[0].sellPrice;
				}
			}
		});
	}
		
		
	// 购买函数
	$scope.commit = function() {
		var order = {};
		order.harvestAddress = "四川成都";
		order.status = 1;
		order.totalPrice = $scope.total;
		order.userID = $scope.userInfo.userID;
		order.items = [];
		
		console.log(order);
		for (var i = 0; i < $scope.shopcatInfo.length; i++) {
			var orderItem = {};
			orderItem.goodsNumber = $scope.shopcatInfo[i].goodsNumber;
			orderItem.goodsID = $scope.shopcatInfo[i].goods[0].goodsID;
			order.items[i] = orderItem;
		}
		$http.post("/order/commit",order).then(function successCallback(result) {
			var successed = result['data']['success'];
			window.location = '/index';
		});
	}
});