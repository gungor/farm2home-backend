package com.farm2home.dao.criteria;

import com.farm2home.json.model.ClientRequestObject;
import com.farm2home.model.Product;
import org.springframework.data.domain.Example;

public abstract class CriteriaGenerator {

    public abstract Example<Product> getCriteriaObject(ClientRequestObject clientRequestObject);
}
