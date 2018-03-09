package com.farm2home.controller;

import com.farm2home.json.model.ProductData;
import com.farm2home.json.model.TableData;
import com.farm2home.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ProductData getNewestProducts(@RequestBody TableData tableData){
        System.out.println( "start: "+ tableData.getStart() + " pageSize: "+ tableData.getPageSize() );

        List<Product> productList = new ArrayList<>();
        for(int i=0; i<35; i++ ){
            Product product = new Product();
            if( i< 12 ){
                product.setName("Domates");
                product.setCity("Antalya");
                product.setMinAmount(5);
                product.setPrice( 22.5f );
            }else if( i < 24 ){
                product.setName("Biber");
                product.setCity("Çanakkale");
                product.setMinAmount(5);
                product.setPrice( 35.5f );
            }else {
                product.setName("Elma");
                product.setCity("Muğla");
                product.setMinAmount(5);
                product.setPrice( 14f );
            }

            productList.add( product );
        }


        List<Product> pageProducts = new ArrayList<>();

        int start = tableData.getStart()*tableData.getPageSize();
        int end =  Math.min(start + tableData.getPageSize(),productList.size()) ;

        for(int i=start; i< end; i++ ){
            pageProducts.add( productList.get(i) );
        }

        ProductData productData = new ProductData();
        productData.setProductList(pageProducts);
        productData.setSize( productList.size() );

        return productData;
    }

}
