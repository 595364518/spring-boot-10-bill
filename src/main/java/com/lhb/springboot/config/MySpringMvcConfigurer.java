package com.lhb.springboot.config;

import com.lhb.springboot.component.MyLocaleResolver;
import com.lhb.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mvc配置类，设置默认主页
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 5:54 2019/10/29
 */
@Configuration
public class MySpringMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            //添加视图控制
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
                registry.addViewController("/user.html").setViewName("user/list");
            }

            //添加拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //指定要拦截的请求，/**表示拦截所有请求
                        .addPathPatterns("/**")
                        //排除不需要拦截的路径
                        .excludePathPatterns("/","/index.html","/login")
                        //排除对静态资源的拦截
                        .excludePathPatterns("/css/*","/img/*","/js/*");
            }
            /**
             * 配置虚文件路径，很好的解决了Not allowed to load local resource的问题
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/image/**").addResourceLocations("file:/Develop/Files/Photos/");
                registry.addResourceHandler("/compress/**").addResourceLocations("file:/Develop/Files/comp/");
            }
        };
    }

    //区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
