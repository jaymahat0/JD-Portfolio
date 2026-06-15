package com.jd.portfolio.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class SecurityData {

    @ConfigurationProperties(prefix = "portfolio.admin")
    public record SecurityProperties(String username, String password, String role){
    }
}
