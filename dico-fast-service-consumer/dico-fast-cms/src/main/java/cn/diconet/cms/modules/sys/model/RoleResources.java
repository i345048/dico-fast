package cn.diconet.cms.modules.sys.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "role_resources")
@Data
public class RoleResources {

    @EmbeddedId
    private RoleResourcesPrimaryKey id;

    @ManyToOne
    private Role role;
}
