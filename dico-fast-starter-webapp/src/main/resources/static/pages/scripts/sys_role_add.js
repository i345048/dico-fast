var SysRoleAdd = function(){

    var addRole=function(){
        //获取表单元素
        var formData = $('form').serializeArray();
        var d = {};
        $.each(formData, function(i, item) {
            if (item.name && item.value) {
                if (item.value != '') {
                    d[item.name] = item.value;
                }
            }
        });

        $.ajax({
            url: App.getGlobalContentPath() + '/roles/add',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(d)
        }).done(function(data) {
            if (data.code == 200) {
                $.bootstrapGrowl('新增角色成功!', {
                    ele: 'body', // which element to append to
                    type: 'success', // (null, 'info', 'danger', 'success', 'warning')
                    offset: {
                        from: 'top',
                        amount: 100
                    }, // 'top', or 'bottom'
                    align: 'right', // ('left', 'right', or 'center')
                    width: 'auto', // (integer, or 'auto')
                    delay: 5000, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
                    allow_dismiss: true, // If true then will display a cross to close the popup.
                    stackup_spacing: 10 // spacing between consecutively stacked growls.
                });
                Layout.loadAjaxContent(App.getGlobalContentPath() + '/roles/list');
            }
        });
    }

    return {
        init:function(){
            $('.form-actions .commit').on('click',function(){
                addRole();
            });

        }
    }
}()

$(document).ready(function(){
    SysRoleAdd.init();
});