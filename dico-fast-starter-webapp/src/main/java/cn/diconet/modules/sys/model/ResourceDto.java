package cn.diconet.modules.sys.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.common.model.dto
 * @Description: 描述
 * @date 2018\4\2 000218:05
 */
@Data
public class ResourceDto {

    private String id;
    private String name;
    private String type;
    private String url;
    private String icon;
    private Integer priority;

    @JsonBackReference
    private ResourceDto parent;

    @JsonManagedReference
    private List<ResourceDto> children= Lists.newArrayList();
}
