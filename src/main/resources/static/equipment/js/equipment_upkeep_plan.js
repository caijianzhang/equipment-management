let tableIns;
let tableInsOnLine;
let tree;
layui.use(['element', 'form', 'table', 'layer', 'laydate', 'tree', 'util'], function () {
    let table = layui.table;
    let form = layui.form;//select、单选、复选等依赖form
    let element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    let laydate = layui.laydate;
    tree = layui.tree;
    let height = document.documentElement.clientHeight - 160;

    $.ajax({
        url:  ctx + "/equipment/upkeep/" + $("#equipmentId").val(),
        dataType: 'json',
        type: 'GET',
        success: function (data) {
            $("#equipmentForm").form(data.data);
            form.render();
        }
    });
});

/**
 * 提交保存
 */
function equipmentFormSave() {
    let equipmentForm = $("#equipmentForm").serializeObject();
    equipmentForm.gmtModified = commonUtil.getNowTime();
    $.post(ctx + "/equipment/upkeep/save", equipmentForm, function (data) {

        if(!data.flag){
            layer.msg(data.msg, {icon: 2,time: 2000}, function () {});
            return;
        }

        layer.msg("保存成功", {icon: 1, time: 2000}, function () {});

        //更新table、gmtModified
        $("input[name='gmtModified']").val(equipmentForm.gmtModified);
        tableIns.reload();
    });
}


