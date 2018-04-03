package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaService;
import cn.diconet.ucenter.model.Resources;
import cn.diconet.ucenter.repository.ResourcesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.ucenter.service
 * @Description: 描述
 * @date 2018\4\2 000216:55
 */
@Service
public class ResourcesService extends JpaService<Resources,String>{

    @Autowired
    private ResourcesRepo repo;

    @Override
    public void save(Resources model) {

    }

    @Override
    public void save(List<Resources> models) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteByIds(String ids) {

    }

    @Override
    public void update(Resources model) {

    }

    @Override
    public Resources findById(String id) {
        return repo.findOne(id);
    }

    @Override
    public Resources findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public List<Resources> findByIds(String ids) {
        return null;
    }

    public List<Resources> findByExample(Example example){
        return repo.findAll(example);
    }

    @Override
    public Page<Resources> findAll(Example<Resources> var1, int pageNum,int pageSize ) {
        return null;
    }

    public List<Resources> findAll() {
        return repo.findAll();
    }




}
