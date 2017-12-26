package org.jvue.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jvue.upms.bean.JvRole;
import org.jvue.upms.mapper.JvRoleMapper;
import org.jvue.upms.service.JvPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class JvSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private JvRoleMapper jvRoleMapper;
    @Autowired
    private JvPermissionService jvPermissionService;

    protected final Log logger = LogFactory.getLog(getClass());
    /*角色权限库：所有匹配规则的仓库key是url规则，集合是角色列表*/
    private  Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;
    /*对requestMap进行缓存，设置一个定时器定时对角色资源列表进行刷新*/
    @Scheduled(cron="* 0/10 *  * * ? ")
    private void cacheRequestMap(){
        requestMap=jvPermissionService.cacheRequestMap();
    }



    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        if ((o == null) || !this.supports(o.getClass())) {
            throw new IllegalArgumentException("对不起,请求权限的目标对象不是类型");
        }
        final HttpServletRequest request = ((FilterInvocation) o).getRequest();
        logger.info("正在访问资源《"+request.getRequestURI()+"》");
        /*如果角色资源仓库为空则进行一次缓存*/
        if(requestMap==null){
            cacheRequestMap();
        }
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        logger.info("****************访问资源不需要权限******************");
        return null;
      /*  FilterInvocation filterInvocation = (FilterInvocation) o;
        HttpServletRequest request = filterInvocation.getRequest();
        String permissionId = request.getParameter("permissionId");
        *//*本系统所有权限通过permissionid来进行控制权限，白名单的url存在配置文件中*//*
        boolean iswhite = JvUrlPermissionUtil.isWhite(request.getRequestURI());
        try {
            if (iswhite) {
                return null;
            } else if (permissionId != null) {
                List rolelist = jvRoleMapper.listRoleByPermissionId(Integer.parseInt(permissionId));
                return rolelist;
            } else {
                List list = new ArrayList<JvRole>();
                JvRole jvRole = new JvRole();
                jvRole.setName("BUSHIBAIMINGDANXIUXIANGJINLAI");
                list.add(jvRole);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;*/
    }

    /**
     * 这里是加载所有的角色列表
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        if(requestMap==null){
            cacheRequestMap();
        }
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    /**
     * 验证用于封装认证携带信息验证的类
     *
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


    public Map<RequestMatcher, Collection<ConfigAttribute>> getRequestMap() {
        return requestMap;
    }

    public void setRequestMap(Map<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        this.requestMap = requestMap;
    }
}
