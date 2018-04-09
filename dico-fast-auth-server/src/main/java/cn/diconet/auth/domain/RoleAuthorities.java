package cn.diconet.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Setter
@Getter
@Entity
@Table(name = "sys_role_authorities")
public class RoleAuthorities {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "authorities_id")
    private Authority authority;
}
