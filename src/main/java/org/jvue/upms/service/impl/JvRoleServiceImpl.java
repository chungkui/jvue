package org.jvue.upms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jvue.upms.bean.JvRole;
import org.jvue.upms.bean.JvUser;
import org.jvue.upms.mapper.JvRoleMapper;
import org.jvue.upms.service.JvRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JvRoleServiceImpl implements JvRoleService {
    @Resource
    private JvRoleMapper jvRoleMapper;

    @Override
    public PageInfo<JvRole> list(JvRole jvRole, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<JvRole> list = jvRoleMapper.list(jvRole);
        PageInfo<JvRole> pageInfo = new <JvRole>PageInfo(list);
        return pageInfo;
    }
}
