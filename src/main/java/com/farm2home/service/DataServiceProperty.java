package com.farm2home.service;

import lombok.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

@Data
public class DataServiceProperty {



    private MongoRepository repository;
    private String defaultSortColumn;

    public DataServiceProperty(MongoRepository repository, String defaultSortColumn) {
        this.repository = repository;
        this.defaultSortColumn = defaultSortColumn;
    }
}
