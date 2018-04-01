package cn.diconet.modules.sys.service;

import cn.diconet.common.base.MybatisService;
import cn.diconet.common.util.DynamicConditionUtils;
import cn.diconet.modules.sys.model.Role;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;

@Service
public class RoleService extends MybatisService<Role> {

    public List<Role> findAll(Map<String, Object> params, int pageNum, int pageSize) {
        Condition condition = DynamicConditionUtils.getSearchCondition(params, Role.class);
        PageHelper.startPage(pageNum, pageSize, "id");
        return mapper.selectByCondition(condition);
    }

}
