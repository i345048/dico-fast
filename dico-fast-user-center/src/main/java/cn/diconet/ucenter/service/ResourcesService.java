package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaService;
import cn.diconet.common.util.DozerMapper;
import cn.diconet.ucenter.api.message.dto.ResourceDto;
import cn.diconet.ucenter.model.Resources;
import cn.diconet.ucenter.repository.ResourcesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.ucenter.service
 * @Description: 描述
 * @date 2018\4\2 000216:55
 */
@Service
public class ResourcesService extends JpaService<ResourceDto,String>{

    @Autowired
    private ResourcesRepo repo;

    @Override
    public void save(ResourceDto model) {

    }

    @Override
    public void save(List<ResourceDto> models) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(ResourceDto model) {

    }

    @Override
    public ResourceDto findById(String id) {
        return DozerMapper.map(repo.findOne(id),ResourceDto.class);
    }

    @Override
    public ResourceDto findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<ResourceDto> findByIds(String ids) {
        return null;
    }

    public List<ResourceDto> findByExample(Example example){
        return DozerMapper.mapList(repo.findAll(example),ResourceDto.class);
    }

    @Override
    public Page<ResourceDto> findAll(Example<ResourceDto> var1, int pageNum,int pageSize ) {
        return null;
    }

    public List<ResourceDto> findAll() {
        return DozerMapper.mapList(repo.findAll(),ResourceDto.class);
    }




}
