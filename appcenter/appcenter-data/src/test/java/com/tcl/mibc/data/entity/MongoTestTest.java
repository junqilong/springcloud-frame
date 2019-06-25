package com.tcl.mibc.data.entity;

import com.tcl.mibc.data.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by linglong.he on 2019/6/25.
 */
public class MongoTestTest extends BaseTest{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void test(){

        MongoTest mongoTest = new MongoTest();
        mongoTest.setName("this is test");

        mongoTemplate.save(mongoTest);
    }

}