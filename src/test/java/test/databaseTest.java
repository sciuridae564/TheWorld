package test;

import cn.sciuridae.MySpringApplication;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.service.StudentService;
import cn.sciuridae.service.TagsService;
import cn.sciuridae.service.TeamService;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringApplication.class)
public class databaseTest {

    @Autowired
    TagsService tagsService;
    @Autowired
    TeamService teamService;
    @Autowired
    StudentService studentService;


    @Test
    public void test() {
//        Tags tags=new Tags();
//        tags.setTags_createtime(LocalDateTime.now());
//        tags.setTags_name("面包");
//        tags.setTags_type(true);
//        tagsService.save(tags);
//        String student_bir="2001-07-04";
//        Student student=new Student();
//        student.setWork_city(4);
//        student.setStudent_bir(LocalDate.parse(student_bir));
//        student.setStudent_sex(false);
//        student.setQq_number(5544166555L);
//        student.setStudent_team_id(2);
//        student.setStudent_class_id(1);
//        student.setStudent_name("test");
//        student.setStudent_id(1122554454L);

        Page<studentShow> byPaging = studentService.findByPaging(1, 2);
        System.out.println(byPaging.getResult().get(0));
        System.out.println(byPaging.getResult().get(1));
    }
}
