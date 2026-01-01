package com.fitness.activityservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.function.Supplier;

@Configuration
@EnableMongoAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class MongoAuditingConfig {
    @Bean
    public DateTimeProvider auditingDateTimeProvider() {
        Supplier<Optional<TemporalAccessor>> supplier = () -> Optional.of(Instant.now());
        return supplier::get;
    }
}
