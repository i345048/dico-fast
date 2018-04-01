var LeftMenu = (function() {

    var template = {
        ul: {
            sidebar: '<ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200"></ul>',
            sub: '<ul class="sub-menu"></ul>'
        },
        li: {
            item:'<li class="nav-item"></li>'
        },
        a: {
            link: '<a href="#" class="nav-link ajaxify"></a>',
            toggle: '<a href="#" class="nav-link nav-toggle"></a>'
        },
        ii: '<i class=""></i>',
        span: {
            title:'<span class="title"></span>',
            arrow: '<span class="arrow"></span>'
        }
    };

    var buildMenuDom = function(data) {
        var $element = buildUlDom();
        var ulElem = $element.children().eq(0);

        $.each(data, function(i) {
            ulElem.append(template.li.item);
            var liElem = ulElem.children().eq(i);
            if (data[i].children && data[i].children.length > 0) {
                liElem.append(template.a.toggle);
            } else {
                liElem.append(template.a.link);
            }

            liElem.children("a").eq(0).append(template.ii);
            liElem.children("a").eq(0).append(template.span.title);
            liElem.children("a").eq(0).find('span').text(data[i].name);
            liElem.children("a").eq(0).prop("href", data[i].url);
            liElem.children("a").eq(0).prop("id", data[i].id);
            liElem.children("a").eq(0).find('i').addClass(data[i].icon);

            if (data[i].children && data[i].children.length > 0) {
                liElem.children("a").eq(0).append(template.span.arrow);
                liElem.children("a").eq(0).addClass('nav-toggle');
            }

            buildLiDom(template, liElem, data[i]);
        })
    };

    var buildUlDom = function() {
        return $('div.page-sidebar ').append(template.ul.sidebar);
    };

    var buildLiDom = function(template, element, data) {
        //判断当前li节点是否有子节点
        if (data.children && data.children.length > 0) {
            element.append(template.ul.sub);
            var subUlElem = element.children("ul").eq(0);
            $.each(data.children, function(i) {
                subUlElem.append(template.li.item);
                var liElem = subUlElem.children().eq(i);

                if (data.children[i].children && data.children[i].children.length > 0) {
                    liElem.addClass('nav-item');
                    liElem.append(template.a.toggle);
                } else {
                    liElem.append(template.a.link);
                }

                liElem.children("a").eq(0).attr("href", data.children[i].url);

                liElem.children("a").eq(0).prop("id", data.children[i].id);
                liElem.children("a").eq(0).append(template.ii);
                liElem.children("a").eq(0).append(template.span.title);
                liElem.children("a").eq(0).find('span').text(data.children[i].name);
                liElem.children("a").eq(0).find('i').addClass(data.children[i].icon);

                if (data.children[i].children && data.children[i].children.length > 0) {
                    liElem.children("a").eq(0).append(template.span.arrow);
                }
                buildLiDom(template, liElem, data.children[i]);
            });
        }
    };

    return {
        init: function() {
            // var d={};
            // d['search_parent.sn_EQ']='root';
            $.ajax({
                url: App.getGlobalContentPath() + '/menus',
                type: 'GET',
                //dataType: 'json',
                async : false,
                // contentType: 'application/json;charset=UTF-8',
                //data:d
            }).done(function(data) {
                if (data) {
                    buildMenuDom(data);
                    // Layout.initSidebar(null);
                }
            });
        }
    };
})();

$(document).ready(function(){
    LeftMenu.init();
});