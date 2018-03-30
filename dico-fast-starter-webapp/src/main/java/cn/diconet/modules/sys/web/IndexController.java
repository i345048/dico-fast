package cn.diconet.modules.sys.web;

import cn.diconet.modules.sys.model.Resources;
import cn.diconet.modules.sys.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.web
 * @Description: 描述
 * @date 2018\3\30 003011:43
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ResourcesService service;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("getMenus")
    @ResponseBody
    public List<Resources> getMenus(){
       return service.findMenus("1");
    }
}
