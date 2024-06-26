package com.sparta.springpersonalboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringPersonalBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPersonalBoardApplication.class, args);
    }

}
