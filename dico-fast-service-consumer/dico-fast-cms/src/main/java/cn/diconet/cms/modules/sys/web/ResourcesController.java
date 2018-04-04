package cn.diconet.cms.modules.sys.web;

import cn.diconet.cms.modules.sys.model.ResourcesDto2;
import cn.diconet.cms.modules.sys.service.UCenterFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.web
 * @Description: 描述
 * @date 2018\4\2 000218:47
 */
@RestController
@RequestMapping("/")
public class ResourcesController {

    @Autowired
    private UCenterFeignClient resourcesFeignClient;

    @GetMapping("menus/{id}")
    public List<ResourcesDto2> getResources(@PathVariable String id) {

        return resourcesFeignClient.getResources(id);
    }
}
