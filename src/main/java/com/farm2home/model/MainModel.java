package com.farm2home.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MainModel {

    @Id
    protected String id;
}
