package com.fitness.activityservice.config;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.models.Activity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        // Prevent copying `id` from ActivityRequest into Activity (so new saves create new documents)
        mapper.typeMap(ActivityRequest.class, Activity.class)
                .addMappings(m -> m.skip(Activity::setId));
        return mapper;
    }
}
