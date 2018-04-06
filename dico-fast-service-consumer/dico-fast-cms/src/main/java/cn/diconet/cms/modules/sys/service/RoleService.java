package cn.diconet.cms.modules.sys.service;

import cn.diconet.cms.modules.sys.model.Role;
import cn.diconet.common.base.MybatisService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends MybatisService<Role> {

//    public List<Role> findAll(Map<String, Object> params, int pageNum, int pageSize) {
//        Condition condition = DynamicConditionUtils.getSearchCondition(params, Role.class);
//        PageHelper.startPage(pageNum, pageSize, "id");
//        return mapper.selectByCondition(condition);
//    }

    @Override
    public Role findOne(Integer id) {
        return null;
    }
}
