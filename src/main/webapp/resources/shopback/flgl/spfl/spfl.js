/**
 * Created by echo on 2017/6/14.
 */
$.extend($.fn.datagrid.methods, {
    editCell: function(jq,param){
        return jq.each(function(){
            var opts = $(this).datagrid('options');
            var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor1 = col.editor;
                if (fields[i] != param.field){
                    col.editor = null;
                }
            }
            $(this).datagrid('beginEdit', param.index);
            for(var i=0; i<fields.length; i++){
                var col = $(this).datagrid('getColumnOption', fields[i]);
                col.editor = col.editor1;
            }
        });
    }
});

var editIndex = undefined;
function endEditing(){
    if (editIndex == undefined){return true}
    if ($('#dg').datagrid('validateRow', editIndex)){
        $('#dg').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}
function onClickCell(index, field){
    if (endEditing()){
        $('#dg').datagrid('selectRow', index)
            .datagrid('editCell', {index:index,field:field});
        editIndex = index;
    }
}


/**
 * 点击新增按钮，弹出一个对话框，在其中添加需要新增的内容
 */
function add() {
    $('#add').dialog({
        title: '新增',
        width: 600,
        height: 400,
        cache: false,
        modal: true,
        href:'add.html',
        /*
        toolbar:[{
            text:'保存',
            iconCls:'icon-save',
            handler:function(){
                // 此处写ajax提交代码
                alert(JSON.stringify($('#spfladd')));
            }
        }]*/
    }).show();
}
// 参考网址：http://www.cnblogs.com/loganni/p/5586380.html
/**
 * 保存表格中被修改的数据
 */
function save() {
    // 判断是否有数据改变
    if($('#dg').datagrid('getChanges').length) {
        // 获取改变的数据
        var updated = $('#dg').datagrid('getChanges',updated);
        // 获取删除的数据
        var deleted = $('#dg').datagrid('getChanges',deleted);
        // 将所有数据装到一起
        var effecrow = new Object();
        alert(JSON.stringify(deleted));
        updated = deleteArray(updated,deleted);
        effecrow = {'updated':updated,
            'deleted':deleted};
        alert(JSON.stringify(effecrow));


        // 用户确认进行数据修改后的保存操作
        if(confirm("是否保存")) {
            // 通过ajax提交到后台进行处理
            $.ajax({
                type: 'POST',
                url: 'url',
                data: category,
                // 执行成功返回值
                success: function () {
                    $("#dg").datagrid('reload');
                },
                // 错误处理
                error: function () {
                    alert('更新数据时发生了错误');
                    $("#dg").datagrid('reload');
                }
            })
        } else {
            alert("取消保存");
        }
    }
}



/**
 * 传入两个数组，去掉A数组中B中存在的值,并返回新的A数组
 * @param A
 * @param B
 */
function deleteArray(A,B) {
    // 用临时数组保存A
    var temp = A;
    for(var i = 0; i < A.length; i++) {
        for (var j = 0; j < B.length; j++) {
            if(A[i] == B[j]) {
                temp.splice(i,1);
            }
        }
    }
    return temp;
}

function delrow(target) {
    $.messager.confirm('Confirm','确认删除？',function (r) {
        if(r) {
            $('#dg').datagrid('deleteRow',getRowIndex(target));
        }
    })
}

function getRowIndex(target){
    var tr = $(target).closest('tr.datagrid-row');
    return parseInt(tr.attr('datagrid-row-index'));
}