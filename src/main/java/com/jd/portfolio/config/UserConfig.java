package com.jd.portfolio.config;

import com.jd.portfolio.security.SecurityData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(
            SecurityData.SecurityProperties properties,
            PasswordEncoder encoder) {

        UserDetails admin = User.builder()
                .username(properties.username())
                .password(
                        encoder.encode(properties.password())
                )
                .roles(properties.role())
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}