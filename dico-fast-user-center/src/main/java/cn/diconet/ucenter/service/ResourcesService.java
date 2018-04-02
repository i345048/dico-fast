package cn.diconet.ucenter.service;

import cn.diconet.common.model.dto.ResourceDto;
import cn.diconet.common.util.DozerMapper;
import cn.diconet.ucenter.model.Resources;
import cn.diconet.ucenter.repository.ResourcesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.ucenter.service
 * @Description: 描述
 * @date 2018\4\2 000216:55
 */
@Service
public class ResourcesService {

    @Autowired
    private ResourcesRepo repo;

    public List<ResourceDto> findAll() {
        return DozerMapper.mapList(repo.findAll(),ResourceDto.class);
    }
}
