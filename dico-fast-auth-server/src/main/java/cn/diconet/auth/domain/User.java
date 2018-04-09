package cn.diconet.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
@Table(name="sys_user")
public class User{

    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy="user",orphanRemoval = true)
    private List<UserRole> userRoles = Lists.newArrayList();
    
}
