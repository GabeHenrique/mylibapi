package com.mylib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Controller
public class MyLibApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLibApiApplication.class, args);
    }

        @GetMapping("/")
        public String teste() {
            return "index";
        }

        @GetMapping("/home")
        public String home() {
            return "home";
        }

        @GetMapping("/login")
        public String login() {
            return "login";
        }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
            }
        };
    }
}
