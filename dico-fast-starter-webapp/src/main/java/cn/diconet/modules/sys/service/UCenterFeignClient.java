package cn.diconet.modules.sys.service;

import cn.diconet.common.base.Result;
import cn.diconet.modules.sys.model.Page;
import cn.diconet.modules.sys.model.ResourcesDto2;
import cn.diconet.modules.sys.model.Role;
import cn.diconet.ucenter.api.message.dto.ResourceDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.service
 * @Description: 描述
 * @date 2018\4\2 000217:55
 */
@FeignClient(name = "api-gateway/ucenter")
//@FeignClient(name = "ucenter")
public interface UCenterFeignClient {

    @RequestMapping(value = "/resources/{id}",method = RequestMethod.GET)
    List<ResourcesDto2> getResources(@PathVariable("id") String id);

    @RequestMapping(value = "roles/{id}",method = RequestMethod.PUT)
    Result putRole(@PathVariable("id") Integer id, @RequestBody Role role) ;

    @RequestMapping(value = "roles",method = RequestMethod.GET)
    Page getRoles(@RequestParam(name="name",required=false) String name, @RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);
}