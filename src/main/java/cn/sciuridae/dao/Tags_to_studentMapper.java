package cn.sciuridae.dao;

import cn.sciuridae.bean.Tags_to_student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface Tags_to_studentMapper extends BaseMapper<Tags_to_student> {
    @Delete("delete from tags_to_student where tags_student_id = #{id}")
    int deleByStudentId(@Param("id") int id);

}
