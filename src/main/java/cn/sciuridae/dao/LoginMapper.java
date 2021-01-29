package cn.sciuridae.dao;

import cn.sciuridae.bean.Login;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface LoginMapper extends BaseMapper<Login> {

    @Select({"select account_password " +
            "from login " +
            "where account_name=#{username}"})
    String getPassword(@Param("username") String username);

    @Select({"select account_password ,role,regtime,id " +
            "from login " +
            "where account_name=#{username}"})
    Login getUser(@Param("username") String username);

    @Update({"update login " +
            "set account_password=#{password} " +
            "where account_name=#{username}"})
    int updatePassword(@Param("username") String username, @Param("password") String password);
}
