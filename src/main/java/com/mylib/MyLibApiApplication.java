package com.mylib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
