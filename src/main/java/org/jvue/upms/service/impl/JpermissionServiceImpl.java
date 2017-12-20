package org.jvue.upms.service.impl;

import org.jvue.upms.bean.Jpermission;
import org.jvue.upms.mapper.JpermissionMapper;

import org.jvue.upms.service.JpermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class JpermissionServiceImpl implements JpermissionService {

    @Resource(name = "jpermissionMapper")
    private JpermissionMapper jpermissionMapper;

    public List<Jpermission> list() {
        return jpermissionMapper.list();
    }


    private List<Jpermission> getChildrenNodes(Integer id, List<Jpermission> datalist) {
        List<Jpermission> list = new ArrayList<Jpermission>();
        for (Jpermission item : datalist) {
            if (id.equals(item.getPermissionId())) {
                List<Jpermission> childs = getChildrenNodes(item.getPermissionId(), datalist);
                if (!childs.isEmpty()) {
                    item.setSunList(childs);
                }
                list.add(item);
            }
        }
        return list;
    }

}
