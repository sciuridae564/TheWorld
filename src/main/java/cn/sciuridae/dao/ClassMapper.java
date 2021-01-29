package cn.sciuridae.dao;

import cn.sciuridae.bean.Class;
import cn.sciuridae.bean.show.tagsShow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Repository
@Mapper
public interface ClassMapper extends BaseMapper<Class> {

    @Select("select id from class where class_name = #{name}")
    Integer getClassid(@Param("name")String name);
    @Select({"SELECT class_id ,class_name " +
            "FROM class"})
    Page<Class> getclass();
    @Select({"SELECT id FROM class where class_id= #{class}"})
    Integer getclassId(@Param("class")Long clazz);
}
