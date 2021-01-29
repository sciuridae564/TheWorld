package cn.sciuridae.dao;

import cn.sciuridae.bean.Student;
import cn.sciuridae.bean.show.studentShow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT * from student where student_id = #{studentId}")
    Student getStudent(@Param("studentId") Long studentId);


    @Select("SELECT " +
            "st.student_id as student_id," +
            "st.student_name as student_name," +
            "IF(st.`student_sex`=1,\"男\",\"女\") AS student_sex," +
            "st.`student_bir` as student_bir, " +
            "cl.`class_name` as student_class , " +
            "t.`team_name` as student_team," +
            "st.`qq_number` ," +
            "c.`city_name` as work_city\n" +
            "FROM student st  \n" +
            "LEFT  JOIN class cl ON st.student_class_id=cl.`id` \n" +
            "LEFT  JOIN team t ON t.`id`=st.`student_team_id` \n" +
            "LEFT  JOIN city c ON c.`id`=st.`work_city`")
    Page<studentShow> getStudentShow();

    @Select("SELECT " +
            "st.student_id as student_id," +
            "st.student_name as student_name," +
            "IF(st.`student_sex`=1,\"男\",\"女\") AS student_sex," +
            "st.`student_bir` as student_bir, " +
            "cl.`class_name` as student_class , " +
            "t.`team_name` as student_team," +
            "st.`qq_number` ," +
            "c.`city_name` as work_city\n" +
            "FROM student st  \n" +
            "LEFT  JOIN class cl ON st.student_class_id=cl.`id` \n" +
            "LEFT  JOIN team t ON t.`id`=st.`student_team_id` \n" +
            "LEFT  JOIN city c ON c.`id`=st.`work_city` " +
            "WHERE c.`city_name` like #{city}")
    Page<studentShow> getStudentShowCity(@Param("city") String city);


    @Select("SELECT" +
            "st.student_id as student_id," +
            "st.student_name as student_name," +
            "IF(st.`student_sex`=1,\"男\",\"女\") AS student_sex," +
            "st.`student_bir` as student_bir, " +
            "cl.`class_name` as student_class , " +
            "t.`team_name` as student_team," +
            "st.`qq_number` ," +
            "c.`city_name` as work_city\n" +
            "FROM student st  \n" +
            "LEFT  JOIN class cl ON st.student_class_id=cl.`id` \n" +
            "LEFT  JOIN team t ON t.`id`=st.`student_team_id` \n" +
            "LEFT  JOIN city c ON c.`id`=st.`work_city`" +
            "WHERE st.`student_id` like #{student_id}")
    Page<studentShow> getStudentShowId(@Param("student_id") String studentid);

    @Select("SELECT " +
            "st.student_id as student_id," +
            "st.student_name as student_name," +
            "IF(st.`student_sex`=1,\"男\",\"女\") AS student_sex," +
            "st.`student_bir` as student_bir, " +
            "cl.`class_name` as student_class , " +
            "t.`team_name` as student_team," +
            "st.`qq_number` ," +
            "c.`city_name` as work_city\n" +
            "FROM student st  \n" +
            "LEFT  JOIN class cl ON st.student_class_id=cl.`id` \n" +
            "LEFT  JOIN team t ON t.`id`=st.`student_team_id` \n" +
            "LEFT  JOIN city c ON c.`id`=st.`work_city`" +
            "WHERE st.`qq_number` like #{qq}")
    Page<studentShow> getStudentShowqq(@Param("qq") String qq);

    @Select("SELECT" +
            "st.student_id as student_id," +
            "st.student_name as student_name," +
            "IF(st.`student_sex`=1,\"男\",\"女\") AS student_sex," +
            "st.`student_bir` as student_bir, " +
            "cl.`class_name` as student_class , " +
            "t.`team_name` as student_team," +
            "st.`qq_number` ," +
            "c.`city_name` as work_city\n" +
            "FROM student st  \n" +
            "LEFT  JOIN class cl ON st.student_class_id=cl.`id` \n" +
            "LEFT  JOIN team t ON t.`id`=st.`student_team_id` \n" +
            "LEFT  JOIN city c ON c.`id`=st.`work_city`" +
            "WHERE st.`student_name` like #{name}")
    Page<studentShow> getStudentShowName(@Param("name") String name);

}
