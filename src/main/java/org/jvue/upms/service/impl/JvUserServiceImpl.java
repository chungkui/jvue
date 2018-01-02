package org.jvue.upms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jvue.upms.bean.JvUser;
import org.jvue.upms.mapper.JvUserMapper;
import org.jvue.upms.service.JvUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JvUserServiceImpl implements JvUserService {
    @Resource
    private JvUserMapper jvUserMapper;

    @Override
    public PageInfo <JvUser> list(JvUser jvUser, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<JvUser> list = jvUserMapper.list(jvUser);
        PageInfo <JvUser>pageInfo=new <JvUser>PageInfo(list);
        return pageInfo;
    }

    @Transactional
    @Override
    public boolean create(JvUser jvUser) {
        jvUserMapper.create(jvUser);
        return false;
    }
}
