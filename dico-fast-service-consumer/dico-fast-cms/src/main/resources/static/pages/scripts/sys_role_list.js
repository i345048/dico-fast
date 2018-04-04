var SysRoleList=function(){

    var table = $('#role_table');

    var roleTable = function () {
        table.dataTable({
            deferRender: true, //当处理大数据时，延迟渲染数据，有效提高Datatables处理能力
            order: [],          //取消默认排序查询,否则复选框一列会出现小箭头
            searching: false,    //禁用原生搜索
            "serverSide": true,
            "columnDefs": [
                { 'orderable': false,'targets': [0],'width':'5%'},
                {"searchable": false,"targets": [0]}
            ],
            "ajax": {
                url: '/roles/list',
                type: 'POST',
                data: function(d) {
                    formData = $('#role_form').serializeArray();
                    if (formData && typeof formData == 'object') {
                        $.each(formData, function(i, item) {
                            if (item.name && item.value) {
                                if (item.value != '') {
                                    d[item.name] = item.value;
                                }
                            }
                        });
                    }

                    App.blockUI({
                        message: ' 数据加载中...',
                        target: table.parents(".portlet"),
                        overlayColor: 'none',
                        cenrerY: true,
                        boxed: true
                    });
                }
            },
            'columns': [
                {'title':'<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">\n' +
                    '<input type="checkbox" class="group-checkable" data-set="#role_table .checkboxes" />\n' +
                    '<span></span>\n' +
                    '</label>','data':'id','render' : function(data, type, row,meta) {
                        return '<label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">\n' +
                            '<input type="checkbox" class="checkboxes" value="'+data+'" />\n' +
                            '<span></span>\n' +
                            '</label>';
                    }},
                {'title': '角色编码','data': 'id'},
                {'title': '角色名称','data': 'name'},
            ],
            'fnDrawCallback':function(){
                App.unblockUI(table.parents(".portlet"));
                $("#role_table").find('.group-checkable').change(function () {
                    var set = jQuery(this).attr("data-set");
                    var checked = jQuery(this).is(":checked");
                    jQuery(set).each(function () {
                        if (checked) {
                            $(this).prop("checked", true);
                        } else {
                            $(this).prop("checked", false);
                        }
                    });
                });
            }
        });

    }

    var table_refresh=function(){
        $('.table-group-action-submit').on('click', function(event) {
            event.preventDefault();
            table.api().ajax.reload();
        });
    }

    var table_row_edit= function(){
        $('.fa-edit').parents('a').on('click',function(event){
            event.preventDefault();
            var checkedColumns=$("#role_table .checkboxes:checked");
            if(checkedColumns.length>1){
                alert('编辑目前只支持单行记录！');
                return false;
            }

            var primaryKey=checkedColumns.val();
            Layout.loadAjaxContent(App.getGlobalContentPath() + '/roles/edit/'+primaryKey);
        })
    }

    var table_row_delete= function(){
        $('.fa-trash').parents('a').on('click',function(event){
            event.preventDefault();

            var sa_title = $(this).data('title');
            var sa_message = $(this).data('message');
            var sa_type = $(this).data('type');
            var sa_allowOutsideClick = $(this).data('allow-outside-click');
            var sa_showConfirmButton = $(this).data('show-confirm-button');
            var sa_showCancelButton = $(this).data('show-cancel-button');
            var sa_closeOnConfirm = $(this).data('close-on-confirm');
            var sa_closeOnCancel = $(this).data('close-on-cancel');
            var sa_confirmButtonText = $(this).data('confirm-button-text');
            var sa_cancelButtonText = $(this).data('cancel-button-text');
            var sa_popupTitleSuccess = $(this).data('popup-title-success');
            var sa_popupMessageSuccess = $(this).data('popup-message-success');
            var sa_popupTitleCancel = $(this).data('popup-title-cancel');
            var sa_popupMessageCancel = $(this).data('popup-message-cancel');
            var sa_confirmButtonClass = $(this).data('confirm-button-class');
            var sa_cancelButtonClass = $(this).data('cancel-button-class');
            swal({
                    title: sa_title,
                    text: sa_message,
                    type: sa_type,
                    allowOutsideClick: sa_allowOutsideClick,
                    showConfirmButton: sa_showConfirmButton,
                    showCancelButton: sa_showCancelButton,
                    confirmButtonClass: sa_confirmButtonClass,
                    cancelButtonClass: sa_cancelButtonClass,
                    closeOnConfirm: sa_closeOnConfirm,
                    closeOnCancel: sa_closeOnCancel,
                    confirmButtonText: sa_confirmButtonText,
                    cancelButtonText: sa_cancelButtonText,
                },
                function(isConfirm){
                    if (isConfirm){
                        delete_request();
                    } else {
                        swal(sa_popupTitleCancel, sa_popupMessageCancel, "error");
                    }
                });
        })
    }

    var delete_request=function(){
        var checkedColumns=$("#role_table .checkboxes:checked");
        if(checkedColumns.length>1){
            alert('删除目前只支持单行记录！');
            return false;
        }
        var primaryKey=checkedColumns.val();

        $.ajax({
            url: App.getGlobalContentPath() + '/roles/delete/'+primaryKey,
            type: 'GET',
            contentType: 'application/json;charset=UTF-8',
        }).done(function(data) {
            if (data.code == 200) {
                $.bootstrapGrowl('删除角色成功!', {
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

                table.api().ajax.reload();
            }
        });
    }

    return {
        init:function(){
            roleTable();table_refresh();table_row_edit();table_row_delete();
        }
    }
}()

$(document).ready(function(){
    SysRoleList.init()
})