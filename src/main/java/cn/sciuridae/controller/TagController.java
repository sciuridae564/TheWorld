package cn.sciuridae.controller;

import cn.sciuridae.bean.Tags;
import cn.sciuridae.service.TagsService;
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
@RequestMapping("tag")
public class TagController {

    @Autowired
    private TagsService tagsService;

    //定义用来接受查询所有的请求
    @GetMapping("findAll")
    public String findAll(Model model) {
        //1.调用业务层查询所有的标签
        List<Tags> tags = tagsService.list();
        return "back/tag/index";

    }

    //定义用来接受查询所有的请求
    @PostMapping("findAll")
    @ResponseBody
    public List<Tags> findAll() {
        //1.调用业务层查询所有的标签
        List<Tags> tags = tagsService.list();
        return tags;

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
