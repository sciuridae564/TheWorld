package cn.sciuridae.controller;

import cn.sciuridae.bean.City;
import cn.sciuridae.bean.Class;
import cn.sciuridae.service.CityService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 插入新城市
     * @param city_name
     * @return code 0成功 -1 已存在一个同名城市 -2 插入数据库失败
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(String city_name) {
        City city=new City();
        city.setCity_name(city_name);
        city.setCity_time(LocalDateTime.now());
        int i = cityService.addCity(city_name);
        ObjectMapper objectMapper=new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("code",i);
        return objectNode.toString();
    }

    //用来查询所有城市的请求，以json对象返回查询的结果
    @RequestMapping("findAlldata")
    @ResponseBody
    public String findAllJSON(int page,int limit) {
        Page<City> Paging = cityService.findByCity(page, limit);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        root.put("count", Paging.getTotal());
        root.put("page", Paging.getPages());
        try {
            List<City> result = Paging.getResult();

            String s=JsonUtils.objectToJsonString(result);
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
}
