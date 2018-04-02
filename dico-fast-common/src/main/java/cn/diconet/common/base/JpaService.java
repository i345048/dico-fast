package cn.diconet.common.base;

import org.springframework.data.domain.Example;

import java.util.List;

public abstract class JpaService<T,K> implements Service<T,K>{

    public List<T> findByExample(Example example){
        return null;
    }
}
