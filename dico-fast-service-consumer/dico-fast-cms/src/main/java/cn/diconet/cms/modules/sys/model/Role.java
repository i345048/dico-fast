package cn.diconet.cms.modules.sys.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role")
@Data
public class Role {

    @Id
    private Integer id;
    private String name;

}
