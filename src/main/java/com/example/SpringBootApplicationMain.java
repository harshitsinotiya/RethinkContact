package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class SpringBootApplicationMain {  // Renamed class to avoid conflict with annotation
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationMain.class, args);
    }
}
