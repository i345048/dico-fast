package cn.diconet.cms.modules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.modules
 * @Description: 描述
 * @date 2018\3\29 002912:56
 */
@Controller
@RequestMapping("/decorator")
public class DecoratorController {

    @RequestMapping("{path}")
    public String defaultDecorator(@PathVariable String path) {
        return "/decorator/"+path;
    }
}
