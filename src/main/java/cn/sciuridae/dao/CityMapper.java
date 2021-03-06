package cn.sciuridae.dao;

import cn.sciuridae.bean.City;
import cn.sciuridae.bean.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface CityMapper extends BaseMapper<City> {
    @Update("update `city` set `city_count` = `city_count`-1 WHERE `id` = #{id}")
    boolean deleStudent(@Param("id") int id);

    @Update("update `city` set `city_count` = `city_count`+1 WHERE `id` = #{id}")
    boolean addStudent(@Param("id") int id);

    @Select("select id from city where city_name = #{name}")
    Integer getCityid(@Param("name")String name);

    @Select("select city_name,city_time ,city_count from city ")
    Page<City> getCity();
}
