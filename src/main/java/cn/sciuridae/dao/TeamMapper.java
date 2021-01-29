package cn.sciuridae.dao;

import cn.sciuridae.bean.Team;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TeamMapper extends BaseMapper<Team> {
    @Select({"select * " +
            "from team " +
            "where team_class_id=#{class_id}"})
    List<Team> getTeamsByClassId(@Param("class_id") String class_id);

    @Select({"select * " +
            "from team " +
            "where team_id=#{team_id}"})
    Team getTeamByTeamId(@Param("team_id") Long team_id);


    @Select({"select * " +
            "from team " +
            "where team_name=#{team_name}"})
    Team getTeamByTeamName(@Param("team_name") String team_name);
}
