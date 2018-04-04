package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaService;
import cn.diconet.ucenter.model.Role;
import cn.diconet.ucenter.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends JpaService<Role,Integer> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Role model) {
        roleRepository.save(model);
    }

    @Override
    public void save(List<Role> models) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Role model) {
        roleRepository.save(model);
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Role> findByIds(String ids) {
        return null;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Page<Role> findAll(Example<Role> var1, int pageNum,int pageSize ) {
        Pageable page = new PageRequest(pageNum,pageSize);
        return roleRepository.findAll(var1,page);
    }
}
