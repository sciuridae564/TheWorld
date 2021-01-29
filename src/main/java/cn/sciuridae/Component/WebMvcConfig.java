package cn.sciuridae.Component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig
        extends WebMvcConfigurationSupport {

    public WebMvcConfig() {
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/student").setViewName("/student");
        registry.addViewController("/city").setViewName("/city");
        registry.addViewController("/class").setViewName("/class");
        registry.addViewController("/tags").setViewName("/tags");
        registry.addViewController("/team").setViewName("/team");
        registry.addViewController("/test").setViewName("/test");
        registry.addViewController("/login").setViewName("/login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/user/getImage","/user/regist","/", "/user/login", "/user/check", "/css/*", "/fonts/*", "/image/*", "/js/*", "/layui/*");
    }

}
