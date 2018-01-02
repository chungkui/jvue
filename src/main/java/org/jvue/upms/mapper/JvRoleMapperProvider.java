package org.jvue.upms.mapper;

import com.github.pagehelper.util.StringUtil;
import org.jvue.upms.bean.JvRole;

public class JvRoleMapperProvider {
    public String listSQL(JvRole jvRole){


        String sql="select * from jv_role w where 1=1";
        if(jvRole.getName()!=null){
            sql+=" and w.name=#{name} ";
        }
        if(StringUtil.isNotEmpty(jvRole.getDescription())){
            sql+=" and w.description like #{description}  ";
        }

        return sql;
    }
}
