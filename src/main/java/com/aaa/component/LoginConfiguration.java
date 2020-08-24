package com.aaa.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/**/Login");
        loginRegistry.excludePathPatterns("/**/tologin");
        loginRegistry.excludePathPatterns("/**/loginout");
        loginRegistry.excludePathPatterns("/**/toRegister");

        // 排除资源请求+
        loginRegistry.excludePathPatterns("/**/*.css");
        loginRegistry.excludePathPatterns("/**/*.js");
        loginRegistry.excludePathPatterns("/**/*.png");
        loginRegistry.excludePathPatterns("/**/*.jpg");
        loginRegistry.excludePathPatterns("/**/*.html");

        loginRegistry.excludePathPatterns("/**/*.eot");
        loginRegistry.excludePathPatterns("/**/*.svg");
        loginRegistry.excludePathPatterns("/**/*.ttf");
        loginRegistry.excludePathPatterns("/**/*.woff");
        loginRegistry.excludePathPatterns("/**/*.woff2");
        loginRegistry.excludePathPatterns("/**/*.otf");
        loginRegistry.excludePathPatterns("/**/*.less");
        loginRegistry.excludePathPatterns("/**/*.scss");
        loginRegistry.excludePathPatterns("/**/*.gif");

    }
}