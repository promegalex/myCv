package com.promegalex.mycv.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mehmet Gökhan MERAL on 25.11.2019.
 */
@Configuration
public class MongoDbConfig {
    @Value("${mongodb.database:promegalex}")
    private String database;
    @Value("${mongodb.host:127.0.0.1}")
    private String host;
    @Value("${mongodb.port:27017}")
    private int port;
    @Value("${mongodb.username}")
    private String username;
    @Value("${mongodb.password}")
    private String pass;

    @Bean
    public MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(username, database, pass.toCharArray());
        MongoClientOptions mongoClientOptions = mongoClientOptions();

        return new MongoClient(new ServerAddress(host, port), credential, mongoClientOptions);
    }

    private MongoClientOptions mongoClientOptions() {
        return MongoClientOptions.builder()
                .build();
    }
}
