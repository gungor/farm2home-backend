package com.farm2home.controller;

import com.farm2home.json.model.ItemData;
import com.farm2home.json.model.TableData;
import com.farm2home.model.MainModel;
import com.farm2home.service.DataServiceProperty;
import com.farm2home.service.GeneralDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

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
                + " itemType: " + tableData.getItemType());

        DataServiceProperty dataServiceProperty = dataService.getValue(tableData.getItemType());

        String sortColumn = tableData.getSortedColumn() == null ? dataServiceProperty.getDefaultSortColumn() : tableData.getSortedColumn();
        Sort.Direction direction =  tableData.getDesc() ? Sort.Direction.DESC : Sort.Direction.ASC;
        int pageNumber = tableData.getStart() % tableData.getPageSize();

        Page page = dataServiceProperty.getRepository().findAll( new PageRequest(pageNumber,tableData.getPageSize(), new Sort(direction, sortColumn) ) );
        List<MainModel> itemList = page.getContent();


        ItemData itemData = new ItemData();
        itemData.setProductList(itemList);
        itemData.setSize( page.getTotalElements());

        return itemData;
    }

}
