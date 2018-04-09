package cn.diconet.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Entity
@Setter
@Getter
@Table(name = "sys_role")
public class Role{

    @Id
    private Long id;
    private String name;
    private String value;

    @JsonIgnore
    @OneToMany(mappedBy = "role",orphanRemoval = true)
    private List<RoleAuthorities> authorities =  Lists.newArrayList();

    @OneToMany(mappedBy = "role", orphanRemoval = true)
    private List<UserRole>  roles = Lists.newArrayList();
}
