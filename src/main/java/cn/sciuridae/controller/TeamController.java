package cn.sciuridae.controller;


import cn.sciuridae.bean.Team;
import cn.sciuridae.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @RequestMapping("index")
    public String index() {
        return "team";
    }


    @GetMapping("allTeam")
    public List<Team> getTeams(int col) {

        List<Team> list = teamService.list();

        return list;
    }

}

