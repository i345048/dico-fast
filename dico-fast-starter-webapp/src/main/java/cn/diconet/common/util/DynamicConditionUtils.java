package cn.diconet.common.util;

import cn.diconet.common.search.SearchFilter;
import org.apache.commons.lang3.Validate;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletRequest;
import java.util.*;

/**
 * @author Administrator
 * @Package cn.diconet.common.util
 * @Description: 描述
 * @date 2018\3\29 002914:54
 */
public class DynamicConditionUtils {

    private static final String REQUEST_SEARCH_PREFIX = "search_";

    /**
     *  获取指定开头的request中的参数
     * @param request
     * @param prefix
     * @return
     */
    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
        Validate.notNull(request, "Request must not be null");
        Enumeration paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap<String, Object>();
        if (prefix == null) {
            prefix = "";
        }
        while ((paramNames != null) && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            if ("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                if ((values == null) || (values.length == 0)) {
                    // Do nothing, no values found at all.
                } else if (values.length > 1) {
                    params.put(unprefixed, values);
                } else {
                    params.put(unprefixed, values[0]);
                }
            }
        }
        return params;
    }

    /**
     * 将request中指定参数转换为查询条件
     * @param request
     * @return
     */
    public static Condition getSearchCondition(Map<String, Object> searchParams ,Class clazz){

        //去除查询条件前缀标识
        //Map<String, Object> searchParams = getParametersStartingWith(request, "search_");
        Map<String, SearchFilter> filters =SearchFilter.parse(searchParams);

        Condition condition=new Condition(clazz);

        for (Iterator iter=filters.entrySet().iterator();iter.hasNext();){

            Example.Criteria criteria= condition.createCriteria();
            Map.Entry<String, SearchFilter> entry= (Map.Entry<String, SearchFilter>) iter.next();
            SearchFilter filter=entry.getValue();

            switch (filter.getOperator()){
                case EQ:
                    criteria.andEqualTo(filter.getFieldName(),filter.getValue());
                    break;
                case LIKE:
                    criteria.andLike(filter.getFieldName(),"%" + filter.getValue() + "%");
                    break;
                case GT:
                    criteria.andGreaterThan(filter.getFieldName(),filter.getValue());
                    break;
                case LT:
                    criteria.andLessThan(filter.getFieldName(),filter.getValue());
                    break;
                case GTE:
                    criteria.andGreaterThanOrEqualTo(filter.getFieldName(),filter.getValue());
                    break;
                case LTE:
                    criteria.andLessThanOrEqualTo(filter.getFieldName(),filter.getValue());
                    break;
            }
        }

        return condition;
    }
}
