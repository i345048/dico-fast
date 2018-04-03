package cn.diconet.modules.sys.model;

import cn.diconet.ucenter.api.message.dto.ResourceDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.modules.sys.model
 * @Description: 描述
 * @date 2018\4\3 00038:30
 */
@Data
public class ResourcesDto2 {

    private String id;
    private String name;
    private String type;
    private String url;
    private String icon;
    private Integer priority;

    @JsonBackReference
    private ResourcesDto2 parent;

    @JsonManagedReference
    private List<ResourcesDto2> children = Lists.newArrayList();
}
