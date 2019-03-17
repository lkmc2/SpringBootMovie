package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.lin.mapper")
@EnableCaching  // 开启缓存
@SpringBootApplication
public class SpringBootMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMovieApplication.class, args);
    }

}

