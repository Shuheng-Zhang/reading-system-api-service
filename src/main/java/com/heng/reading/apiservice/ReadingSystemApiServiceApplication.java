package com.heng.reading.apiservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heng
 */
@SpringBootApplication
@MapperScan("com.heng.reading.apiservice.mapper")
public class ReadingSystemApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingSystemApiServiceApplication.class, args);
    }

}
