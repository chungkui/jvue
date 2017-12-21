package org.jvue.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.Map;

public class JvSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // guess object is a URL.
        if ((o == null) || !this.supports(o.getClass())) {
            throw new IllegalArgumentException("对不起,目标对象不是类型");
        }
        System.out.println("object的类型为:" + o.getClass());
        FilterInvocation filterInvocation = (FilterInvocation) o;
        Map<String,String[]> parameterMap=filterInvocation.getRequest().getParameterMap();
        /*String routerPath=parameterMap.get("routerPath")[0];
        String optNmae=parameterMap.get("optNmae")[0];*/
        /*如果为空就是list操作*/
        /*每个请求都要添加这两个参数，通过属于哪个页面的哪个方法来决定权限*/
        /*想了想还是要根据最终ajax请求的url来进行控制，现在要解决的问题是router和url绑定的问题*/
        String requestUrl = filterInvocation.getRequestUrl();
        System.out.println("访问的URL地址为(包括参数):" + requestUrl);
        requestUrl = filterInvocation.getRequest().getServletPath();
        System.out.println("访问的URL地址为:" + requestUrl);
        /*根据rul获取权限*/


       /* OptDesc od = Struts2UrlParser.parseUrl(sUrl, fi.getRequest());
        if("T".equals(CodeRepositoryUtil.getValue("SYSPARAM","ACTIONRUNLOG")))
            optRecDao.recRunTime( od.getActionUrl(),od.getMethod());
        Map<OptDesc,RdbmsEntryHoder> list = this.getRdbmsEntryHolderList();
        if (list == null)
            return null;
        RdbmsEntryHoder entryHolder = list.get(od);
        if(entryHolder!=null)
            return entryHolder.getCad();*/
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
