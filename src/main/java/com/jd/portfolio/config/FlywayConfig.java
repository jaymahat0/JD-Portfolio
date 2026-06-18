package com.jd.portfolio.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(Flyway flyway) {
        System.out.println("************ FLYWAY INITIALIZED **************");
        return flyway;
    }
}
