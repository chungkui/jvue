package org.jvue.upms.service.impl;

import org.jvue.upms.bean.Jpermission;
import org.jvue.upms.mapper.JpermissionMapper;

import org.jvue.upms.service.JpermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JpermissionServiceImpl implements JpermissionService {

    @Resource(name = "jpermissionMapper")
    private JpermissionMapper jpermissionMapper;

    public List<Jpermission> list() {
        List<Jpermission> list = formatTree(jpermissionMapper.list());
        return list;
    }


    private List<Jpermission> formatTree(List<Jpermission> datalist) {
        Iterator<Jpermission> iterator = datalist.iterator();
        List<Jpermission> topJpermission = new ArrayList<Jpermission>();
        while (iterator.hasNext()) {
            Jpermission s = iterator.next();
            //去掉级联关系后需要手动维护这个属性
            boolean getParent = false;
            for (Jpermission p : datalist) {
                if (p.getPermissionId()==s.getPid()) {
                    List sunList = p.getSunList();
                    if (sunList == null) {
                        p.setSunList(new ArrayList());
                    }
                    p.getSunList().add(s);
                    getParent = true;
                    break;
                }
            }
            if (!getParent)
                topJpermission.add(s);
        }
        return topJpermission;
    }

}
