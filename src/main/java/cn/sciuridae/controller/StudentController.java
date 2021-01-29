package cn.sciuridae.controller;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.Tags_to_student;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.service.StudentService;
import cn.sciuridae.service.TagsService;
import cn.sciuridae.service.Tags_to_studentService;
import cn.sciuridae.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Tags_to_studentService tags_to_studentService;
    @Autowired
    private TagsService tagsService;

    /**
     * 查询学生数据
     */
    @GetMapping("findAll")
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

    //学生添加方法
    @RequestMapping("save")
    @ResponseBody
    public boolean save(Long student_id,
                        String student_name,
                        String student_sex,
                        String student_bir,
                        String student_class,
                        String student_team,
                        Long qq_number,
                        String work_city,
                        String[] tags) {

        //插入student
        studentShow student = new studentShow();
        student.setWork_city(work_city);


        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate=LocalDate.parse(student_bir,dTF);
        LocalDateTime localDateTime=localDate.atTime(0,0);
        student.setStudent_bir(localDateTime);


        student.setStudent_sex(student_sex);
        student.setQq_number(qq_number);
        student.setStudent_team(student_team);
        student.setStudent_class(student_class);
        student.setStudent_name(student_name);
        student.setStudent_id(student_id);

        Student student1 = studentService.addStudent(student);
        if (student1 == null) {
            return false;
        }


        //插入标签关系
        if(tags!=null){
            Tags_to_student tags_to_student;
            for (String s : tags) {
                tags_to_student = new Tags_to_student();
                tags_to_student.setTags_student_id(student1.getId());
                tags_to_student.setTags_tags_id(tagsService.getTags(s));
                tags_to_studentService.save(tags_to_student);
            }
        }

        return true;
    }

    //学生删除方法
    @RequestMapping("dele")
    @ResponseBody
    public boolean save(Long student_ID) {
        return studentService.deleStudent(student_ID);
    }

    //学生改变方法
    @RequestMapping("change")
    @ResponseBody
    public String save(Long student_ID,
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
