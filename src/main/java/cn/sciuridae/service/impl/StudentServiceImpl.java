package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.dao.*;
import cn.sciuridae.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    Tags_to_studentMapper tags_to_studentMapper;

    @Override
    public boolean deleStudent(Long studentId) {
        Student student = studentMapper.getStudent(studentId);
        if (student == null) {
            return false;
        }
        cityMapper.deleStudent(student.getWork_city());//城市更新
        tags_to_studentMapper.deleByStudentId(student.getId());//关系表更新
        studentMapper.deleteById(student.getId());

        return true;
    }

    @Override
    public int addStudent(Student student) {
        cityMapper.addStudent(student.getWork_city());//城市更新
        int insert = studentMapper.insert(student);
        return insert;
    }

    @Override
    public Student addStudent(studentShow student) {
        Student stu = studentMapper.getStudent(student.getStudent_id());
        if(stu!=null){
            return null;
        }
        stu=new Student();
        if (student.getStudent_sex() != null) {
            stu.setStudent_sex(student.getStudent_sex().equals("男"));
        }

        if (student.getStudent_bir() != null) {
            try {
                LocalDate parse = LocalDate.parse(student.getStudent_bir());
                stu.setStudent_bir(parse);
            } catch (DateTimeParseException e) {
                return null;
            }
        }

        if (student.getStudent_class() != null && !student.getStudent_class().equals("")) {
            try {
                stu.setStudent_class_id(classMapper.getClassid(student.getStudent_class()));
            }catch (NullPointerException e){
                return null;
            }
        }


        if (student.getStudent_name() != null && !student.getStudent_name().equals("")) {
            stu.setStudent_name(student.getStudent_name());
        }
        if (student.getQq_number() != null &&  student.getQq_number()!=0) {
            stu.setQq_number(student.getQq_number());
        }
        if (student.getWork_city() != null && !student.getWork_city().equals("")) {
            try {
                stu.setWork_city(cityMapper.getCityid(student.getWork_city()));
            }catch (NullPointerException e){
                return null;
            }
        }
        if (student.getStudent_team() != null && !student.getStudent_team().equals("")) {
            try {
                stu.setStudent_class_id(teamMapper.getTeamIDByTeamName(student.getStudent_team()));
            }catch (NullPointerException e){
                return null;
            }
        }


        //更新
        studentMapper.insert(stu);
        cityMapper.addStudent(stu.getWork_city());


        return stu;
    }

    @Override
    public studentShow changeStudent(studentShow student) {
        Student stu = studentMapper.getStudent(student.getStudent_id());
        studentShow studentShowIdone = studentMapper.getStudentShowIdone(student.getStudent_id());
        if (student.getStudent_sex() != null && !student.getStudent_sex().equals("")) {
            stu.setStudent_sex(student.getStudent_sex().equals("男"));
        }

        if (student.getStudent_bir() != null) {
            try {
                LocalDate parse = LocalDate.parse(student.getStudent_bir());
                stu.setStudent_bir(parse);
            } catch (DateTimeParseException e) {
                return studentShowIdone;
            }
        }

        if (student.getStudent_class() != null && !student.getStudent_class().equals("")) {
           try {
               stu.setStudent_class_id(classMapper.getClassid(student.getStudent_class()));
           }catch (NullPointerException e){
               return studentShowIdone;
           }
        }


        if (student.getStudent_name() != null && !student.getStudent_name().equals("")) {
            stu.setStudent_name(student.getStudent_name());
        }
        if (student.getQq_number() != null &&  student.getQq_number()!=0) {
            stu.setQq_number(student.getQq_number());
        }
        if (student.getWork_city() != null && !student.getWork_city().equals("")) {
            try {
                stu.setWork_city(cityMapper.getCityid(student.getWork_city()));
            }catch (NullPointerException e){
                return studentShowIdone;
            }
        }
        if (student.getStudent_team() != null && !student.getStudent_team().equals("")) {
            try {
                stu.setStudent_class_id(teamMapper.getTeamIDByTeamName(student.getStudent_team()));
            }catch (NullPointerException e){
                return studentShowIdone;
            }
        }


        //更新
        studentMapper.updateById(stu);
        return null;
    }

    @Override
    public com.github.pagehelper.Page<studentShow> findByPaging(int current, int limit) {
        PageHelper.startPage(current, limit);
        return studentMapper.getStudentShow();
    }

    @Override
    public com.github.pagehelper.Page<studentShow> findByPaging(int current, int limit, searchType searchType, String value) {
        PageHelper.startPage(current, limit);
        switch (searchType) {
            case id:
                return studentMapper.getStudentShowId(value);
            case name:
                return studentMapper.getStudentShowName(value);
            case qq:
                return studentMapper.getStudentShowqq(value);
            case city:
                return studentMapper.getStudentShowCity(value);
        }
        return null;
    }

}
