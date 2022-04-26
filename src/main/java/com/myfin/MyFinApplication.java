package com.myfin;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zihang Gao, Yuhzhuo Ma
 */
@MapperScan("com.myfin.mapper")
@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyFinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFinApplication.class, args);
        log.info("MyFin application start");
    }
}
