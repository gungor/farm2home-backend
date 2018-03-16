package com.farm2home.dao.criteria;

import com.farm2home.json.model.ClientRequestObject;
import com.farm2home.model.Product;
import org.springframework.data.domain.Example;

public class ProductCriteriaGenerator extends CriteriaGenerator{


    public Example<Product> getCriteriaObject(ClientRequestObject clientRequestObject) {

        Product product = new Product();

        if( clientRequestObject == null )
            return Example.of(product);

        product.setName(clientRequestObject.getName());
        product.setCity(clientRequestObject.getCity());
        product.setMinAmount(clientRequestObject.getMinAmount());
        product.setPrice(clientRequestObject.getPrice());
        return Example.of(product);

    }


}




