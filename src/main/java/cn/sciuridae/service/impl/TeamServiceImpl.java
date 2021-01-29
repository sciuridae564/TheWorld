package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.Team;
import cn.sciuridae.dao.TeamMapper;
import cn.sciuridae.service.TeamService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Team> getTeamsByClassId(String class_id) {
        return teamMapper.getTeamsByClassId(class_id);
    }

    @Override
    public Result saveTeamData(Team team) {
        Result result = new Result();
        Team teamByTeamId = teamMapper.getTeamByTeamId(team.getTeam_id());
        if (teamByTeamId != null) {
            result.setStatus(false);
            result.setMessage("异常:组别编号已存在");
            return result;
        }
        teamByTeamId = teamMapper.getTeamByTeamName(team.getTeam_name());
        result.setStatus(true);
        if (teamByTeamId != null) {
            result.setMessage("警告:组别名字存在");
        } else {
            result.setMessage("成功插入组别");
        }
        teamMapper.insert(team);
        return result;
    }

    @Override
    public List<Team> getTeams(int col, int size) {

        Page<Team> studentPage = teamMapper.selectPage(new Page<>(col, size), null);
        return studentPage.getRecords();

    }


}
