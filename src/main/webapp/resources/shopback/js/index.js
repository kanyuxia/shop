/**
 * Created by echo on 2017/6/14.
 */
/**
 * 添加选项卡操作
 * @param title
 * @param url
 */
function addTab(title,url) {
    if ($('#tt').tabs('exists', title)){
        $('#tt').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
        $('#tt').tabs('add',{
            title:title,
            content:content,
            closable:true
        });
    }
}

/*
<script>
angular.module('back', ['ngRoute'])
    .controller('spflControl', function ($scope, $route) {
        $scope.spfls = [{id:'001',time:'2017.2.3',name:'家电'},
            {id:'002',time:'2016.2.3',name:'3C'},
            {id:'003',time:'2016.4.3',name:'生鲜'}];
        spflscope.manager = "小明";
    })
    .controller('spsjControl', function ($scope) {

    })
    .controller('splbControl',function($scope) {

    })
    .controller('yhlbControl',function($scope) {

    })
    .controller('ddlbControl',function($scope) {

    })
    .controller('spfladdControl', function ($scope, $route) {
        $scope.spfls = [{id:'001',time:'2017.2.3',name:'家电'},
            {id:'002',time:'2016.2.3',name:'3C'},
            {id:'003',time:'2016.4.3',name:'生鲜'}];
        $scope.manager = "小明";
    })
    .config(function ($routeProvider) {
        $routeProvider.
        when('/spfl', {
            templateUrl: 'flgl//spgl//spfl.html',
            controller: 'spflControl'
        }).
        when('/spsj', {
            templateUrl: 'flgl//spsj.html',
            controller: 'spsjControl'
        }).
        when('/splb',{
            templateUrl: 'flgl//splb.html',
            controller: 'splbControl'
        }).
        when('/ddlb',{
            templateUrl: 'ddgl//ddlb.html',
            controller: 'ddglControl'
        }).
        when('/yhlb',{
            templateUrl: 'yhgl//yhlb.html',
            controller: 'yhlbControl'
        }).
        when('/addspfl', {
            templateUrl: 'spfl//add.html',
            controller: 'spfladdControl'
        }).
        otherwise({
            template:"我不挑"
        });
    });
*/