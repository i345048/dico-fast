package cn.diconet.auth.repository;

import cn.diconet.auth.domain.SysUser;
import cn.diconet.auth.repository.support.WiselyRepository;

import java.util.Optional;

/**
 * Created by wangyunfei on 2017/6/9.
 */
public interface SysUserRepository extends WiselyRepository<SysUser,Long> {
    Optional<SysUser> findOneWithRolesByUsername(String username);
}
