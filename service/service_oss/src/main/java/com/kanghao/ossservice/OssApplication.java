package com.kanghao.ossservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.kanghao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);

    }
}
