package com.farm2home.json.model;

import lombok.Data;

@Data
public class ClientRequestObject {


    private String name;
    private String description;
    private String city;
    private Integer minAmount;
    private Float price;

}
