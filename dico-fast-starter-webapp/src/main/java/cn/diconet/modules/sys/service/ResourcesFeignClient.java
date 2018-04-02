package cn.diconet.modules.sys.service;

import cn.diconet.common.model.dto.ResourceDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.service
 * @Description: 描述
 * @date 2018\4\2 000217:55
 */
@FeignClient(name = "UCENTER",url = "http://localhost:8001")
public interface ResourcesFeignClient {

    @RequestMapping(value = "/resources",method = RequestMethod.GET)
    @ResponseBody
    List<ResourceDto> getResources();
}
