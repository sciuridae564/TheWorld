package cn.sciuridae.aop;

import cn.sciuridae.aop.anno.check;
import cn.sciuridae.bean.Login;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class CheckImpl {
    @Around("@annotation(cn.sciuridae.aop.anno.check)")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //捕获session
        HttpSession o = null;
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpSession) {
                o = (HttpSession) args[i];
                break;
            }
        }
        //没session直接退出
        if (o == null) {
            return;
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取注解
        check HelloWorld = signature.getMethod().getAnnotation(check.class);
        //权限验证拦截
        switch (HelloWorld.need()) {
            case admin:
                Login user = (Login) o.getAttribute("user");
                if (user.getRole()) {
                    //通过验证，放行
                    joinPoint.proceed();
                }
                break;
            case student:
                //student权限大家都有,就走个过场
                joinPoint.proceed();
                break;
            default:
                break;
        }
    }
}
