package cn.sciuridae.service;

import cn.sciuridae.bean.Team;
import cn.sciuridae.bean.show.teamShow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
public interface TeamService extends IService<Team> {
    Page<teamShow> findByPaging(int current, int limit);
    int dele(Long teamId);
    int add(Long teamId, String team_name,
            Long team_class_id, String team_nick,
            String team_slo, Long team_leader_id);
    int Change(Long teamid, String team_name,
               Long team_class_id, String team_nick,
               String team_slo, Long team_leader_id);
}
