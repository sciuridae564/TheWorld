package cn.sciuridae.controller;

import cn.sciuridae.bean.City;
import cn.sciuridae.service.CityService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    //定义用来接受查询所有的请求
    @GetMapping("findAlldata")
    @ResponseBody
    public ObjectNode findAll(Model model) {
        List<City> list = cityService.list();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("code", 0);
        root.put("msg", "完成");
        root.put("count", list.size());
        try {
            String s = JsonUtils.objectToJsonString(list);
            JsonNode jsonNode = mapper.readTree(s);
            root.set("data", jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(root);
        return root;
    }

    //定义一个请求用来接受添加城市操作
    @RequestMapping("save")
    @ResponseBody
    public String save(City city) {
        cityService.save(city);
        return "redirect:/city/findAll";
    }

    //用来查询所有城市的请求，以json对象返回查询的结果
    @RequestMapping("findAllJSON")
    @ResponseBody
    public List<City> findAllJSON() {
        List<City> cities = cityService.list();
        return cities;
    }
}
