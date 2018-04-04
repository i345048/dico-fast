package cn.diconet.ucenter.web;

import cn.diconet.common.base.Result;
import cn.diconet.common.base.ResultGenerator;
import cn.diconet.common.base.ServiceException;
import cn.diconet.ucenter.model.Permission;
import cn.diconet.ucenter.model.Role;
import cn.diconet.ucenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("roles")
    public Page getRoles(@RequestParam(required=false) String name, @RequestParam int pageNum, @RequestParam int pageSize){
        Role role=new Role();
        if(!StringUtils.isEmpty(name)){
            role.setName(name);
        }
        Example example=Example.of(role);
        return service.findAll(example,pageNum,pageSize);
    }

//    @GetMapping("roles")
//    public List<Role> getRoles() {
//        return service.findAll();
//    }

    @GetMapping("roles/{id}")
    public Role getRole(@PathVariable("id") Integer id) {
        return null;
    }

    @GetMapping("roles/{id}/permissions")
    public List<Permission> getRolePerms(@PathVariable("id") Integer id) {
        return null;
    }

    @PostMapping("roles")
    public Result createRole(@RequestBody Role role) {

        Result result = ResultGenerator.genSuccessResult();
        try {
            service.save(role);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("roles/{id}")
    public Result putRole(@PathVariable Integer id, @RequestBody Role role) {
        Result result = ResultGenerator.genSuccessResult();
        try {
            Role _role=service.findById(id);
            _role.setName(role.getName());
            service.update(_role);
        } catch (ServiceException e) {
            result = ResultGenerator.genFailResult(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PatchMapping("roles/{id}")
    public Result patchRole(@PathVariable("id") Integer id, @RequestBody Role role) {
        return null;
    }


    @DeleteMapping("roles/{id}")
    public Result deleteRole(@PathVariable("id") Integer id) {
        return null;
    }
}
