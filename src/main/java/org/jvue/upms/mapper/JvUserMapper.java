package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.jvue.upms.bean.JvUser;

@Mapper
public interface JvUserMapper {
    @Select("select * from jv_user where id=#{id}")
    public JvUser getUserById(Integer id);
    @Results(@Result(property = "userId",column = "user_id"))
    @Select("select * from jv_user where username=#{username}")
    public JvUser getUserByUserName(String username);
}
