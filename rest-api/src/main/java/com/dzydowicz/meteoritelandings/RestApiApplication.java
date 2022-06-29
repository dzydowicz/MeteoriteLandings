package com.dzydowicz.meteoritelandings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RestApiApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}
