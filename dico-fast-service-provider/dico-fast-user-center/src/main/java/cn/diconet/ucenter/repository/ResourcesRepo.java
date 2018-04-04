package cn.diconet.ucenter.repository;

import cn.diconet.ucenter.model.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.ucenter.repository
 * @Description: 描述
 * @date 2018\4\2 000216:53
 */
@Repository
public interface ResourcesRepo extends JpaRepository<Resources,String> {
}
