package org.jvue.security;

import org.jvue.upms.bean.JvPermission;
import org.jvue.upms.bean.JvUser;
import org.jvue.upms.mapper.JvPermissionMapper;
import org.jvue.upms.mapper.JvUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

public class JvUserDetailServiceImpl implements UserDetailsService {
    @Resource(name = "jvPermissionMapper")
    private JvPermissionMapper jvPermissionMapper;
    @Resource(name = "jvUserMapper")
    private JvUserMapper jvUserMapper;
    /**
     * 返回用户信息接口
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        JvUser jvUser=jvUserMapper.getUserByUserName(s);
        if(jvUser!=null){
            List<JvPermission> list=jvPermissionMapper.listPermissionByUser(jvUser.getUserId());
            jvUser.setAuthorities(list);
        }

        return jvUser;
    }
}
