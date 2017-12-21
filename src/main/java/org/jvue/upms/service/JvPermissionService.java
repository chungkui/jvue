package org.jvue.upms.service;

import org.jvue.upms.bean.JvPermission;

import java.util.List;

public interface JvPermissionService {
    List<JvPermission> list();
    List<JvPermission>listPermissionByUser(Integer userId);
    List <JvPermission>listPermissionByRole(Integer roleId);
}
