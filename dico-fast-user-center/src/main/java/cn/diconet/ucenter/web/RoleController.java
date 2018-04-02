package cn.diconet.ucenter.web;

import cn.diconet.common.base.Result;
import cn.diconet.ucenter.api.message.dto.PermissionDto;
import cn.diconet.ucenter.api.message.dto.RoleDto;
import cn.diconet.ucenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping("roles")
    public List<RoleDto> getRoles() {
        return service.findAll();
    }

    @GetMapping("roles/{id}")
    public RoleDto getRole(@PathVariable("id") Integer id) {
        return null;
    }

    @GetMapping("roles/{id}/permissions")
    public List<PermissionDto> getRolePerms(@PathVariable("id") Integer id) {
        return null;
    }

    @PostMapping("roles")
    public Result createRole(@RequestBody RoleDto role) {
        return null;
    }

    @PutMapping("roles/{id}")
    public Result putRole(@PathVariable("id") Integer id, @RequestBody RoleDto role) {
        return null;
    }

    @PatchMapping("roles/{id}")
    public Result patchRole(@PathVariable("id") Integer id, @RequestBody RoleDto role) {
        return null;
    }


    @DeleteMapping("roles/{id}")
    public Result deleteRole(@PathVariable("id") Integer id) {
        return null;
    }
}
