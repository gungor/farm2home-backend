package com.farm2home.dao;

import com.farm2home.config.MongoConfig;
import com.farm2home.model.BaseModel;
import com.farm2home.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,classes = {MongoConfig.class})
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void shouldReturnNonEmptyList(){
        Pageable pageable = new PageRequest(0, 5, null);
        Page page = productRepository.findAll(pageable);
        assertTrue(page.getTotalElements() > 0);
    }

    @Test
    public void shouldReturnNameDescSortedList(){
        Pageable pageable = new PageRequest(0, 50, new Sort(Sort.Direction.DESC,"name"));
        Page page = productRepository.findAll(Example.of(new Product()),pageable);

        List<BaseModel> actualSortedlist = page.getContent();
        ArrayList<BaseModel> expectedSortedBeforeSort = new ArrayList<BaseModel>(actualSortedlist);
        expectedSortedBeforeSort = (ArrayList<BaseModel>) expectedSortedBeforeSort.clone();

        Collections.sort(expectedSortedBeforeSort, new Comparator<BaseModel>() {
            @Override
            public int compare(BaseModel product1, BaseModel product2) {
                return ((Product)product2).getName().compareTo( ((Product)product1).getName() );
            }
        });

        List<BaseModel> expectedSortedList = expectedSortedBeforeSort;
        assertEquals(actualSortedlist, expectedSortedList);
    }




}
