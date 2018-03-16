package com.farm2home.json.model;

import lombok.Data;

@Data
public class TableData {

    private Integer start;
    private Integer pageSize;
    private String sortedColumn;
    private Boolean desc;
    private String itemType;
    private ClientRequestObject clientRequestObject;

}
