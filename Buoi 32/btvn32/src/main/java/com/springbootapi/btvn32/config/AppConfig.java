package com.springbootapi.btvn32.config;

import com.springbootapi.btvn32.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public GreetingService greetingService(){
        return new GreetingService();
    }
}
