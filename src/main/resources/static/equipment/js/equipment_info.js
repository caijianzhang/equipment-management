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

    //用户列表
    tableIns = table.render({
        elem: '#equipmentTable'
        , url: ctx + '/equipment/info/page'
        , method: 'POST'
        //请求前参数处理
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusName: 'flag' //规定数据状态的字段名称，默认：code
            , statusCode: true //规定成功的状态码，默认：0
            , msgName: 'msg' //规定状态信息的字段名称，默认：msg
            , countName: 'records' //规定数据总数的字段名称，默认：count
            , dataName: 'rows' //规定数据列表的字段名称，默认：data
        }
        //响应后数据处理
        , parseData: function (res) { //res 即为原始返回的数据
            var data = res.data;
            return {
                "flag": res.flag, //解析接口状态
                "msg": res.msg, //解析提示文本
                "records": data.records, //解析数据长度
                "rows": data.rows //解析数据列表
            };
        }
        , toolbar: '#equipmentTableToolbarDemo'
        , title: '设备列表'
        , cols: [[
            {field: 'id', title: 'ID', hide: true}
            , {field: 'name', title: '设备名称'}
            , {field: 'number', title: '设备编号'}
            , {field: 'type', title: '设备类型'}
            , {field: 'limitMultiLogin', title: '是否允许多人在线', hide: true}
            , {field: 'limitedIp', title: '限制允许登录的IP集合', hide: true}
            , {field: 'expiredTime', title: '账号失效时间', hide: true}
            , {field: 'lastChangePwdTime', title: '最近修改密码时间', hide: true}
            , {field: 'gmtCreated', title: '创建时间', hide: true}
            , {field: 'gmtModified', title: '更新时间', hide: true}
            , {fixed: 'right', title: '操作', toolbar: '#userTableBarDemo'}
        ]]
        , defaultToolbar: ['', '', '']
        , page: true
        , height: height
        , cellMinWidth: 80
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        switch (obj.event) {
            case 'addData':
                //重置操作表单
                $("#userForm")[0].reset();
                let nowTime = commonUtil.getNowTime();
                $("input[name='gmtCreated']").val(nowTime);
                $("input[name='gmtModified']").val(nowTime);
                $("input[name='lastChangePwdTime']").val(nowTime);

                $("input[name='loginName']").removeAttr("readonly");

                form.render();
                layer.msg("请填写右边的表单并保存！");
                break;
            case 'query':
                let queryByName = $("#queryByName").val();
                let query = {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , done: function (res, curr, count) {
                        //完成后重置where，解决下一次请求携带旧数据
                        // this.where = {};
                    }
                };
                if (!queryByName) {
                    queryByName = "";
                }
                //设定异步数据接口的额外参数
                query.where = {loginName: queryByName};
                tableIns.reload(query);
                $("#queryByName").val(queryByName);
                break;
            case 'reload':
                tableInsOnLine.reload();
                break;
        }
    });

    //监听行工具事件
    table.on('tool(test)', function (obj) {
        let data = obj.data;
        //删除
        if (obj.event === 'del') {
            layer.confirm('确认删除吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/sys/sysUser/delete/" + data.userId, {}, function (data) {
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
        //编辑
        else if (obj.event === 'edit') {
            //回显操作表单
            $("#userForm").form(data);
            $("input[name='loginName']").attr("readonly","readonly");

            form.render();
        }
        //踢下线
        else if (obj.event === 'forced') {
            layer.confirm('确认强制该用户下线吗？', function (index) {
                //向服务端发送删除指令
                $.delete(ctx + "/sys/sysUser/forced/" + data.loginName, {}, function (data) {
                    tableInsOnLine.reload();
                    layer.close(index);
                })
            });
        }
    });

    //日期选择器
    laydate.render({
        elem: '#expiredTimeDate',
        format: "yyyy-MM-dd HH:mm:ss"
    });
});

/**
 * 提交保存
 */
function equipmentFormSave() {
    let userForm = $("#userForm").serializeObject();
    userForm.gmtModified = commonUtil.getNowTime();
    $.post(ctx + "/sys/sysUser/save", userForm, function (data) {

        if(!data.flag){
            layer.msg(data.msg, {icon: 2,time: 2000}, function () {});
            return;
        }

        //保存用户菜单跟用户权限,只要userId，以及Id集合就可以了
        let menuIdList = [];
        for (let check of tree.getChecked('userMenuTree')[0].children) {
            menuIdList.push(check.id);
            if (check.children && check.children.length > 0) {
                for (let check1 of check.children) {
                    menuIdList.push(check1.id);
                }
            }
        }
        let postData = {
            userId: data.data.userId,
            menuIdList: menuIdList.join(",")
        };
        $.post(ctx + "/sys/sysUserMenu/saveAllByUserId", postData, function (data) {});

        let authorityIdList = [];
        for (let check of tree.getChecked('userAuthorityTree')[0].children) {
            authorityIdList.push(check.id);
        }
        let postData2 = {
            userId: data.data.userId,
            authorityIdList: authorityIdList.join(",")
        };
        $.post(ctx + "/sys/sysUserAuthority/saveAllByUserId", postData2, function (data) {});

        layer.msg("保存成功", {icon: 1, time: 2000}, function () {});

        //更新table、gmtModified
        $("input[name='gmtModified']").val(userForm.gmtModified);
        tableIns.reload();
    });
}

