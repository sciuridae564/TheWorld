package cn.sciuridae.controller;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.Tags_to_student;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.controller.bean.JsonData;
import cn.sciuridae.service.CityService;
import cn.sciuridae.service.StudentService;
import cn.sciuridae.service.TagsService;
import cn.sciuridae.service.Tags_to_studentService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Tags_to_studentService tags_to_studentService;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private CityService cityService;

    /**
     * 查询学生数据，可以根据传入的搜索条件进一步搜索
     *
     * @param page        请求第几页
     * @param limit       页面容量
     * @param searchValue 搜索内容 如 944584122 可为空
     * @param SearchType  搜索种类 如 qq号，可为空
     * @return 搜索结果 {code:0,msg:失败原因 ,data:Object}
     */
    @GetMapping("findAlldata")
    @ResponseBody
    public ObjectNode findAll(Integer page, Integer limit, String searchValue, String SearchType) {
        Page<studentShow> Paging;
        if (searchValue == null || searchValue.equals("")) {
            Paging = studentService.findByPaging(page, limit);
        } else {
            searchType item = searchType.valueOf(SearchType);
            Paging = studentService.findByPaging(page, limit, item, searchValue);
        }
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
        return root;
    }

    /**
     * 添加一个学生
     *
     * @param student_id    学生学号 如 11254125
     * @param student_name  学生姓名 如 阿里巴巴
     * @param student_sex   性别   如 女
     * @param student_bir   生日  如 2020-02-15 必须符合 yyyy-MM-dd
     * @param student_class 班级名如 烤鸭班 必须已存在
     * @param student_team  团队名如 烤鸭队
     * @param qq_number     qq号码  如 54555155
     * @param work_city     工作城市 如  北京    城市必须已存在
     * @param tags          标签数组      如 [篮球，乒乓球]标签必须已存在
     * @return 插入成功与否json 0成功 {code:0,msg:,data}
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(Long student_id,
                       String student_name,
                       String student_sex,
                       String student_bir,
                       String student_class,
                       String student_team,
                       Long qq_number,
                       String work_city,
                       String[] tags) {
        JsonData jsonData = new JsonData();
        //student构造
        studentShow student = new studentShow();

        //插入城市数据
        if (work_city != null) {
            Integer cityId = cityService.getCityId(work_city);
            //如果城市存在则插入
            if (cityId != null) {
                student.setWork_city(work_city);
            }
        }

        //生日插入
        if (student_bir != null) {
            try {
                DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(student_bir, dTF);
                LocalDateTime localDateTime = localDate.atTime(0, 0);
                student.setStudent_bir(localDateTime);
            } catch (DateTimeParseException e) {
                jsonData.setCode(-1);
                jsonData.setMsg("生日格式错误，正确格式为2012-05-12");
                try {
                    return JsonUtils.objectToJsonString(jsonData);
                } catch (JsonParseException jsonParseException) {
                }
            }
        }

        if (student_sex != null) {
            student.setStudent_sex(student_sex);
        } else {
            jsonData.setCode(-2);
            jsonData.setMsg("人物必须有性别");
            try {
                return JsonUtils.objectToJsonString(jsonData);
            } catch (JsonParseException jsonParseException) {
            }
        }

        student.setQq_number(qq_number);
        student.setStudent_team(student_team);
        student.setStudent_class(student_class);
        student.setStudent_name(student_name);
        student.setStudent_id(student_id);

        Student student1 = studentService.addStudent(student);
        if (student1 == null) {
            jsonData.setCode(-1);
            jsonData.setMsg("插入失败");
            try {
                return JsonUtils.objectToJsonString(jsonData);
            } catch (JsonParseException jsonParseException) {
            }
        }


        //插入标签关系
        if (tags != null) {
            Tags_to_student tags_to_student;
            for (String s : tags) {
                tags_to_student = new Tags_to_student();
                tags_to_student.setTags_student_id(student1.getId());
                tags_to_student.setTags_tags_id(tagsService.getTags(s));
                tags_to_studentService.save(tags_to_student);
            }
        }


        jsonData.setCode(0);
        jsonData.setMsg("成功插入");
        jsonData.setData(student);
        try {
            return JsonUtils.objectToJsonString(jsonData);
        } catch (JsonParseException jsonParseException) {
        }
        return null;
    }

    /**
     * 根据传入的学生学号删除学生 数据
     *
     * @param student_ID 学生学号
     * @return 成功与否
     */
    @RequestMapping("dele")
    @ResponseBody
    public boolean save(Long student_ID) {
        return studentService.deleStudent(student_ID);
    }

    /**
     * 更改学生信息，为空的字段则不会修改，格式与添加相同
     *
     * @param student_ID    学生学号  不可为空 一定在数据库中已存在
     * @param student_name  学生姓名 可为空
     * @param student_sex   学生性别 可为空
     * @param student_bir   学生生日  可为空
     * @param student_class 学生班级名字 可为空
     * @param student_team  学生小组名字 可为空
     * @param qq_number     学生qq号 可为空
     * @param work_city     学生工作城市名字 可为空
     * @return {code：0，message ：object}
     * 如果成功则coded为0，不成功则为1，且message携带旧的学生数据
     */
    @RequestMapping("change")
    @ResponseBody
    public String changse(Long student_ID,
                          String student_name,
                          String student_sex,
                          String student_bir,
                          String student_class,
                          String student_team,
                          Long qq_number,
                          String work_city) {
        studentShow studentShow = new studentShow(student_ID, student_name, student_sex, student_bir, student_class, student_team, qq_number, work_city);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();
        studentShow studentShow1 = studentService.changeStudent(studentShow);
        root.put("code", studentShow1==null?0:1);

        try {
            root.put("message", mapper.writeValueAsString(studentShow1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return root.toString();
    }
}
