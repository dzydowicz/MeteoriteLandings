package com.dzydowicz.meteoritelandings.db.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {

    @Value("spring.data.mongodb.uri")
    String connectionDbUri;

    @Value("spring.data.mongodb.database")
    String dbName;

    @Bean
    MongoTemplate mongoTemplate() {
        MongoClient mongoClient = MongoClients.create(connectionDbUri);
        return new MongoTemplate(mongoClient, dbName);
    }
}
