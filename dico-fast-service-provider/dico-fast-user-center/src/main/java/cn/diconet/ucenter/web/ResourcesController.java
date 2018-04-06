package cn.diconet.ucenter.web;

import cn.diconet.ucenter.model.Resources;
import cn.diconet.ucenter.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.ucenter.web
 * @Description: 描述
 * @date 2018\4\2 000217:25
 */
@RestController
public class ResourcesController {

    @Autowired
    private ResourcesService service;

    @GetMapping("resources/{id}")
    public List<Resources> getResource(@PathVariable("id") String id){
        Resources resources=new Resources();
        Resources parent=new Resources();
        parent.setId(id);
        resources.setParent(parent);
        return service.findAll(resources);
    }
}
