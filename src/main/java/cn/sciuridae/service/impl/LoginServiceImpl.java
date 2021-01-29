package cn.sciuridae.service.impl;

import cn.sciuridae.bean.Login;
import cn.sciuridae.bean.Result;
import cn.sciuridae.bean.show.loginShow;
import cn.sciuridae.bean.show.studentShow;
import cn.sciuridae.dao.LoginMapper;
import cn.sciuridae.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public int login(String username, String password) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        Login user = loginMapper.getUser(username);
        if (user != null) {
            boolean matches = bc.matches(password, user.getAccount_password());

            if(matches){
                if(user.getRole()){
                    return 2;//管理员
                }else {
                    return 1;
                }
            }else {
                return 0;
            }

        }
        return 0;
    }

    public Page<loginShow> findByPaging(int current, int limit){
        PageHelper.startPage(current, limit);
        return loginMapper.getlogins();
    }
}
