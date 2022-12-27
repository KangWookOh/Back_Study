package com.example.chang_intern1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChangIntern1Application {

    public static void main(String[] args) {
        SpringApplication.run(ChangIntern1Application.class, args);
    }

}
