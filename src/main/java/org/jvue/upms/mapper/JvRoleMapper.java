package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jvue.upms.bean.JvRole;

import java.util.List;

@Mapper
public interface JvRoleMapper {
    @Select("select r.* from jv_role_permission w join jv_role r on w.role_id=r.role_id where w.permission_id=#{permissionId}")
    public List<JvRole> listRoleByPermissionId(@Param("permissionId")Integer permissionId);
}
