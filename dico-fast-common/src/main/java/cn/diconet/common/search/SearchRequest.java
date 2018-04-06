package cn.diconet.common.search;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Package cn.diconet.common.search
 * @Description: 描述
 * @date 2018\3\29 002915:14
 */
public class SearchRequest {
    public enum Operator {
        EQ, LIKE, GT, LT, GTE, LTE, IN
    }

    @Setter
    @Getter
    private String fieldName;

    @Setter
    @Getter
    private Object value;

    @Setter
    @Getter
    private Operator operator;

    public SearchRequest(String fieldName, Operator operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    /**
     * searchParams中key的格式为OPERATOR_FIELDNAME
     */
    public static Map<String, SearchRequest> parse(Map<String, Object> searchParams) {
        Map<String, SearchRequest> filters = new HashMap<String, SearchRequest>();

        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            // 过滤掉空值
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isBlank((String) value)) {
                continue;
            }
            // 拆分operator与filedAttribute
            String[] names = StringUtils.split(key, "_");
            if (names.length < 2) {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            //String filedName = names[1];
            String filedName = key.substring(0, key.indexOf(names[names.length - 1]) - 1);

            Operator operator = Operator.valueOf(names[names.length - 1]);

            // 创建searchFilter
            SearchRequest filter = new SearchRequest(filedName, operator, value);
            filters.put(key, filter);
        }

        return filters;
    }
}
