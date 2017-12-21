package org.jvue.upms.service.impl;

import org.jvue.upms.bean.JvPermission;
import org.jvue.upms.mapper.JvPermissionMapper;

import org.jvue.upms.service.JvPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 不出现sql代码
 */
@Service
public class JvPermissionServiceImpl implements JvPermissionService {

    @Resource(name = "jvPermissionMapper")
    private JvPermissionMapper jvPermissionMapper;
    @Override
    public List<JvPermission> list() {
        List<JvPermission> list = formatTree(jvPermissionMapper.list());
        return list;
    }
    @Override
    public List<JvPermission>listPermissionByUser(Integer userId){
        List <JvPermission> list=jvPermissionMapper.listPermissionByUser(userId);
        return formatTree(list);
    }
    @Override
    public List <JvPermission>listPermissionByRole(Integer roleId){
        List <JvPermission> list=jvPermissionMapper.listPermissionByRole(roleId);
        return  formatTree(list);
    }

    private List<JvPermission> formatTree(List<JvPermission> datalist) {
        Iterator<JvPermission> iterator = datalist.iterator();
        List<JvPermission> topJvPermission = new ArrayList<JvPermission>();
        while (iterator.hasNext()) {
            JvPermission s = iterator.next();
            //去掉级联关系后需要手动维护这个属性
            boolean getParent = false;
            for (JvPermission p : datalist) {
                if (p.getPermissionId().equals(s.getPid())) {
                    List sunList = p.getSunList();
                    if (sunList == null) {
                        p.setSunList(new ArrayList());
                    }
                    p.getSunList().add(s);
                    getParent = true;
                    break;
                }
            }
            if (!getParent){
                topJvPermission.add(s);
            }

        }
        return topJvPermission;
    }

}
