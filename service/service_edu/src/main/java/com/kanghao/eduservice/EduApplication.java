package com.kanghao.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.kanghao"})
@SpringBootApplication
public class EduApplication  {
    public static void main(String[] args) {

        SpringApplication.run(EduApplication.class,args);
    }
}
