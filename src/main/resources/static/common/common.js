
/**
 * jQuery扩展
 */
jQueryExtend = {
    /**
     * 是否已经进行jq的ajax加密重写
     */
    ajaxExtendFlag : false,
    /**
     * 扩展jquery对象方法
     */
    fnExtend : function(){
        /**
         * 拓展表单对象：用于将对象序列化为JSON对象
         */
        $.fn.serializeObject = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

        /**
         * 拓展表单对象：表单自动回显
         * 使用参考：$("#form1").form({"id":"112","username":"ff","password":"111","type":"admin"});
         */
        $.fn.form = function (data) {
            let form = $(this);
            for (let i in data) {
                let name = i;
                let value = data[i];
                if (name !== "" && value !== "") {
                    valuAtion(name, value);
                }
            }

            function valuAtion(name, value) {
                if (form.length < 1) {
                    return;
                }
                if (form.find("[name='" + name + "']").length < 1) {
                    return;
                }
                let input = form.find("[name='" + name + "']")[0];
                if ($.inArray(input.type, ["text", "password", "hidden", "select-one", "select", "textarea"]) > -1) {
                    $(input).val(value);
                } else if (input.type === "radio" || input.type === "checkbox") {
                    form.find("[name='" + name + "'][value='" + value + "']").attr("checked", true);
                }
            }
        };

        /**
         * 拓展jQuery对象：快速AJAX Delete删除
         */
        $.delete = function (url, params, callback) {
            if (!params || typeof params === 'string') {
                throw new Error('Error Params：' + params);
            }

            $.ajax({
                url: url,
                type: "DELETE",
                contentType: 'application/json',//发送格式（JSON串）
                data: JSON.stringify(params),//发送参数（JSON串）
                success: function (result) {
                    callback && callback(result);
                }
            });
        };
    }
};

/**
 * 常用工具方法
 */
commonUtil = {
    /**
     * 获取当前时间，并格式化输出为：2018-05-18 14:21:46
     */
    getNowTime: function () {
        var time = new Date();
        var year = time.getFullYear();//获取年
        var month = time.getMonth() + 1;//或者月
        var day = time.getDate();//或者天

        var hour = time.getHours();//获取小时
        var minu = time.getMinutes();//获取分钟
        var second = time.getSeconds();//或者秒
        var data = year + "-";
        if (month < 10) {
            data += "0";
        }
        data += month + "-";
        if (day < 10) {
            data += "0"
        }
        data += day + " ";
        if (hour < 10) {
            data += "0"
        }


        data += hour + ":";
        if (minu < 10) {
            data += "0"
        }
        data += minu + ":";
        if (second < 10) {
            data += "0"
        }
        data += second;
        return data;
    },

    /**
     * 将我们响应的系统菜单数据转换成符合layui的tree结构
     * @param arrar  旧数据
     * @returns {Array} 新数据
     */
    updateKeyForLayuiTree: function (arrar) {
        let newArray = [];
        for (let i = 0; i < arrar.length; i++) {
            let obj1 = {};
            let obj = arrar[i];
            obj1.id = obj.menuId;
            obj1.title = obj.menuName;
            obj1.href = obj.menuPath;

            if (obj.children.length > 0) {
                obj1.children = this.updateKeyForLayuiTree(obj.children);
            }
            newArray.push(obj1);
        }
        return newArray
    },

    /**
     * 在所有系统菜单上勾选用户菜单
     * @param arrTree
     * @param userTreeString
     */
    checkedForLayuiTree:function (arrTree, userTreeString) {
        for(let tree of arrTree){
            //默认全部展开
            tree.spread=true;
            //递归子节点
            if(tree.children && tree.children.length > 0){
                tree.children = this.checkedForLayuiTree(tree.children,userTreeString);
            }else{
                //是否包含（勾选子节点默认会勾上父节点，如果勾选父节点，默认会全部勾上所有子节点）
                if(userTreeString.search(tree.id) !== -1){
                    tree.checked = true;
                }
            }
        }
        return arrTree;
    }
};





