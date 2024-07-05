package com.zalominimenu.springboot.configuration;

import com.zalominimenu.springboot.security.jwt.CustomerJwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomerJwtAuthenticationFilter> registration(@Qualifier("customerJwtAuthenticationFilter") CustomerJwtAuthenticationFilter filter) {
        FilterRegistrationBean<CustomerJwtAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}