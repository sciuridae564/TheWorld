package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Login;
import cn.sciuridae.bean.Result;
import cn.sciuridae.dao.LoginMapper;
import cn.sciuridae.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sciuridae
 * @since 2021-01-28
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Result regist(String username, String password, boolean role) {
        Result result = new Result();
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        Login login = new Login();
        login.setAccount_name(username);
        login.setAccount_password(bc.encode(password));
        login.setRole(role);
        login.setRegtime(LocalDateTime.now());
        try {
            loginMapper.insert(login);
            result.setStatus(true);
            result.setMessage("插入成功");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMessage("插入失败，是否账户已被注册过或格式错误");
        }
        return result;
    }

    @Override
    public Result login(String username, String password) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        Result result = new Result();
        Login user = loginMapper.getUser(username);
        if (user != null) {
            boolean matches = bc.matches(password, user.getAccount_password());
            result.setStatus(matches);
            result.setMessage(matches ? "登陆成功" : "密码错误");
            result.setObject(matches ? null : user);
            return result;
        }
        result.setStatus(false);
        result.setMessage("无此用户");
        return result;
    }
}
