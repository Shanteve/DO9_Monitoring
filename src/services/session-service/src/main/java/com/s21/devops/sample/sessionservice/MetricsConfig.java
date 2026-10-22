package com.s21.devops.sample.sessionservice;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
    @Bean
    public Counter authorizationRequests(MeterRegistry registry) {
        return Counter.builder("auth.requests.total")
                .description("Number of authorization requests")
                .register(registry);
    }
}