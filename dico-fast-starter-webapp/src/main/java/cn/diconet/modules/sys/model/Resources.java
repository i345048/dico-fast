package cn.diconet.modules.sys.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.model
 * @Description: 描述
 * @date 2018\3\30 003016:45
 */
@Data
public class Resources {

    @Id
    private String id;
    private String name;
    private String type;
    private String url;
    private String icon;
    private Integer priority;
    private List<Resources> children;
}
