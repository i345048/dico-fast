package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaDao;
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
    protected JpaDao<Role, Integer> getDao() {
        return roleRepository;
    }
}
