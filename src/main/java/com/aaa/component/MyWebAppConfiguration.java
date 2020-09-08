package com.aaa.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebAppConfiguration extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 对文件的路径进行配置,创建一个虚拟路径/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
         *这是图片的物理路径 "file:/+本地图片的地址"
         * @Date： Create in 14:08 2017/12/20
         */
        registry.addResourceHandler("/path/**").addResourceLocations("file:\\D:\\image\\");
        registry.addResourceHandler("/TV/**").addResourceLocations("file:\\D:\\classVido\\");

        registry.addResourceHandler("/js/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\js\\");
        registry.addResourceHandler("/js1/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\js1\\");
        registry.addResourceHandler("/css/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\css\\");
        registry.addResourceHandler("/css1/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\css1\\");
        registry.addResourceHandler("/images/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\images\\");
        registry.addResourceHandler("/images1/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\images1\\");
        registry.addResourceHandler("/fonts/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\fonts\\");
        registry.addResourceHandler("/fonts1/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\fonts1\\");
        registry.addResourceHandler("/plugins/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\plugins\\");
        registry.addResourceHandler("/styles/**").addResourceLocations("file:\\D:\\课堂\\三期项目\\sweet\\src\\main\\resources\\templates\\styles\\");



        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**/findAllById");
        loginRegistry.addPathPatterns("/**/viptc");
        loginRegistry.addPathPatterns("/**/GeRen");
        loginRegistry.addPathPatterns("/**/SendXQ");
        loginRegistry.addPathPatterns("/**/qlists");
        loginRegistry.addPathPatterns("/**/mygz");
        super.addInterceptors(registry);

    }
}