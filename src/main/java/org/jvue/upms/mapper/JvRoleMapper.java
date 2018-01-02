package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.JvRole;

import java.util.List;

@Mapper
public interface JvRoleMapper {
    /**
     * 根据资源id获所需要的角色数据
     * @param permissionId
     * @return
     */
    @Select("select r.* from jv_role_permission w join jv_role r on w.role_id=r.role_id where w.permission_id=#{permissionId}")
    public List<JvRole> listRoleByPermissionId(@Param("permissionId")Integer permissionId);

    /**
     * 维护角色列表
     * @return
     */
    @Results(
            @Result(column = "role_id",property = "roleId")
    )
    @SelectProvider(type = JvRoleMapperProvider.class,method = "listSQL")
    public List<JvRole>list(JvRole jvRole);
}
