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
	
	// 获得userInfo,绑定userInfo
	$http({
		url: "/pass/getUser",
		method: "get"
	}).then(function(result) {
		console.log(result);
		$scope.userInfo = result['data']['data'];
		console.log($scope.userInfo);
		$scope.user = $scope.userInfo;
		if ($scope.userInfo == null) {
			window.location = '/pass/login';
		} else {
			$scope.userName = "你好，" + $scope.userInfo.nickname;
		}
	});

    $scope.user = {};
    
    $scope.newpass = "";
    $scope.surepass = "";
    $scope.oldpass = "";


//   

    $scope.password = function () {
    	if($scope.oldpass == "" || $scope.newpass == "" || $scope.surepass == ""){
    		 message("input is null!","danger");
    		 return;
    	}
        if($scope.newpass!=$scope.surepass){
            message("new password input different!","danger");
            return;
        }
        console.log($scope.oldpass);
        $http({
            method: 'GET',
            url: '/pass/modifyPassword?number='+$scope.user.number+"&oldPassword="+$scope.oldpass+"&newPassword="+$scope.newpass
        }).then(function(result) {
        	console.log(result);
            if (result.data.success){
                message("success!", "success");
            }else{
                message(result.data.message, "danger")
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