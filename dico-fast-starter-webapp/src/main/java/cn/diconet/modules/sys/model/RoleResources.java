package cn.diconet.modules.sys.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "role_resources")
@Data
public class RoleResources {

    @EmbeddedId
    private RoleResourcesPrimaryKey id;

    @ManyToOne
    private Role role;
}
