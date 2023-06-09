package com.springboot.eschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests().anyRequest().permitAll();
        //http.authorizeHttpRequests().anyRequest().permitAll();

//        http.formLogin();
        //http.httpBasic();

//        http.authorizeHttpRequests().anyRequest().denyAll();
//        http.formLogin();
//        http.httpBasic();
//
        return http.build();
    }
}
