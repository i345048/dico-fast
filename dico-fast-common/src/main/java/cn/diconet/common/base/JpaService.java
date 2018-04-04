package cn.diconet.common.base;

import cn.diconet.common.util.DynamicSearchUtils;
import cn.diconet.common.util.ReflectUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Map;

public abstract class JpaService<T, K> implements Service<T, K> ,ExampleService<T>{

    protected abstract JpaDao getDao();

    @Override
    public void save(T model) {
        this.getDao().save(model);
    }

    @Override
    public void save(List<T> models) {
        this.getDao().save(models);
    }

    @Override
    public void deleteById(K id) {
        this.getDao().delete(id);
    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(T model) {
        this.getDao().save(model);
    }

    @Override
    public List<T> findAll(T t) {
        Example example=Example.of(t);
        return this.getDao().findAll(example);
    }

    @Override
    public Page<T> findAll(T t, int pageNum, int pageSize) {
        Pageable page = new PageRequest(pageNum, pageSize);
        Example example=Example.of(t);
        return this.getDao().findAll(example, page);
    }

//    public Page<T> findAll(Map<String, Object> params) {
//        Specification<T> spec= DynamicSearchUtils.getSpecification(params, ReflectUtils.findParameterizedType(getClass(), 0));
//       Pageable page=new PageRequest(params.get("page"))
//        return getDao().findAll(spec);
//        return null;
//    }

}
