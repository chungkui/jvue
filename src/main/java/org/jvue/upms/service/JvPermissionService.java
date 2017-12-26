package org.jvue.upms.service;

import org.jvue.upms.bean.JvPermission;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface JvPermissionService {
    List<JvPermission> list();
    List<JvPermission>listPermissionByUser(Integer userId);
    List <JvPermission>listPermissionByRole(Integer roleId);
    Map<RequestMatcher, Collection<ConfigAttribute>> cacheRequestMap();
}
