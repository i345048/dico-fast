package cn.diconet.auth.repository;

import cn.diconet.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
