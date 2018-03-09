package com.farm2home.json.model;

import com.farm2home.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductData {

    private List<Product> productList;
    private Integer size;

}
