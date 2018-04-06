package cn.diconet.common.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\4 0004
 */
public interface JpaDao<T,K extends Serializable> extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {
}
