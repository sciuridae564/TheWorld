package cn.sciuridae.service;

import cn.sciuridae.bean.Login;
import cn.sciuridae.bean.Result;
import com.baomidou.mybatisplus.extension.service.IService;

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

    Result login(String username, String password);
}
