package com.farm2home.service;

import com.farm2home.dao.ProductRepository;
import com.farm2home.dao.criteria.CriteriaGenerator;
import com.farm2home.dao.criteria.ProductCriteriaGenerator;
import com.farm2home.json.model.ClientRequestObject;
import com.farm2home.model.BaseModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class GeneralDataService {

    @Autowired
    private ProductRepository productRepository;

    private Map<String,ServiceProperty> repositoryMap;

    @PostConstruct
    public void init(){
        repositoryMap = new HashMap<>();
        repositoryMap.put("product", new ServiceProperty(productRepository,new ProductCriteriaGenerator()) );
    }

    public Page<BaseModel>  getList(String itemType,int startPage, int pageSize, Sort sort, ClientRequestObject clientRequestObject){
        CriteriaGenerator criteriaGenerator = repositoryMap.get(itemType).getCriteraGenerator();
        MongoRepository repository = repositoryMap.get(itemType).getRepository();
        Pageable pageable = new PageRequest(startPage, pageSize, sort);
        Page page = repository.findAll(criteriaGenerator.getCriteriaObject(clientRequestObject), pageable);
        return page;
    }

    @Data
    private class ServiceProperty{

        private MongoRepository repository;
        private CriteriaGenerator criteraGenerator;

        public ServiceProperty(MongoRepository repository, CriteriaGenerator criteraGenerator) {
            this.repository = repository;
            this.criteraGenerator = criteraGenerator;
        }

    }

}
