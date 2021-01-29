package cn.sciuridae.controller;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.bean.show.tagsShow;
import cn.sciuridae.service.TagsService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagsService tagsService;

    //定义用来接受查询所有的请求
    @RequestMapping("findAlldata")
    @ResponseBody
    public String findAll(int page, int limit) {
        Page<tagsShow> Paging;
        Paging = tagsService.findByPaging(page, limit );
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("count", Paging.getTotal());
        root.put("page", Paging.getPages());
        try {
            List<tagsShow> result = Paging.getResult();
            String s  =mapper.writeValueAsString(result);
            JsonNode jsonNode = mapper.readTree(s);
            root.set("data", jsonNode);
            root.put("code", 0);
            root.put("msg", "");
        } catch (JsonProcessingException e) {
            root.put("code", 1);
            root.put("msg", "json解析错误");
            e.printStackTrace();
        }
        return root.toString();

    }

    //定义一个用来接受添加标签的请求
    @PostMapping("save")
    @ResponseBody
    public boolean save(String Tags_name, boolean Tags_type) {
        Tags tags = new Tags();
        tags.setTags_type(Tags_type);
        tags.setTags_name(Tags_name);
        tags.setTags_createtime(LocalDateTime.now());
        try {
            tagsService.save(tags);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 0班级1学生
     *
     * @param type
     * @return
     */
    @GetMapping("findByType")
    @ResponseBody
    public List<Tags> findByType(boolean type) {
        return tagsService.getTags(type);
    }
}
