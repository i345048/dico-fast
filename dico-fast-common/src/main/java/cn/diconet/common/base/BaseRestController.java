package cn.diconet.common.base;

import cn.diconet.common.util.DynamicSearchUtils;
import cn.diconet.common.util.ReflectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Thomas
 * @Description: 服务提供通用封装
 * @date 2018\4\4 0004
 */
public  class BaseRestController <T>{

    protected Service getService() {
        return null;
    }

    /**
     *  按条件查询,分页参数 pageNum pageSize 在params中
     * @param params
     * @return
     */
    public Page<T> list(Map<String, Object> params) {

        return null;
    }

}
