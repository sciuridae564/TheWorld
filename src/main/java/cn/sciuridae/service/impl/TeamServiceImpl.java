package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.Team;
import cn.sciuridae.bean.show.teamShow;
import cn.sciuridae.dao.ClassMapper;
import cn.sciuridae.dao.StudentMapper;
import cn.sciuridae.dao.TeamMapper;
import cn.sciuridae.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassMapper classMapper;


    @Override
    public Page<teamShow> findByPaging(int current, int limit) {
        PageHelper.startPage(current, limit);
        return teamMapper.getShow();
    }

    @Override
    public int dele(Long teamId) {
        Team teamByTeamId = teamMapper.getTeamByTeamId(teamId);
        if (teamByTeamId == null) {
            return -1;
        }

        return teamMapper.deleteById(teamByTeamId.getId());
    }

    @Override
    public int add(Long teamId, String team_name,
                   Long team_class_id, String team_nick,
                   String team_slo, Long team_leader_id) {
        Team team = teamMapper.getTeamByTeamId(teamId);
        if (team != null) {
            return -1;//已经存在组号
        }

        team = new Team();
        team.setTeam_id(teamId);
        team.setTeam_name(team_name);
        team.setTeam_nick(team_nick);
        team.setTeam_slo(team_slo);

        Student student = studentMapper.getStudent(team_leader_id);
        Integer integer = classMapper.getclassId(team_leader_id);
        if (student == null || integer == null) {
            return -2;//组长和班级不存在
        }
        team.setTeam_class_id(Long.valueOf(integer));
        team.setTeam_leader_id(student.getId());

        return 0;
    }

    @Override
    public int Change(Long teamid, String team_name,
                      Long team_class_id, String team_nick,
                      String team_slo, Long team_leader_id) {
        if(teamid==null){
            return -1;
        }
        Team team = teamMapper.getTeamByTeamId(teamid);//数据库的旧数据
        if(team==null){
            return -1;
        }

        if(team_name!=null&&!team.getTeam_name().equals(team_name)){
            team.setTeam_name(team_name);
        }

        if(team_class_id!=null){
            Integer integer = classMapper.getclassId(team_leader_id);
            if(integer==null){
                return -2;
            }
            team.setTeam_class_id(Long.valueOf(integer));
        }

        if(team_nick!=null&&!team.getTeam_nick().equals(team_nick)){
            team.setTeam_nick(team_nick);
        }

        if(team_slo!=null&&!team.getTeam_slo().equals(team_slo)){
            team.setTeam_slo(team_slo);
        }
        if(team_leader_id!=null){
            Student student = studentMapper.getStudent(team_leader_id);
            if(student==null){
                return -3;
            }
            team.setTeam_leader_id(student.getId());
        }

        teamMapper.updateById(team);
        return 0;
    }


}
