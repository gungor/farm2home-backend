package com.farm2home.controller;

import com.farm2home.config.MongoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by gungoryz on 30/07/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,classes = {MongoConfig.class})
public class GeneralDataRetrievalControllerTests {

    /*
    @Autowired
    private GeneralDataRetrievalController generalDataRetrievalController;

    @Test
    public void shouldReturnNonEmptyItemData(){

        ClientRequestObject clientRequestObject = new ClientRequestObject();
        clientRequestObject.setCity("Antalya");
        clientRequestObject.setDescription();

        TableData tableData = new TableData();
        tableData.se

        generalDataRetrievalController.getItems()
    }
    */

    @Test
    public void shouldReturnNonEmptyItemData(){

    }

}
