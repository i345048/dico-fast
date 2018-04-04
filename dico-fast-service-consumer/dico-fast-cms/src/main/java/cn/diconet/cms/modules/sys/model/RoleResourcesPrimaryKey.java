package cn.diconet.cms.modules.sys.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class RoleResourcesPrimaryKey {

    private Integer roleId;
    private Integer resourceId;

}
