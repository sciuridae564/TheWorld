package cn.sciuridae.controller;

import cn.sciuridae.bean.Login;
import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.loginShow;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.service.LoginService;
import cn.sciuridae.utils.JsonUtils;
import cn.sciuridae.utils.ValidateImageCodeUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.lang.management.OperatingSystemMXBean;

//该控制器层用来接受用户模块相关的请求
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private LoginService loginService;

    //定义一个专门用来接受生成随机验证码图片请求的方法
    @GetMapping("getImage")
    public void getImage(HttpServletResponse response, HttpSession session) throws Exception {
        //1.获取一个随机的验证码
        String code = ValidateImageCodeUtils.getSecurityCode();

        //把生成的验证码设置在session域中
        session.setAttribute("code", code);
        //2.根据获取的随机验证码生成一张验证码图片
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        //3.把生成的验证码图片传输到前端对应发送请求的img标签中
        ImageIO.write(image, "png", response.getOutputStream());
    }


    //定义一个用来接受注册请求的方法
    @PostMapping("regist")
    @ResponseBody
    public Result regist(String code, String username, String password, int role, HttpSession session) {
        Result result;

//        String code1 = (String) session.getAttribute("code");
//        if (code1.equalsIgnoreCase(code)) {
            //当验证码一致的时候，调用业务层
            result = loginService.regist(username, password, role == 1);
//        } else {
//            result = new Result();
//            result.setMessage("验证码错误").setStatus(false);
//        }

        return result;
    }


    //定义一个请求用来接受登录操作
    @RequestMapping("login")
    @ResponseBody
    public String login(HttpSession session, String code, String username, String password) {
        ObjectMapper objectMapper=new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        String code1 = (String) session.getAttribute("code");

        if (code1.equalsIgnoreCase(code)) {
            int role = loginService.login(username, password);
            if(role>0){
                Login object = new Login();
                object.setAccount_name(username);
                object.setAccount_password(password);
                if(role>1){
                    object.setRole(true);
                }
                session.setAttribute("user",object);
                objectNode.put("code",1);
                objectNode.put("message","登陆成功");
            }else {
                objectNode.put("code",0);
                objectNode.put("message","用户名或密码输入错误");
            }

        } else {
        objectNode.put("code",0);
        objectNode.put("message","验证码错误");
        }
        return objectNode.toString();
    }


    //用户退出功能
    @RequestMapping("back")
    @ResponseBody
    public String back(HttpSession session) {
        //1.清空session域中的数据
        session.invalidate();//清空
        //2.跳转到login.jsp登录页面
        return "yes,sir";
    }

    @RequestMapping("list")
    public String getuser(Integer page, Integer limit) {


        Page<loginShow> Paging=loginService.findByPaging(page,limit);

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

}
