var app = angular.module('orders',[]);
app.controller('ordersController', function($scope, $http) {

    // $http({
    //     method: 'GET',
    //     url: 'item.shop.com/10003/current'
    // }).then(function(result) {
    //     if (result.data.success == true) {
    //         $scope.name = result.data.data;
    //     }
    // });

    $scope.orders = [];

    $http({
        method: 'GET',
        url: '/order/current'
    }).then(function(result) {
        $scope.orders = result.data.data;
        console.log(result);
        for(var i = 0; i<$scope.orders.length; i++){
            if(i<$scope.orders[i].status == 1){
                $scope.orders[i].statusName = "待付款";
            } else if($scope.orders[i].status == 2){
                $scope.orders[i].statusName = "已付款";
            } else if($scope.orders[i].status == 3){
                $scope.orders[i].statusName = "已收货";
            } else if($scope.orders[i].status == 4){
                $scope.orders[i].statusName = "已评价";
            }
        }

    });

    $scope.change = function (status, id) {
        $http({
            method: 'GET',
            url: '/orders/changeStatus?status='+status+"&ordersID="+id
        }).then(function(result) {
            console.log(result);
        });
    }

});