package com.example.intern2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Intern2Application {

    public static void main(String[] args) {
        SpringApplication.run(Intern2Application.class, args);
    }

}
