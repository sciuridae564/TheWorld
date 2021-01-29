package cn.sciuridae.controller;

import cn.sciuridae.bean.Class;
import cn.sciuridae.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClassController {

    @Autowired
    private ClassService classService;

    //定义一个用来接受查询所有班级信息请求
    @RequestMapping("findAll")
    public String findAll(Model model) {
        //1.调用业务层
        List<Class> clazzes = classService.list();
        model.addAttribute("clazzes", clazzes);
        //2。转发到用来展示所有班级信息的页面
        return "back/clazz/index";
    }

    @RequestMapping("save")
    public String save(Class clazz) {
        classService.save(clazz);
        //  return "back/clazz/index";
        return "redirect:/clazz/findAll";
    }

    //查询所有班级信息
    @RequestMapping("findAllClazzJSON")
    @ResponseBody
    public List<Class> findAllClazzJSON() {
        return classService.list();
    }

}
