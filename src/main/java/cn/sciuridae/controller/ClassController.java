package cn.sciuridae.controller;

import cn.sciuridae.bean.Class;
import cn.sciuridae.bean.show.tagsShow;
import cn.sciuridae.service.ClassService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @RequestMapping("findAlldata")
    @ResponseBody
    public String findAll(int page,int limit ) {
        Page<Class> Paging;
        Paging = classService.findByClass(page, limit );
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("count", Paging.getTotal());
        root.put("page", Paging.getPages());
        try {
            List<Class> result = Paging.getResult();
            String s=mapper.writeValueAsString(result);
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

    @RequestMapping("save")
    @ResponseBody
    public String save(String classname,String classid) {
        Class clazz=new Class();
        try {
            clazz.setClass_id(Long.parseLong(classid.trim()));
        }catch (Exception e){
            e.printStackTrace();
            return "false";

        }

        clazz.setClass_name(classname);
        return String.valueOf(classService.save(clazz));
    }

    //查询所有班级信息
    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Class> findAllClazzJSON() {
        return classService.list();
    }

}
