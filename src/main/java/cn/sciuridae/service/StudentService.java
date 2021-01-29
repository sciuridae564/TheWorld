package cn.sciuridae.service;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.searchType;
import cn.sciuridae.bean.show.studentShow;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
public interface StudentService extends IService<Student> {

    boolean deleStudent(Long studentId);

    int addStudent(Student student);

    boolean changeStudentCity(studentShow student);

    Page<studentShow> findByPaging(int current, int limit);

    Page<studentShow> findByPaging(int current, int limit, searchType searchType, String value);
}
