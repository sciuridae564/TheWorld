package cn.sciuridae.controller;


import cn.sciuridae.bean.Team;
import cn.sciuridae.bean.show.teamShow;
import cn.sciuridae.service.TeamService;
import cn.sciuridae.utils.JsonUtils;
import com.github.pagehelper.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("findAlldata")
    @ResponseBody
    public String getTeams(Integer page, Integer limit) {

        Page<teamShow> Paging = teamService.findByPaging(page, limit);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("count", Paging.getTotal());
        root.put("page", Paging.getPages());
        try {
            String s = JsonUtils.objectToJsonString(Paging.getResult());
            JsonNode jsonNode = mapper.readTree(s);
            root.set("data", jsonNode);
            root.put("code", 0);
            root.put("msg", "");
        } catch (JsonProcessingException e) {
            root.put("code", 1);
            root.put("msg", "json解析错误");
        }
        return root.toString();
    }

    @RequestMapping("dele")
    @ResponseBody
    public String deleTeam(Long teamid) {

        int dele = teamService.dele(teamid);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        if (dele == -1) {
            root.put("code", dele);
            root.put("msg", "数据不存在");
        } else {
            root.put("code", dele);
            root.put("msg", "");
        }

        return root.toString();
    }

    /**
     *
     * @param teamid
     * @param team_name
     * @param team_class_id
     * @param team_nick
     * @param team_slo
     * @param team_leader_id
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public String saveTeam(Long teamid, String team_name,
                           String team_class_id, String team_nick,
                           String team_slo, String team_leader_id) {
        Long clazz;
        Long leader;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        try {
            clazz=Long.parseLong(team_class_id);
            leader=Long.parseLong(team_leader_id);
        }catch (Exception e){
            root.put("code", -3);
            root.put("msg", "格式错误");
            return root.toString();
        }

        int add = teamService.add(teamid, team_name, clazz, team_nick, team_slo, leader);
        root.put("code", add);
        if (add == -1) {
            root.put("msg", "数据不存在");
        } else if(add==-2){
            root.put("msg", "组长和班级不存在");
        }else if (add==0){
            root.put("msg", "插入成功");
        }


        return root.toString();
    }

    @RequestMapping("change")
    @ResponseBody
    public String changeTeam(Long teamid, String team_name,
                             String team_class_id, String team_nick,
                             String team_slo, String team_leader_id) {
        Long clazz;
        Long leader;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        try {
            clazz=Long.parseLong(team_class_id);
            leader=Long.parseLong(team_leader_id);
        }catch (Exception e){
            root.put("code", -3);
            root.put("msg", "格式错误");
            return root.toString();
        }
        int change = teamService.Change(teamid, team_name, clazz, team_nick, team_slo, leader);
        root.put("code", change);
        if (change == -1) {
            root.put("msg", "数据不存在");
        } else if(change==-2){
            root.put("msg", "班级不存在");
        }else if (change==-3){
            root.put("msg", "组长不存在");
        }else if(change==0){
            root.put("msg", "插入成功");
        }

        return root.toString();
    }

}

