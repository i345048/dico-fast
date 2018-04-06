package cn.diconet.ucenter.service;

import cn.diconet.common.base.JpaDao;
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
    protected JpaDao getDao() {
        return repo;
    }

}
