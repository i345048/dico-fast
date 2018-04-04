package cn.diconet.cms.modules.sys.web;

import cn.diconet.cms.modules.sys.model.Page;
import cn.diconet.cms.modules.sys.model.Role;
import cn.diconet.cms.modules.sys.service.RoleService;
import cn.diconet.cms.modules.sys.service.UCenterFeignClient;
import cn.diconet.common.base.PageResult;
import cn.diconet.common.base.Result;
import cn.diconet.common.base.ResultGenerator;
import cn.diconet.common.base.ServiceException;
import cn.diconet.common.util.DynamicConditionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/roles")
@Slf4j
public class RoleController {

    @Autowired
    private RoleService service;

    @Autowired
    private HttpServletRequest request;

    @Autowired
   private UCenterFeignClient feignClient;

//    @PostMapping("list")
//    @ResponseBody
//    public PageResult<Role> list(PageResult pageResult){
//        PageInfo page=new PageInfo<Role>(service.findAll(DynamicConditionUtils.getParametersStartingWith(request,"search_"),pageResult.getPageNum(),pageResult.getLength()));
//        pageResult.setData(page.getList());
//        pageResult.setRecordsTotal(page.getTotal());
//
//        return pageResult;
//    }

    @PostMapping("list")
    @ResponseBody
    public PageResult<Role> list(PageResult pageResult){
       // PageInfo page=new PageInfo<Role>(service.findAll(DynamicConditionUtils.getParametersStartingWith(request,"search_"),pageResult.getPageNum(),pageResult.getLength()));
        Map<String,Object> params=DynamicConditionUtils.getParametersStartingWith(request,"search_");
        Page page=feignClient.getRoles((String) params.get("name_LIKE"),pageResult.getPageNum(),pageResult.getLength());
        pageResult.setData(page.getContent());
        pageResult.setRecordsTotal(page.getTotalElements());

        return pageResult;
    }

    @PostMapping("add")
    @ResponseBody
    public Result add(@RequestBody Role role){
        Result result= ResultGenerator.genSuccessResult();
        try{
            service.save(role);
        }catch (ServiceException e){
            log.error("",e);
            result=ResultGenerator.genFailResult(e.getMessage());
        }
        return result;
    }

    @PostMapping("edit")
    @ResponseBody
    public Result edit(@RequestBody Role role){
        Result result= ResultGenerator.genSuccessResult();
        try{
           // service.update(role);
            feignClient.putRole(role.getId(),role);
        }catch (ServiceException e){
            log.error("",e);
            result=ResultGenerator.genFailResult(e.getMessage());
        }
        return result;
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public Result edit(@PathVariable Integer id){
        Result result= ResultGenerator.genSuccessResult();
        try{
            service.deleteById(id);
        }catch (ServiceException e){
            log.error("",e);
            result=ResultGenerator.genFailResult(e.getMessage());
        }
        return result;
    }

    /**
     *  列表页面
     * @return
     */
    @GetMapping("list")
    public String list(){
        return "/sys/sys_role_list";
    }

    @GetMapping("add")
    public String add(){
        return "/sys/sys_role_add";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("role",service.findById(id));
        return "/sys/sys_role_edit";
    }
}
