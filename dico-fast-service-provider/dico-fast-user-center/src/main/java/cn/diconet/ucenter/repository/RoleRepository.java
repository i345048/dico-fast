package cn.diconet.ucenter.repository;

import cn.diconet.common.base.JpaDao;
import cn.diconet.ucenter.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaDao<Role, Integer> {
}
