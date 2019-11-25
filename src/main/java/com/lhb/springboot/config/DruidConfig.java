package com.lhb.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 08:42 2019/11/4
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置Druid监控
     * 1. 配置一个管理后台的Servlet
     * 2. 配置一个监控的filter
     */
    @Bean // 1. 配置一个管理后台的Servlet
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //设置初始化参数
        Map<String,String> initParams = new HashMap<>();
//        public static final String PARAM_NAME_RESET_ENABLE = "resetEnable";
//        public static final String PARAM_NAME_JMX_URL = "jmxUrl";
//        public static final String PARAM_NAME_JMX_USERNAME = "jmxUsername";
//        public static final String PARAM_NAME_JMX_PASSWORD = "jmxPassword";
        initParams.put(StatViewServlet.PARAM_NAME_JMX_USERNAME,"YayaLy");
        initParams.put(StatViewServlet.PARAM_NAME_JMX_PASSWORD,"123");
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean//配置Filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
