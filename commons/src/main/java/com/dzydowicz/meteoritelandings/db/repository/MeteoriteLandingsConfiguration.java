package com.dzydowicz.meteoritelandings.db.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MeteoriteLandingsConfiguration {

    @Bean
    @Scope("prototype")
    IMeteoriteLandingsService meteoriteLandingsService(MongoTemplate mongoTemplate)
    {
        return new MeteoriteLandingsService(new MeteoriteLandingsRepository(mongoTemplate));
    }

}
