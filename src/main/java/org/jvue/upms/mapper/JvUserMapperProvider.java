package org.jvue.upms.mapper;

import com.github.pagehelper.util.StringUtil;
import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.jvue.upms.bean.JvUser;

public class JvUserMapperProvider {
    public String listSql(@Param("jvUser")JvUser jvUser){

     String sql="select * from jv_user w where 1=1";
         if(jvUser.getLocked()!=null){
             sql+=" and w.locked=#{locked} ";
         }
         if(StringUtil.isNotEmpty(jvUser.getRealname())){
             sql+=" and w.realname like #{realname}  ";
         }
        if(StringUtil.isNotEmpty(jvUser.getUsername())){
            sql+=" and w.username like #{username}  ";
        }
        return sql;
    }
}
