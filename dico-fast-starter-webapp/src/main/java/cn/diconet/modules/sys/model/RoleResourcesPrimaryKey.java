package cn.diconet.modules.sys.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class RoleResourcesPrimaryKey {

    private Integer roleId;
    private Integer resourceId;

}
