package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.JvRole;
import org.jvue.upms.bean.JvUser;

import java.util.List;

@Mapper
public interface JvUserMapper {
    /**
     * 根据userid查询用户信息
     * @param id
     * @return
     */
    @Select("select * from jv_user where id=#{id}")
    public JvUser getUserById(Integer id);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
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


    /**
     * 获取用户列表
     * @return
     */
    @Results(
            @Result(property = "userId" ,column = "user_id")
    )
    @SelectProvider(type = JvUserMapperProvider.class,method = "listSql")
    public List<JvUser>list(JvUser jvUser);

    /**
     * 新增用户
     */
    @SelectKey(statement = "select last_insert_id()", keyProperty = "jvUser.userId", before = false, resultType = int.class)
    @Insert("INSERT INTO jv_user(user_id,username,password,realname,avatar,phone,email,sex,locked,ctime) " +
            "VALUES(#{jvUser.userId},#{jvUser.username},#{jvUser.password},#{jvUser.realname},#{jvUser.avatar}," +
            "#{jvUser.phone},#{jvUser.email},#{jvUser.sex},#{jvUser.locked},SYSDATE())")
    public boolean create(@Param("jvUser")JvUser jvUser);


}
