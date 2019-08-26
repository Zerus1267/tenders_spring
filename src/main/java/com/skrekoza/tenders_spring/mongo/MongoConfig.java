package com.skrekoza.tenders_spring.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "tenderdata";
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://skrekoza:855492@beginner-sutg2.azure.mongodb.net/tenderdata?retryWrites=true&w=majority");
        return new MongoClient(uri);
    }
}
