package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaService;
import cn.diconet.common.util.DozerMapper;
import cn.diconet.ucenter.api.message.dto.RoleDto;
import cn.diconet.ucenter.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends JpaService<RoleDto,Integer> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(RoleDto model) {

    }

    @Override
    public void save(List<RoleDto> models) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(RoleDto model) {

    }

    @Override
    public RoleDto findById(Integer id) {
        return null;
    }

    @Override
    public RoleDto findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<RoleDto> findByIds(String ids) {
        return null;
    }

    public List<RoleDto> findAll() {
        return DozerMapper.mapList(roleRepository.findAll(),RoleDto.class);
    }

}
