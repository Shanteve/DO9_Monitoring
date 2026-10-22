package com.s21.devops.sample.reportservice;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
    @Bean
    public Counter messagesProcessedRabbitmq(MeterRegistry registry) {
        return Counter.builder("rabbitmq.messages.processed")
                .description("Number of messages form RabbitMQ")
                .register(registry);
    }
}