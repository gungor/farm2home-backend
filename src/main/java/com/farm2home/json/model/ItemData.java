package com.farm2home.json.model;

import com.farm2home.model.MainModel;
import lombok.Data;

import java.util.List;

@Data
public class ItemData {

    private List<MainModel> productList;
    private Long size;

}
