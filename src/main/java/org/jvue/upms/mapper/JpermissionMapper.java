package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.Jpermission;

import java.util.List;

@Mapper
public interface JpermissionMapper {
   /* @Select("select * from j_Permission where type=2")
    @Results({
            @Result( property ="permissionId",column = "permission_Id"),
            *//*@Result(property = "sunList", javaType = List.class, column = "PERMISSION_ID",
                    many = @Many(select = "org.jvue.upms.mapper.JpermissionMapper.listByPid"))*//*
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

            @Result(property = "serialVersionUID", column = "serial_version_u_i_d"),
    })
    @SelectProvider(type = JpermissionSqlProvider.class, method = "selectBean")
    public List<Jpermission> list();

    @Select("select * from j_Permission where pid= #{xxx}")
    public List<Jpermission> listByPid(@Param("permission_Id") String xxx);

    @Delete("delete from j_Permission where id=#{id}")
    public void delete(String id);

    @Select("select * from j_Permission where id=#{id}")
    public Jpermission getObjectById(String id);

    @Update("update j_Permission set ")
    public void update(Jpermission menu);

    class JPermissionMapperp {

    }
}
