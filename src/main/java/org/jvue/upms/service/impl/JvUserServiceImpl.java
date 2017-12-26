package org.jvue.upms.service.impl;

import org.jvue.upms.bean.JvUser;
import org.jvue.upms.mapper.JvUserMapper;
import org.jvue.upms.service.JvUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JvUserServiceImpl implements JvUserService {
    @Resource
    private JvUserMapper jvUserMapper;
    @Override
    public List<JvUser> list() {
        return jvUserMapper.list( );
    }
}
