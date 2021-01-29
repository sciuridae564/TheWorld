package cn.sciuridae.dao;

import cn.sciuridae.bean.Team;
import cn.sciuridae.bean.show.teamShow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
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

    @Select({"select id " +
            "from team " +
            "where team_name=#{team_name}"})
    Integer getTeamIDByTeamName(@Param("team_name") String team_name);

    @Select("SELECT  te.team_id ,te.team_name ,cl.`class_name` AS team_class,te.`team_nick`,te.`team_slo`,st.`student_name` AS team_leader\n" +
            "FROM team te  \n" +
            "LEFT  JOIN class cl ON te.team_class_id=cl.`id` \n" +
            "LEFT  JOIN student st ON st.`id`=te.`team_leader_id`  \n" )
    Page<teamShow> getShow();
}
