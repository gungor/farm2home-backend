package com.farm2home.controller;

import com.farm2home.json.model.ClientRequestObject;
import com.farm2home.json.model.ItemData;
import com.farm2home.json.model.TableData;
import com.farm2home.model.BaseModel;
import com.farm2home.service.GeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralDataRetrievalController {

    @Autowired
    private GeneralDataService dataService;

    @CrossOrigin
    @RequestMapping(value = "/items", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ItemData getItems(@RequestBody TableData tableData){
        System.out.println("start: " + tableData.getStart()
                + " pageSize: " + tableData.getPageSize()
                + " sortColumn:" + tableData.getSortedColumn()
                + " desc:" + tableData.getDesc()
                + " itemType: " + tableData.getItemType()
                + " clientObject : "+ tableData.getClientRequestObject());

        int pageNumber = tableData.getStart() % tableData.getPageSize();
        String sortColumn = tableData.getSortedColumn() ;
        Sort.Direction direction =  tableData.getDesc() ? Sort.Direction.DESC : Sort.Direction.ASC;
        ClientRequestObject clientRequestObject = tableData.getClientRequestObject();

        Page page = dataService.getList( tableData.getItemType(), pageNumber, tableData.getPageSize(),  new Sort(direction, sortColumn), clientRequestObject);

        List<BaseModel> itemList = page.getContent();


        ItemData itemData = new ItemData();
        itemData.setProductList(itemList);
        itemData.setSize( page.getTotalElements());

        return itemData;
    }

}
