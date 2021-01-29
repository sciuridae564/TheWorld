package cn.sciuridae.dao;

import cn.sciuridae.bean.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TagsMapper extends BaseMapper<Tags> {
    @Select({"select id,tags_name,tags_pos,tags_type,tags_createtime " +
            "from tags " +
            "where tags_type=#{type}"})
    List<Tags> getTegs(@Param("type") boolean type);
}
