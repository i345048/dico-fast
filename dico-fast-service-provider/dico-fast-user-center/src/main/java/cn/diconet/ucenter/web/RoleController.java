package cn.diconet.ucenter.web;

import cn.diconet.common.base.*;
import cn.diconet.ucenter.model.Permission;
import cn.diconet.ucenter.model.Role;
import cn.diconet.ucenter.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "角色接口")
public class RoleController extends BaseRestController<Role,Integer> {

    @Autowired
    private RoleService service;

    @Override
    protected JpaService<Role, Integer> getService() {
        return service;
    }

    @ApiOperation(value="分页获取角色列表信息", notes="根据name获取角色列表信息")
    @GetMapping("roles")
    public Page list(@RequestParam(required=false) String name, @RequestParam int pageNum, @RequestParam int pageSize){
        Role role=new Role();
        role.setName(name);
        return super.list(role,pageNum,pageSize);
    }

    @ApiOperation(value="获取角色信息", notes="根据id获取角色信息")
    @GetMapping("roles/{id}")
    public Role get(@PathVariable("id") Integer id) {
        return super.get(id);
    }

    @PostMapping("roles")
    public Result create(@RequestBody Role role) {
        return this.create(role);
    }

    @PutMapping("roles/{id}")
    public Result put(@PathVariable Integer id, @RequestBody Role role) {
        Role _role=service.findOne(id);
        _role.setName(role.getName());
        return super.put(_role);
    }

    @PatchMapping("roles/{id}")
    public Result patch(@PathVariable("id") Integer id, @RequestBody Role role) {
        Role _role=service.findOne(id);
        _role.setName(role.getName());
        //patch更新为部分属性,具体情况根据set上面的属性来决定
        return super.patch(_role);
    }

    @DeleteMapping("roles/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        return super.delete(id);
    }

}
