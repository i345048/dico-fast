package cn.diconet.auth.security;

import cn.diconet.auth.domain.RoleAuthorities;
import cn.diconet.auth.domain.User;
import cn.diconet.auth.domain.UserRole;
import cn.diconet.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Service
@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowcaseUsername = username.toLowerCase();
        User user=new User();
        user.setUsername(lowcaseUsername);
        Example example=Example.of(user);
        User realUser = repository.findOne(example);

        Set<GrantedAuthority> userAuthotities = new HashSet();
        List<UserRole> userRoles=realUser.getUserRoles();

        for(UserRole userRole:userRoles){

            List<RoleAuthorities> roleAuthorities=userRole.getRole().getAuthorities();
            for(RoleAuthorities authorities:roleAuthorities){
                userAuthotities.add(new SimpleGrantedAuthority(authorities.getAuthority().getValue()));
            }
        }

        return new org.springframework.security.core.userdetails.User(realUser.getUsername(),realUser.getPassword(),userAuthotities);
    }
}
