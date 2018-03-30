package cn.diconet.modules.sys.model;

import lombok.Data;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.mapping.FetchType;

import javax.persistence.AssociationOverrides;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "sys_role")
@Data
public class Role {

    @Id
    private Integer id;
    private String name;

}
