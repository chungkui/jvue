package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.JvRole;
import org.jvue.upms.bean.JvUser;

import java.util.List;

@Mapper
public interface JvUserMapper {
    @Select("select * from jv_user where id=#{id}")
    public JvUser getUserById(Integer id);
    @Results(@Result(property = "userId",column = "user_id"))
    @Select("select * from jv_user where username=#{username}")
    public JvUser getUserByUserName(String username);
    /**
     * 根据用户获取角色下的菜单列表
     * @param userId
     * @return
     */
    @Results({
            @Result(property = "roleId", column = "role_id")
    })
    @Select("select t.* from jv_user_role w join jv_role t on w.role_id=t.role_id  where user_id=#{userId} ")
    public List<JvRole> listRoleByUser(@Param("userId") Integer userId);


}
