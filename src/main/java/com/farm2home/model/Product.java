package com.farm2home.model;
import lombok.Data;

@Data
public class Product {

    private String name;
    private String description;
    private String city;
    private Integer minAmount;
    private Float price;

}
