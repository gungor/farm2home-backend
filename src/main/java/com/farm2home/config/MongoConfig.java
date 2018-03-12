package com.farm2home.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.farm2home.dao")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "farm2home";
    }

    @Override
    public Mongo mongo() throws Exception {

        return new MongoClient( Collections.singletonList(new ServerAddress("ds211029.mlab.com", 11029)),
                Collections.singletonList(MongoCredential.createCredential("frm2home", "farm2home", "Tvazwq418".toCharArray())));
    }

}
