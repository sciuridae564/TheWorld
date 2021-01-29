package cn.sciuridae.controller;


import cn.sciuridae.bean.show.teamShow;
import cn.sciuridae.service.TeamService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 查找小队数据
     *
     * @param page  页码
     * @param limit 页面容量
     * @return json {code:0,msg:错误原因,data:object}
     * code为0为成功，data携带查询到的数据 其他则为不成功 msg携带错误原因
     */
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

    /**
     * 删除小队数据
     *
     * @param teamid 小队的队伍编号
     * @return json {code：0，msg：“”}
     * code为0则为成功 msg为不成功信息
     */
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
     *  保存一个小队数据
     * @param teamid 小队队伍编号
     * @param team_name 小队队名
     * @param team_class_id 小队所属的班级编号
     * @param team_nick  小队昵称
     * @param team_slo 小队的标语
     * @param team_leader_id 小队的队长学号
     * @return {code：0，msg}
     *          0为成功 ，msg为错误原因
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
        } else if (add == -2) {
            root.put("msg", "组长和班级不存在");
        } else if (add == 0) {
            root.put("msg", "插入成功");
        }


        return root.toString();
    }

    /**
     * 更改一个小队数据
     *
     * @param teamid         小队编码 必须在数据库中已有值
     * @param team_name      小队队名 可为空
     * @param team_class_id  小队所属的班级编号 可为空
     * @param team_nick      小队昵称 可为空
     * @param team_slo       小队标语 可为空
     * @param team_leader_id 小队队长学号 可为空
     * @return {code：0.msg：“”}
     */
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

