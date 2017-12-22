package org.jvue.security;

import org.jvue.upms.bean.JvRole;
import org.jvue.upms.mapper.JvPermissionMapper;
import org.jvue.upms.mapper.JvRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JvSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private JvRoleMapper jvRoleMapper;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        if ((o == null) || !this.supports(o.getClass())) {
            throw new IllegalArgumentException("对不起,目标对象不是类型");
        }
        System.out.println("object的类型为:" + o.getClass());
        FilterInvocation filterInvocation = (FilterInvocation) o;
        HttpServletRequest request=filterInvocation.getRequest();
        String permissionId=request.getParameter("permissionId");
        try {
            if(permissionId!=null){
                List rolelist= jvRoleMapper.listRoleByPermissionId(Integer.parseInt(permissionId));
                return rolelist;
            }else{
             List list=   new ArrayList<JvRole>();
               JvRole jvRole= new JvRole();
                jvRole.setName("就你还想进来？可能吗");
                list.add(jvRole ) ;
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 验证用于封装认证携带信息验证的类
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(Class<?> aClass) {
        if (FilterInvocation.class.isAssignableFrom(aClass)) {
            return true;
        }
        return false;
    }
}
