package com.farm2home.json.model;

import com.farm2home.model.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class ItemData {

    private List<BaseModel> productList;
    private Long size;

}
