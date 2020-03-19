package com.switchfully.maven.exchange.jars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.switchfully.maven.exchange.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
