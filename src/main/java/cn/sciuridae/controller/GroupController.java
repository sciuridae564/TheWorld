package cn.sciuridae.controller;

import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.Team;
import cn.sciuridae.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("group")
public class GroupController {

    @Autowired
    private TeamService teamService;

    //定义用来查询所有小组
    @GetMapping("findAll")
    public String findAll(Model model) {
        //跳转页面
        return "back/group/index";
    }

    //定义用来查询所有小组
    @GetMapping("findAlldata")
    public List<Team> findAll() {
        return teamService.list();
    }

    //定义用来保存小组信息
    @PostMapping("save")
    @ResponseBody
    public Result save(Team team) {
        Result result = teamService.saveTeamData(team);
        return result;
    }

    //定义一个请求。用来根据用户传递的班级id查询对应的小组信息
    @RequestMapping("findAllJSON")
    @ResponseBody
    public List<Team> findAllJSON(String id) {
        return teamService.getTeamsByClassId(id);
    }
}
