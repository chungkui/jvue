package org.jvue.upms.service;

import com.github.pagehelper.PageInfo;
import org.jvue.upms.bean.JvUser;

import java.util.List;

public interface JvUserService {
    PageInfo<JvUser> list(JvUser jvUser, Integer currentPage, Integer pageSize);
    boolean create(JvUser jvUser);
}
