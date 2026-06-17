package com.jd.portfolio.config;

import com.jd.portfolio.security.SecurityData;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableConfigurationProperties(SecurityData.SecurityProperties.class)
public class SecurityConfig {

    public static final String[] PUBLIC_URLs = {
            "/educations/**",
            "/experiences/**",
            "/projects/**",
            "/skills/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        .requestMatchers(HttpMethod.GET, PUBLIC_URLs)
                        .permitAll()

                        .requestMatchers(HttpMethod.POST,
                                "/contact-messages")
                        .permitAll()

                        .anyRequest()
                        .hasRole("ADMIN")
                )

                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}