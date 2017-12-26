package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.JvPermission;
import org.jvue.upms.bean.JvRole;

import java.util.List;

@Mapper
public interface JvPermissionMapper {
   /* @Select("select * from j_Permission where type=2")
    @Results({
            @Result( property ="permissionId",column = "permission_Id"),
            *//*@Result(property = "sunList", javaType = List.class, column = "PERMISSION_ID",
                    many = @Many(select = "org.jvue.upms.mapper.JvPermissionMapper.listByPid"))*//*
    })*//*此处自关联查询要不用写mapper名称，如果要写也要写全路径，或者 直接写对应的方法即可*//*
     */

    /**
     * @return
     */
    @Results({
            @Result(property = "permissionId", column = "permission_id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "name", column = "name"),
            @Result(property = "type", column = "type"),
            @Result(property = "permissionValue", column = "permission_value"),
            @Result(property = "routerUri", column = "router_uri"),
            @Result(property = "routerName", column = "router_name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "status", column = "status"),
            @Result(property = "ctime", column = "ctime"),
            @Result(property = "orders", column = "orders"),
            @Result(property = "componentPath", column = "component_path"),
            @Result(property = "serialVersionUID", column = "serial_version_u_i_d"),
    })
    @SelectProvider(type = JvPermissionSqlProvider.class, method = "selectBean")
    public List<JvPermission> list();

    /**
     * 根据角色获取角色下的菜单列表
     * @param roleId
     * @return
     */
    @Results({
            @Result(property = "permissionId", column = "permission_id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "name", column = "name"),
            @Result(property = "type", column = "type"),
            @Result(property = "permissionValue", column = "permission_value"),
            @Result(property = "routerUri", column = "router_uri"),
            @Result(property = "routerName", column = "router_name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "status", column = "status"),
            @Result(property = "ctime", column = "ctime"),
            @Result(property = "orders", column = "orders"),
            @Result(property = "componentPath", column = "component_path"),
            @Result(property = "serialVersionUID", column = "serial_version_u_i_d"),
    })
    @SelectProvider(type = JvPermissionSqlProvider.class, method = "listPermissionByRoleSQL")
    public List<JvPermission>listPermissionByRole(@Param("roleId") Integer roleId);


    /**
     * 根据用户获取角色下的菜单列表
     * @param userId
     * @return
     */
    @Results({
            @Result(property = "permissionId", column = "permission_id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "name", column = "name"),
            @Result(property = "type", column = "type"),
            @Result(property = "permissionValue", column = "permission_value"),
            @Result(property = "routerUri", column = "router_uri"),
            @Result(property = "routerName", column = "router_name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "status", column = "status"),
            @Result(property = "ctime", column = "ctime"),
            @Result(property = "orders", column = "orders"),
            @Result(property = "componentPath", column = "component_path"),
            @Result(property = "serialVersionUID", column = "serial_version_u_i_d"),
    })
    @SelectProvider(type = JvPermissionSqlProvider.class, method = "listPermissionByUserSQL")
    public List<JvPermission>listPermissionByUser(@Param("userId") Integer userId);

    @Select("select * from jv_Permission where pid= #{xxx}")
    public List<JvPermission> listByPid(@Param("permission_Id") String xxx);

    @Delete("delete from jv_Permission where id=#{id}")
    public void delete(String id);

    @Select("select * from jv_Permission where id=#{id}")
    public JvPermission getObjectById(String id);

    @Update("update jv_Permission set ")
    public void update(JvPermission menu);





    /*查询多对多关系*/
    @Results({
            @Result(property = "permissionId", column = "permission_id"),
            @Result(property = "pid", column = "pid"),
            @Result(property = "name", column = "name"),
            @Result(property = "type", column = "type"),
            @Result(property = "permissionValue", column = "permission_value"),
            @Result(property = "routerUri", column = "router_uri"),
            @Result(property = "routerName", column = "router_name"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "status", column = "status"),
            @Result(property = "ctime", column = "ctime"),
            @Result(property = "orders", column = "orders"),
            @Result(property = "componentPath", column = "component_path"),
            @Result(property = "serialVersionUID", column = "serial_version_u_i_d"),
            @Result(property = "roleList", javaType = List.class, column = "PERMISSION_ID",
                    many = @Many(select = "org.jvue.upms.mapper.JvPermissionMapper.selectRoles"))
    })
    @Select("select * from jv_permission")
    List <JvPermission>cacheRequestMap();

    /*根据权限id查询出jvRole*/
    @Select("select DISTINCT * from jv_role jvr WHERE jvr.role_id in (select jvrp.role_id from jv_role_permission jvrp where jvrp.permission_id=#{permissionId})")
    List<JvRole>selectRoles(@Param("permissionId") Integer permissionId);

    /**/

}
