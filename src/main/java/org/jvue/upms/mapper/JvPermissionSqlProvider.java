package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.Param;

public class JvPermissionSqlProvider {
    public String selectBean() {
        return "select * from jv_permission";
    }

    public String listPermissionByRoleSQL(@Param("roleId")Integer roleId) {
        String sql="SELECT" +
                " distinct t.* " +
                " FROM " +
                " jv_role_permission w" +
                " LEFT JOIN jv_permission t ON t.permission_id = w.permission_id " +
                " where w.role_id=#{roleId}";
        return sql;
    }
    public String listPermissionByUserSQL(@Param("userId")Integer userId) {
        String sql="select distinct p.* from jv_user_role ur  " +
                "join jv_role_permission rp on rp.role_id=ur.role_id  " +
                "join jv_permission  p on rp.permission_id=p.permission_id " +
                " where ur.user_id=#{userId}";
        return sql;
    }

}
