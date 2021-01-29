package cn.sciuridae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {

    @RequestMapping("data")
    @ResponseBody
    public String save(String[] interest) {

        System.out.println("a");
        return "aaa";
    }

    @RequestMapping("test")
    public String aaa() {

        System.out.println("a");
        return "test";
    }

}
