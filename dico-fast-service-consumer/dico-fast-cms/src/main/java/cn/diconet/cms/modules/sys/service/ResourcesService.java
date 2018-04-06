package cn.diconet.cms.modules.sys.service;

import cn.diconet.cms.modules.sys.model.Resources;
import cn.diconet.common.base.MybatisService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.modules.sys.service
 * @Description: 描述
 * @date 2018\3\30 003016:49
 */
@Service
public class ResourcesService extends MybatisService<Resources> {

    @Override
    public Resources findOne(Integer id) {
        return null;
    }
}
