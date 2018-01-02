package org.jvue.upms.service;

import com.github.pagehelper.PageInfo;
import org.jvue.upms.bean.JvRole;

public interface JvRoleService {
    PageInfo<JvRole> list(JvRole jvRole, Integer currentPage, Integer pageSize);

}

