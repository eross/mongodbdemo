package com.evross.mongodbdemo.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person, String> {
    public Person findByName(String name);
}
