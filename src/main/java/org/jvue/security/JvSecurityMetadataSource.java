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
        FilterInvocation fi = (FilterInvocation) o;
        String sUrl = fi.getRequestUrl();
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

    @Override
    public boolean supports(Class<?> aClass) {
        if (FilterInvocation.class.isAssignableFrom(aClass)) {
            return true;
        }
        return false;
    }
}
