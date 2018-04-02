package cn.diconet.modules.sys.service;

import cn.diconet.ucenter.api.message.dto.ResourceDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.service
 * @Description: 描述
 * @date 2018\4\2 000217:55
 */
@FeignClient(name = "ucenter")
public interface ResourcesFeignClient {

    @RequestMapping(value = "/resources/{id}",method = RequestMethod.GET)
    List<ResourceDto> getResources(@PathVariable("id") String id);
}
