package com.myfin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfiguration(){

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/myfin/**")
                        .allowedOrigins("http://localhost:3000","http://localhost:80")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*");

            }
        };
    }
}
