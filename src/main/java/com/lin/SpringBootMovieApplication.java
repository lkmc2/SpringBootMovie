package com.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.lin.mapper")
@SpringBootApplication
public class SpringBootMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMovieApplication.class, args);
    }

}

