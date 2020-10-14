package com.evross.mongodbdemo.service;

import com.evross.mongodbdemo.db.Person;
import com.evross.mongodbdemo.db.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DbServicePerson {
    @NonNull
    private PersonRepo repo;

    @Autowired
    public DbServicePerson(PersonRepo repo) {
        this.repo = repo;
    }

    public Person findByName(String name){
        return repo.findByName(name);
    }
}
