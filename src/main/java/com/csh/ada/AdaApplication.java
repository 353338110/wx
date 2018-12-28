package com.csh.ada;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.csh.ada.dao")
public class AdaApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AdaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(AdaApplication.class);
    }



    /*public static void main(String[] args) {
        SpringApplication.run(AdaApplication.class, args);
    }*/
}
