package com.project2.project2.controller;

import com.project2.project2.repositories.revistaRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public revistaRepo revistaRepo() {
        return new revistaRepo(); // Proporciona una instancia de revistaRepo
    }
}
