var app = angular.module('simple',[]);
app.controller('simpleController', function($scope, $http, $location) {
	
	
	// 获得userInfo,绑定userInfo
	$http({
		url: "/pass/getUser",
		method: "get"
	}).then(function(result) {
		$scope.userInfo = result['data']['data'];
		console.log($scope.userInfo);
		if ($scope.userInfo == null) {
			$scope.userName = "你好，请登录!";
		} else {
			$scope.userName = "你好，" + $scope.userInfo.nickname;
		}
	});

    // $http({
    //     method: 'GET',
    //     url: 'item.shop.com/10003/current'
    // }).then(function(result) {
    //     if (result.data.success == true) {
    //         $scope.name = result.data.data;
    //     }
    // });

    

    //start------
    $scope.currentProduct = {
        // "productID": -1,
        // "createTime": -1,
        // "name": "",
        // "attributes": "",
        // "goods": [],
        // "categoryID": 10000,
        // "totalSellNumber": 0,
        // "totalInvNumber": 0,
        // "category": {
        //     "categoryID": 10000,
        //     "createTime": 1497875797000,
        //     "name": "手机"
        // }
    };

    $scope.currentGoods = {
        // "goodsID": -1,
        // "createTime": -1,
        // "attributes": "",
        // "originalPrice": -1,
        // "sellPrice": -1,
        // "productID": -1
    };

    $scope.goodsValue = {};

    $scope.property = new Array();
    $scope.selectedGoodsId = -1;
    $scope.selectedProperty = new Array();

    // 完整URL地址
	var absurl = $location.absUrl(); 
	// URL中的分类ID
	var itemID = absurl.split("/");
	console.log("hello"+itemID[4]);
    
    $http({
        method: 'GET',
        url: '/item/' + itemID[4] + '/current'
    }).then(function(result) {
        if (result.data.success == true){
            $scope.currentGoods = result.data.data;
            $scope.selectedGoodsId =  $scope.currentGoods.goodsID;
            $scope.currentGoods.pictures = $scope.currentGoods.picture.split(",");
            $http({
                method: 'GET',
                url: '/item/'+ $scope.selectedGoodsId +'/inventory'
            }).then(function(result) {
                console.log(result);
                $scope.currentGoods.inventory = result.data.data;
                console.log($scope.currentGoods);
            });
            $http({
                method: 'GET',
                url: '/item/'+ $scope.selectedGoodsId +'/properties'
            }).then(function(result) {
                console.log(result);
                $scope.goodsValue = result.data.data;
                console.log($scope.goodsValue);
            });
            $scope.currentProduct = result.data.data.product;
            $scope.currentProduct.attributeArr = $scope.currentProduct.attributes.split(",");
            //默认选择
            $scope.selectedProperty = $scope.currentGoods.attributes.split(",");
            //将属性键值对存在二维数组里
            for (var i = 0; i<$scope.currentProduct.attributeArr.length; i++) {
                $scope.property[i] = new Array;
                $scope.property[i][0] = $scope.currentProduct.attributeArr[i];
                for (var j = 0; j<$scope.currentProduct.goods.length; j++) {
                    var arr = $scope.currentProduct.goods[j].attributes.split(",");
                    $scope.property[i][j+1] = {"status" : 0,"value" : arr[i]};
                    if ($scope.selectedProperty[i] == arr[i]){
                        $scope.property[i][j+1].status = 1;
                    }
                }
            }

            console.log($scope.property);
            console.log($scope.currentProduct);
            $scope.selected();
            $scope.name = result.data.product;
        }

    });

    $scope.selected = function () {
        var str = "";
        for(var i = 0; i<$scope.selectedProperty.length; i++){
            str = str + $scope.selectedProperty[i] + ",";
        }
        console.log(str);
        for (var i = 0; i<$scope.currentProduct.goods.length; i++) {
            console.log($scope.currentProduct.goods[i].attributes + ",");
            if ($scope.currentProduct.goods[i].attributes + "," == str){
                $scope.selectedGoodsId = $scope.currentProduct.goods[i].goodsID;
                console.log($scope.selectedGoodsId);
                return;
            }
        }
        message("该商品不存在！","info");
    }

    $scope.selectProperty = function (index, value) {
        console.log(index);
        $scope.selectedProperty[index] = value;
        console.log($scope.selectedProperty);
        $scope.selected();
//        $scope.panduan(index);
    }

    //加入购物车
    $scope.addShopCar = function () {

        $http({
            method: 'POST',
            url: '/cart/addcart?gid='+$scope.selectedGoodsId,
            data : {
                gid :  $scope.selectedGoodsId
            }
        }).then(function(result) {
            if(result.data.data == true){
                message("添加购物车成功！","success");
            }else {
                message("添加购物车失败！","danger");
            }

        });
    }

    function message(messages, type){
        $.bootstrapGrowl(messages, {
            ele: 'body', // which element to append to
            type: type, // (null, 'warning', 'info', 'danger', 'success')
            offset: {from: 'top', amount: 60}, // 'top', or 'bottom'
            align: 'right', // ('left', 'right', or 'center')
            width: 250, // (integer, or 'auto')
            delay: 4000,
            allow_dismiss: true,
            stackup_spacing: 10 // spacing between consecutively stacked growls.
        });
    };

    $scope.panduan = function(index){
        // for (var i = 0; i<$scope.property.length; i++) {
        //     if (i = index) continue;
        //     for (var a = 0; a<$scope.currentProduct.goods; a++){
        //         var arrs = new Array();
        //         for (var b = 0; b < $scope.property[i].length; b++){
        //
        //         }
        //         if($scope.currentProduct.goods[a].attributes.split(",")[i] == $scope.property[i]){
        //             arrs[i] = 1;
        //         }
        //     }
        //     for (var j = 0; j<$scope.property[i].length; j++){
        //
        //     }
        // }
        var goods =  $scope.currentProduct.goods;
        for (var i = 0; i<$scope.property.length; i++) {
            if (i = index) continue;

            console.log("-------");

            for(var a = 0; a<goods.length; a++){
                var arrs = goods[a].attributes.split(",");
                // for (var b = 0; b<arrs.length; b++) {
                //     if (value == arrs[index] && $scope.selectedProperty[b]) {
                //         $scope.property[index][b + 1]
                //     }
                // }
                //删掉与选择无关的商品
                for (var b = 0; b<$scope.selectedProperty.length; b++){
                    if (b == i) continue;
                    if ($scope.selectedProperty[b] != arrs[b]) {
                        goods.splice(a,1);
                        break;
                    }
                }
            }
            console.log(goods);
            for(var a = 0; a<goods.length; a++){
                var arrs = goods[a].attributes.split(",");
                for (var b = 1; b<$scope.property[i].length; b++){
                    if ($scope.property[i][b].value == arrs[i]){
                        $scope.property[i][b].status = 2;
                        continue;
                    }
                }
            }
        }


        for (var i = 0; i<$scope.property.length; i++) {
            for (var j = 1; j<$scope.property[i].length; j++){
                if ($scope.property[i][j].status == 2){
                    $scope.property[i][j].status == 0;
                    if ($scope.property[i][j].value == $scope.selectedProperty[j-1]){
                        $scope.property[i][j].status == 1;
                    }
                } else{
                    $scope.property[i][j].status == -1;
                }
            }
        }
        console.log($scope.property);


    }

});