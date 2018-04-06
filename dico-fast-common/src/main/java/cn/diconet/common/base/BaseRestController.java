package cn.diconet.common.base;

import cn.diconet.common.util.DynamicSearchUtils;
import cn.diconet.common.util.ReflectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas
 * @Description: 服务提供通用封装
 * @date 2018\4\4 0004
 */
@Slf4j
public abstract class BaseRestController<T, K extends Serializable> {

    protected abstract JpaService<T, K> getService();

    public Page list(T t, int pageNum, int pageSize) {
        return ((ExampleService) this.getService()).findAll(t, pageNum, pageSize);
    }

    public T get(K id) {
        return this.getService().findOne(id);
    }

    public Result create(T t) {
        Result result = ResultGenerator.genSuccessResult();
        try {
            this.getService().save(t);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            log.error("", e);
        }
        return result;
    }

    public Result put(T t) {
        Result result = ResultGenerator.genSuccessResult();
        try {
            this.getService().update(t);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result patch(T t) {
        Result result = ResultGenerator.genSuccessResult();
        try {
            this.getService().update(t);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    public Result delete(K id) {
        Result result = ResultGenerator.genSuccessResult();
        try {
            this.getService().deleteById(id);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
