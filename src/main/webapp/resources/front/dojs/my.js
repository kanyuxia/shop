var app = angular.module('my',[]);
app.controller('myController', function($scope, $http) {

    // $http({
    //     method: 'GET',
    //     url: 'item.shop.com/10003/current'
    // }).then(function(result) {
    //     if (result.data.success == true) {
    //         $scope.name = result.data.data;
    //     }
    // });

    $scope.user = {
        nickname : "尹健康",
        number: "12345678913",
        sex : "男"
    };
    $scope.oldpass = "-1";
    $scope.newpass = "-1";
    $scope.surepass = "-2";


    // $http({
    //     method: 'GET',
    //     url: '/order/current'
    // }).then(function(result) {
    //
    // });

    $scope.password = function () {
        if($scope.newpass!=$scope.surepass){
            message("输入的两次新密码不同！","danger");
            return;
        }
        $http({
            method: 'GET',
            url: '/pass/modifyPassword?number='+$scope.user.number+"&oldPassword="+$scope.oldpass+"&newPassword="+$scope.newpass
        }).then(function(result) {
            if (result.data.data.success){
                message("修改密码成功！", "success");
            }else{
                message(result.data.data.message, "danger")
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
});