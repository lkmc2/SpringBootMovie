package com.lin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 网络配置
 * @author lkmc2
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加静态资源文件，外部可以直接访问地址
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
