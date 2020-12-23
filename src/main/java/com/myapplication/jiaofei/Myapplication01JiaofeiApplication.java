package com.myapplication.jiaofei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.myapplication.jiaofei.mapper")
public class Myapplication01JiaofeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Myapplication01JiaofeiApplication.class, args);
    }

}
