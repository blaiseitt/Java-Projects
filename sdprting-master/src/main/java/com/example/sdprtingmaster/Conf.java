package com.example.sdprtingmaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Conf {

    @Bean
    public RepoImpl method() {
        RepoImpl repo = new RepoImpl();
        repo.setField1("ustawione");
        return repo;

    }
}
