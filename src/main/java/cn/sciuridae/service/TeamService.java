package cn.sciuridae.service;

import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.Team;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
public interface TeamService extends IService<Team> {
    List<Team> getTeamsByClassId(String class_id);

    Result saveTeamData(Team team);

    List<Team> getTeams(int col, int size);

}
