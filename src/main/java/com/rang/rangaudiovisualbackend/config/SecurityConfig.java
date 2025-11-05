package com.rang.rangaudiovisualbackend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for Postman testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/v1/admin/login",
                                "/api/v1/admin/create",
                                "/api/v1/admin/**",
                                "/api/v1/employee/**",
                                "/api/v1/events/**"
                        ).permitAll() // allow public access
                        .anyRequest().authenticated() // protect others
                )
                .formLogin(AbstractHttpConfigurer::disable) // disable default login page
                .httpBasic(AbstractHttpConfigurer::disable); // disable basic auth popup

        return http.build();
    }
}


