package cn.sciuridae.controller;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.bean.show.tagsShow;
import cn.sciuridae.service.TagsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /**
     * 分页查找所有标签数据
     *
     * @param page  页码 可为0 为0则返回全部数据
     * @param limit 页面容量
     * @return {code:0 ,msg:错误原因 ,data:Object}
     * 0为成功查找 data有值 发生错误时msg有值 ，
     */
    @RequestMapping("findAlldata")
    @ResponseBody
    public String findAll(int page, int limit) {
        Page<tagsShow> Paging;
        Paging = tagsService.findByPaging(page, limit);
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

    /**
     * 保存一个标签数据
     *
     * @param Tags_name 标签名
     * @param Tags_type 标签种类 0为学校标签 1为个人标签
     * @return 插入成功与否
     */
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

}
