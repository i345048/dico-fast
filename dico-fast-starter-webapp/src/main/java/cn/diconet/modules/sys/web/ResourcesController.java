package cn.diconet.modules.sys.web;

import cn.diconet.modules.sys.service.ResourcesFeignClient;
import cn.diconet.ucenter.api.message.dto.ResourceDto;
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
    private ResourcesFeignClient resourcesFeignClient;

    @GetMapping("menus/{id}")
    public List<ResourceDto> getResources(@PathVariable String id) {

        return resourcesFeignClient.getResources(id);
    }
}
