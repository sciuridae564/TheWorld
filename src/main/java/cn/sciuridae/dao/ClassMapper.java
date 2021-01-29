package cn.sciuridae.dao;

import cn.sciuridae.bean.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface ClassMapper extends BaseMapper<Class> {

}
