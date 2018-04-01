package cn.diconet.modules.sys.web.vo;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private String id;
    private String name;
    private String type;
    private String url;
    private String icon;
    private Integer priority;
    private String pid;

    private List<Menu> children;

}
