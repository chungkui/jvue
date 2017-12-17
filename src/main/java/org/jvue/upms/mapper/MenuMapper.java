package org.jvue.upms.mapper;

import org.apache.ibatis.annotations.*;
import org.jvue.upms.bean.Menu;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from j_menu where level=1")
    @Results({
            @Result( property ="id",column = "id"),
            @Result(property = "sunList", javaType = List.class, column = "ID",
                    many = @Many(select = "org.jvue.upms.mapper.MenuMapper.listByPid"))
    })/*此处自关联查询要不用写mapper名称，如果要写也要写全路径，或者 直接写对应的方法即可*/
    public List<Menu> list();

    @Select("select * from j_menu where pid= #{xxx}")
    public List<Menu> listByPid(@Param("id")String xxx);

    @Delete("delete from j_menu where id=#{id}")
    public void delete(String id);

    @Select("select * from j_menu where id=#{id}")
    public Menu getObjectById(String id);

    @Update("update j_menu set ")
    public void update(Menu menu);

    class MenuMapperPrivade {

    }
}
