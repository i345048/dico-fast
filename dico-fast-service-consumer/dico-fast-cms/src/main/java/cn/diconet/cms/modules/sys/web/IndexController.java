package cn.diconet.cms.modules.sys.web;

import cn.diconet.cms.modules.sys.model.Resources;
import cn.diconet.cms.modules.sys.service.ResourcesService;
import cn.diconet.cms.modules.sys.web.vo.Menu;
import cn.diconet.common.util.DozerMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.modules.sys.web
 * @Description: 描述
 * @date 2018\3\30 003011:43
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ResourcesService service;
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    public List<Menu> getMenus() {
       List<Resources> resourcesList=service.findAll();
       List<Menu> menuList= DozerMapper.mapList(resourcesList,Menu.class);

       List<Menu> parents=Lists.newArrayList();
       //遍历所有的菜单
        for(Iterator<Menu> iter = menuList.iterator(); iter.hasNext();){
            //当前菜单
            Menu current=iter.next();
            if(current.getPid()==null){
                parents.add(current);
                iter.remove();
            }
        }

        for(Iterator<Menu> iter=parents.iterator();iter.hasNext();){
            Menu parent=iter.next();
            parent.setChildren(recurSubMenu(parent.getId(),menuList));
        }
        return parents;
    }

    private List<Menu> recurSubMenu(String pid, List<Menu> menuList) {

        List<Menu> subMenuList = Lists.newArrayList();

        if (CollectionUtils.isEmpty(menuList)) {
            return subMenuList;
        }
        for (Iterator<Menu> iter = menuList.iterator(); iter.hasNext(); ) {
            Menu current = iter.next();
            //如果为子菜单
            if (pid.equals(current.getPid())) {
                //iter.remove();
                current.setChildren(recurSubMenu(current.getId(), menuList));
                subMenuList.add(current);
            }
        }

        return subMenuList;
    }

}
