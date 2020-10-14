package com.evross.mongodbdemo.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories
public class MongoConfig{
    @Bean
    public MongoClient mongoClient() {
        ConnectionString connection = new ConnectionString("mongodb://localhost:27017");
        MongoCredential cred = MongoCredential.createAwsCredential("user","password".toCharArray());
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(cred)
                //.credential(MongoCredential.createCredential("myUserAdmin","admin", "mysecret".toCharArray()))
                .applyConnectionString(connection)
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "mydb");
    }

}
