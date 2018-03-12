package com.farm2home.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "products")
public class Product extends MainModel {



    private String name;
    private String description;
    private String city;
    private Integer minAmount;
    private Float price;

}
