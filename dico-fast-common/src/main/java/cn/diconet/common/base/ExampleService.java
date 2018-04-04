package cn.diconet.common.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Thomas
 * @Description: Example 条件查询
 * @date 2018\4\4 0004
 */
public interface ExampleService<T> {

    List<T> findAll(T t);

    Page<T> findAll(T t, int pageNum, int pageSize);
}
