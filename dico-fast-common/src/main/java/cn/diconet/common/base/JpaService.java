package cn.diconet.common.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class JpaService<T,K> implements Service<T,K>{

    public List<T> findByExample(Example example){
        return null;
    }

    public abstract Page<T> findAll(Example<T> var1, int pageNum,int pageSize );
}
