/**
 * Created by echo on 2017/6/14.
 */
var products = [{"productid": 1, name: 'a'},
        {"productid": 2, name: 'b'}]


    function inserRow() {
        var row = $('#spsj').datagrid('getSelected');
        if (row) {
            var index = $('#spsj').datagrid('getRowIndex', row);
        } else {
            index = 0;
        }
        $('#spsj').datagrid('insertRow', {
            index: index,
            row: {
                productID: '',
                attributes: '',
                originalPrice: '',
                sellPrice: '',
                inventoryNumber: ''
            }
        });
    }
// 参考网址：http://www.cnblogs.com/loganni/p/5586380.html
/**
 * 保存新增或修改、删除的数据
 */
function save() {
    // 判断是否有数据改变
    if (isChanged('#spsj')) {
        // 获取插入的数据
        var inserted = $('#spsj').datagrid('getChanges', inserted);
        // 获取改变的数据
        //var updated = $('#spsj').datagrid('getChanges',updated);
        // 获取删除的数据
        //var deleted = $('#spsj').datagrid('getChanges',deleted);
        // 商品数据
        var goods = new Object();
        // 库存数据
        var Inventory = new Object();
        // 将所有数据装到一起
        var effecrow = new Object();

        // 去除空数据
        inserted = getData(inserted);
        //updated = getData(updated);
        //deleted = getData(deleted);
        // 去掉重复的数据，主要是updated中会有其他的重复数据
        //updated = deleteArray(updated,inserted);
        //updated = deleteArray(updated,deleted);

        // 拼装JSON
        effecrow = addJson(inserted);
        //effecrow["update"] = addJson(updated);
        //effecrow["delete"] = addJson(deleted);
        alertJSON(effecrow);
        // 通过ajax提交到后台进行处理
 
        $.ajax({
        	  type: 'POST',
        	  url: '/addGoods.do',
        	  contentType: 'application/json',
        	  data:JSON.stringify(effecrow),
        	  dataType:"json",
        	  success: function() {
        		  
        	  }
        	});
    }
}

/**
 * 传入一个id,判断传入id指定的表格数据是否改变
 * @param A
 * @returns {boolean}
 */
function isChanged(A) {
    if ($(A).length > 0) {
        return true;
    }
    return false;
}

/**
 * 判断传入的商品数据是否为空，去除空数据
 * @param updatedData
 */
function getData(data) {
    var temp = new Array();
    var index = 0;
    for (var i = 0; i < data.length; i++) {
        // 使用let .. in 遍历对象，判断对象属性是否全部为空
        for (let j in data[i]) {
            // 如果存在不为空的字段，则将整个对象赋给temp
            if (data[i][j] != "") {
                temp[index] = data[i];
                index++;
                break;
            }
        }
    }
    return temp;
}

/**
 * 传入两个数组，去掉A数组中B中存在的值,并返回新的A数组
 * @param A
 * @param B
 */
function deleteArray(A, B) {
    // 用临时数组保存A
    var temp = new Object();
    var index = 0;
    for (var i = 0; i < A.length; i++) {
        for (var j = 0; j < B.length; j++) {
            if (A[i] != B[j]) {
                temp[index] = A[i];
                index++;
            }
        }
    }
    return temp;
}
/**
 * 将one对象组装放入all中,action为进行的操作
 * @param one
 */
function addJson(one) {
    if (one.length > 0) {
        // 商品
        var goods = new Array();
        // 遍历one
        for (var i = 0; i < one.length; i++) {
            // 组装goods
            goods[i] = {
                goodsID: "",                                   //商品id
                createTime: "",                               //创建时间
                productID: one[i].productID, // 产品id
                attributes: one[i].attributes,               // 商品属性
                originalPrice: one[i].originalPrice,         // 原价
                sellPrice: one[i].sellPrice,                // 售价
                inventoryNumber: one[i].inventoryNumber,   // 库存数量
            }
        }
        return goods;
    }
}

function alertJSON(a) {
    alert(JSON.stringify(a));
}

/**
 * 删除一行数据
 * @param target
 */
function deleterow(target) {
    $.messager.confirm('Confirm', '确认删除？', function (r) {
        if (r) {
            $("#spsj").datagrid('deleteRow', getRowIndex(target));
        }
    })
}

function getRowIndex(target) {
    var tr = $(target).closest('tr.datagrid-row');
    alert(parseInt(tr.attr('datagrid-row-index')));
    return parseInt(tr.attr('datagrid-row-index'));
}

function unique(arr) {
    var result = [], isRepeated;
    for (var i = 0, len = arr.length; i < len; i++) {
        isRepeated = false;
        for (var j = 0, len = result.length; j < len; j++) {
            if (arr[i] == result[j]) {
                isRepeated = true;
                break;
            }
        }
        if (!isRepeated) {
            result.push(arr[i]);
        }
    }
    return result;
}