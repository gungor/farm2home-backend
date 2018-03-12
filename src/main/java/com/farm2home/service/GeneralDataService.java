package com.farm2home.service;

import com.farm2home.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class GeneralDataService {

    @Autowired
    private ProductRepository productRepository;

    private Map<String,DataServiceProperty> repositoryMap;

    @PostConstruct
    public void init(){
        repositoryMap = new HashMap<>();
        repositoryMap.put("product",new DataServiceProperty( productRepository ,"date"));
    }

    public DataServiceProperty getValue(String key){
        return repositoryMap.get(key);
    }

}
