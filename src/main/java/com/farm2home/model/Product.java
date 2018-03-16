package com.farm2home.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "products")
public class Product extends BaseModel {



    private String name;
    private String description;
    private String city;
    private Integer minAmount;
    private Float price;
    private String unit;
    private String currency;
    private Date date;

}
