package com.farm2home.controller;

import com.farm2home.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping(value = "/", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<Product> getNewestProducts(){
        List<Product> productList = new ArrayList<>();
        for(int i=0; i<35; i++ ){
            Product product = new Product();
            product.setName("Domates");
            product.setCity("Antalya");
            product.setMinAmount(5);
            productList.add( product );
        }
        return productList;
    }

}
