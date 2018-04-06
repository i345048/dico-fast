package cn.diconet.cms.modules.sys.service;

import cn.diconet.cms.modules.sys.model.Page;
import cn.diconet.cms.modules.sys.model.ResourcesDto2;
import cn.diconet.cms.modules.sys.model.Role;
import cn.diconet.common.base.PageResult;
import cn.diconet.common.base.Result;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeignClientFallback implements UCenterFeignClient {

    @Override
    public List<ResourcesDto2> getResources(String id) {
        return null;
    }

    @Override
    public Result putRole(Integer id, Role role) {
        return null;
    }

    @Override
    public Page getRoles(String name, int pageNum, int pageSize) {

        Page page=new Page();

        List<Role> roles= Lists.newArrayList();
        Role role=new Role();
        role.setId(1);
        role.setName(name);
        roles.add(role);

        page.setContent(roles);
        page.setTotalElements(1);
        return page;
    }
}
