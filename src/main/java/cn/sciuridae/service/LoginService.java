package cn.sciuridae.service;

import cn.sciuridae.bean.Login;
import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.show.loginShow;
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
public interface LoginService extends IService<Login> {
    Result regist(String username, String password, boolean role);

    int login(String username, String password);

    Page<loginShow> findByPaging(int current, int limit);
}
