package com.myfin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zihang Gao
 */
@MapperScan("com.myfin.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyFinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFinApplication.class, args);
    }

}
